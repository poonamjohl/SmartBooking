import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class PaymentServlet extends HttpServlet
{

HashMap<String,List> packages;
public void init() {
  packages = MySqlDataStoreUtilities.getPackages();
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String  ccFirstName = request.getParameter("ccfname");
		String ccLastName = request.getParameter("cclname");
		String emailId = request.getParameter("mail");
    int ccNumber = Integer.parseInt(request.getParameter("ccnumber"));
		int phoneNumber = Integer.parseInt(request.getParameter("phnumber"));
		String address=request.getParameter("address");
    MySqlDataStoreUtilities sdu=new MySqlDataStoreUtilities() ;
    int orderId = sdu.generateNewOrderId();
    Double totalAmount = 0.0;
		if(ccFirstName != null && ccFirstName.length() != 0)
    {
      ccFirstName = ccFirstName.trim();
    }
		if(ccLastName != null && ccLastName.length() != 0)
    {
			ccLastName = ccLastName.trim();
		}
		if(emailId != null && emailId.length() != 0)
    {
			 emailId = emailId.trim();
		}

		if(ccFirstName != "" && ccLastName != "" && emailId != "")
    {
      Boolean insertOrderStatus = sdu.insertOrder(orderId, ccFirstName, ccLastName, ccNumber, phoneNumber, emailId, totalAmount, address);
      HttpSession session = request.getSession();
      Cart cart;
      bookingDetails bd;
      cart = (Cart)session.getAttribute("cart");
      List<CartItem> items = cart.getItems();
      if (insertOrderStatus == true)
      {
      for(CartItem itemobj : items)
        {
              String hotelId = itemobj.getId();
	        		String hotelName = itemobj.getName();
	        		//String roomType = itemobj.getItemType();
            	Double price = itemobj.getPrice();
							String fromDate= itemobj.getStart();
							String toDate = itemobj.getEnd();

              Boolean insertOrderDetailsStatus = sdu.insertOrderDetails(orderId, hotelId, hotelName, price, fromDate, toDate);
              if(insertOrderDetailsStatus){System.out.println("Order details inserted Succesfully");}

			       // bd = new bookingDetails(hotelName,roomType, price, ccFirstName,ccLastName,ccNumber,phoneNumber,emailId, hotelId,fromDate, toDate);

              //Boolean status= sdu.insertOrder(bd);
              //System.out.println(status);
              response.setContentType("text/html");
      				PrintWriter pw=response.getWriter();
      				Utilities utility=new Utilities(request,pw);
      				RequestDispatcher rd = request.getRequestDispatcher("OrderConfirmation.jsp");
      				rd.forward(request,response);

		     }
         session.removeAttribute("cart");
       } else {
         out.println("<h3>Room reservation Unsuccessful:<h3>");}
    }
		 else {
			     out.println("<h3>The following error may have occured:<h3>");
			     out.println("<p>1: Any one field may have been kept empty</p>");
			     out.println("<p>2: Valid Credentials not entered</p>");
			     out.println("<p>Please go back and try again !</p>");
		      }
		out.close();
}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
