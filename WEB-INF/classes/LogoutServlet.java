import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class LogoutServlet extends HttpServlet
{
	/*Customer customer;
	HashMap<String,Customer> customers;
    String emailId;
	String password;*/
	
	//PopulateCustomersHashmap pch;
	
	public void init()
	{
		//pch = new PopulateCustomersHashmap();
		//customers = new HashMap<String, Customer>();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	HttpSession session = request.getSession(false);
	
	if(session != null)
	{
		session.invalidate();
	}
	
	RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
	view.forward(request, response);
	out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	
}