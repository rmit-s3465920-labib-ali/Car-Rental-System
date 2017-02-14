import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageHiring{

	
// Class to test the Vehicle class (provided) class TestVehicle
	
	static String option;
	static int loop = 1;
	static int v;
	static int odo;
	static int ARRAY_SIZE = 100;
	static int ARRAY_FILLED = 0;
	static int ARRAY_POSITION = 0;
	static int ARRAY_POSITION2 = 0;
	static Vehicle[] vehs = new Vehicle[ARRAY_SIZE];
	static Customer[] cust = new Customer[100];
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) throws StatusException, odoException, IOException {
	
		
		readVehicle();
		readCustomer();
		
		
		
		/*
		vehs[0] = new Vehicle("QJT123", "Startlet99", 35.00, 190000);
		vehs[1] = new PremiumVehicle("QKO156", "Honda Accord 04", 65.00, 125000, 100, 1000000, 5000);
		vehs[2] = new Vehicle("TUV178", "Toyata Starlet 02", 35.00, 180000);
		vehs[3] = new Vehicle("SAG132", "Toyata Avalon 05", 52.00, 190000);
		vehs[4] = new PremiumVehicle("PRE342", "Honda Civic 97", 35, 145000, 120, 12000, 20000);
        */
		while(loop != 0){
		System.out.println("\n\nSelect From Following options :");
		System.out.println("1. View All Vehicles");
		System.out.println("2. Select Price Range");
		System.out.println("3. Hire Vihicle");
		System.out.println("4. Complete Hire");
		System.out.println("5. Service Vehicle");
		System.out.println("6. Complete Service");
		System.out.println("7. Add new Vehicle");
		System.out.println("8. Add new customer");
		System.out.println("9. Quit");
		
		option = sc.next();
		
		switch(option){
		
		
		  case "1" :
			  AllVehicle();
			  break;
		  case "2" : 
			  selectedVehicle();
			  break;  
		  case "3" : 
			  	 hireVehicle();
			     break;
		  case "4" :
			  completeHire();
			  break;
		  case "5" : 
		      serviceVehicle();
			  break;
		  case "6" :
		      completeService();
			  break;
		  case "7" :
			  addVehicle();
			  break;
		  case "8" :
			  addCustomer();
			  break;
		  case "9" :
			  loop = 0;
			  break;
		
		  
		}
						
		}
		
        
        }
	
	public static void readVehicle() throws IOException{
		
	    String VID;
	    String desc;
	    double rate;
	    int odo;
	    int DailyMil;
	    int ServiceLen;
	    int Lastservice;
	    
	    
		
		BufferedReader bufr = new BufferedReader(new FileReader("Vehicle.txt"));
		
		String line = null;
		
		line = bufr.readLine();
		
		while(line != null){
			
			int i = 0;	
		String details;
		
		details = line;
		
		String[] splitter = new String[7];
		
		for(String vh : details.split(",")){
			
			splitter[i] = vh;
			i++;
		}
		
		  VID =  splitter[0];
		  desc = splitter[1];
		  rate = Double.parseDouble(splitter[2]);
		  odo = Integer.parseInt(splitter[3]);
		
		  if(i > 4){
			  DailyMil = Integer.parseInt(splitter[4]);
			  ServiceLen = Integer.parseInt(splitter[5]); 
			  Lastservice = Integer.parseInt(splitter[6]);
			  
			  
			  vehs[ARRAY_POSITION] = new PremiumVehicle(VID, desc, rate, odo, DailyMil, ServiceLen, Lastservice);
		  }else{
		       
			  vehs[ARRAY_POSITION] = new Vehicle(VID, desc, rate, odo);
		  }
		  
		  ARRAY_FILLED++;
		  ARRAY_POSITION++;
		  
			

			line = bufr.readLine();
		}
		
		
	}
	
	public static void readCustomer() throws IOException{
		
		BufferedReader bufr = new BufferedReader(new FileReader("Customer.txt"));
		
		String id; 
		String name; 
		int phone; 
		int experience;
		double rating;
		char custType;
		
		String line = bufr.readLine();
		
		
        while(line != null){
			
			int i = 0;	
		    String details;
		
		    details = line;
		
		    String[] splitter = new String[5];
		
		    for(String vh : details.split(",")){
			
			   splitter[i] = vh;
			   i++;
		     }
		
		    id =splitter[1];
		    name = splitter[2];
		    phone = Integer.parseInt(splitter[3]);
		   
		   if((splitter[0]).charAt(0) == 'I'){
		    	
		    	 experience = Integer.parseInt(splitter[4]);
		    	 cust[ARRAY_POSITION2] = new ICustomer(id, name, phone, experience);
		      }else{
		    	rating = Double.parseDouble(splitter[4]);
		    	  cust[ARRAY_POSITION2] = new CorporateCustomer(id, name, phone, rating);
		     }
		
		   ARRAY_POSITION2++;
		  
		 line = bufr.readLine();
        
        }
	}
	
	public static int custDuplicateCheck(String ID, String nam) throws IOException{
		
		
        BufferedReader bufr = new BufferedReader(new FileReader("Customer.txt"));
		
		String id = ID; 
		String name = nam; 
		

		String line = bufr.readLine();
		
		
        while(line != null){
			
			int i = 0;	
		    String details;
		
		    details = line;
		
		    String[] splitter = new String[5];
		
		    for(String vh : details.split(",")){
			
			   splitter[i] = vh;
			   i++;
		     }
		
		   if( id.equals(splitter[1])){
			   System.out.println("ID already exists. Please enter different ID");
			   return 1;
		   }else if(name.equals(splitter[2])){
			   System.out.println("Name already exists. Please enter different name");
			   return 1;
		   }else{
			   line = bufr.readLine();
		   }
		    
		     }
		
        return 0;
	}
	
	
	public static void addCustomer() throws IOException{
		
		
		int expYear = 0;
		double rating = 0;
		String custID;
		String name;
		loop = 0;
		
		System.out.println("1. Press 'I' to add Individual Customer");
		System.out.println("2. Press 'C' to add Corporate Customer");
		
		String custype = sc.next();
		
		do{
		System.out.println("Enter customer ID: ");
		 custID = sc.next();
		System.out.println("Enter customer name: ");
		 name = sc.next();
		
		if(custDuplicateCheck(custID, name) == 1){
			
		}else{
			loop = 1;
		}
		
		}while(loop == 0);
		
		System.out.println("Enter customer phone number");
		int phone = sc.nextInt();
		
		if(custype.charAt(0) == 'I'){
		System.out.println("Enter customer driving experience(In year): ");
		expYear = sc.nextInt();
		}else{
			System.out.println("Enter customer ratings: ");
			rating = sc.nextDouble();
		}
		
		
		
		try(FileWriter fw = new FileWriter("Customer.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.print("\n");
			    out.print(custype);
			    out.print(",");
			    out.print(custID);
			    out.print(",");
			    out.print(name);
			    out.print(",");
			    out.print(phone);
			  
			    if(custype.charAt(0) == 'I'){
			    	 out.print(",");
			    	 out.print(expYear);
			    }else{
			    	 out.print(",");
			    	 out.print(rating);
			    }
			   
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		
		ARRAY_POSITION2 = 0;
		readCustomer();
		
	}
	
	
	
	

	public static void addVehicle() throws IOException{
		int loop = 0;
		
		System.out.println("1. Add Vehicle: ");
		System.out.println("2. Add Premium Vehicle: ");
		
		int option = sc.nextInt();
		
		do{
		System.out.println("Enter vehicleID(6 Character): ");
		
		String ID = sc.next();
		String decs;
		double rate;
		int odo;
		int DailyMil = 0;
	    int ServiceLen = 0;
	    int Lastservice = 0;
	    
	    
		if(ID.length() != 6){
			System.out.println("LIMIT ERROR!!!! Please enter again: ");
		 
		   }else{
			   
			System.out.println("Enter Vehicle Description: ");
			decs = sc.next();
			System.out.println("Enter Vehicle Daily-Rate(Doublr): ");
			rate = sc.nextDouble();
			System.out.println("Enter Vehicle odometer(Int): ");
			odo = sc.nextInt();
			
			if(option == 2){
				System.out.print("Enter Daily-Mileage: ");
				DailyMil = sc.nextInt();
				System.out.print("Enter Service-Lenght: ");
			    ServiceLen = sc.nextInt(); 
			    System.out.print("Enter Last Service: ");
			    Lastservice = sc.nextInt();
				
			}
			
			try(FileWriter fw = new FileWriter("Vehicle.txt", true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.print("\n");
				    out.print(ID);
				    out.print(",");
				    out.print(decs);
				    out.print(",");
				    out.print(rate);
				    out.print(",");
				    out.print(odo);
				  
				    if(option == 2){
				    	 out.print(",");
				    	 out.print(DailyMil);
				    	 out.print(",");
				    	 out.print(ServiceLen);
				    	 out.print(",");
				    	 out.print(Lastservice);
				    	
				    }
				   
				} catch (IOException e) {
				    //exception handling left as an exercise for the reader
				}
			 ARRAY_FILLED = 0;
			  ARRAY_POSITION = 0;
			readVehicle();
			  loop++;
		}
		}while(loop == 0);
		
	}
	
	
	
	public static  void AllVehicle(){
		
		for(int i=0; i < ARRAY_FILLED ; i++){

	    //String description	= vehs[i].getDescription1();
		//String ID = vehs[i].getID() ;
		//int odometer = vehs[i].getOdometer();
		
		
		
			vehs[i].print();
			if(vehs[i].getStatus() == 'H'){
		      System.out.println("HirerName: " + vehs[i].getHirer() + "  HireDate: " + vehs[i].getDATE() );
			}else{}
		
	}
	}
	
	public static int SearchCustomer(){
		
		int i = 0;
		int loop = 0;
        String CustID = null;
		
		while(loop == 0){
			
			System.out.println("Enter customer ID: ");
			String ID = sc.next();
		
		while( i < ARRAY_POSITION2 && !ID.equals(CustID)){
	        
			CustID = cust[i].getCusID();
			
			i++;
			}
		
		     i--;
		     
		     if(ID.equals(CustID)){
		    	 loop = 1;
		    	 return i;
		    	 
		     }else{
		    	 System.out.println("No entries found. Try again.");
		    	 loop = 0;
		    	 i=0;
		}
	}
		   return -1;
	}

	
	
	
	public static void hireVehicle() throws StatusException, IOException{
		
		int loop = 0;
		
		try{
			
			System.out.print("Are you a registered Customer(Y/N): ");
		  	String option = sc.next();
		  	
		  	while(loop == 0){
		  	if(option.equals("N") || option.equals("n")){
		  		System.out.println("Please register to continue: ");
		  		addCustomer();
		  		System.out.println("Now you are ready to hire vehicle..........\n----------------------------------\n");
		  		option = "Y";
		  	}else{
        
		 // System.out.print("Enter Hirer ID: ");
		  int	custIndex = SearchCustomer();
		  String ID =  cust[custIndex].getCusID();
		  if( cust[custIndex] instanceof ICustomer){
			  
			  if(((ICustomer) cust[custIndex]).getCarRented() == 1){
				  System.out.println("You have already hired one vehicle. Operating unsuccessful!!!");
				  break;
			  }else{
				  ((ICustomer) cust[custIndex]).setCarRented(1);
				  int v = ArrayLoop();
				  
				  cust[custIndex].setMilAtHire(vehs[v].getOdometer());
				  vehs[v].hire(ID);
				  loop = 1;
			  }
			  
		  }else{
			  
		  int v = ArrayLoop();
		  
		  cust[custIndex].setMilAtHire(vehs[v].getOdometer());
		  vehs[v].hire(ID);
		  loop = 1;
		}
		  	}
		 }}catch(StatusException e){
			if(e.getMessage().charAt(14) == 'H'){
				System.out.println("Vehicle you have attempted to hire is not avaliable.\nPlease hire another Vehicle. ");
			}else{
				System.out.println("Please hire when it's back from service. Hire Another Vehicle.");
			}
		}
	
	}
	
	
	public static void completeHire() throws StatusException, odoException{
		
		int condition = 1;
		int condition2 = 1;
	
		do{
		try{
			
		   int custIndex = SearchCustomer();
			
		
		System.out.println("Enter Odometer: ");
		  odo = sc.nextInt();
		  
		  int v = ArrayLoop();
		  if(vehs[v].getHirer().equals(cust[custIndex].getCusID())){
		 double price =  vehs[v].hireComplete(odo);
		 if(cust[custIndex] instanceof ICustomer){
		  ((ICustomer) cust[custIndex]).setCarRented(0);
		 }
		  cust[custIndex].setMilAtReturn(odo);
		  cust[custIndex].updateMilage();
		  double discountP =cust[custIndex].getDiscount(price);
		  
		  
		  
		 if(price == discountP){
			 System.out.print("No discount is offered. Total amount is " + discountP);
			 
		 }else{
			 System.out.println("Amount after discount is" + discountP);
		 }
		  
		  condition = 2;
		  condition = 2;
		
			
		  }else{
			  System.out.println("CustomerID not matching with hirerID of this vehicle. Please enter again....");
		  }
		}catch(StatusException e){
			System.out.println("Renter vehicleID as this vehicle is not on hire");
		}catch(InputMismatchException e){
			System.out.println("Please enter odometer again");
			sc.nextLine();
		}catch(odoException e){
			System.out.println("ERROR!!! Try again");
			sc.nextLine();
		}
		}while(condition == 1);
	}
	
	
	public static void serviceVehicle() throws StatusException{
		
		try{
			v= ArrayLoop();
		 vehs[v].service();
		}catch(StatusException e){
			if(e.getMessage().charAt(15) == 'S'){
				System.out.println("Vehile is already on service.\n redirecting to main menu.......");
			}else{
				System.out.println("Vehicle is on hire.\n redirecting to main manu.......");
			}
		}
	}
	
	
	public static void completeService() throws StatusException, odoException{
		
		int condition = 1;
		
		do{
		try{System.out.println("Enter Odometer: ");
		   odo = sc.nextInt();
		 v = ArrayLoop();
		 vehs[v].serviceComplete(odo);
		 condition = 2;
		}catch(StatusException e){
			System.out.println("ERROR!!! Selected Vehicle is not on Service.\nRedirecting to main menu....");
			condition = 2;
		}catch(odoException e){
			System.out.println("Incorrect odometer readings. Please enter again");
		}catch(InputMismatchException e){
			System.out.println("Wrong input. Please re-enter");
			sc.nextLine();
		}
	  }while(condition == 1);
	
	}
	
	
	
	
	
	
	
	
	
	public static void selectedVehicle(){
		
		
		
			double min, max;
			int count=0;
			
			
			System.out.println("Enter Minimun Value:");
			min = sc.nextDouble();
			System.out.println("Enter Maximum Value:");
			max = sc.nextDouble();
			
			
			
			for(int j=0; j < ARRAY_POSITION ; j++){
			
				double price = vehs[j].getdailyRate();
				
	
				if(price >= min && price <= max){
				   count++;
				}else{
					
				}
			}
			
				
				if(count != 0){
					 
					System.out.println("\n Following vehicle for specified price range::::\n----------------------------------------------------\n");
					
					 for(int z=0; z < ARRAY_FILLED; z++){
						 
					double price = vehs[z].getdailyRate();
				    String description	= vehs[z].getDescription1();
					String ID = vehs[z].getID() ;
							
							if(price >= min && price <= max){
								
								System.out.println("vehicle ID: " +  ID + "  Description: " + description + "  Daily-Rate  " +price );
							}else{
								
							} }
				 }else{
					 System.out.print("No Entry Found");				
			}
		}
	
	
	
	public static int ArrayLoop(){
		int L = 0;
		
		while(L == 0){ 
			
			int i=0; 
			int j;
			String VID = null;
			
			System.out.println("Enter Vehicle ID: ");
			String ID = sc.next(); 
			
		 while( i < ARRAY_FILLED  && !ID.equals(VID)){
			
		    VID = ManageHiring.vehs[i].getID();
			i++;
		  }
		
		i--;
		
		if(ID.equals(VID)){
			return i;
		}else{System.out.println("No Entries Found"); L = 0;}  	
		}
			return -1;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	