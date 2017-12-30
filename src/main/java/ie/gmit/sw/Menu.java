package ie.gmit.sw;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.db4o.*;

@WebServlet(urlPatterns = "/MainMenu")
public class Menu extends HttpServlet {

	private static final long serialVersionUID = 1L;
	MenuService menuService = new MenuService();
	
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
    	String [] result;
    	response.setContentType("text/html"); 
    	PrintWriter out = response.getWriter();
    	
    	if (request.getParameter("txtTitle") != null && request.getParameter("txtDocument") != null) {
    		String title = request.getParameter("txtTitle");
    		Part document = request.getPart("txtDocument");
    		
    		result = menuService.CompareService(title,document);
    	}else if(request.getParameter("newTitle") != null && request.getParameter("newDocument") != null) {
    		
    	}
    	else {
    		
    	}
    		
    }

}
