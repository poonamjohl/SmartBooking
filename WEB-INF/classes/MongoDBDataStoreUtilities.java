import java.util.logging.*;
import java.util.HashMap;
import java.util.*;
import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ParallelScanOptions;
import com.mongodb.ServerAddress;
import com.mongodb.MongoException;
import com.mongodb.AggregationOutput;
import java.util.List;
import java.util.Set;

public class MongoDBDataStoreUtilities {

	static DBCollection hotelReviews = null;

	public static Boolean storeReview(Reviews reviewIn) {

		try {
			System.out.println("Tet ins"+reviewIn);
			MongoDBDataStoreUtilities.insertReview(reviewIn);
		} catch (Exception ex) {
			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.SEVERE, ex.getMessage(),
					ex.getStackTrace());
			return false;
		}

		return true;

	}

	public static LinkedHashMap<String, Float> mostLikedProducts() {
		
		getConnection();
		DBObject groupFields = new BasicDBObject("_id", 0);
		groupFields.put("_id", "$hotelName");
		groupFields.put("average", new BasicDBObject("$avg", "$reviewRating"));
		DBObject group = new BasicDBObject("$group", groupFields);

		DBObject sort = new BasicDBObject();
		sort.put("average", -1);
		DBObject orderby = new BasicDBObject("$sort", sort);

		DBObject limit = new BasicDBObject("$limit", 5);

		AggregationOutput output = hotelReviews.aggregate(group, orderby, limit);
		LinkedHashMap<String, Float> hotelList = new LinkedHashMap<String, Float>();

		for (final DBObject result : output.results()) {
			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO,
					"individual output " + result.toString());
			hotelList.put(result.get("_id").toString(), Float.parseFloat(result.get("average").toString()));
		}

		return hotelList;

	}

	public static LinkedHashMap<String, Integer> top5zipcodes() {
		getConnection();

		BasicDBObject query = new BasicDBObject();
		query.put("cityZip", new BasicDBObject("$ne", null));
		query.put("cityZip", new BasicDBObject("$ne", ""));

		DBObject match = new BasicDBObject("$match", query);

		DBObject groupFields = new BasicDBObject("_id", 0);
		groupFields.put("_id", "$cityZip");
		groupFields.put("count", new BasicDBObject("$sum", 1));
		DBObject group = new BasicDBObject("$group", groupFields);

		DBObject sort = new BasicDBObject();
		sort.put("count", -1);
		DBObject orderby = new BasicDBObject("$sort", sort);

		DBObject limit = new BasicDBObject("$limit", 5);

		AggregationOutput output = hotelReviews.aggregate(match, group, orderby, limit);

		Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO, "total output : " + output.toString());
		LinkedHashMap<String, Integer> hotelList = new LinkedHashMap<String, Integer>();

		for (final DBObject result : output.results()) {
			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO,
					"individual output " + result.toString());
			hotelList.put(result.get("_id").toString(), Integer.parseInt(result.get("count").toString()));
		}

		return hotelList;

	}

	public static LinkedHashMap<String, Integer> mostReviewedProducts() {
		getConnection();

		LinkedHashMap<String, ArrayList<Reviews>> reviewHashmap = new LinkedHashMap<String, ArrayList<Reviews>>();
		DBObject groupFields = new BasicDBObject("_id", 0);
		groupFields.put("_id", "$hotelName");
		groupFields.put("count", new BasicDBObject("$sum", 1));
		DBObject group = new BasicDBObject("$group", groupFields);

		DBObject sort = new BasicDBObject();
		sort.put("count", -1);
		DBObject orderby = new BasicDBObject();
		orderby = new BasicDBObject("$sort", sort);

		DBObject limit = new BasicDBObject("$limit", 5);

		AggregationOutput output = hotelReviews.aggregate(group, orderby, limit);

		Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO, "total output : " + output.toString());
		LinkedHashMap<String, Integer> hotelList = new LinkedHashMap<String, Integer>();

		for (final DBObject result : output.results()) {
			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO,
					"individual output " + result.toString());
			hotelList.put(result.get("_id").toString(), Integer.parseInt(result.get("count").toString()));
		}

		return hotelList;

	}

	public static HashMap<String, ArrayList<Reviews>> selectReview() {
		getConnection();
		HashMap<String, ArrayList<Reviews>> reviewHashmap = new HashMap<String, ArrayList<Reviews>>();

		DBCursor cursor = hotelReviews.find();

		while (cursor.hasNext()) {
			BasicDBObject obj = (BasicDBObject) cursor.next();
			if (!reviewHashmap.containsKey(obj.getString("hotelName"))) {
				ArrayList<Reviews> arr = new ArrayList<Reviews>();
				reviewHashmap.put(obj.getString("hotelName"), arr);
			}
			ArrayList<Reviews> listReview = reviewHashmap.get(obj.getString("hotelName"));
			Reviews review = new Reviews(obj.getString("hotelName"), obj.getString("hotelType"),obj.getString("cityName"), obj.getString("cityZip"), obj.getString("offers"), obj.getString("userName"),
					obj.getInt("userAge"), obj.getString("gender"), obj.getString("userOccupation"),
					obj.getInt("reviewRating"), obj.getString("reviewDate"), obj.getString("reviewText"));

			listReview.add(review);
		}
		return reviewHashmap;
	}

	public static void insertReview(Reviews reviewIn) {
		getConnection();
		BasicDBObject doc = new BasicDBObject("title", "hotelReviews").append("userName", reviewIn.getUserId())
				.append("hotelName", reviewIn.getHotelName())
				.append("hotelType", reviewIn.getHotelType()).append("cityName", reviewIn.getCityName()).append("cityZip", reviewIn.getCityZip())
				.append("offers", reviewIn.getOffers())
				.append("userAge", reviewIn.getUserAge())
				.append("gender", reviewIn.getUserGender()).append("userOccupation", reviewIn.getOccupation())
				.append("reviewRating", reviewIn.getRating()).append("reviewDate", reviewIn.getReviewDate())
				.append("reviewText", reviewIn.getReviewText());

		hotelReviews.insert(doc);

	}

	public static void getConnection() {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// MongoClient mongoClient = new MongoClient( "localhost" );

			DB db = mongoClient.getDB("HReviews");
			hotelReviews = db.getCollection("hotelReviews");

			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.INFO, "Successfully connected to mongodb");

		} catch (Exception ex) {
			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.SEVERE, "Failed to connect to mongodb",
					ex.getStackTrace());
			Logger.getLogger(WriteReviewsServlet.class.getName()).log(Level.SEVERE, ex.getMessage(),
					ex.getStackTrace());
		}
	}
	public static LinkedHashMap<String, LinkedHashMap<String, ArrayList<Object>>> selectReviewForChart()
	{
		{
		getConnection();
		LinkedHashMap<String, LinkedHashMap<String, ArrayList<Object>>> Top5ListOfLikedProductsForEveryCity = new LinkedHashMap<String, LinkedHashMap<String, ArrayList<Object>>>();
	
		AggregationOutput output1 =
            hotelReviews.aggregate(
                    new BasicDBObject("$group",
                            new BasicDBObject("_id", "$cityName"))
            );
		ArrayList<Object> values = new ArrayList<Object>();
		LinkedHashMap<String, ArrayList<Object>> hotelListHashMap = new LinkedHashMap<String, ArrayList<Object>>();
		String cityName="";
		for (final DBObject doc : output1.results()) 
		{
			System.out.println("doc");
			cityName = (String) doc.get("_id");
		
			AggregationOutput output =
            hotelReviews.aggregate(
					new BasicDBObject("$match", 
				    new BasicDBObject("cityName",
				    new BasicDBObject("$eq", cityName) ) ),
					
                    new BasicDBObject("$group",
                            new BasicDBObject("_id", "$hotelName")
                                    .append("avgRating", new BasicDBObject("$avg", "$reviewRating")))
                    ,
                    new BasicDBObject("$sort", new BasicDBObject("avgRating", -1)),
					
					new BasicDBObject("$limit", 3)
            );
			
			String city = cityName;
			String hotelName="";
			double avg = 0;
			
			
			
			for (DBObject doc2 : output.results())
			{
				hotelName = (String) doc2.get("_id");
				avg = (Double) doc2.get("avgRating");
				values.add(hotelName);
				values.add(avg);
				
				
				hotelListHashMap.put(hotelName, values);

				System.out.println("hotelName: " + hotelName);
				System.out.println("avg: " + avg);
				
			}
			
			Top5ListOfLikedProductsForEveryCity.put(cityName, hotelListHashMap);
			System.out.println("hotelListHashMap: " + hotelListHashMap);
		}
		
		System.out.println("Top5ListOfLikedProductsForEveryCity: " + Top5ListOfLikedProductsForEveryCity);
		return Top5ListOfLikedProductsForEveryCity;
	}
	}
}
	
	
	