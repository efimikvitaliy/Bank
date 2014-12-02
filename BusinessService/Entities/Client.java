package BusinessService.Entities;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:50:09
 */
public class Client {

	private String address;
	private String email;
	private String FirstName;
	private String id;
	private String SecondName;

	public Client(){

	}

	public void finalize() throws Throwable {

	}

	public String getAddress(){
		return address;
	}

	public String getEmail(){
		return email;
	}

	public String getFirstName(){
		return FirstName;
	}

	public String getSecondName(){
		return SecondName;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setAddress(String newVal){
		address = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setEmail(String newVal){
		email = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFirstName(String newVal){
		FirstName = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecondName(String newVal){
		SecondName = newVal;
	}

}