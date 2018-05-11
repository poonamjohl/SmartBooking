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

public class UpdateServlet extends HttpServlet
{
	
	
	
	
	MySqlDataStoreUtilities sdu = new MySqlDataStoreUtilities();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{

	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	int hotelid=Integer.parseInt(request.getParameter("chotelId"));
	System.out.println("Poupulating for update"+hotelid);
	String country = "";
		String city ="";
        Double price=0.0;
		String hotelName="";
		String rating="";
		String nearBy="";
		String roomType="";
		String compbreak="";
		String size="";
		String available="";
		String Sold="";
		String maxoccupants="";
		String ammentities="";
		String images="";
		String beds="";
		String bedtype="";
		
		

		
		try{
				Connection conn=sdu.getConnection();
				PreparedStatement ps=conn.prepareStatement("select *  from Hotels where (hotelId=?)");
				ps.setInt(1,hotelid);
				ResultSet rs=ps.executeQuery();
				
				
				
				while(rs.next())
			{
				 country = rs.getString("country");
				 city =rs.getString("city");
				 price =rs.getDouble("price");
				 hotelName=rs.getString("hotelName");
				 rating=rs.getString("rating");
				 nearBy=rs.getString("nearBy");
				 roomType=rs.getString("roomType");
				 compbreak=rs.getString("breakfast");
				 size=rs.getString("size");
				 available=rs.getString("available");
				 Sold=rs.getString("sold");
				 maxoccupants=rs.getString("maxOccupants");
				 ammentities=rs.getString("amenities");
				 images=rs.getString("images");
				 beds=rs.getString("beds");
				 bedtype=rs.getString("bedType");
				
				
			}
			
			
				
				
				
				
				
				
			}
			
			catch(Exception e)
			{
				System.out.println("Error while getting  products for update"+e);
				
			}
		
		

			System.out.println(country);
			System.out.println(city);
			System.out.println(price);
			System.out.println(hotelName);
			System.out.println(rating);
			System.out.println(nearBy);
			System.out.println(roomType);
			System.out.println(compbreak);
			System.out.println(size);
			System.out.println(available);
			System.out.println(Sold);
			System.out.println(maxoccupants);
			System.out.println(ammentities);
			System.out.println(images);
			System.out.println(beds);
			System.out.println(bedtype);
	
		

		
		
out.println("<!DOCTYPE html>");
out.println("<!--[if IE 9]> <html lang=\"en\" class=\"ie9\"> <![endif]-->");
out.println("<!--[if !IE]><!--> <html lang=\"en\"> <!--<![endif]-->");
out.println("<head>");
	out.println("<title>Smart Booking</title>");

	out.println("<!-- Meta -->");
	out.println("<meta charset=\"utf-8\">");
	out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">");
	out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
	out.println("<meta name=\"description\" content=\"\">");
	out.println("<meta name=\"author\" content=\"\">");

	out.println("<!-- Favicon -->");
	out.println("<link rel=\"shortcut icon\" href=\"../favicon.ico\">");

	out.println("<!-- Web Fonts -->");
	out.println("<link rel=\"stylesheet\" href=\"//fonts.b.com/css?family=Open+Sans:400,300,700&subset=cyrillic,latin\">");

	out.println("<!-- CSS Global Compulsory -->");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/bootstrap/css/bootstrap.min.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/css/app.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/css/blocks.css\">");

	out.println("<!-- CSS Implementing Plugins -->");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/animate.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/line-icons/line-icons.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/font-awesome/css/font-awesome.min.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/sky-forms-pro/skyforms/css/sky-forms.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/owl-carousel2/assets/owl.carousel.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/cube-portfolio/cubeportfolio/css/cubeportfolio.min.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/master-slider/masterslider/style/masterslider.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/master-slider/u-styles/testimonials-1.css\">");
	out.println("<link rel=\"stylesheet\" href=\"assets/plugins/master-slider/u-styles/promo-1.css\">");

	out.println("<!-- CSS Theme -->");
	out.println("<link rel=\"stylesheet\" href=\"assets/css/travel.style.css\">");

	out.println("<!-- CSS Customization -->");
	out.println("<link rel=\"stylesheet\" href=\"assets/css/custom.css\">");
out.println("</head>");
out.println("<body>");
out.println("<main class=\"wrapper\">");
	out.println("<!--=== Header ===-->");
	out.println("<nav class=\"one-page-header navbar navbar-default\" data-role=\"navigation\">");
		out.println("<div class=\"container\">");
		out.println("<div class=\"menu-container page-scroll\">");
				out.println("<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">");
					out.println("<span class=\"sr-only\">Toggle navigation</span>");
					out.println("<span class=\"icon-bar\"></span>");
					out.println("<span class=\"icon-bar\"></span>");
					out.println("<span class=\"icon-bar\"></span>");
				out.println("</button>");
				out.println("<a class=\"navbar-brand\" href=\"#body\" style=\"padding-top:20px;color:#000;\">");
				out.println("SmartBooking");
				out.println("</a>");
			out.println("</div>");

			
		out.println("</div>");
		out.println("<!-- /.container -->");
	out.println("</nav>");
	out.println("<!--=== End Header ===-->");
    out.println("<!-- Search Tours Section -->");
	out.println("<div class=\"search-tours g-heading-v8\">");
	out.println("	<div class=\"container\">");
			out.println("<div class=\"row\">");
			out.println("	<div class=\"col-md-3 search-tours-title-wrapper\">");
			out.println("		<div class=\"container\">");
				out.println("		<h2><em class=\"block-name\">SmartBooking</em><br>Please Login</h2>");
				out.println("	</div>");
				out.println("</div>");
				out.println("<div class=\"col-md-9 search-tours-col-bg-default\">");
				out.println("	<div class=\"container\">");
					out.println("	<form action=\"UpdateHotelServlet\" method=\"POST\" class=\"sky-form clearfix\">");
					out.println("<input type='hidden' name='chotelId' value='"+hotelid+"'>");
						out.println("	<div class=\"col-md-12\">");
					out.println("			<label class=\"label\">Country</label>");
							out.println("	<label class=\"input\">");
									
							out.println("		<input type=\"text\" name=\"country\" id=\"\" value='"+country+"'>");
								out.println("</label>");
							out.println("</div>");
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">City</label>");
							out.println("	<label class=\"input\">");
									
									out.println("<input type=\"text\" name=\"city\" id=\"\" value='"+city+"'>");
								out.println("</label>");
							out.println("</div>");
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Name</label>");
							out.println("	<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"hotelName\" id=\"\"value='"+hotelName+"'>");
								out.println("</label>");
						out.println("	</div>");
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Rating</label>");
							out.println("	<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"rating\" id=\"\" value='"+rating+"'>");
							out.println("	</label>");
							out.println("</div>");
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Places Nearby</label>");
							out.println("	<label class=\"input\">");
									
							out.println("		<input type=\"text\" name=\"nearBy\" id=\"\" value='"+nearBy+"' >");
							out.println("	</label>");
							out.println("</div>");
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Room Type</label>");
							out.println("	<label class=\"input\">");
									
							out.println("		<input type=\"text\" name=\"roomType\" id=\"\" value='"+roomType+"'>");
							out.println("	</label>");
							out.println("</div>");
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Complimentry Breakfast</label>");
								out.println("<select class=\"select\" name=\"compbreak\" style=\"background:#d43c31;\">");
								if(compbreak.equalsIgnoreCase("yes")){	
									out.println("	<option value=\"yes\" selected >Yes</option>");
									out.println("	<option value=\"no\">No</option>");
								}
								if(compbreak.equalsIgnoreCase("no"))
								{
									out.println("	<option value=\"yes\">Yes</option>");
									out.println("	<option value=\"no\" selected >No</option>");
									
								}
								out.println("</select>");
							out.println("</div>");
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Size</label>");
							out.println("	<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"size\" id=\"\" value='"+size+"'> ");
								out.println("</label>");
							out.println("</div>");
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Price</label>");
							out.println("	<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"price\" id=\"\" value='"+price+"'>");
								out.println("</label>");
							out.println("</div>");
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Available</label>");
							out.println("	<label class=\"input\">");
									
									out.println("<input type=\"text\" name=\"available\" id=\"\" value='"+available+"'>");
								out.println("</label>");
							out.println("</div>");
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Beds</label>");
							out.println("	<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"beds\" id=\"\" value='"+beds+"'>");
								out.println("</label>");
							out.println("</div>");
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Bed Type</label>");
								out.println("<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"bedtype\" id=\"\" value='"+bedtype+"'>");
								out.println("</label>");
							out.println("</div>");
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Sold</label>");
							out.println("	<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"sold\" id=\"\" value='"+Sold+"'>");
							out.println("	</label>");
							out.println("</div>");
							
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">MaxOccupants</label>");
							out.println("	<label class=\"input\">");
									
								out.println("	<input type=\"text\" name=\"maxoccupants\" id=\"\" value='"+maxoccupants+"'>");
							out.println("	</label>");
							out.println("</div>");
							
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Ammenities</label>");
							out.println("	<label class=\"input\">");
									
								out.println("<input type=\"text\" name=\"ammentities\" id=\"\" value='"+ammentities+"'>");
								out.println("</label>");
							out.println("</div>");
							
							out.println("<div class=\"col-md-12\">");
							out.println("	<label class=\"label\">Images</label>");
								out.println("<label class=\"input\">");
									
									out.println("<input type=\"text\" name=\"images\" id=\"\" value='"+images+"'>");
								out.println("</label>");
							out.println("</div>");
							
							out.println("<div class=\"col col-3\">");
							out.println("	<button type=\"submit\" class=\"btn-u btn-u-lg btn-u-upper\">Update</button>");
							out.println("</div>");
						out.println("</form>");
					out.println("</div>");
				out.println("</div>");
			out.println("</div>");
	out.println("	</div>");
	out.println("</div>");
	out.println("<!-- End Search Tours Section -->");
    
out.println("<!-- Footer Section -->");
	out.println("<div class=\"footer g-pt-40 g-pb-40\">");
	out.println("	<div class=\"container\">");
		out.println("	<div class=\"g-display-table\">");
			out.println("	<div class=\"g-display-td g-text-middle page-scroll\"><a href=\"#body\" class=\"footer-logo\">SmartBooking</a></div>");
			out.println("	<div class=\"g-display-td g-text-middle text-right g-pt-10\">&copy; 2017 All right reserved. Deelopment by <a href=\"#\">Team #08</a></div>");
			out.println("</div>");
		out.println("</div>");
	out.println("</div>");
	out.println("<!-- End Footer Section -->");
out.println("</main>");

    
out.println("</body>");
out.println("</html>");
		
		
			
		
		
		
}

}