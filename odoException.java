
public class odoException extends Exception {
	
	String message;
	int odometer;

	public String getMessage(){
		
		return message;
	}
	
	public int getOdometer(){
		return odometer;
	}
	
	public odoException(String mess) {
		this.message = mess;
		
	}

}
