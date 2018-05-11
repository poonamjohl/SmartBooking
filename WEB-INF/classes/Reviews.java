

public class Reviews {
	private String hotelName;
	private String hotelType;
	private String cityName;
	private String cityZip;
	private String offers;
	private String userId;
	private int userAge;
	private String userGender;
	private String occupation;
	private Integer rating;
	private String reviewDate;
	private String reviewText;
	private Integer count;

	public Reviews(){}

	public Reviews(String hotelName, String hotelType, String cityName,
			String cityZip,String offers,String userId, int userAge, String userGender,
			String occupation, Integer rating, String reviewDate, String reviewText) {
		
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.cityName = cityName;
		this.cityZip = cityZip;
		this.offers = offers;
		this.userId = userId;
		this.userAge = userAge;
		this.userGender = userGender;
		this.occupation = occupation;
		this.rating = rating;
		this.reviewDate = reviewDate;
		this.reviewText = reviewText;
		
	}

	public Reviews(String hotelName, String hotelType, String cityName,
			String cityZip, String offers, String userId, int userAge, String userGender,
			String occupation, Integer rating, String reviewDate, String reviewText, Integer count) {
		
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.cityName = cityName;
		this.cityZip = cityZip;
		this.offers = offers;
		this.userId = userId;
		this.userAge = userAge;
		this.userGender = userGender;
		this.occupation = occupation;
		this.rating = rating;
		this.reviewDate = reviewDate;
		this.reviewText = reviewText;
		this.count = count;
		
	}

	public int getCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityZip() {
		return cityZip;
	}
	public void setCityZip(String cityZip) {
		this.cityZip = cityZip;
	}
	public String getOffers() {
		return offers;
	}
	public void setOffers(String offers) {
		this.offers = offers;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String toString() {
		return "Employee [hotelName=" + hotelName + ", hotelType=" + hotelType
				+ ",cityName=" + cityName + ", cityZip=" + cityZip
				+ ",offers=" + offers + ", userId=" + userId + ", userAge=" + userAge + ", userGender=" + userGender
				+ ", occupation=" + occupation + ", rating=" + rating + ", reviewDate=" + reviewDate + ", reviewText="
				+ reviewText + "]";
	}
}