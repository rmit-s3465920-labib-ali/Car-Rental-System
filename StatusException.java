import java.util.*;

public class StatusException extends Exception{
	
	String message;
	
	public String getMessage(){
		return message;
	}

	public StatusException(String string) {
		
		this.message = string;
	}

}
