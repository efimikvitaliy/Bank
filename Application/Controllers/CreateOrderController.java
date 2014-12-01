package Application.Controllers;
import Entities.*;
import Application.Forms.*;
import Database.*;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:47:48
 */
public class CreateOrderController {

	public OrderDAO m_OrderDAO;
	public ClientsDAO m_ClientsDAO;
	public CatalogDAO m_CatalogDAO;
	public Client m_Client;
	public Catalog m_Catalog;
	public Order m_Order;
	public CatalogForm m_CatalogForm;
	public ListOfClientsForm m_ListOfClientsForm;
	public OrderForm m_OrderForm;
	public ListOfClients m_ListOfClients;

	public CreateOrderController(){

	}

	public void finalize() throws Throwable {

	}

	public void getCatalog(){

	}

	public void getListOfClients(){

	}

	public Order newOrder(){
		return null;
	}

	/**
	 * 
	 * @param order
	 */
	public void saveOrder(Order order){

	}

	public void showCatalogForm(){

	}

	public void showListOfClientsForm(){

	}

	public void showOrderForm(){

	}

}