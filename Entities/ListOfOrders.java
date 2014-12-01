package Entities;

import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:50:17
 */
public class ListOfOrders {

	private ArrayList<Order> list;
	public Order m_Order;



	public void finalize() throws Throwable {

	}

	public ListOfOrders(){

	}

	/**
	 * 
	 * @param order
	 */
	public boolean deleteOrder(Order order){
		return false;
	}

}