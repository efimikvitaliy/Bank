package Application.Controllers;
import Entities.*;
import Application.Forms.*;
import Database.*;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:48:02
 */
public class EditOrderController {

	public RequestOfDeleteOrderForm m_RequestOfDeleteOrderForm;
	public CatalogForm m_CatalogForm;
	public OrderForm m_OrderForm;
	public EditOrderOperationForm m_EditOrderOperationForm;
	public ListOfOrderForm m_ListOfOrderForm;
	public ListOfOrders m_ListOfOrders;
	public Order m_Order;
	public Catalog m_Catalog;
	public CatalogDAO m_CatalogDAO;
	public OrderDAO m_OrderDAO;

	public EditOrderController(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param name
	 */
	public void deleteOrder(String name){

	}

	public boolean formIsFill(){
		return false;
	}

	public ListOfOrders getListOfOrder(){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public void getOrder(String name){

	}

	public void newCatalog(){

	}

	/**
	 * 
	 * @param order
	 */
	public void saveOrder(Order order){

	}

	public void showCatalogForm(){

	}

	public void showListOfOrderForm(){

	}

	public void showOrderForm(){

	}

	public void showOrderOperationForm(){

	}

	public void showRequestOfDeleteOrderForm(){

	}

	/**
	 * 
	 * @param order
	 */
	public void updateOrder(Order order){

	}

}