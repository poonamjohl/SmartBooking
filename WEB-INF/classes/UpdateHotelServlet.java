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

public class UpdateHotelServlet extends HttpServlet
{

	
	
	MySqlDataStoreUtilities sdu = new MySqlDataStoreUtilities();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{

	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	Utilities utility = new Utilities(request,out);	
		
		
		managedata(request);
		
		out.println("Update hotel successfully");
		out.println("<a href='managerLogin.html' class='button'>Go back to Dasboard</a>");
		
				out.close();
		
		
			
		
		
		
}

public void managedata(HttpServletRequest request)
{
	
	
		String country = request.getParameter("country");
		String city = request.getParameter("city");
        Double price =Double.parseDouble(request.getParameter("price"));
		String hotelName=request.getParameter("hotelName");
		String rating=request.getParameter("rating");
		String nearBy=request.getParameter("nearBy");
		String roomType=request.getParameter("roomType");
		String compbreak=request.getParameter("compbreak");
		String size=request.getParameter("size");
		String available=request.getParameter("available");
		String Sold=request.getParameter("Sold");
		String maxoccupants=request.getParameter("maxoccupants");
		String ammentities=request.getParameter("ammentities");
		String images=request.getParameter("images");
		String beds=request.getParameter("beds");
		String bedtype=request.getParameter("bedtype");
		int hotelid=Integer.parseInt(request.getParameter("chotelId"));
		System.out.println("Updating this hotel"+hotelid);
		

		
		
		
		
		
		
		try{
			System.out.println("update product entry reached");
			Connection conn=sdu.getConnection();
				
				PreparedStatement ps=conn.prepareStatement("UPDATE Hotels SET country = ?, city = ?,hotelName=?, rating=?,nearBy=?,roomType=?,breakfast=?,size=?,price=?,available=?,sold=?,beds=?,bedType=?,maxOccupants=?,amenities=?,images=? WHERE hotelId=?");
			    
				ps.setString(1,country);
				ps.setString(2,city);
				ps.setString(3,hotelName);
				ps.setString(4,rating);
				ps.setString(5,nearBy);
				
				ps.setString(6,roomType);
				ps.setString(7,compbreak);
				ps.setString(8,size);
				ps.setDouble(9,price);
				ps.setString(10,available);
				ps.setString(11,Sold);
				ps.setString(12,beds);
				ps.setString(13,bedtype);
				ps.setString(14,maxoccupants);
				ps.setString(15,ammentities);
				ps.setString(16,images);
				ps.setInt(17,hotelid);
				
				
				ps.executeUpdate();
				
			
			
		}
		catch(Exception e)
			{
					System.out.println("error while updating hotels"+e);
				
			}
			
		
		
		
		
		
	
	
	
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	doGet(request,response);

}	
	
	
}