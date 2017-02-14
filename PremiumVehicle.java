import java.util.Date;

public class PremiumVehicle extends Vehicle {
	
	int dailyMilage;
	int serviceLenght;
    int lastService;
    
    

	public PremiumVehicle(String vehicleid, String desc, double Drate, int Odometer, int DailyMil, int ServiceLen, int Lastservice) {
		
		super(vehicleid, desc, Drate, Odometer);
		
		dailyMilage = DailyMil;
		serviceLenght = ServiceLen;
		lastService = Lastservice;
		
	}
	
	public boolean serviceComplete(int odo) throws StatusException, odoException{
		
		lastService = odo;
		return super.serviceComplete(odo);
		
	}
	
	public boolean hire(String HireID) throws StatusException{
	
		
		 if(( super.getOdometer() - lastService )< serviceLenght){
			 
			return super.hire(HireID);
			 
		  }else{
			  System.out.println("Service is due. Cannot be hired.");
			  return false;
		  }
	}

	
	public double hireComplete(int odom) throws StatusException, odoException{
		
		if((super.getOdometer() - odom) > dailyMilage){
			
			double Price = super.hireComplete(odom);
			return Price;
		}else{
			return super.hireComplete(odom);
		}
	}
	

	public void print(){
		
		
		super.print();
		System.out.println(" Daily-Milage:  " + dailyMilage + " Service-Lenght:  " + serviceLenght + " Last-Service:  " + lastService);
	}
	
}
