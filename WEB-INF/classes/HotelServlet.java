import java.io.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class HotelServlet extends HttpServlet {

	HashMap<String,List> packages;
	Hotel hotel;
	
	public void init() {
		packages = MySqlDataStoreUtilities.getPackages();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("packages", packages);

		String param = request.getParameter("param");
		if(param != null && param.equals("details")) {
			String hotelId = request.getParameter("hotelId");
			try {
				hotel = MySqlDataStoreUtilities.getHotelById(hotelId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("hotel", hotel);
			RequestDispatcher view = request.getRequestDispatcher("Detail.jsp");
			view.forward(request, response);
			return;
		}

		RequestDispatcher view = request.getRequestDispatcher("Filter.jsp");
		view.forward(request, response);
	}
}
