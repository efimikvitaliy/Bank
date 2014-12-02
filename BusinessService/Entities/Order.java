package BusinessService.Entities;

import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:50:22
 */
public class Order {

	private Client client;
	private int id;
	private ArrayList<Product> listOfProducts;
	private int price;
	public Client m_Client;



	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param price
	 * @param list
	 * @param client
	 */
	public Order(int price, ArrayList<Product> list, Client client){

	}

	public Order(){

	}

	/**
	 * 
	 * @param company
	 */
	public void setTransportCompanyToDeliver(TransportCompany company){

	}

	/**
	 * 
	 * @param company
	 */
	public void setTransportCompanyToDeliverReturn(TransportCompany company){

	}

}