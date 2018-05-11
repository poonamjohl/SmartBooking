import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class ViewReviewsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HashMap<String, ArrayList<Reviews>> reviews = new HashMap<String, ArrayList<Reviews>>();

		String hname = request.getParameter("hotelName");

		Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO,
				"Logging from ViewReviewsServlet class" + hname);

		reviews = MongoDBDataStoreUtilities.selectReview();
		ArrayList<Reviews> reviewList = new ArrayList<Reviews>();

		boolean reviewFound = false;

		if (reviews.containsKey(hname.trim())) {
			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO, "Success");
			reviewFound = true;

		}

		if (reviewFound) {
			for (HashMap.Entry<String, ArrayList<Reviews>> myKey : reviews.entrySet()) {

				String key = myKey.getKey();

				if (key != null && key.trim().equals(hname.trim())) {
					reviewList = myKey.getValue();

					Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO,
							"number of reviews = " + reviewList.size());
					break;
				}

			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Utilities utility = new Utilities(request,out);
		
		
		out.println("<h1>Hotel Reviews</h1>");
		for (Reviews review : reviewList) {
	
			out.println("<table id='hotelReview'  >");
		        out.println("<tbody>");
		            out.println("<tr>");
		                out.println("<td>Hotel Name</td>");
		                out.println("<td>" + review.getHotelName() + "</td>");
		            out.println("</tr>");
		            out.println("<tr>");
		                out.println("<td>Hotel Type</td>");
		                out.println("<td>" + review.getHotelType() + "</td>");
		            out.println("</tr>");
		  
		                out.println("<td>City</td>");
		                out.println("<td>" + review.getCityName() + "</td>");
		            out.println("</tr>");
		       
		            out.println("<tr>");
		                out.println("<td>Zip code</td>");
		                out.println("<td>" + review.getCityZip() + "</td>");
		            out.println("</tr>");
		           
		            out.println("<tr>");
		                out.println("<td>Hotel Offers</td>");
		                out.println("<td>" + review.getOffers() + "</td>");
		            out.println("</tr>");
		     
		            out.println("<tr>");
		                out.println("<td>UserName</td>");
		                out.println("<td>" + review.getUserId() + "</td>");
		            out.println("</tr>");
		            out.println("<tr>");
		                out.println("<td>User Age</td>");
		                out.println("<td>" + review.getUserAge() + "</td>");
		            out.println("</tr>");
		            out.println("<tr>");
		                out.println("<td>Gender</td>");
		                out.println("<td>" + review.getUserGender() + "</td>");
		            out.println("</tr>");
		            out.println("<tr>");
		                out.println("<td>Occupation</td>");
		                out.println("<td>" + review.getOccupation() + "</td>");
		            out.println("</tr>");
		            out.println("<tr>");
		                out.println("<td>Rating</td>");
		                out.println("<td>" + review.getRating() + "</td>");
		            out.println("</tr>");
		            out.println("<tr>");
		                out.println("<td>Review Date</td>");
		                out.println("<td>" + review.getReviewDate() + "</td>");
		            out.println("</tr>");
		            out.println("<tr>");
		                out.println("<td>Review Text</td>");
		                out.println("<td>" + review.getReviewText() + "</td>");
		            out.println("</tr>");
		            
	            out.println("</tbody>");
    		out.println("</table>");
			out.println("</p>");
		}
		out.println("</body>");
		out.println("</html>");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}