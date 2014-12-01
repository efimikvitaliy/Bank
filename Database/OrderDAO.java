package Database;

import Entities.*;


/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:51:13
 */
public class OrderDAO {

	public OrderDAO(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param name
	 */
	public void deleteOrder(String name){

	}

	public ListOfOrders getListOfOrder(){
		return null;
	}

	public ListOfOrders getListOfReturns(){
		return null;
	}

	public ListOfOrders getListOfSendOrder(){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public Order getOrder(String name){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public Order getReturn(String name){
		return null;
	}

	/**
	 * 
	 * @param orders
	 */
	public void saveListOfOrders(ListOfOrders orders){

	}

	/**
	 * 
	 * @param order
	 */
	public void saveOrder(Order order){

	}

	/**
	 * 
	 * @param order
	 */
	public void saveOrderWithTransportCompany(Order order){

	}

	/**
	 * 
	 * @param order
	 */
	public void saveOrderWithTransportCompanyToReturn(Order order){

	}

	/**
	 * 
	 * @param order
	 */
	public void saveReturn(Order order){

	}

}