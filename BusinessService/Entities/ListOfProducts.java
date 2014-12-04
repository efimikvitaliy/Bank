package BusinessService.Entities;

import java.util.ArrayList;

public class ListOfProducts
{
	private ArrayList<Product> products;
	public Product m_Product;

	public ListOfProducts()
	{
		products = new ArrayList<>();
	}
	public void add(Product p)
	{
		products.add(p);
	}
	public void delete(Product p)
	{
		products.remove(p);
	}
	public int size()
	{
		return products.size();
	}
	public Product get(int index)
	{
		return products.get(index);
	}
}
