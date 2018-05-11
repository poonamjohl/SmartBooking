import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNumber = request.getParameter("orderNumber");
		String orderUpdate = request.getParameter("orderUpdate");
		String fromDate = request.getParameter("fromDate");
		
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
		
		//Cancel order
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
		
		//Update order
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
		
		//Get order
		if(orderUpdate != null && orderUpdate.equals("search")) {
			bookingDetails orderDetails = MySqlDataStoreUtilities.getOrder(Integer.parseInt(orderNumber));
			if(orderDetails!=null){
				if(!checkOrderCancel(orderDetails.getFromDate())) {
					request.setAttribute("dateCheck", false);
					request.setAttribute("orderFailMessage", "Your booking is locked in!");
				}
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
	
	public static String getDateAfterTwoWeeks() {
		LocalDate today = LocalDate.now();
		//add 2 weeks to the current date
		LocalDate nextWeek = today.plus(2, ChronoUnit.WEEKS);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formattedString = nextWeek.format(formatter);
		return formattedString;
	}

	public static String getCurrentDate() {
		LocalDate today = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		String formattedString = today.format(formatter);
		return formattedString;
	}

	public static boolean checkOrderCancel(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate today = LocalDate.now();
		LocalDate orderDate = LocalDate.parse(date, formatter);
		try {
			long daysBetween = Duration.between(today.atStartOfDay(), orderDate.atStartOfDay()).toDays();
			if(daysBetween > 5) {
				return true;
			}
		} catch (Exception e) {	}

		return false;
	}
}
