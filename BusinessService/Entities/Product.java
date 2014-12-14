package BusinessService.Entities;

public class Product
{
	private int id;
	private String name;
	
	public Product(){}
	
	public Product(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public String toString() {
		return ""  + name;
	}
}
