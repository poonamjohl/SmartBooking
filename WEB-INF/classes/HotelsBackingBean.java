import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelsBackingBean {

	private Map<String, Hotel> hotels;
	private Map<Utility.FILTER_KEY, String> filter;
	private List<String> cities;
	private List<String> rooms;
	private List<String> noOfPersons;
	private String city;
	private String priceHigh;
	private String priceLow;
	private String roomType;
	private String startDate;
	private String endDate;
	private String noOfPerson;
	private String rating;


	public HotelsBackingBean() throws Exception {
		this.filter = new HashMap<Utility.FILTER_KEY, String>();
		this.hotels = MySqlDataStoreUtilities.readHotelList(filter);
		try {
			this.cities = MySqlDataStoreUtilities.getCities();
			this.rooms = MySqlDataStoreUtilities.getRooms();
			this.noOfPersons = MySqlDataStoreUtilities.getNumPersons();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("My SQL is down. Please try later");
		}

		this.priceLow = Utility.def_priceH;
		this.priceHigh = Utility.def_priceL;
		this.city = Utility.def_city;
		this.roomType = Utility.def_room;
		this.startDate = Utility.def_start;
		this.endDate = Utility.def_end;
		this.noOfPerson = Utility.def_person;
		this.rating = Utility.def_rating;

	}

	public void setHotels(Map<String, Hotel> hotels) {
		this.hotels = hotels;
	}

	public Map<String, Hotel> getHotels() {
		return hotels;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPriceHigh() {
		return priceHigh;
	}

	public void setPriceHigh(String priceHigh) {
		this.priceHigh = priceHigh;
	}

	public String getPriceLow() {
		return priceLow;
	}

	public void setPriceLow(String priceLow) {
		this.priceLow = priceLow;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNoOfPerson() {
		return noOfPerson;
	}

	public void setNoOfPerson(String noOfPerson) {
		this.noOfPerson = noOfPerson;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setFilter(Map<Utility.FILTER_KEY, String> filter) {
		this.filter = filter;
	}

	public Map<Utility.FILTER_KEY, String> getFilter() {
		return filter;
	}


	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public List<String> getRooms() {
		return rooms;
	}

	public void setRooms(List<String> rooms) {
		this.rooms = rooms;
	}

	public List<String> getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(List<String> noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public boolean addFilter(Utility.FILTER_KEY key, String value) {
		if (key!=null && value != null && !value.isEmpty()) {
			filter.put(key, value);
			return true;
		}
		return false;
	}

	public boolean removeFilter(String key) {
		if(null !=key && null != filter.remove(key)) {
			return true;
		}
		return fetchPackages();
	}

	public boolean fetchPackages() {
		try{
			hotels = MySqlDataStoreUtilities.readHotelList(filter);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}
}
