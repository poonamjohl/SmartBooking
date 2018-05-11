
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Package implements java.io.Serializable {
	
	String Pid;
	String City;
	double Price;
	double Ratings;
	String Image;
	String Description;
	int available, sold;
	//ArrayList<Item> alItems;
	//HashMap<String,String> accessories;
  
    // public Product(String name, float price, String image, String company, String condition, double discount ,int available, int sold, String rebates , String sale){
        // //accessories = new HashMap<String,Accessory>();
		// this.name=name;
		// this.price=price;
		// this.image=image;
		// this.company=company;
		// this.condition=condition;
		// this.discount=discount;
		// this.available=available;
		// this.sold=sold;
		// this.rebates=rebates;
		// this.sale=sale;
		// this.accessories=new HashMap<String, String>();
    // }
	public Package(String Pid, String City, String Image, String Description, double Price, double Ratings, int available, int Sold) {
		this.Pid=Pid;
		this.City=City;
		this.Image=Image;
		this.Description=Description;
		this.Price=Price;
		this.Ratings=Ratings;
		this.available=available;
		this.sold=sold;
	}
	
	void setId(String Pid) {
		this.Pid = Pid;
	}

	public String getId() {
			return Pid;
	}
	
	
	void setAvailable(int available) {
		this.available = available;
	}

	public int getAvailable() {
			return available;
	}
	
	
	void setSold(int sold) {
		this.sold = sold;
	}

	public int getSold() {
			return sold;
	}

	
	void setCity (String City) {
		this.City = City;
	}

	public String getCity() {
			return City;
	}
	
	
	void setImage (String Image) {
		this.Image = Image;
	}

	public String getImage() {
			return Image;
	}
	
	
	void setDescription (String Description) {
		this.Description = Description;
	}

	public String getDescription() {
			return Description;
	}

	
	void setPrice (double Price) {
		this.Price = Price;
	}

	public double getPrice() {
			return Price;
	}
	
	void setRatings (double Ratings) {
		this.Ratings = Ratings;
	}

	public double getRatings() {
			return Ratings;
	}




}
	