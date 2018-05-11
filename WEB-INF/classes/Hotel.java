public class Hotel implements java.io.Serializable {

	private String hotelId;
	private String hotelName;
	private String image;
	private String city;
	private String country;
	private String roomType;
	private int available;
	private int sold;
	private Double ratings;
	private Double price;
	private int numGuests;
	private String fromDate;
	private String toDate;
	private String amenities;
	private String beds;
	private String bedType;
	private String maxPerson;
	private String breakfast, sale, rebates;
	
	public Hotel(String hotelId, String city, String hotelName, String roomType, 
	  int available, int sold, double price, int numGuests, String fromDate, 
	  String toDate, Double ratings, String image, String country, String amenities,
	  String beds, String bedType, String maxPerson, String breakfast, String sale, String rebates) {
		
		this.hotelId=hotelId;
		this.city=city;
		this.hotelName= hotelName;
		this.roomType= roomType;
		this.available=available;
		this.sold=sold;
		this.ratings=ratings;
		this.price=price;
		this.numGuests=numGuests;
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.image =image;
		this.country = country;
		this.amenities = amenities;
		this.beds = beds;
		this.bedType = bedType;
		this.maxPerson = maxPerson;
		this.breakfast = breakfast;
		this.sale = sale;
		this.rebates = rebates;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getSale() {
		return sale;
	}

	public void setSale(String sale) {
		this.sale = sale;
	}
	
	public String getRebates() {
		return rebates;
	}

	public void setRebates(String rebates) {
		this.rebates = rebates;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getSold() {
		return sold;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}

	public Double getRatings() {
		return ratings;
	}

	public void setRatings(Double ratings) {
		this.ratings = ratings;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public void setNumGuests(int numGuests) {
		this.numGuests = numGuests;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAmenities() {
		return amenities;
	}

	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	public String getBeds() {
		return beds;
	}

	public void setBeds(String beds) {
		this.beds = beds;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public String getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(String maxPerson) {
		this.maxPerson = maxPerson;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

}
