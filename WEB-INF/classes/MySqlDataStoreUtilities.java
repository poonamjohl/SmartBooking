import java.util.List;
import java.util.logging.*;

import javax.servlet.ServletException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

public class MySqlDataStoreUtilities {
	static Connection connection = null;
	
	public static boolean isMySqlRunning() throws ServletException {
		boolean isMySqlRunning = false;
		try {zz
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://smartbooking.cmu9foiuklwn.us-east-1.rds.amazonaws.com:3306/smartbooking?autoReconnect=true&useSSL=false", "hotels", "hotels123");
			System.out.println("Connected to MYSQL");
			isMySqlRunning = true;
		} catch (SQLException ex) {
			// handle any errors
			ex.printStackTrace();
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}catch (Exception ex) {
			// handle the error
			ex.printStackTrace();
			System.out.println("Exception: " + ex.getMessage());
		}
		return isMySqlRunning;
	}
	
	public static Connection getConnection() throws SQLException {
		try{
			Connection conn;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://smartbooking.cmu9foiuklwn.us-east-1.rds.amazonaws.com:3306/smartbooking?autoReconnect=true&useSSL=false", "hotels", "hotels123");
			System.out.println("Connected");
			return conn;
		}
		catch(Exception e) {
			System.out.println("Exception in db connection"+e);
			throw new SQLException("Could not connect to Database");
		}
	}

	public static boolean cancelOrder(int orderId) { 
		try{
			String cancelOrderProdQuery = "DELETE FROM bookingDetail where orderId=?;";
			PreparedStatement pst = connection.prepareStatement(cancelOrderProdQuery);
			pst.setInt(1,orderId); 
			int affectedRows = pst.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("bookingDetails not deleted ");
			}

			String cancelOrderQuery = "DELETE FROM booking where orderId=?;";
			pst = connection.prepareStatement(cancelOrderQuery);
			pst.setInt(1,orderId); 
			affectedRows = pst.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("bookings not deleted ");
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean updateOrder(int orderId, String shippingAddress) { 
		try{
			String updateOrderQuery = "UPDATE booking set address=? where orderId=?;";
			PreparedStatement pst = connection.prepareStatement(updateOrderQuery);
			pst.setString(1,shippingAddress);
			pst.setInt(2,orderId); 
			int affectedRows = pst.executeUpdate();
			if(affectedRows == 0) {
				throw new SQLException("bookings not updated ");
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static bookingDetails getOrder(int orderId) { 
		bookingDetails bookingDetails= null;
		try{
			String selectOrderQuery = "SELECT * from booking, bookingDetail where booking.orderId=? and booking.orderId=bookingDetail.orderId;";
			PreparedStatement pst = connection.prepareStatement(selectOrderQuery);
			pst.setInt(1,orderId);
			pst.executeQuery();
			ResultSet rs = pst.getResultSet();
			if(rs.next()){
				bookingDetails = new bookingDetails(rs.getString("orderId"), rs.getDouble("totalAmount"), rs.getString("ccFirstName"), rs.getString("ccLastName"), 
				  rs.getInt("ccNumber"), rs.getInt("phoneNumber"), rs.getString("emailId"), rs.getString("address"));
				
				bookingDetails.setHotelId(rs.getString("id"));
				bookingDetails.setHotelName(rs.getString("name"));
				bookingDetails.setToDate(rs.getString("toDate"));
				bookingDetails.setFromDate(rs.getString("fromDate"));
				bookingDetails.setOrderDate(rs.getString("orderDate"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bookingDetails;
	}
	
	
	public int generateNewOrderId() {
		java.sql.Statement stm = null;
		Connection conn= null;
		int orderId;
		int newOrderId = 0;
		try {
			conn = getConnection();

			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String getMaxOrderId = "SELECT MAX(orderId) AS newId FROM booking;";

			ResultSet rst;
			rst = stm.executeQuery(getMaxOrderId);
			if (!rst.next()) {
				orderId = 0;
			} else {
				orderId = rst.getInt("newId");
			}

			newOrderId = orderId + 1;

			stm.close();
			conn.close();
		} catch (Exception e) {
			Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, e.getMessage(),
					e.getStackTrace());
		}

		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException se) {
					Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
							se.getStackTrace());
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
							se.getStackTrace());
				}
			}
		}
		Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, newOrderId + " returned value");

		return newOrderId;

	}

	public Boolean insertOrder(int orderId,String ccFirstName,String ccLastName,int ccNumber,int phoneNumber,String emailId,Double totalAmount,String address) {
		Boolean insertSuccess = false;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
		 conn=getConnection();

			String insertCustomerOrdersQuery = "INSERT INTO booking(orderId, ccFirstName, ccLastName, ccNumber, phoneNumber, emailId, totalAmount,address) "
					+ "VALUES (?,?,?,?,?,?,?,?);";

			pst = conn.prepareStatement(insertCustomerOrdersQuery);

	//		for(bookingDetails b: bd){
			pst.setInt(1,orderId);
	//		pst.setString(2,bd.getRoomType());
//			pst.setDouble(3,bd.getPrice());
			pst.setString(2,ccFirstName);
			pst.setString(3,ccLastName);

			pst.setInt(4,ccNumber);
			pst.setInt(5,phoneNumber);
			pst.setString(6,emailId);
			pst.setDouble(7,totalAmount);
			pst.setString(8,address);
		//	pst.setString(9,bd.getHotelId());
			//pst.setString(10,bd.getFromDate());
			//pst.setString(11,bd.getToDate());
			pst.execute();
			insertSuccess = true;

//}
			pst.close();
			conn.close();
		} catch (Exception e) {
			Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, e.getMessage(),
					e.getStackTrace());
		}

		finally {
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException se) {
					Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
							se.getStackTrace());
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException se) {
					Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
							se.getStackTrace());
				}
			}
		}

		return insertSuccess;

	}


	public Boolean insertOrderDetails(int orderId,String id,String name,Double price,String fromDate,String toDate) {
			Boolean insertSuccess = false;Connection conn =null;
			PreparedStatement pst = null;
			try {
				conn=getConnection();

				String insertCustomerOrdersQuery = "INSERT INTO bookingDetail(orderId, id, name, price, fromDate, toDate) "
						+ "VALUES (?,?,?,?,?,?);";

				pst = conn.prepareStatement(insertCustomerOrdersQuery);
				pst.setInt(1,orderId);
				pst.setString(2,id);
				pst.setString(3,name);
				pst.setDouble(4,price);
				pst.setString(5,fromDate);
				pst.setString(6,toDate);
				pst.execute();
				insertSuccess = true;


				pst.close();
				conn.close();
			} catch (Exception e) {
				Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, e.getMessage(),
						e.getStackTrace());
			}

			finally {
				if (pst != null) {
					try {
						pst.close();
					} catch (SQLException se) {
						Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
								se.getStackTrace());
					}
				}

				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException se) {
						Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
								se.getStackTrace());
					}
				}
			}

			return insertSuccess;

		}

	public static HashMap<String,List> getPackages()
	{
		Package pack = null;
		//HashMap<String,Package> packages = new HashMap<String, Package>();
		HashMap<String,List> packages = new HashMap<String, List>();
		String Pid, City, Image, Description;
		double Price, Ratings;
		int Available, Sold;
		List<String> packContent;
		try
		{
			Connection conn = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://smartbooking.cmu9foiuklwn.us-east-1.rds.amazonaws.com:3306/smartbooking?autoReconnect=true&useSSL=false", "hotels", "hotels123");

			Statement s = conn.createStatement ();
			s.executeQuery ("SELECT * FROM package");
			ResultSet rs = s.getResultSet();

			while (rs.next ())
			{
				packContent = new ArrayList<String>();
				Pid = rs.getString("Pid");
				packContent.add(Pid);
				City = rs.getString("City");
				packContent.add(City);
				Image = rs.getString("Image");
				packContent.add(Image);
				System.out.println(Image);
				System.out.println(" Images "+rs.getString("Image"));
				Description = rs.getString("Description");
				packContent.add(Description);

				Price = rs.getDouble("Price");
				packContent.add(Double.toString(Price));
				Ratings = rs.getDouble("Ratings");
				packContent.add(Double.toString(Ratings));

				Available = rs.getInt("Available");
				packContent.add(Integer.toString(Available));
				Sold = rs.getInt("Sold");
				packContent.add(Integer.toString(Sold));


				pack = new Package(Pid, City, Image, Description, Price, Ratings, Available, Sold);
				packages.put(Pid, packContent);
			}
			System.out.println("Customers: "+packages);
			rs.close ();
			s.close ();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return packages;
	}

	public static String getCity() {
		//ArrayList<String> cities = new ArrayList<String>();
		String citiessss="";

		try
		{
			Connection conn = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://smartbooking.cmu9foiuklwn.us-east-1.rds.amazonaws.com:3306/smartbooking?autoReconnect=true&useSSL=false", "hotels", "hotels123");

			Statement s = conn.createStatement ();
			s.executeQuery ("SELECT city FROM smartbooking.Hotels group by city;");
			ResultSet rs = s.getResultSet();

			while (rs.next ())
			{
				//cities.add(rs.getString("City"));
				citiessss = citiessss + rs.getString("city")+"***";
			}
			System.out.println("Cities: "+citiessss);
			//String [] city;
			//city = (String[]) cities.toArray();

			rs.close ();
			s.close ();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return citiessss;
	}

	public static HashMap<String,Hotel> readHotelList(Map<Utility.FILTER_KEY, String> filter){
		HashMap<String, Hotel> hotelList = new HashMap<>();
		Connection conn = null;
		java.sql.Statement stm = null;
		try {
			conn = getConnection();
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sqlQuery = "SELECT * FROM Hotels WHERE 1=1";
			for(Map.Entry<Utility.FILTER_KEY, String> myKey: filter.entrySet()){
				Utility.FILTER_KEY key = myKey.getKey();
				String value = myKey.getValue();
				switch(key){
				case CITY:
					if(null != value && !value.isEmpty()){
						sqlQuery += " AND city = '"+ value + "'"; }
					break;
				case PRICE_HIGH:
					if(null != value && !value.isEmpty()){
						sqlQuery += " AND price < '"+ Double.parseDouble(value) + "'"; }
					break;
				case PRICE_LOW:
					if(null != value && !value.isEmpty()){
						sqlQuery += " AND price > '"+ Double.parseDouble(value) + "'"; }
					break;
				case RATINGS :
					if(null != value && !value.isEmpty()){
						sqlQuery += " AND rating = '"+ value + "'"; }
					break;
				case ROOM_TYPE:
					if(null != value && !value.isEmpty()){
						sqlQuery += " AND roomType = '"+ value + "'"; }
					break;
				case DATE_START:
					if(null != value && !value.isEmpty()){
						String date_s = value;
						SimpleDateFormat dt = new SimpleDateFormat("dd.mm.yyyy");
						Date date = dt.parse(date_s);
						SimpleDateFormat dt1 = new SimpleDateFormat("mm/dd/yyyy");
						System.out.println(dt1.format(date));
						sqlQuery += " AND fromDate <= '"+ dt1.format(date) + "'"; }
					break;
				case DATE_END:
					if(null != value && !value.isEmpty()){
						String date_s = value;
						SimpleDateFormat dt = new SimpleDateFormat("dd.mm.yyyy");
						Date date = dt.parse(date_s);
						SimpleDateFormat dt1 = new SimpleDateFormat("mm/dd/yyyy");
						System.out.println(dt1.format(date));
						sqlQuery += " AND toDate >= '"+ dt1.format(date) + "'"; }
					break;
				case NUM_PERSON :
					if(null != value && !value.isEmpty()){
						sqlQuery += " AND maxOccupants >= '"+ value + "'"; }
					break;
				default:
					break;
				}
			}
			sqlQuery += " group by hotelName;";
			ResultSet rst;
			rst = stm.executeQuery(sqlQuery);
			hotelList = new HashMap<>();
			while (rst.next()) {
				Hotel hotel = new Hotel(rst.getString("hotelId"),rst.getString("city"), rst.getString("hotelName"), rst.getString("roomType"),
				  rst.getInt("available"), rst.getInt("sold"), rst.getDouble("price"), rst.getInt("maxOccupants"), rst.getString("fromDate"),
				  rst.getString("toDate"), rst.getDouble("rating"), rst.getString("images"), rst.getString("country"), rst.getString("amenities"),
				  rst.getString("beds"), rst.getString("bedType"), rst.getString("maxOccupants"), rst.getString("breakfast"), rst.getString("sale"), rst.getString("rebates"));
				Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, hotel.toString() + "read from db");
				hotelList.put(hotel.getHotelId(), hotel);
			}
			stm.close();
			conn.close();
		} catch (Exception e) {
			Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, e.getMessage()+"error while reading from db",
					e.getStackTrace());
		}

		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException se) {
					Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
							se.getStackTrace());
				}
			}

			if (conn != null) {
		      try {
		        conn.close();
		      } catch (SQLException se) {
		        Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, se.getMessage(),
		            se.getStackTrace());
		      }
		    }
		}
		return hotelList;
	}
	//Get all hotel for admin side
	public static HashMap<String,Hotel> getHotels()
	{
		//Hotel hotel = null;
		//HashMap<String,Package> packages = new HashMap<String, Package>();
		HashMap<String, Hotel> hotelList = new HashMap<String, Hotel>();
		String hotelId, hotelName, image, city, country, roomType;
	int available, sold;
	double ratings, price;
	int numGuests;
	String fromDate, toDate, amenities, beds, bedType, maxPerson, breakfast, sale, rebates;;

		try
		{
			Connection conn = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://smartbooking.cmu9foiuklwn.us-east-1.rds.amazonaws.com:3306/smartbooking?autoReconnect=true&useSSL=false", "hotels", "hotels123");

			Statement s = conn.createStatement ();
			s.executeQuery ("SELECT * FROM Hotels");
			ResultSet rs = s.getResultSet();
			Hotel hotel = null;
			while (rs.next ())
			{

				hotelId = rs.getString("hotelId");

				city = rs.getString("city");
				hotelName = rs.getString("hotelName");
				roomType = rs.getString("roomType");
				fromDate = rs.getString("fromDate");
				toDate = rs.getString("toDate");
				image = rs.getString("images");
				price = rs.getDouble("price");
				country = rs.getString("country");
				amenities = rs.getString("amenities");
				beds = rs.getString("beds");
				bedType = rs.getString("bedType");
				maxPerson = rs.getString("maxOccupants");
				breakfast = rs.getString("breakfast");
				ratings = rs.getDouble("rating");
				numGuests = rs.getInt("maxOccupants");
				available = rs.getInt("available");
				sold = rs.getInt("sold");
				sale = rs.getString("sale");
				rebates = rs.getString("rebates");
				hotel = new Hotel (hotelId, city, hotelName, roomType, available,  sold,  price, numGuests, fromDate,
	  toDate, ratings, image, country, amenities,beds, bedType, maxPerson, breakfast, sale, rebates);
				//packages.put(Pid, packContent);
				hotelList.put(hotelId, hotel);
			}
			System.out.println("Hotel: "+hotel);
			System.out.println("HotelList: "+hotelList);

			rs.close ();
			s.close ();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return hotelList;
	}
	public static Hotel getHotelById(String hotelId) throws SQLException {
		Hotel hotel = null;
		Connection conn = getConnection();
		String query ="SELECT * FROM smartbooking.Hotels where hotelId = ?;";
		PreparedStatement pst = conn.prepareStatement(query);
		pst.setInt(1, Integer.parseInt(hotelId));
		ResultSet rst = pst.executeQuery();

		while (rst.next()) {
			hotel = new Hotel(rst.getString("hotelId"),rst.getString("city"), rst.getString("hotelName"), rst.getString("roomType"),
			  rst.getInt("available"), rst.getInt("sold"), rst.getDouble("price"), rst.getInt("maxOccupants"), rst.getString("fromDate"),
			  rst.getString("toDate"), rst.getDouble("rating"), rst.getString("images"), rst.getString("country"), rst.getString("amenities"),
			  rst.getString("beds"), rst.getString("bedType"), rst.getString("maxOccupants"), rst.getString("breakfast"), rst.getString("sale"), rst.getString("rebates"));
			Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, hotel.toString() + "read from db");
			break;
		}
		rst.close ();
		pst.close ();
		return hotel;
	}

	public static List<String> getCities() throws SQLException {
		List<String> cities = new ArrayList<String>();
		Connection conn = getConnection();
		String sql ="SELECT DISTINCT(city) FROM smartbooking.Hotels group by city;";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
		ResultSet rs = stmt.getResultSet();
		while (rs.next ()) {
			cities.add(rs.getString("city"));
		}
		rs.close ();
		stmt.close ();
		return cities;
	}

	public static List<String> getRooms() throws SQLException {
		List<String> rooms = new ArrayList<String>();
		Connection conn = getConnection();
		String sql ="SELECT DISTINCT(roomType) FROM smartbooking.Hotels group by roomType;";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
		ResultSet rs = stmt.getResultSet();
		while (rs.next ()) {
			rooms.add(rs.getString("roomType"));
		}
		rs.close ();
		stmt.close ();
		return rooms;
	}

	public static List<String> getNumPersons() throws SQLException {
		List<String> persons = new ArrayList<String>();
		persons.add("Any");
		Connection conn = getConnection();
		String sql ="SELECT DISTINCT(maxOccupants) FROM smartbooking.Hotels group by maxOccupants;";
		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
		ResultSet rs = stmt.getResultSet();
		while (rs.next ()) {
			persons.add(rs.getString("maxOccupants"));
		}
		rs.close ();
		stmt.close ();
		return persons;
	}


	public Person getPerson(String email, String pass)
{

		Person p;
		String Id="";
		String firstName="";
		String lastName="";
		String emailId="";
		String password="";
		String type="";
		String address="";
		String cardNumber="";
		String cardDate="";
		String cardName="";


		try{
			Connection conn=getConnection();


			PreparedStatement ps=conn.prepareStatement("select *  from person where (emailid=?) and (password=?)");
			ps.setString(1,email);
			ps.setString(2,pass);


			ResultSet rs=ps.executeQuery();


			while(rs.next())
			{
				Id=rs.getString("Id");
				firstName=rs.getString("fname");
				lastName=rs.getString("lname");
				emailId=rs.getString("emailid");
				password=rs.getString("password");
				type=rs.getString("type");
				address=rs.getString("address");
				cardNumber=rs.getString("cardnumber");
				cardDate=rs.getString("carddate");
				cardName=rs.getString("cardname");
			}
		}
		catch(Exception e)
			{
					System.out.println("error while getting person from db"+e);

			}

		System.out.println(email+"T");
		System.out.println(emailId+"T");
		System.out.println(password+"T");
		System.out.println(pass+"T");
		System.out.println(""+email==emailId && password==pass);
		if(email.equals(emailId) && password.equals(pass))
		{
			System.out.println("inside if");
			p=new Person(type,firstName,lastName,email,pass, address);
			p.setId(Id);
			p.setaddress(address);
			p.setcardNumber(cardNumber);
			p.setcardDate(cardDate);
			p.setcardName(cardName);
			return p;

		}
		else
		{
			p=new Person("NA","NA","NA","NA","NA","NA");
			return p;

		}

}


public ArrayList<Person> readPerson() {
		ArrayList<Person> personList = null;
		java.sql.Statement stm = null;

		try {
			Connection conn=getConnection();
			stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String getpersonData = "SELECT type,fname,lname,emailid,password,address FROM person";

			ResultSet rst;
			rst = stm.executeQuery(getpersonData);
			personList = new ArrayList<>();
			while (rst.next()) {
				Person person = new Person(rst.getString("type"),rst.getString("fname"), rst.getString("lname"),
						rst.getString("emailid"), rst.getString("password"),rst.getString("address"));
				Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE,
						person.toString() + "read from db");
				personList.add(person);
			}

			stm.close();
			conn.close();
		} catch (Exception e) {
			Logger.getLogger(MySqlDataStoreUtilities.class.getName()).log(Level.SEVERE, e.getMessage(),
					e.getStackTrace());
		}


		return personList;
	}
	public void addPerson(Person p)
{
		String Id;
		String firstName;
		String lastName;
		String emailId;
		String password;
		String type;
		String address;
		String cardNumber;
		String cardDate;
		String cardName;

		

		try{

				Connection conn=getConnection();

				PreparedStatement ps=conn.prepareStatement("Insert into person values(?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1,Id);
				ps.setString(2,firstName);
				ps.setString(3,lastName);
				ps.setString(4,emailId);
				ps.setString(5,password);
				ps.setString(6,type);
				ps.setString(7,address);
				ps.setString(8,cardNumber);
				ps.setString(9,cardDate);
				ps.setString(10,cardName);

				ps.executeUpdate();//0ps.execute();


		}
		catch(Exception e)
			{
					System.out.println("error while adding Person"+e);

			}




}

//Calculate total sales per Day
	public static HashMap<String,Order> getDailySales()
	{
		Order order = null;
		HashMap<String,Order> orders = new HashMap<String, Order>();

		try
		{
			Connection conn = null;

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://smartbooking.cmu9foiuklwn.us-east-1.rds.amazonaws.com:3306/smartbooking?autoReconnect=true&useSSL=false", "hotels", "hotels123");

			Statement s = conn.createStatement ();
			s.executeQuery ("SELECT orderId ,orderDate, SUM(price) as dailySales FROM bookingDetail group by orderDate;");
			ResultSet rs = s.getResultSet();

			while (rs.next ())
			{
				String orderId = rs.getString ("orderId");
				String orderDate = rs.getString("orderDate");
				String id = "";
				String name = "";
				double amount = 0.0;
				String fromDate = "";
				String toDate = "";
				
				double dailySales = rs.getDouble("dailySales");
				//ArrayList blank = new ArrayList<String>();
			   
				order = new Order( orderId, id, name, amount, orderDate, fromDate, toDate, dailySales);
				orders.put(orderId, order);
			}
			//System.out.println("OrderItems: "+orderItems);
			rs.close ();
			s.close ();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("OrderItems: "+orders);
		return orders;
	}

	public static void main(String args[]){
		MySqlDataStoreUtilities msql = new MySqlDataStoreUtilities();
		System.out.println("Inside Main");
		MySqlDataStoreUtilities.getHotels();
		MySqlDataStoreUtilities.getDailySales();
		try {
			List<String> out = MySqlDataStoreUtilities.getCities();
			out = MySqlDataStoreUtilities.getRooms();
			out = MySqlDataStoreUtilities.getNumPersons();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
