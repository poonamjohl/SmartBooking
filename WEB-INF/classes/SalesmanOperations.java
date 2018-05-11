import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class SalesmanOperations extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Utilities utility=new Utilities(request,out);
        utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Header.html");
        out.println("<!DOCTYPE html>");
		out.println("<head>");
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
        out.println("<body>");
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
		out.println("<a class='navbar-brand' href='#body' style='padding-top:20px;color:#000;' >");
		out.println("</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("</nav>");
		out.println("<div class='search-tours g-heading-v8'>");
		out.println("<div class='container'>");
		out.println("<div class='row'>");
		out.println("<div class='col-md-9 search-tours-col-bg-default'>");
		out.println("<div class='container'>");
		out.println("<form method='post' action='SalesmanOperations' class='sky-form clearfix'>");				
		out.println("<div class='col-md-12'>");
        out.println("<label class='label'>ENTER EMAIL ID:</label>");
        out.println("<label class='input'>");
		out.println("<input type='text' name='mail' id='' placeholder='test@smartbooking.com'>");
		out.println("</label>");
		out.println("</div>");
		out.println("<div class='col col-3'>");
		out.println("<button type='submit' class='btn-u btn-u-lg btn-u-upper'>SUBMIT</button>");
		out.println("</div>");
        out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");		
        utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Footer.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String emailId = request.getParameter("email");
		MySqlDataStoreUtilities dsutils = new MySqlDataStoreUtilities();
        //ArrayList<Person> personList = SerializeDataStore.readPersonDataStore();      
        Boolean personFound=false;
		try{
        ArrayList<Person> personList = dsutils.readPerson();
		
        if(personList.size()==0){

        }
        else{
            for(Person person:personList){
                if(person.getemailId().equals(emailId)){
                    HttpSession session = request.getSession(true);
                    String userInfo = new String("UserInfo"); 
                    person.settype("salesman");
                    session.setAttribute(userInfo, person);
                    personFound=true;
                    break;
                }
            }
        }

        if(personFound){
            response.sendRedirect("HomeServlet");
        }
        else{
            response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			Utilities utility=new Utilities(request,out);
            utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Header.html");
            out.println("<!DOCTYPE html>");
		out.println("<head>");
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
        out.println("<body>");
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
		out.println("<a class='navbar-brand' href='#body' style='padding-top:20px;color:#000;' >");
		out.println("</a>");
		out.println("</div>");
		out.println("</div>");
		out.println("</nav>");
		out.println("<div class='search-tours g-heading-v8'>");
		out.println("<div class='container'>");
		out.println("<div class='row'>");
		out.println("<div class='col-md-9 search-tours-col-bg-default'>");
		out.println("<div class='container'>");
		out.println("<form method='post' action='SalesmanOperations' class='sky-form clearfix'>");				
		out.println("<div class='col-md-12'>");
            out.println("<p><label class='label'>Invalid email!!! Please try again!!!</label>");
            out.println("<p><label class='label'>Enter Customer Emaill Id:</label>");
			out.println("<label class='input'>");
            out.println("<input name='email' id='email' value='' type='text'/></p>");
            out.println("<div class='col col-3'>");
		out.println("<button type='submit' class='btn-u btn-u-lg btn-u-upper'>SUBMIT</button>");
		out.println("</div>");
        out.println("</form>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
		out.println("</div>");
out.println("</div>");		
            
            utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Footer.html");

        }
    }

		catch(Exception ex){
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			Utilities utility=new Utilities(request,out);
            utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Header.html");
            out.println("<div id='body'>");
            out.println("<section id='content'>"); 
            out.println("<form method='post' action='SalesmanOperations'>");
            out.println("<p><label for='ErrorMessage'>MySql server is not up and running.</label>");
            out.println("</form>");               
            out.println("</section>");
            utility.printHtml("C:/apache-tomcat-7.0.34/webapps/SmartBooking/Footer.html");
    }

    }


}


