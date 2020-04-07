package fileupload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer=response.getWriter();
		writer.println("<html><body>");
		String contentType=request.getContentType();
		//요청 컨텐츠 타입 확인
		if(contentType!=null&&contentType.toLowerCase().startsWith("multipart/")) {
			PrintPartInfo(request,writer);
		}else {
			writer.println("No multipart!");
		}
		writer.println("</body></html>");
	}

	private void PrintPartInfo(HttpServletRequest request, PrintWriter writer)
	throws IOException, ServletException{
		//Part 목록 구하기
		Collection<Part> parts=request.getParts();
		for(Part part : parts) {
			writer.println("<br/>name="+part.getName()); //input태그의 name속성값구하기
			String contentType=part.getContentType();//part의 컨텐츠타입을 구하고 출력
			writer.println("<br/>contentType="+contentType);
			//part의 contnet-Disposition헤더가 "filename="을 포함하고 있으면 업로드한 파일 데이터 처리
			if(part.getHeader("Content-Disposition").contains("filename=")) {
				writer.println("<br/>size = "+part.getSize());
				String fileName=part.getSubmittedFileName();
				writer.println("<br/> filename = "+ fileName);
				if(part.getSize()>0) {
					part.write("C:\\Tomcat8545\\"+fileName);
					part.delete();//업로드를 처리하기 위해 임시폴더에 생성한 임시파일 삭제
				}
			}else {
				//파일 업로드가 아닌경우 httpServletRequest의 getParameter()를 이용하여 파라미터 값 구하기.(파라미터 이름은 part.getName())
				String value=request.getParameter(part.getName());
				writer.println("<br/>value ="+value);
			}
			writer.println("<hr/>");
		
		
		}
		
	}
	
	

}
