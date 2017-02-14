
public abstract class Customer {

    String CusID;
	String name;
	int phone;
	
	
	public Customer(String id, String name, int phone) {
		
		this.CusID = id;
		this.name = name;
		this.phone = phone;
	}


	public String getCusID() {
		return CusID;
	}


	public void setCusID(String cusID) {
		CusID = cusID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}

	
	public abstract double getDiscount(double amount);

	public abstract void setMilAtHire(int mil);
	public abstract void setMilAtReturn(int  mil);


	public abstract int updateMilage();


	
	
}