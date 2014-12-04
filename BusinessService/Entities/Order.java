package BusinessService.Entities;

import java.util.ArrayList;

public class Order
{
	private Client client;
	private int id;
	private ArrayList<CatalogRecord> listOfProducts;
	private int price;
	public Client m_Client;

	public Order(){}
	public Order(int price, ArrayList<CatalogRecord> list, Client client)
	{
		this.price = price;
		listOfProducts = list;
		this.client = client;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Client getClient()
	{
		return client;
	}
	public void setClient(Client client)
	{
		this.client = client;
	}
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public ArrayList<CatalogRecord> getListOfProducts() {
		return listOfProducts;
	}
	public void setListOfProducts(ArrayList<CatalogRecord> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}
	
	public void setTransportCompanyToDeliver(TransportCompany company){

	}

	public void setTransportCompanyToDeliverReturn(TransportCompany company){

	}
}
