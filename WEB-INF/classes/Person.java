import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Person implements java.io.Serializable {

	//static incrementer to give every new person a unique id.
	static int scounter=1;
	static int ccounter=1;
	static int rcounter=1;
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

	public Person (String type,String firstName, String lastName, String emailId, String password, String address){
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailId=emailId;
		this.password=password;
		this.type=type;
		this.address=address;
		if(type=="salesman")
		{
			setId("S"+Integer.toString(scounter));	
			setcardName("NA");
			setcardDate("NA");
			setcardNumber("NA");
			scounter++;
		}
		if(type=="retailer")
		{
			setId("R"+Integer.toString(rcounter));	
			setcardName("NA");
			setcardDate("NA");
			setcardNumber("NA");
			rcounter++;
		}
		if(type=="customer")
		{
			setId("C"+Integer.toString(ccounter));
			ccounter++;
		}
	}

	void settype(String firstName) {
		this.type=type;
	}		
	public String gettype() {
		return type;
	}
	
	
	
	void setfirstName(String firstName) {
		this.firstName=firstName;
	}		
	public String getfirstName() {
		return firstName;
	}
	void setId(String Id) {
		this.Id = Id;
	}

	public String getId() {
		return Id;
	}
		
	void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getlastName() {
		return lastName;
	}

	void setemailId(String emailId) {
		this.emailId = emailId;
	}

	public String getemailId() {
			return emailId;
		}
		
	void setpassword(String password) {
		this.password = password;
	}

	public String getpassword() {
			return password;
		}

	void setaddress(String address) {
		this.address = address;
	}

	public String getaddress() {
			return address;
		}

	void setcardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getcardNumber() {
			return cardNumber;
		}

	void setcardDate(String cardDate) {
		this.cardDate = cardDate;
	}

	public String getcardDate() {
			return cardDate;
		}

	void setcardName(String cardName) {
		this.cardName = cardName;
	}

	public String getcardName() {
			return cardName;
		}

	
}