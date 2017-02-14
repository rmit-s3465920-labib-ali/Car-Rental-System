
public  class ICustomer extends Customer{

	int carRented = 0;
	

	int ExpYear;
	int mileage = 0;
	int milAtHire;
	int milAtReturn;
	
	public ICustomer(String id, String name, int phone, int experience) {
		
		super(id, name, phone);
		this.ExpYear = experience;
		
	}
	
	
	
	
	public int getCarRented() {
		return carRented;
	}

	public void setCarRented(int carRented) {
		this.carRented = carRented;
	}
	
	
	public int getExpYear() {
		return ExpYear;
	}

	public void setExpYear(int expYear) {
		ExpYear = expYear;
	}

	public void setMilAtHire(int mil){
		this.milAtHire = mil;
		
	}
	
	public void setMilAtReturn(int  mil){
		this.milAtReturn = mil;
	}

	public int updateMilage(){
		
	    int travelMil =  milAtReturn - milAtHire ;
		
	    mileage += travelMil; 
	   
	    System.out.println("mileage update : " + mileage);
		return mileage;
		
	}

	public double getDiscount(double am) {
		
		double amount = am;
		double disAmount;
		
		if(mileage > 100000 && mileage <= 200000){
			
			disAmount = amount * 0.9;
			return disAmount;
			
		}else if(mileage > 200000){
			disAmount = amount * 0.8;
			return disAmount;
		}else{
			return amount;
		}
		
		
	}

}
