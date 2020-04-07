package org.zerock.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.zerock.domain.BoardAttachVO;
import org.zerock.mapper.BoardAttachMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {
	
	@Setter(onMethod_ = {@Autowired})
	private BoardAttachMapper attachMapper;
	
	private String getFolderYesterDay() {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator);
	}
	
	@Scheduled(cron="0 * * * * *")//매일 새벽 2시에 동작(초,분,시,일,달,day of week,연)순서,601P	
	public void checkFiles() throws Exception{
		log.warn("File Check Task Run................."); //서버 실행중 로그확인
		
		log.warn(new Date());
		//file list in database
		List<BoardAttachVO> fileList = attachMapper.getOldFiles(); //전날 파일을 불러오기 (데이터베이스속)
		
		
		//java.nio.Paths 목록으로 변환하기(비교목적)
		//ready for check file in directory with database file list 
		List<Path> fileListPaths = fileList.stream().map(vo->
														Paths.get("C:\\upload", vo.getUploadPath(),
																	vo.getUuid()+"_"+vo.getFileName()))
																	.collect(Collectors.toList());
		
		//image file has thumnail file - 섬네일 별도처리하기
		fileList.stream().filter(vo->vo.isFileType()==true)
						 .map(vo->Paths.get("C:\\upload", vo.getUploadPath(),"s_"+
								 			vo.getUuid()+"_"+vo.getFileName()))
						 						.forEach(p->fileListPaths.add(p));
		
		log.warn("====================================");
		
		fileListPaths.forEach(p->log.warn(p));
		
		//files in yesterday directory - 서버에있는 어제자 파일목록 불러오기 
		File targetDir = Paths.get("C:\\upload",getFolderYesterDay()).toFile();
		
		//서버와 데이터베이스의 파일목록을 비교해서 데이터베이스에 존재하지 않는 파일목록을 만들기
		File[] removeFiles = targetDir.listFiles(file->fileListPaths.contains(file.toPath())==false);
		
		log.warn("------------------------------------");
		for(File file : removeFiles) {
			log.warn(file.getAbsolutePath());
			
			file.delete();
		}
		
		
				
	}
	
}
