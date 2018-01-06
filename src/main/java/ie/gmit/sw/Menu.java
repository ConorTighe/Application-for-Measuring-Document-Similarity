package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.db4o.*;

@WebServlet(urlPatterns = "/MainMenu")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB. The file size in bytes after which the file will be temporarily stored on disk. The default size is 0 bytes.
maxFileSize=1024*1024*10,      // 10MB. The maximum size allowed for uploaded files, in bytes
maxRequestSize=1024*1024*50)   // 50MB. he maximum size allowed for a multipart/form-data request, in bytes.
public class Menu extends HttpServlet {

	private static final long serialVersionUID = 1L;
	MenuService menu = new MenuService();
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// GET JSP Menu view
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/MainMenu.jsp").forward(
				request, response);
	}
    
    // POST JSP Menu view
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<String> result = null;
    	response.setContentType("text/html"); 
    	PrintWriter out = response.getWriter();
    	System.out.println(request.getParameter("txtTitle"));
    	System.out.println(request.getPart("txtDocument"));
    	if (request.getParameter("txtTitle") != null && request.getPart("txtDocument") != null) {
    		String title = request.getParameter("txtTitle");
    		Part document = request.getPart("txtDocument");
    		System.out.println("POST to server");
    		try {
    			result = menu.CompareService(title, document, result);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		System.out.println("server res: " + result);
    		out.print("<html><head><title>A JEE Application for Measuring Document Similarity</title>");		
    		out.print("</head>");		
    		out.print("<body>");
    		out.print("<H3>Document Being Compared Title: " + title + "</H3>");
    		for (String comparision: result) {
    			out.print("<b>" + comparision + "</b><br>");
    		}
    		out.print("</body></html>");
    	}else if(request.getParameter("newTitle") != null && request.getParameter("newDocument") != null) {
    		
    	}
    		
    }

}
