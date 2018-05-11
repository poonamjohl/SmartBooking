
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Order implements java.io.Serializable {
	
	String orderId;
	String id;
    String name;
	double amount;
    String orderDate;
    String fromDate;
	String toDate;
	double dailySale;
  
    public Order(String orderId, String id, String name, double amount, String orderDate, String fromDate, String toDate, double dailySale){
		this.orderId = orderId;
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.orderDate = orderDate;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.dailySale = dailySale;
    }

	void setorderId(String orderId) {
		this.orderId = orderId;
	}

	public String getorderId() {
			return orderId;
	}
	
	void setDailySale(double dailySale) {
		this.dailySale = dailySale;
	}

	public double getDailySale() {
			return dailySale;
	}
	
	void setId(String id) {
		this.id = id;
	}

	public String getName() {
			return name;
	}
	void setName(String name) {
		this.name = name;
	}	
	
	public String getOrderDate() {
			return orderDate;
	}
	void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getFromDate() {
			return fromDate;
	}
	void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	public String getToDate() {
			return toDate;
	}
	void setToDate(String toDate) {
		this.toDate = toDate;
	}

	

}
