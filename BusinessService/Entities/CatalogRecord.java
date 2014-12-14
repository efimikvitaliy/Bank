package BusinessService.Entities;

public class CatalogRecord
{
	private String id;
	private String information;
	private int price;
	private ManufacturersAndProducts product;

	public CatalogRecord(){}
	public CatalogRecord(int price, String information, ManufacturersAndProducts product)
	{
		this.price = price;
		this.information = information;
		this.product = product;
	}
	public String getInformation()
	{
		return information;
	}
	public int getPrice()
	{
		return price;
	}
	public ManufacturersAndProducts getProduct()
	{
		return product;
	}
	public void setInformation(String newVal)
	{
		information = newVal;
	}
	public void setPrice(int newVal)
	{
		price = newVal;
	}
	public void setProduct(ManufacturersAndProducts newVal)
	{
		product = newVal;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	@Override
	public String toString() {
		return "" + product.getProducts() + " : " + information + "";
	}
	
}
