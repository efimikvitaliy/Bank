package BusinessService.Entities;

import java.util.ArrayList;

public class Catalog
{
	private String information;
	private ArrayList<CatalogRecord> records;
	public CatalogRecord m_CatalogRecord;
	public int date;
	public int id;
	public Catalog()
	{
		records = new ArrayList<>();
	}
	public void addRecord(CatalogRecord record)
	{
		records.add(record);
	}
	public void deleteRecord(CatalogRecord record)
	{
		records.remove(record);
	}
	public String getInformation()
	{
		return information;
	}
	public void setDate(int newVal)
	{
		date = newVal;
	}
	public int getDate()
	{
		return date;
	}
	public void setInformation(String newVal)
	{
		information = newVal;
	}
	public String[] getElementsInStringArray()
	{
		String []s = new String[records.size()];
		int i = 0;
		for(CatalogRecord m: records)
		{
			s[i] = new String("Manufacturer: " + m.getProduct().getManufacturers() + ", Product: "
		                      + m.getProduct().getProducts() + ", Price: " + m.getPrice()
		                      + ", Count: " + m.getProduct().getCount());
			++i;
		}
		return s;
	}
	public int size()
	{
		return records.size();
	}
	public void updateRecord(CatalogRecord record)
	{

	}
	
	public ArrayList<CatalogRecord> getCatalogRecords() {
		return records;
	}
}
