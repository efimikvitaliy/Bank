package BusinessService.Entities;

public class User 
{
	private String login;
	private String password;
	private int type;

	private User(String login, String password)
	{
		this.login = login;
		this.password = password;
	}
	public static User create(String login, String password)
	{
		return new User(login, password);
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public int getType()
	{
		return type;
	}
	public String getLogin()
	{
		return login;
	}
	public void setLogin(String login)
	{
		this.login = login;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
}
