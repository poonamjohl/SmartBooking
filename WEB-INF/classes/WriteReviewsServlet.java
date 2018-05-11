import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

public class WriteReviewsServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String userName = request.getParameter("userid");
        Reviews review = new Reviews();
        review.setHotelName(request.getParameter("hotelName").trim());
        review.setHotelType(request.getParameter("hotelType").trim());
        review.setCityName(request.getParameter("cityName").trim());
        review.setCityZip(request.getParameter("cityZip").trim());
        review.setOffers(request.getParameter("offers").trim());
        review.setUserId(request.getParameter("userID").trim());
        review.setUserAge(Integer.parseInt(request.getParameter("userAge")));
        review.setUserGender(request.getParameter("userGender").trim());
        review.setOccupation(request.getParameter("userOccupation").trim());
        review.setRating(Integer.parseInt(request.getParameter("reviewRating").trim()));
        review.setReviewDate(request.getParameter("reviewDate").trim());
        review.setReviewText(request.getParameter("review").trim());
        Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO, "Logging from WriteReviewsServlet class" + review.toString());
        Boolean success = MongoDBDataStoreUtilities.storeReview(review);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		Utilities utility=new Utilities(request,out);

        out.println("<div id='body'>");
        out.println("<section id='content'>");  
        out.println("<fieldset>"); 
        if(success){
            out.println("<h2>Thank you for your valuable review, it has been added successfully.</h2>");  
        }
        else {
            out.println("<h2>MongoDB is not up and running.</h2>");  
        }
        
        out.println("</fieldset>"); 
        out.println("</section>");
        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        /**********************/
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Utilities utility=new Utilities(request,out);
        Calendar today = Calendar.getInstance();
        today.clear(Calendar.HOUR); today.clear(Calendar.MINUTE); today.clear(Calendar.SECOND);
        Date todayDate = today.getTime();
        out.println("<div id='body'>");
        out.println("<section id='content'>");  
        out.println("<fieldset>"); 
		out.println("<br>");
		out.println("<br>");
        out.println("<h2>Please fill the below form to submit your review</h2>");     
        out.println("<form method='post' action='WriteReviewsServlet'>");        
        out.println("<p><label for='hotelName'>Hotel Name</label>");
        out.println("<input name='hotelName' id='hotelName'  readonly  value=' "+  request.getParameter("hotelName").trim()+ "' type='text'/></p>");
        out.println("<p><label for='hotelType'>Hotel Type</label>");
        out.println("<input name='hotelType' id='hotelType'  readonly  value=' "+  request.getParameter("rating").trim()+ "' type='text'/></p>");
        out.println("<p><label for='cityName'>City Name</label>");
        out.println("<input name='cityName' id='city'  readonly  value=' "+request.getParameter("cityName").trim()+ "' type='text'/></p>");
        out.println("<p><label for='cityZip'>Retailer Zip</label>");
        out.println("<input name='cityZip' id='cityZip' value=''  placeholder= 'Zip Code' pattern='[0-9]{5}' title='5 Number Zip Code' min='00000'/></p>");       
        out.println("<p><label for='offers'>Hotels With Deals</label>");
        out.println("<select id='offers' name='offers'>");
        out.println("<option value='Yes'>Yes</option>"); 
        out.println("<option value='No'>No</option>");   
        out.println("</select>");
        out.println("<p><label for='userID'>User ID</label>");
        out.println("<input name='userID' id='userID'  readonly  value='"+  request.getParameter("userID")+ "' type='text' /></p>");
        out.println("<p><label for='userAge'>User Age</label>");
        out.println("<input name='userAge' id='userAge' value='' type='number' min='15' max='100' step='1' /></p>");

        out.println("<p><label for='userGender'>Gender</label>");
        out.println("<select id='userGender' name='userGender'>");
        out.println("<option value='Male'>Male</option>"); 
        out.println("<option value='Female'>Female</option>");   
        out.println("</select>");
        out.println("<p><label for='userOccupation'>User Occupation</label>");
        out.println("<input name='userOccupation' id='userOccupation' value='' type='text' /></p>");

        out.println("<p><label for='reviewRating'>Review Rating</label>");
        out.println("<select id='reviewRating' name='reviewRating'>");
        out.println("<option value='1'>1</option>"); 
        out.println("<option value='2'>2</option>");
        out.println("<option value='3'>3</option>"); 
        out.println("<option value='4'>4</option>");    
        out.println("<option value='5'>5</option>");   
        out.println("</select>");
        out.println("<p><label for='reviewDate'>Review Date</label>");
        out.println("<input name='reviewDate' id='reviewDate' value='" + todayDate+ " '  readonly  type='text' /></p>");
        out.println("<p><label for='reviewText'>Review Text</label>");
        out.println("<textarea rows='4' cols='50' name='review'>");
        out.println("</textarea>");
		out.println("<br>");
		out.println("<br>");
        out.println("&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input class='button'  type='submit' value='Submit'/>");
        out.println("</form>");
        out.println("</fieldset>"); 
        out.println("</section>");
       
    }


}