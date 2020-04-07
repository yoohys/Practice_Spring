package servlet_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contextFile")
public class contextFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String readFile = "/WEB-INF/test1.txt";
		InputStream a = getServletContext().getResourceAsStream(readFile);
		BufferedReader bf = new BufferedReader(new InputStreamReader(a));

		response.setContentType("text/html); charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		while (bf.ready()) {
			out.print(bf.readLine());
		}
		bf.close();
		out.print("</body></html>");

	}

}
