package BusinessService.Entities;

public class Client
{
	private String address;
	private String email;
	private String FirstName;
	private String id;
	private String SecondName;

	public Client(){}
	public Client(String id, String FirstName, String SecondName)
	{
		this.setId(id);
		this.FirstName = FirstName;
		this.SecondName = SecondName;
	}
	public String getAddress()
	{
		return address;
	}
	public String getEmail()
	{
		return email;
	}
	public String getFirstName()
	{
		return FirstName;
	}
	public String getSecondName()
	{
		return SecondName;
	}
	public void setAddress(String newVal)
	{
		address = newVal;
	}
	public void setEmail(String newVal)
	{
		email = newVal;
	}
	public void setFirstName(String newVal)
	{
		FirstName = newVal;
	}
	public void setSecondName(String newVal)
	{
		SecondName = newVal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
