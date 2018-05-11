import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.io.*;
import java.util.*;

public class DealMatches {

	static ArrayList<Object> products;
	static HashMap<String,Hotel> hotels;
	
	

	
	static MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
	
	public static void loadXML()
	{
		try{
			//AjaxUtility a = new AjaxUtility();
			hotels = mysql.getHotels();
		
		}catch(Exception E){
			System.out.println("Exception");
		}
	}
	
	static HashMap<String, Hotel> selectedHotels;
	
	public static ArrayList<String> tweets = new ArrayList<String>();
	
	public static ArrayList<String> getTweets()
	{
		return tweets;
	}
	
	public static HashMap<String, Hotel> getSelectedHotelsFromTweets()
	{
		loadXML();
		selectedHotels = new HashMap<String, Hotel>();
		
		tweets = new ArrayList<String>();
		
		String line=null;
		
		try
		{
			for(Map.Entry<String, Hotel> entry: hotels.entrySet())
			{
				
				Hotel s = entry.getValue();
				if(selectedHotels.size()<2 && !selectedHotels.containsKey(entry.getKey()))
				//if(!selectedProducts.containsKey(entry.getKey()))
				{
					BufferedReader reader = new BufferedReader(new FileReader(new File("C:/apache-tomcat-7.0.34/webapps/SmartBooking/DealMatches.txt")));
					
					line = reader.readLine();
					
					if(line==null)
					{
						
					}
					
					else
					{
						do{
							if(line.contains(s.getHotelName()))
							{
								tweets.add(line);
								selectedHotels.put(entry.getKey(), s);
								break;
							}
							
						}while ((line=reader.readLine()) != null);
					}
				
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return selectedHotels;
		
	}
	
	public static void main(String args[]){
		
		DealMatches dm = new DealMatches();
		
		HashMap<String, Hotel> s1=dm.getSelectedHotelsFromTweets();
		ArrayList<String> tweets=dm.getTweets();
		for(int i=0;i<tweets.size();i++)
			System.out.println(tweets);
			System.out.println(s1);
		for(Map.Entry<String,Hotel> m :s1.entrySet()){
			Hotel s = m.getValue();
			System.out.println(s.getHotelName());
		}

	}

}