import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class SignUpServlet extends HttpServlet
{
	Person p;
	HashMap<String, Person> people;
	String firstName;
	String lastName;
	String emailId;
	String phoneNumber;
	String password;
	String renterPassword;
	String utype;
	String address;
	
	PersonAdapter pa;
	MySqlDataStoreUtilities sdu=new MySqlDataStoreUtilities() ;
	
	public void init() {
		//pa = new PersonAdapter();
		//people = new HashMap<String, Person>();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		firstName = request.getParameter("fname");
		lastName = request.getParameter("lname");
		emailId = request.getParameter("mail");
		password = request.getParameter("pass");
		renterPassword = request.getParameter("rpass");
		utype=request.getParameter("usertype");
		address=request.getParameter("address");
	
		
 
		if(firstName != null && firstName.length() != 0) {
            firstName = firstName.trim();
        }
		if(lastName != null && lastName.length() != 0) {
			lastName = lastName.trim();
		}
		if(emailId != null && emailId.length() != 0) {
			emailId = emailId.trim();
		}
		if(phoneNumber != null && phoneNumber.length() != 0) {
			phoneNumber = phoneNumber.trim();
		}
		if(password != null && password.length() != 0) {
            password = password.trim();
		}
		
	
		
		if(password.equals(renterPassword) && firstName != "" && lastName != "" && emailId != "" && password != "" && renterPassword != "") {
			p = new Person(utype,firstName, lastName, emailId, password, address);
			
			
			
			Person temp= sdu.getPerson(emailId,password);
			if(temp.getemailId()=="NA")
			{
				sdu.addPerson(p);
				response.setContentType("text/html");
				PrintWriter pw=response.getWriter();
				Utilities utility=new Utilities(request,pw);
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.forward(request,response);
				//utility.printHtml("C:/Apache/apache-tomcat-7.0.34/webapps/csj/Login.html");
				
			}				
			else
			{
				
				out.println("<h3>Customer "+firstName+ " " +lastName+" with Email ID "+emailId+"  already exist<h3>");
			}
		
		}
		
		
			
			
			
			
		 else {
			out.println("<h3>The following error may have occured:<h3>");
			out.println("<p>1: Any one field may have been kept empty</p>");
			out.println("<p>2: Passwords do not match</p>");
			out.println("<p>Please go back and try again !</p>");
		}
		out.close();
	}	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}