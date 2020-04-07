package org.zerock.controller;

import static org.springframework.test.web.client.response.MockRestResponseCreators.withUnauthorizedRequest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}

	@PostMapping("/uploadFormAction")
	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "C:\\upload";

		for (MultipartFile multipartFile : uploadFile) {
			log.info("---------------------");
			log.info("Upload FIle Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());

			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			// upload폴더에 원래 이름으로 저장됨.

			try {
				multipartFile.transferTo(saveFile); // 업로드된 파일 저장하는 방법.
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end for
	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload Ajax");
	}

	private String getFolder() {// 오늘 날짜의 경로를 문자열로 생성. 생성된 경로는 폴더 경로로 수정된 뒤 반환

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);

		return str.replace("-", File.separator);

	}

	private boolean checkImageType(File file) { // 특정한 파일이 이미지 타입인지 검사하는 메서드

		try {
			String contentType = Files.probeContentType(file.toPath());
			// probeContentType():적절한 MIME타입 데이터를 Http의 헤더메시지에 포함
			return contentType.startsWith("image");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(MultipartFile[] uploadFile) {
		log.info("update ajax post......................");

		List<AttachFileDTO> list = new ArrayList<AttachFileDTO>();

		String uploadFolder = "C:\\upload";

		String uploadFolderPath = getFolder();
		// make folder----------------
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		log.info("upload path: " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs(); // 상위 폴더까지 한번에 생성가능
		}

		// make yyyy/MM/dd folder
		for (MultipartFile multipartFile : uploadFile) {
			log.info("---------------------");
			log.info("Upload FIle Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size: " + multipartFile.getSize());

			AttachFileDTO attachDTO = new AttachFileDTO();

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path : IE의 경우 전체 파일경로가 전송되므로 마지막 '\'를 기준으로 잘라낸 문자열이 실제파일이름이 됨.
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);

			log.info("only file name: " + uploadFileName);
			attachDTO.setFileName(uploadFileName);

			// (이름의)중복방지를 위한 UUID적용 : 원본이름과 같더라도 다른 이름의 파일로 생성됨.
			UUID uuid = UUID.randomUUID();
			uploadFileName = uuid.toString() + "_" + uploadFileName;

			try {
				// upload폴더에 원래 이름으로 저장됨.
				File saveFile = new File(uploadPath, uploadFileName); // 연월일 폴더로 변경함.
				multipartFile.transferTo(saveFile); // 업로드된 파일 저장하는 방법.

				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);

				// check image type file
				if (checkImageType(saveFile)) {
					attachDTO.setImage(true);
					// 이미지 파일은 파일이름이 s_로 시작하는 섬네일 파일 생성됨.
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
					// Thumbnailator는 InputStream과 java.io.File 객체를 이용해서 파일 생성가능.
					// 사이즈(width,height)파라미터 지정

					thumbnail.close();
				}

				// add to List
				list.add(attachDTO);

			} catch (Exception e) {
				log.error(e.getMessage());
			}
		} // end for

		return new ResponseEntity<List<AttachFileDTO>>(list, HttpStatus.OK);
	}

	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName) {// UploadController에서 섬네일 데이터 전송하기
		// filename은 경로가 포함된 파라미터를 받아야함.
		log.info("fileName: " + fileName);

		File file = new File("c:\\upload\\" + fileName);
		log.info("file: " + file);
		ResponseEntity<byte[]> result = null;

		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			// probeContentType():적절한 MIME타입 데이터를 Http의 헤더메시지에 포함
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody // 다운로드는 MIME타입고정 : APPLICATION_OCTET_STREAM_VALUE
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {
		log.info("download file: " + fileName);

		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);

		log.info("resource : " + resource);

		if (resource.exists() == false) {
			return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
		}

		String resourceName = resource.getFilename();
		
		//remove UUID(다운로드시 순수한 파일의 이름으로 저장되도록함)
		String resourceOriginalName=resourceName.substring(resourceName.indexOf("_")+1);

		HttpHeaders headers = new HttpHeaders();// 다운로드시 파일의 이름 처리(한글 등)

		try { //브라우저에 따라 다른 방식으로 처리하기(한글 문제)
			String downloadName = null;
			
			if (userAgent.contains("Trident")) {
				//http://localhost:8080/download?fileName=%EC%A4%91%EC%95%99.doc 한글 인코딩후 처리하기.
				log.info("IE browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				log.info("Edge browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
				log.info("Edge name: " + downloadName);
			} else {
				log.info("Chrome browser");
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}
			
			log.info("downloadName : "+downloadName);
			
			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	
	@PostMapping("/deleteFile") //브라우저에서 전송하는 파일이름과 종류를 파라미터로 받아서 파일의종류에 따라 다르게 동작
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		//브라우저에서 전송되는 파일이름은 경로+UUID+파일이름으로 구성되어 있음.
		log.info("deleteFile: "+fileName);
		File file;
		
		try {
			file=new File("c:\\upload\\"+URLDecoder.decode(fileName, "UTF-8"));
			file.delete();
			
			if(type.equals("image")) {
				String largeFileName= file.getAbsolutePath().replace("s_", "");
				log.info("largeFileName : "+largeFileName);
				file=new File(largeFileName);
				file.delete();
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);

	}

}
