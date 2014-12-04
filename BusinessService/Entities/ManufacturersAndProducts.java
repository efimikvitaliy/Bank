package BusinessService.Entities;

public class ManufacturersAndProducts
{
	private String manufacturers;
	private String products;
	private int id;
	private int count;

	public ManufacturersAndProducts(){}
	public ManufacturersAndProducts(int id, String manufacturers, String products)
	{
		this.id = id;
		this.manufacturers = manufacturers;
		this.products = products;
	}
	public void update(int id, String m, String p)
	{
		this.id = id;
		this.manufacturers = m;
		this.products = p;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getManufacturers()
	{
		return manufacturers;
	}
	public void setManufacturers(String manufacturers)
	{
		this.manufacturers = manufacturers;
	}
	public String getProducts()
	{
		return products;
	}
	public void setProducts(String products)
	{
		this.products = products;
	}
	public int getCount()
	{
		return count;
	}
	public void setCount(int count)
	{
		this.count = count;
	}
}
