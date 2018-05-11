import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class ManagerFilter extends HttpServlet {

	public static HotelsBackingBean hotelBB;
	HashMap<String,List> packages;
	HashMap<String, ArrayList<Reviews>> reviews = new HashMap<String, ArrayList<Reviews>>();
	ArrayList<Reviews> reviewList = new ArrayList<Reviews>();
	HashMap<String,List> viewReviews;
	List<String> listReview;

	public void init() {
		viewReviews = new HashMap<String,List>();
		packages = MySqlDataStoreUtilities.getPackages();
		reviews = MongoDBDataStoreUtilities.selectReview();
		
		
	}

	public HotelsBackingBean getHotelBB() {
		return hotelBB;
	}

	public void setHotelBB(HotelsBackingBean hotelBB) {
		FilterServlet.hotelBB = hotelBB;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("packages", packages);

		HttpSession session = request.getSession();
		if(null != (HotelsBackingBean) session.getAttribute("hotelBB")) {
			hotelBB = (HotelsBackingBean) session.getAttribute("hotelBB");
		} else{
			try {
				hotelBB = new HotelsBackingBean();
			} catch (Exception e) {
				throw new ServletException("MySQL is down. Please try later");
			}
		}
		String city = request.getParameter("city");
		String rooms = request.getParameter("rooms");
		String start = request.getParameter("start");
		String end = request.getParameter("finish");
		String person = request.getParameter("person");

		String pricesLow = request.getParameter("priceLow");
		String pricesHigh = request.getParameter("priceHigh");

		
		city= city==null?Utility.def_city:city;
		rooms= rooms==null?Utility.def_room:rooms;
		pricesLow= pricesLow==null?Utility.def_priceL:pricesLow;
		pricesHigh= pricesHigh==null?Utility.def_priceH:pricesHigh;
		
		if(city!=null && hotelBB.addFilter(Utility.FILTER_KEY.CITY, city)) {
			hotelBB.setCity(city);
		}
		if(rooms!=null && hotelBB.addFilter(Utility.FILTER_KEY.ROOM_TYPE, rooms)) {
			hotelBB.setRoomType(rooms);
		}
		if(start!=null && !start.isEmpty() && hotelBB.addFilter(Utility.FILTER_KEY.DATE_START, start)) {
			hotelBB.setStartDate(start);
		}
		if(end!=null && !end.isEmpty() && hotelBB.addFilter(Utility.FILTER_KEY.DATE_END, end)) {
			hotelBB.setEndDate(end);
		}
		if(person!=null && !person.isEmpty() && !person.equals(Utility.def_person) && hotelBB.addFilter(Utility.FILTER_KEY.NUM_PERSON, person)) {
			hotelBB.setNoOfPerson(person);
		}
		if(pricesLow!=null && hotelBB.addFilter(Utility.FILTER_KEY.PRICE_LOW, pricesLow)) {
			hotelBB.setPriceLow(pricesLow);
		}
		if(pricesHigh!=null && hotelBB.addFilter(Utility.FILTER_KEY.PRICE_HIGH, pricesHigh)) {
			hotelBB.setPriceHigh(pricesHigh);
		}

		hotelBB.setHotels(MySqlDataStoreUtilities.readHotelList(hotelBB.getFilter()));
		request.getSession().setAttribute("hotelBB", hotelBB);
		
		//Code to send review
		
		for (HashMap.Entry<String, ArrayList<Reviews>> myKey : reviews.entrySet()) {

				String key = myKey.getKey();
				reviewList = new ArrayList<Reviews>();
				reviewList = myKey.getValue();

			
				for (Reviews review : reviewList) {
					listReview = new ArrayList<String>();
					listReview.add(review.getHotelName());// o is name
					listReview.add(review.getHotelType());// 1 is hotel type
					listReview.add(review.getCityName());// 2 is City Name
					listReview.add(review.getCityZip());// 3 is Zip
					listReview.add(review.getOffers());// 4 is offer
					listReview.add(Integer.toString(review.getUserAge()));// 5 is user age
					listReview.add(review.getUserGender());// 6 is gender
					listReview.add(review.getOccupation());// 7 is occusupation
					listReview.add(Integer.toString(review.getRating())); // 8 is rating
					listReview.add(review.getReviewDate()); // 9 is date
					listReview.add(review.getReviewText()); // 10 is text
					viewReviews.put(review.getHotelName(), listReview);
				}
			}
		request.getSession().setAttribute("viewReviews", viewReviews);
		

		RequestDispatcher view = request.getRequestDispatcher("ManagerFilter.jsp");
		view.forward(request, response);
	}
}
