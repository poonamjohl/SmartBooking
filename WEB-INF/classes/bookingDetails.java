public class bookingDetails implements java.io.Serializable {

	private String orderId;
	private String hotelId;
	private String hotelName;
	private String roomType;
	private Double price;
	private Double totalAmount;
	private String fromDate;
	private String toDate;
	private int ccNumber;
	private String ccFirstName;
	private String ccLastName;
	private int phoneNumber;
	private String emailId;
	private String address;
	private String orderDate;

	public bookingDetails(String orderId,Double totalAmount, String ccFirstName, String ccLastName, int ccNumber, int phoneNumber, String emailId, String address) {

	this.orderId = orderId;
	//this.hotelName = hotelName;
	//this.roomType = roomType;
	this.totalAmount = totalAmount;
	//this.price = price;
	this.ccNumber=ccNumber;
	this.ccFirstName=ccFirstName;
	this.ccLastName=ccLastName;
	this.phoneNumber=phoneNumber;
	this.emailId =emailId;
	//this.hotelId = hotelId;
	//this.fromDate = fromDate;
	//this.toDate=toDate;
	this.address = address;
}

	public bookingDetails(String orderId,String hotelId,String hotelName, String roomType,double price,String fromDate, String toDate) {

	this.orderId = orderId;
	this.hotelId = hotelId;
	this.hotelName = hotelName;
	this.roomType = roomType;
	this.price = price;
	this.fromDate = fromDate;
	this.toDate=toDate;
	//this.ccNumber=ccNumber;
	//this.ccFirstName=ccFirstName;
	//this.ccLastName=ccLastName;
	//this.phoneNumber=phoneNumber;
	//this.emailId =emailId;


	}

	public String getorderId() {
		return orderId;
	}

	public void setorderId(String orderId) {
		this.orderId = orderId;
	}

	public Double gettotalAmount() {
		return totalAmount;
	}

	public void settotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
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


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public int getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(int ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcFirstName() {
		return ccFirstName;
	}

	public void setCcFirstName(String ccFirstName) {
		this.ccFirstName = ccFirstName;
	}

	public String getCcLastName() {
		return ccLastName;
	}

	public void setCcLastName(String ccLastName) {
		this.ccLastName = ccLastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setemailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
