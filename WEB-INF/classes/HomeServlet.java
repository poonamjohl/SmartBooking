import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class HomeServlet extends HttpServlet
{
	ArrayList<Object> products;
	
	HashMap<String,List> packages;
	String cities;
	List<String> rooms;
	public HashMap<String, Hotel> selectedHotels;
	public ArrayList<String> tweets;
	HashMap<String,List> hotels;
	//String [] city;
	// HashMap<String, Headphone> headphones;
	// HashMap<String, HD> hds;
	// HashMap<String, MC> mcs;
	// HashMap<String, USB> usbs;
	//
	//SAXParserForProducts sp = new SAXParserForProducts();

	public void init()
	{
		try{
		packages = new HashMap<String,List>();
		//cities = new ArrayList<String>();
		System.out.println("Getting packages from DB");	
		packages = MySqlDataStoreUtilities.getPackages();
		cities = MySqlDataStoreUtilities.getCity();
		rooms = MySqlDataStoreUtilities.getRooms();
		System.out.println("Getting Hotels from Dealmatches");	
		selectedHotels = DealMatches.getSelectedHotelsFromTweets();	
		System.out.println("*****************************");	
		System.out.println(selectedHotels);	
		System.out.println("*****************************");	
		tweets = DealMatches.getTweets();
		//city = cities.toArray(new String[cities.size()]);
		}
		catch(Exception E)
		{
			System.out.println("Exception");
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(selectedHotels.isEmpty())
		{
			ArrayList<String> test = new ArrayList<String>();	
			
			
		} else {
			for(Map.Entry<String,Hotel> m :selectedHotels.entrySet()){
				ArrayList<String> hotelInfo = new ArrayList<String>();
				Hotel s = m.getValue();	
				hotelInfo.add(s.getHotelId()); //0
				hotelInfo.add(s.getHotelName());//1
				hotelInfo.add(s.getImage());//2
				hotelInfo.add(s.getRoomType());//3
				hotelInfo.add(Double.toString(s.getPrice()));//4
				hotelInfo.add(s.getCity());//5
				hotelInfo.add(s.getCountry());//6
				hotelInfo.add(s.getSale());//7
				hotelInfo.add(Integer.toString(s.getAvailable()));//8
				hotelInfo.add(Integer.toString(s.getSold()));//9
				hotelInfo.add(Double.toString(s.getRatings()));//10
				hotelInfo.add(s.getRebates());//11
				hotels = new HashMap<String,List>();
				hotels.put(s.getHotelId(), hotelInfo);
				
			}
			System.out.println(hotels);
		}
	request.setAttribute("packages", packages);
	request.setAttribute("hotels", hotels);
	request.setAttribute("cities", cities);
	request.setAttribute("rooms", rooms);
	request.setAttribute("tweets", tweets);
	RequestDispatcher view = request.getRequestDispatcher("Home.jsp");
	view.forward(request, response);

	//out.close();

	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	
	}
}
