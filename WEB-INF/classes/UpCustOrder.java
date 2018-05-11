import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class UpCustOrder extends HttpServlet{

    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String orderNumber = request.getParameter("orderNumber");
		String orderUpdate = request.getParameter("orderUpdate");
		
		if(orderUpdate==null) {
			RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
			view.forward(request, response);
			return;
		} 

		System.out.println("In Order");
		if(!MySqlDataStoreUtilities.isMySqlRunning()) {
			String errorMessage = "MySQL Database is not running";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
			view.forward(request, response);
			return;
		}
		if(orderUpdate != null && orderUpdate.equals("cancel")) {
			if(MySqlDataStoreUtilities.cancelOrder(Integer.parseInt(orderNumber))){
				String orderSuccessMessage="Your order is successfully cancelled!";
				request.setAttribute("orderSuccessMessage", orderSuccessMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			} else {
				String orderFailMessage="Something went wrong, please try later!";
				request.setAttribute("orderFailMessage", orderFailMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			}
			return;
		}
		if(orderUpdate != null && orderUpdate.equals("update")) {
			String shipping = request.getParameter("shippingAddress");
			if(MySqlDataStoreUtilities.updateOrder(Integer.parseInt(orderNumber), shipping)){
				String orderSuccessMessage="Your order is successfully updated!";
				request.setAttribute("orderSuccessMessage", orderSuccessMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			} else {
				String orderFailMessage="Something went wrong, please try later!";
				request.setAttribute("orderFailMessage", orderFailMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			}
			return;
		}
		if(orderUpdate != null && orderUpdate.equals("search")) {
			bookingDetails orderDetails = MySqlDataStoreUtilities.getOrder(Integer.parseInt(orderNumber));
			if(orderDetails!=null){
				request.setAttribute("orderDetails", orderDetails);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			} else {
				String orderFailMessage="Order does not exist!";
				request.setAttribute("orderFailMessage", orderFailMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			}
			return;
		}
    }
 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	 String orderNumber = request.getParameter("orderNumber");
		String orderUpdate = request.getParameter("orderUpdate");
		
		if(orderUpdate==null) {
			RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
			view.forward(request, response);
			return;
		} 

		System.out.println("In Order");
		if(!MySqlDataStoreUtilities.isMySqlRunning()) {
			String errorMessage = "MySQL Database is not running";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
			view.forward(request, response);
			return;
		}
		if(orderUpdate != null && orderUpdate.equals("cancel")) {
			if(MySqlDataStoreUtilities.cancelOrder(Integer.parseInt(orderNumber))){
				String orderSuccessMessage="Your order is successfully cancelled!";
				request.setAttribute("orderSuccessMessage", orderSuccessMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			} else {
				String orderFailMessage="Something went wrong, please try later!";
				request.setAttribute("orderFailMessage", orderFailMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			}
			return;
		}
		if(orderUpdate != null && orderUpdate.equals("update")) {
			String shipping = request.getParameter("shippingAddress");
			if(MySqlDataStoreUtilities.updateOrder(Integer.parseInt(orderNumber), shipping)){
				String orderSuccessMessage="Your order is successfully updated!";
				request.setAttribute("orderSuccessMessage", orderSuccessMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			} else {
				String orderFailMessage="Something went wrong, please try later!";
				request.setAttribute("orderFailMessage", orderFailMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			}
			return;
		}
		if(orderUpdate != null && orderUpdate.equals("search")) {
			bookingDetails orderDetails = MySqlDataStoreUtilities.getOrder(Integer.parseInt(orderNumber));
			if(orderDetails!=null){
				request.setAttribute("orderDetails", orderDetails);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			} else {
				String orderFailMessage="Order does not exist!";
				request.setAttribute("orderFailMessage", orderFailMessage);
				RequestDispatcher view = request.getRequestDispatcher("Order.jsp");
				view.forward(request, response);
			}
			return;
		}
    }



}