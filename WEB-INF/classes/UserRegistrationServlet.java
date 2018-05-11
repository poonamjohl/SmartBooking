import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.sql.*;

import java.text.*;

public class UserRegistrationServlet extends HttpServlet
{

	
	
	MySqlDataStoreUtilities sdu = new MySqlDataStoreUtilities();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{

	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Utilities utility = new Utilities(request,out);	
		
		
		managedata(request);
		
		out.println("Added customer details successfully");
		out.println("<a href='SalesLogin.html' class='button'>Go back to Dasboard</a>");
		
				out.close();
		
		
			
		
		
		
}

public void managedata(HttpServletRequest request)
{
	
	
		String fname = request.getParameter("First Name");
		String lname = request.getParameter("Last Name");
        String email =request.getParameter("Email");
		String paswd=request.getParameter("Password");
		String type=request.getParameter("Type");
		String address=request.getParameter("Address");
		String cardno=request.getParameter("Card No.");
		String carddate=request.getParameter("Card Date");
		String cardname=request.getParameter("Card Name");
		
		int personid=0;

		
		
		
		
		
		
		try{
			Connection conn=sdu.getConnection();
				
				
				
				PreparedStatement ps=conn.prepareStatement("insert into person(fname,lname,emailid,password,type,address,cardnumber,carddate,cardname) VALUES(?,?,?,?,?,?,?,?,?)");
			    
				ps.setString(1,fname);
				ps.setString(2,lname);
				ps.setString(3,email);
				ps.setString(4,paswd);
				ps.setString(5,type);
				ps.setString(6,address);
				ps.setString(7,cardno);
				ps.setString(8,carddate);
				ps.setString(9,cardname);
				
			
				
				
				ps.executeUpdate();
				
			
			
		}
		catch(Exception e)
			{
					System.out.println("error while adding customer"+e);
				
			}
			
		
		
		
		
		
	
	
	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{

doGet(request,response);
}	
	
	
}