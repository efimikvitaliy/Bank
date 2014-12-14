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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getDeliverTransportCompany() {
		return deliverTransportCompany;
	}
	public void setDeliverTransportCompany(int deliverTransportCompany) {
		this.deliverTransportCompany = deliverTransportCompany;
	}
	public int getReturnTransportCompany() {
		return returnTransportCompany;
	}
	public void setReturnTransportCompany(int returnTransportCompany) {
		this.returnTransportCompany = returnTransportCompany;
	}
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public Client getM_Client() {
		return m_Client;
	}
	public void setM_Client(Client m_Client) {
		this.m_Client = m_Client;
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
		return "Order id = " + Integer.toString(id) + " Clien Id = " + Integer.toString(client_id);
	}
}
