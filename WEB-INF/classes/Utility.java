
public class Utility {
	public static final String HOTEL = "Hotel";
	public static final String PACKAGE = "Package";

	public static final String def_city = "New York";
	public static final String def_room = "Single Room";
	public static final String def_person = "Any";
	public static final String def_priceH = "1500";
	public static final String def_priceL = "1";
	public static final String def_rating = "4";
	public static final String def_start = "";
	public static final String def_end = "";
	
	
	public enum FILTER_KEY{ 
		CITY("city"), ROOM_TYPE("roomType"), DATE_START("startDate"), DATE_END("endDate"), NUM_PERSON("noOfPerson"), 
		PRICE_HIGH("priceHigh"), PRICE_LOW ("priceLow"), RATINGS("rating"), BREAKFAST("breakfast");
		
		private String value;
		FILTER_KEY(String value) {
			this.value = value;
		}
		public String getValue() { return value; }
	};
}
	