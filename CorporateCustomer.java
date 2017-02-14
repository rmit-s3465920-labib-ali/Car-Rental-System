
public class CorporateCustomer extends Customer{

	double rate;
	
	public CorporateCustomer(String id, String name, int phone, double R) {
		
		super(id, name, phone);
		this.rate = R;
	}

	
	public double getDiscount(double amount) {
		
		double discount = amount - (amount * (rate/100));
		
		return discount;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	@Override
	public void setMilAtHire(int mil) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setMilAtReturn(int mil) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int updateMilage() {
		// TODO Auto-generated method stub
		return 0;
	}


	
	

}
