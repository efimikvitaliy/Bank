package BusinessService.Entities;

import java.util.ArrayList;

public class ListOfManufacturersAndProducts
{
	private ArrayList<ManufacturersAndProducts> list;
	private ManufacturersAndProducts m_ManufacturersAndProducts;

	public ListOfManufacturersAndProducts()
	{
		list = new ArrayList<>();
	}
	public void add(ManufacturersAndProducts obj)
	{
		list.add(obj);
	}
	public void delete(ManufacturersAndProducts obj)
	{
		list.remove(obj);
	}
	public ManufacturersAndProducts get(int index)
	{
		return list.get(index);
	}
	public int size()
	{
		return list.size();
	}
	public boolean itemIsContainedInTheList(ManufacturersAndProducts p)
	{
		for(ManufacturersAndProducts m: list)
		{
			if(m.getManufacturers().equals(p.getManufacturers()) && m.getProducts().equals(p.getProducts()))
			{
				return true;
			}
		}
		return false;
	}
	public int getMaxId()
	{
		int i = 0;
		for(ManufacturersAndProducts m: list)
		{
			if(m.getId() > i)
			{
				i = m.getId();
			}
		}
		return i + 1;
	}
	public String[] getElementsInStringArray()
	{
		String []s = new String[list.size()];
		int i = 0;
		for(ManufacturersAndProducts m: list)
		{
			s[i] = new String(m.getManufacturers() + ", " + m.getProducts());
			++i;
		}
		return s;
	}
}
