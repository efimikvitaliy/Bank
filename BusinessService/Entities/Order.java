package BusinessService.Entities;

import java.util.ArrayList;

public class Order
{
	private Client client;
	private int id;
	private ArrayList<CatalogRecord> listOfProducts;
	private int price;
	private int state;
	private int deliverTransportCompany;
	private int returnTransportCompany;
	private int client_id;
	public Client m_Client;

	public Order(){}
	public Order(int price, ArrayList<CatalogRecord> list, Client client)
	{
		this.price = price;
		listOfProducts = list;
		this.client = client;
	}
	public Order( int id_, int state_, int deliverTransportCompany_, int returnTransportCompany_, int client_id_ ){
		id = id_;
		state = state_;
		deliverTransportCompany = deliverTransportCompany_;
		returnTransportCompany = returnTransportCompany_;
		client_id = client_id_;
		
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
	
	public String toString(){
		return Integer.toString(id) + " " + Integer.toString(state) + " " + Integer.toString(deliverTransportCompany) + " " + Integer.toString(returnTransportCompany) + " " + Integer.toString(client_id);
	}
}
