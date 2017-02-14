import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import java.util.Scanner;

public class Vehicle {

	private String vehicleId;
	private static String hirerId;
	private String description;
	protected  char status = 'A';
	private Double dailyRate;
	private int odometer;
	DateTime d1;
	DateTime d2;
	String DATE;
	static Scanner sc = new Scanner(System.in);
	
	
	public Vehicle(String vehicleid, String desc, double Drate, int Odometer){
		  vehicleId = vehicleid;
		  description = desc;
		  dailyRate = Drate;
		  odometer = Odometer; 
		  
	  }	
	
	public String getDATE(){
		return DATE;
	}
	
 public Double getdailyRate(){
	 
	 return dailyRate;
	 
 }	
 
 public int getOdometer(){
	 return odometer;
 }
	
	
  public String getHirer() {
		return hirerId;
	}

	public void hirer(String HirerID) {
		this.hirerId = HirerID;
	}

public String getID() {
		return vehicleId;
	}

	public void setID(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public char getStatus(){
		return status;
	}

	
  public boolean hire(String HireID) throws StatusException{
	   
	  if(status == 'H'){
		  throw new StatusException("Vehicle is on Hire");
	  }
		 
		
	  if(status == 'S'){ 
		  throw new StatusException("Vehicle is on Service");
	  }else{
		  
	  hirerId = HireID;
		
		d1 = new DateTime();
		
		  
		Date date = new Date();
		DATE = date.toString();
		
		
		status = 'H';
		System.out.print("Hired");
		
		
		 String details = DATE + "         " + vehicleId + " hired by "+ hirerId + " odometer" + odometer; 
		  
		  transaction(details);
		
		
		 return true;
	  }

  }



public boolean service() throws StatusException{
	
	if(status == 'S'){
		  throw new StatusException("Vehicle is on Service");
		  
	  }else if(status == 'H'){
			 throw new StatusException("Vehicle is on hire");
	  }else{
		  
		  status = 'S';
		  
		  
		  Date date = new Date();
			DATE = date.toString();
			
          String details = DATE + "         " + vehicleId + " sent to service"; 
		  
		  transaction(details);
		  
		  System.out.println("Vehicle is send for service");
			return true;
	  
	  }

	
	   
  } 
  
  public boolean serviceComplete(int odo) throws StatusException, odoException{
  
	  if(status == 'S'){
		  odometer = odo;
		  status = 'A';
		  
		  Date date = new Date();
			DATE = date.toString();
			
          String details = DATE + "         " + vehicleId + " returned from service"; 
		  
		  transaction(details);
		  
		  System.out.println("Vehicle is return from service.");
		  return true;
	  }else if(odo <= odometer){
		  throw new odoException("");
	  }else{
		  throw new StatusException("Vehicle is not on service, cannot be returned.");
	  }
  }
	
  
  public double hireComplete(int odo) throws StatusException, odoException{
	
	  double Price = 0;
	  
	  
	  if(status != 'H') {
		  throw new StatusException("Vehicle is not Hired. Cannot be returned.");
	  }else if(odo <= odometer){
		  throw new odoException("Wrong odometer. Please re-enter it");
		  
	  }
	  
	  else{
		  DateTime d2 = new DateTime();
		  odometer = odo;
		  status = 'A';
		  
		  int difference = DateTime.diffDays(d2, d1);
		  
		  
		  Price =  difference * dailyRate;
		  
		  Date date = new Date();
		  DATE = date.toString();
			
		  String details = DATE + "         " + vehicleId + " returned odomter" + odometer; 
		  
		  transaction(details);
		  
		  return Price;
		  
	  }
	  
  }
  
  
  public void print(){ 
	  
	Date date = new Date();
	
	  
	System.out.println(date.toString());
	  
	  
	 
	  
	  System.out.println("vehicle ID =" +  vehicleId + "\t" +  "description = " +  description + "\t" + "status = " + status + "\t" + "daily rate = " + dailyRate + "odometer reading = " + odometer );
	  
  }
  
  
  public static void transaction(String detail){

	  String details = detail;
	  
		try(FileWriter fw = new FileWriter("transaction.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.print(details);
			    out.print("\n");
			    
			    
			}catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
	}
  
  
  

public String getDescription1() {
	// TODO Auto-generated method stub
	return description;
} 
  
  
}
