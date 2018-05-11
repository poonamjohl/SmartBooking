import java.util.*;
import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class PersonAdapter{


	public HashMap<String, Person> People = new HashMap<String, Person>();
	
	public String datapath = "C:/Apache/apache-tomcat-7.0.34/webapps/csj/WEB-INF/classes/datafile";

	void Personpopulate(){
		
		Person p = new Person("customer","Shubham", "Bhardwaj", "sbhardwaj@hawk.iit.edu", "1234","Chicago");
		System.out.println("\t Customer ID : "+p.getId());
		People.put(p.getemailId(), p);
	}
	
	
	public HashMap<String, Person> getPersonHashMap()
	{
		try{

			InputStream data = PersonAdapter.class.getResourceAsStream("datafile");
			ObjectInputStream ois=new ObjectInputStream(data);
			HashMap<String,Person> people=(HashMap<String,Person>)ois.readObject();
			ois.close();

			

			for(Map.Entry<String,Person> m :people.entrySet()){

				
				Person p = m.getValue();
				
			}
			return people;

		}
		catch(Exception e){

			e.printStackTrace();

		}
		return null;

	}

	

	public void  writePersonHashMap(HashMap<String, Person> PersonUpdated){

		try{
			File customerHashmap=new File(datapath);
			FileOutputStream fos=new FileOutputStream(customerHashmap);
			ObjectOutputStream oos=new ObjectOutputStream(fos);

				oos.writeObject(PersonUpdated);
				oos.flush();
				oos.close(); 
				fos.close();

		}catch(Exception e){
			e.printStackTrace();

	}
	}
	
	
	
	private void  writePersonHashMap(){

		try{

			File PersonHashmap=new File("datafile");
			FileOutputStream fos=new FileOutputStream(PersonHashmap);
			ObjectOutputStream oos=new ObjectOutputStream(fos);

			oos.writeObject(People);
			oos.flush();
			oos.close();
			fos.close();
			
		}catch(Exception e){
			System.out.println("Hey Could NOT Write customers to CustomerHashMap ...");
		}

	}

	

	private void readPersonHashmap() {

		try{
			
			File customerHashmap=new File("datafile");
			FileInputStream fis=new FileInputStream(customerHashmap);
			ObjectInputStream ois=new ObjectInputStream(fis);
			HashMap<String,Person> customersFromFile=(HashMap<String,Person>)ois.readObject();

			ois.close();
			fis.close();
			System.out.println("Inside readcustomerHashmap method");
			System.out.println("customersFromFile : "+customersFromFile);
			
			for(Map.Entry<String, Person> m : customersFromFile.entrySet()) {
				System.out.println("Key: "+m.getKey());
				Person p = m.getValue();
				System.out.println("\n Customer ID: "+p.getId());
				System.out.println("\n First Name: "+p.getfirstName());
				System.out.println("\n Last Name: "+p.getlastName());
				System.out.println("\n Email ID: "+p.getemailId());
			}

		}catch(Exception e){

			

			System.out.println("Inside exception");

		}



	}


	
	//RunTest
	private void runTest() {
		//Personpopulate();
		//writePersonHashMap();
		getPersonHashMap();
	}
	
	//Main
	public static void main(String args[]) {
		
		PersonAdapter pa=new PersonAdapter();
		
		
		pa.runTest();
		
		
	}
}