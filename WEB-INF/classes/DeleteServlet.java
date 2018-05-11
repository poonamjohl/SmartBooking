import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class DeleteServlet extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Utilities utility = new Utilities(request,out);
	
	HttpSession session = request.getSession();
	String firstName = (String)session.getAttribute("firstName");
	int hotelid=Integer.parseInt(request.getParameter("chotelId"));
	
	System.out.println("deleting"+hotelid);
	
	MySqlDataStoreUtilities sdu=new MySqlDataStoreUtilities();
	
	
	try{
				Connection conn=sdu.getConnection();
				PreparedStatement ps=conn.prepareStatement("delete from Hotels where (hotelId=?)");
				ps.setInt(1,hotelid);
				ps.execute();
			}
			
			catch(Exception e)
			{
				System.out.println("Error while deleting hotel"+e);
				
			}
	
		out.println("Deleted hotel successfully");
		out.println("<a href='managerLogin.html' class='button'>Go back to Dasboard</a>");
		

	
				out.close();
		
		
	
	}
	
	
}