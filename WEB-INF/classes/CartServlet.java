import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {

	HashMap<String,List> packages;
	Cart cart;
	Cart wishList;
	public void init() {
		packages = MySqlDataStoreUtilities.getPackages();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("packages", packages);

		String start = request.getParameter("startD");
		String end = request.getParameter("endD");
		String type = request.getParameter("cType");
		String id = request.getParameter("chotelId");
		String isWish = request.getParameter("wish");
		String wishToCart = request.getParameter("wishToCart");
		String action = request.getParameter("param");
		if(action != null && action.equals("view")) {
			RequestDispatcher view = request.getRequestDispatcher("Cart.jsp");
			view.forward(request, response);
			return;
		}
		if(cart == null) {
			cart = new Cart();
		}
		if(wishList == null) {
			wishList = new Cart();
		}
		
		if(wishToCart!=null && id!=null && wishToCart.equals("true")) {
			for(CartItem wishItem:wishList.getItems()) {
				if(wishItem.getId().equals(id)){
					cart.addItem(wishItem);
					request.getSession().setAttribute("cart", cart);
					request.getSession().setAttribute("cartSize", cart != null?cart.getSize():0);
					RequestDispatcher view = request.getRequestDispatcher("Cart.jsp");
					view.forward(request, response);
					return;
				}
			}
		}
		SimpleDateFormat dt = new SimpleDateFormat("dd.mm.yyyy");
		Date sDate = null, eDate = null;
		try {
			sDate = dt.parse(start);
			eDate = dt.parse(end);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if(sDate==null || eDate ==null) {
			RequestDispatcher view = request.getRequestDispatcher("Filter.jsp");
			view.forward(request, response);
			return;
		}

		long diff = eDate.getTime() - sDate.getTime();
	    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

		if(id != null && type != null) {
			if(type.equals("hotel")) {
				try {
					Hotel hotel = MySqlDataStoreUtilities.getHotelById(id);
					if(isWish !=null && isWish.equals("wish")) {
						if(wishList == null) {
							wishList = new Cart();
						}
						wishList.addToCart(hotel, start, end, days*hotel.getPrice());
						request.getSession().setAttribute("wishlist", wishList);
						RequestDispatcher view = request.getRequestDispatcher("WishList.jsp");
						view.forward(request, response);
						return;
					} else {
						cart.addToCart(hotel, start, end, days*hotel.getPrice());
						request.getSession().setAttribute("cart", cart);
						request.getSession().setAttribute("cartSize", cart != null?cart.getSize():0);
						RequestDispatcher view = request.getRequestDispatcher("Cart.jsp");
						view.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				//TODO: cart.addToCart(packages.get(id));
			}
		}
		return;
	}
}
