package BusinessService.Entities;

import java.util.ArrayList;

public class ListOfOrders
{
	private ArrayList<Order> list;
	public Order m_Order;
	
	public ListOfOrders()
	{
		list = new ArrayList<>();
	}
	public boolean deleteOrder(Order order)
	{
		return false;
	}
	public Order get(int index)
	{
		return list.get(index);
	}
	public void add(Order order)
	{
		list.add(order);
	}
	public void remove(Order order)
	{
		list.remove(order);
	}	
}
