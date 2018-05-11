import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Inventory extends HttpServlet {
	
	HashMap<String,Hotel> hotels;
	
	ArrayList<String> productName;
	
	ArrayList<Integer> available;
	
	
	MySqlDataStoreUtilities msql = new MySqlDataStoreUtilities();
	
	void getDataFromXML()
	{
		try{
		hotels = msql.getHotels();
		
		}catch(Exception E){
		System.out.println("Exception");
		}
	}
	
	
	
	
	
  public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		getDataFromXML();
		productName = new ArrayList<String>();
	
		available = new ArrayList<Integer>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        HttpSession session = request.getSession();
		String firstName = (String)session.getAttribute("firstName");
		String accList = (String)session.getAttribute("accList");
		
        Utilities utility = new Utilities(request,out);
		utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Header.html"); 
		
		
		
		out.println("<div class='search-tours g-heading-v8'>");
		out.println("<div class='container'>");
			out.println("<div class='row'>");
				out.println("<div class='col-md-3 search-tours-title-wrapper'>");
					out.println("<div class='container'>");
						out.println("<h2><em class='block-name'>SmartBooking</em><br>Welcome, Manager</h2>");
					out.println("</div>");
				out.println("</div>");
				out.println("<div class='col-md-9 search-tours-col-bg-default'>");
					out.println("<div class='container'>");
						out.println("<form action='LoginServlet' method='POST' class='sky-form clearfix'>");
							out.println("<div class='col-md-8'>");
								out.println("<label class='label'>Please choose from the following actions</label>");
							out.println("</div>");
							out.println("<div class='col-md-8'>");
									
								out.println("<a href='LogoutServlet'>Logout</a>");
		
							out.println("</div>");
							
							
						out.println("</form>");
					out.println("</div>");
				out.println("</div>");
			out.println("</div>");
		out.println("</div>");
	out.println("</div>");
		//out.println("<li><a href='#'>Accessories</a></li>");
		
		
		
		
		
		
		
		
		/*Bootstrap Collapse Plugin*/
		out.println("<div class='container'>");
		out.println("<div class = 'panel-group' id = 'accordion'  style='padding-top:20px'>");
			
			
		   
		   out.println("<div class = 'panel panel-default'>");
		  
			  out.println("<div class = 'panel-heading'>");
				 out.println("<h4 class = 'panel-title'>");
					out.println("<a data-toggle = 'collapse' data-parent = '#accordion' href = '#collapseOne'>");
					   out.println("Products Availability");
					out.println("</a>");
				 out.println("</h4>");
			  out.println("</div>");
			  
			  out.println("<div id = 'collapseOne' class = 'panel-collapse collapse'>");
				 out.println("<div class = 'panel-body'>");
					
					
					
					
					//out.println("<article class='expanded'>");
			out.println("<div class='col-xs-12'>");
					out.println("<table class='table'>");
						out.println("<thead>");
							//out.println("<th>");
								out.println("<td>Id</td>");
								out.println("<td>Name</td>");
								out.println("<td>Price</td>");
								out.println("<td>Stock Available</td>");
							//out.println("</th>");
						out.println("</thead>");
						
						out.println("<tbody>");
						
						
			for(Map.Entry<String,Hotel> m :hotels.entrySet()){
				
				Hotel s = m.getValue();
				productName.add(s.getHotelName());
				available.add(s.getAvailable());
							out.println("<tr>");
							// //out.println("<form action='AddProductsDB' method='post'>");
							// out.println("<input type='hidden' name='id' value='"+s.getId()+"'>");
							// out.println("<input type='hidden' name='type' value='Smartphone'>");
								
								out.println("<td>"+s.getHotelId()+"</td>");
								out.println("<td>"+s.getHotelName()+"</td}>");
								out.println("<td>"+s.getPrice()+"</td>");
								out.println("<td>"+s.getAvailable()+"</td>");
								//out.println("<td><a href='#' class='btn btn-danger del-prod'>Delete</a></td>");
							out.println("</tr>");
			}
			out.println("</tbody>");
					out.println("</table>");
				out.println("</div>");
					
					
					
					
					 out.println("</div>"); 
				 out.println("</div>");
			  out.println("</div>");
			  
		   //out.println("</div>");
		   
		out.println("<div class = 'panel panel-default'>");
		  
			  out.println("<div class = 'panel-heading'>");
				 out.println("<h4 class = 'panel-title'>");
					out.println("<a data-toggle = 'collapse' data-parent = '#accordion' href = '#collapseTwo'>");
					   out.println("Products Currently on Sale");
					out.println("</a>");
				 out.println("</h4>");
			  out.println("</div>");
			  
			  out.println("<div id = 'collapseTwo' class = 'panel-collapse collapse'>");
				 out.println("<div class = 'panel-body'>");
					
					
					
					
					//out.println("<article class='expanded'>");
			out.println("<div class='col-xs-12'>");
					out.println("<table class='table'>");
						out.println("<thead>");
							//out.println("<th>");
								out.println("<td>Id</td>");
								out.println("<td>Name</td>");
								out.println("<td>Price</td>");
							//out.println("</th>");
						out.println("</thead>");
						
						out.println("<tbody>");
						
						
			for(Map.Entry<String,Hotel> m :hotels.entrySet()){
				Hotel s = m.getValue();
				String sale=s.getSale();
				if (sale.equalsIgnoreCase("Yes")) {
							out.println("<tr>");
							// //out.println("<form action='AddProductsDB' method='post'>");
							// out.println("<input type='hidden' name='id' value='"+s.getId()+"'>");
							// out.println("<input type='hidden' name='type' value='Smartphone'>");
								
								out.println("<td>"+s.getHotelId()+"</td>");
								out.println("<td>"+s.getHotelName()+"</td}>");
								out.println("<td>"+s.getPrice()+"</td>");
								//out.println("<td><a href='#' class='btn btn-danger del-prod'>Delete</a></td>");
							out.println("</tr>");
				}
			}
			out.println("</tbody>");
					out.println("</table>");
				out.println("</div>");
					
					
					
					
					 out.println("</div>"); 
				 out.println("</div>");
			  out.println("</div>");
			  
		   //out.println("</div>");
		      
		out.println("<div class = 'panel panel-default'>");
		  
			  out.println("<div class = 'panel-heading'>");
				 out.println("<h4 class = 'panel-title'>");
					out.println("<a data-toggle = 'collapse' data-parent = '#accordion' href = '#collapseThree'>");
					   out.println("Products with Manufacturer Debates");
					out.println("</a>");
				 out.println("</h4>");
			  out.println("</div>");
			  
			  out.println("<div id = 'collapseThree' class = 'panel-collapse collapse'>");
				 out.println("<div class = 'panel-body'>");
					
					
					
					
					//out.println("<article class='expanded'>");
			out.println("<div class='col-xs-12'>");
					out.println("<table class='table'>");
						out.println("<thead>");
							//out.println("<th>");
								out.println("<td>Id</td>");
								out.println("<td>Name</td>");
								out.println("<td>Price</td>");
								out.println("<td>Stock Available</td>");
							//out.println("</th>");
						out.println("</thead>");
						
						out.println("<tbody>");
						
						
			for(Map.Entry<String,Hotel> m :hotels.entrySet()){
				Hotel s = m.getValue();
				String sale=s.getRebates();
				if (sale.equalsIgnoreCase("Yes")) {
							out.println("<tr>");
							// //out.println("<form action='AddProductsDB' method='post'>");
							// out.println("<input type='hidden' name='id' value='"+s.getId()+"'>");
							// out.println("<input type='hidden' name='type' value='Smartphone'>");
								
								out.println("<td>"+s.getHotelId()+"</td>");
								out.println("<td>"+s.getHotelName()+"</td}>");
								out.println("<td>"+s.getPrice()+"</td>");
								out.println("<td>"+s.getAvailable()+"</td>");
								//out.println("<td><a href='#' class='btn btn-danger del-prod'>Delete</a></td>");
							out.println("</tr>");
				}
			}
			out.println("</tbody>");
					out.println("</table>");
				out.println("</div>");
					
					
					
					
					 out.println("</div>"); 
				 out.println("</div>");
			  out.println("</div>");
			  
		   //out.println("</div>");
		      
		      
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
			  
		  
		
		
		
		

		
		
		out.println("<div class = 'panel panel-default'>");
		  
			  out.println("<div class = 'panel-heading'>");
				 out.println("<h4 class = 'panel-title'>");
					out.println("<a data-toggle = 'collapse' data-parent = '#accordion' href = '#collapseThree'>");
					   out.println("Bar Chart");
					out.println("</a>");
				 out.println("</h4>");
			  out.println("</div>");
			  
			  out.println("<div id = 'collapseThree' class = 'panel-collapse collapse in'>");
				 out.println("<div class = 'panel-body'>");
					
					
					
					
					//out.println("<article class='expanded'>");
			out.println("<div class='col-xs-12'>");
					
						out.println("<div id='barchart_material' height=1000px width=100%></div>");
						
			
				out.println("</div>");
					
					
					
					
					 out.println("</div>"); 
				 out.println("</div>");
			  out.println("</div>");
			  
		   
		   
		out.println("</div>");
		out.println("</div>");//End of Container
	
		
		
		//printSideBar(out);
		//utility.printHtml("C:/apache-tomcat-7.0.34/webapps/Assignment1/LeftNavigationBar.html"); 
		utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Footer.html");
		
		out.println("<script type='text/javascript' src='assets/js/loader.js'></script>");
		out.println("<script type='text/javascript'>");
		  out.println("google.charts.load('current', {'packages':['bar']});");
		  out.println("google.charts.setOnLoadCallback(drawChart);");

		  out.println("function drawChart() {");
			out.println("var data = google.visualization.arrayToDataTable([");
			  out.println("['Product Name', 'Availability']");
			    for (int i=0;i<productName.size(); i++){
					out.println(",['"+productName.get(i)+"',"+available.get(i)+"]");
					//System.out.println("["+productName.get(i)+","+ available.get(i)+"]");
					
			  }
			  // out.println("['Philadelphia, PA', 8777]");
			  //out.println("['PA', 8990]");
			  // out.println(",['hjjjk', 2343]");
				out.println("]);");
			
			out.println("var options = {");
			  out.println("chart: {");
				out.println("title: 'Smart Portables',");
				out.println("subtitle: 'Product and there availability',");
				
			  out.println("},");
			  out.println("'width':1000,'height':1000,");
			  out.println("bars: 'horizontal' // Required for Material Bar Charts.");
			out.println("};");

			out.println("var chart = new google.charts.Bar(document.getElementById('barchart_material'));");
			out.println("var container = document.getElementById('barchart_material');");
			// throw error for testing
			out.println("google.visualization.events.addListener(chart, 'ready', function () {");
			  out.println("throw new Error('Test Google Error');");
			out.println("});");

			// listen for error
			out.println("google.visualization.events.addListener(chart, 'error', function (err) {");
			  // check error
			  out.println("console.log(err.id, err.message);");

			  // remove error
			  out.println("google.visualization.errors.removeError(err.id);");

			  // remove all errors
			  out.println("google.visualization.errors.removeAll(container);");
			out.println("});");

			out.println("chart.draw(data, google.charts.Bar.convertOptions(options));");
		  out.println("}");
		out.println("</script>");
		
		out.close();
	
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
}


}