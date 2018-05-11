import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

import java.util.*;



public class LoginServlet extends HttpServlet

{
	
	Person p;
	
	String mail;
	String password;
	
	HashMap<String, Person> people;
	
	PersonAdapter ca;
	MySqlDataStoreUtilities sdu=new MySqlDataStoreUtilities() ;
	
	
	
	public void init()

	{

		//ca = new PersonAdapter();

		//people = new HashMap<String, Person>();

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		

	response.setContentType("text/html");

	PrintWriter pw = response.getWriter();
	
	Utilities utility=new Utilities(request,pw);
	utility.printHtml("C:/Apache/apache-tomcat-7.0.34/webapps/csj/LoginPage.Html");
	
	
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
	

	response.setContentType("text/html");

	PrintWriter out = response.getWriter();

	

	HttpSession session = request.getSession();



	mail = request.getParameter("mail");

	password = request.getParameter("pass");

	String usertype = request.getParameter("usertype");

	



	

	if(mail != null && mail.length() != 0) {

            mail = mail.trim();

        }

	if(password != null && password.length() != 0) {

            password = password.trim();

		}

	



				Person p= sdu.getPerson(mail,password);
				System.out.println(usertype);
				
				System.out.println(p.getemailId());
				String utype=p.gettype();
				System.out.println("test"+utype);
				if(p.getemailId()!="NA")
				{
						
						session.setAttribute("firstName",p.getfirstName());

						session.setAttribute("userid",mail);
						session.setAttribute("usertype",usertype);
						System.out.println(usertype);

					
					if(utype.equals("customer"))

					{

						RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");

						rd.forward(request,response);

			

					}
					if(utype.equals("Manager"))

					{
							System.out.println("Manager Reached");
							RequestDispatcher rd = request.getRequestDispatcher("managerLogin.html");

							rd.forward(request, response);

			

					}
					if(utype.equals("salesman"))

					{
							System.out.println("Salesman Reached");
							RequestDispatcher rd = request.getRequestDispatcher("SalesLogin.html");

							rd.forward(request, response);

			

					}
					
					
	
				}




				else

				{	

					out.println("<b>Invalid Username or Password. Please try again !<b>");
					out.println("<a href=\"Login.html\">Go back to login</a>");

				}

	

			out.close();
				
	}






}				

			

			

		

	

	

	

	

	

	

	

	
	
	
	
	
