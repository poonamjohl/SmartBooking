import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class TrendingServlet extends HttpServlet{	

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{


        // MongoDBDataStoreUtilities mongoUtils = new MongoDBDataStoreUtilities();
        HashMap<String, ArrayList<Reviews>> reviews = new HashMap<String, ArrayList<Reviews>>();

        LinkedHashMap<String,Float> mostLikedProducts = MongoDBDataStoreUtilities.mostLikedProducts();

        LinkedHashMap<String,Integer> top5ZipCodes = MongoDBDataStoreUtilities.top5zipcodes();

        LinkedHashMap<String,Integer> mostReviewedProducts = MongoDBDataStoreUtilities.mostReviewedProducts();

        /**********************/
        response.setContentType("text/html");
        //utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Header.html",response);
        PrintWriter out = response.getWriter();
		Utilities utility=new Utilities(request,out);
		out.println("<!DOCTYPE html>");
		out.println("<head>");
		out.println("<title>TRENDING</title>");
		out.println("<meta charset='utf-8'>");
		out.println("<meta http-equiv='X-UA-Compatible' content='IE=Edge'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<meta name='description' content=''>");
		out.println("<meta name='author' content=''>");
		out.println("<link rel='stylesheet' href='//fonts.b.com/css?family=Open+Sans:400,300,700&subset=cyrillic,latin'>");
		out.println("<link rel='stylesheet' href='assets/plugins/bootstrap/css/bootstrap.min.css'>");
		out.println("<link rel='stylesheet' href='assets/css/app.css'>");
		out.println("<link rel='stylesheet' href='assets/css/blocks.css'>");
		out.println("<link rel='stylesheet' href='assets/css/travel.style.css'>");
		out.println("<link rel='stylesheet' href='assets/css/custom.css'>");
        out.println("<div id='body'>");
		out.println("<main class='wrapper'>");
		out.println("<nav class='one-page-header navbar navbar-default' data-role='navigation'>");
		out.println("<div class='container'>");
		out.println("<div class='menu-container page-scroll'>");
		out.println("<button type='button' class='navbar-toggle' data-toggle='collapse' data-target='.navbar-ex1-collapse'>");
		out.println("<span class='sr-only'>Toggle navigation</span>");
		out.println("<span class='icon-bar'></span>");
		out.println("<span class='icon-bar'></span>");
		out.println("<span class='icon-bar'></span>");
		out.println("</button>");
		out.println("<a class='navbar-brand' href='#body' style='padding-top:20px;color:#000;' >SMARTBOOKING");
		out.println("</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("</nav>");
		out.println("<div class='search-tours g-heading-v8'>");
		out.println("<div class='container'>");
		out.println("<div class='row'>");
		out.println("<div class='col-md-3 search-tours-title-wrapper'>");
		out.println("<div class='container'>");
		out.println("<h2><em class='block-name'>SmartBooking</em><br>Trending</h2>");
		out.println("</div>");
		out.println("</div>");
		out.println("<div class='col-md-9 search-tours-col-bg-default'>");
		out.println("<div class='container'>");
		out.println("<div class='col-md-12'>"); 
		out.println("<br>");
        out.println("<h2>Top 5 most liked Hotels: </h2>"); 
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
		
        out.println("<td><label class='label'><br>Product Name</td>");
        out.println("<td><label class='label'><br>Average rating </td>");        
        out.println("</tr");
        out.println("</thead>");
        out.println("<tbody>");


        for (Map.Entry<String, Float> myKey : mostLikedProducts.entrySet()) {
            String key = myKey.getKey();
            Float value = myKey.getValue();
        out.println("<tr>");
		
        out.println("<td>" +  key +" </td>");
        out.println("<td>" + value + " </td>");
          out.println("</tr>");
    }
        
      
        out.println("</tbody>");
        out.println("</table>");
		out.println("<br>");
        out.println("<h2>Top 5 Zip-codes where max numbers of Hotels are booked: </h2>"); 
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<td><label class='label'><br>Zip-codes</td>");
        out.println("<td><label class='label'><br>Number of Hotels</td>");        
        out.println("</tr");
        out.println("</thead>");
        out.println("<tbody>");

        for (Map.Entry<String, Integer> myKey : top5ZipCodes.entrySet()) {
            String key = myKey.getKey();
            Integer value = myKey.getValue();
        out.println("<tr>");
        out.println("<td>" + key + " </td>");
        out.println("<td>" +  value+" </td>");
        out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
		out.println("<br>");
        out.println("<h2>Top 5 most reviewed Hotels regardless of the rating: </h2>"); 
        out.println("<table>");
         out.println("<thead>");
        out.println("<tr>");
        out.println("<td><label class='label'><br>Product Name</td>");
        out.println("<td><label class='label'><br>Number of Reviews</td>");        
        out.println("</tr");
        out.println("</thead>");
        out.println("<tbody>");
        for (Map.Entry<String, Integer> myKey : mostReviewedProducts.entrySet()) {
            String key = myKey.getKey();
            Integer value = myKey.getValue();
        out.println("<tr>");
        out.println("<td>" + key + " </td>");
        out.println("<td>" +  value+" </td>");
        out.println("</tr>");
        }
        out.println("</tbody>");
        out.println("</table>");
        out.println("</div");
		out.println("</div");
		out.println("</div");
      
        //utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj1/LeftNavigationBar.html",response);
       // utility.printHtml("C:/apache-tomcat-7.0.34/webapps/csj1/Footer.html",response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        
    }


}