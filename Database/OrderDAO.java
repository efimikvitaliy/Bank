package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessService.Entities.Catalog;
import BusinessService.Entities.CatalogRecord;
import BusinessService.Entities.ListOfOrders;
import BusinessService.Entities.ManufacturersAndProducts;
import BusinessService.Entities.Order;

public class OrderDAO
{
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet r = null;
	
	public OrderDAO()
	{
		con = DBManager.getInstance().getConnection();
	}
	public void deleteOrder(String name)
	{

	}
	public ListOfOrders getListOfOrder() throws SQLException
	{
		ListOfOrders array = new ListOfOrders();
		stmt = con.createStatement();
		int order_id = 0;
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER, CLIENT WHERE TABLE_ORDER.client_id = CLIENT.id");
		while(r.next())
		{
			Order order = new Order();
			array.add(order);
		}
        r.close();
        stmt.close();
		return array;
	}
	public ListOfOrders getListOfReturns()
	{
		return null;
	}
	public ListOfOrders getListOfSendOrder()
	{
		return null;
	}
	public Order getOrder(String name)
	{
		return null;
	}
	public Order getReturn(String name)
	{
		return null;
	}
	public void saveListOfOrders(ListOfOrders orders)
	{

	}
	public void saveOrder(Order order) throws SQLException
	{
		stmt = con.createStatement();
		int order_id = 0;
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER");
        while(r.next())
        {
        	int temp = Integer.valueOf(r.getString("id")); 
        	if(order_id < temp)
        	{
        		order_id = temp;
        	}
        }
        ++order_id;
		int client_id = Integer.valueOf(order.getClient().getId());
        stmt.executeUpdate("INSERT INTO [TABLE_ORDER] ([id], [state], [deliverTransportCompany], [returnTransportCompany], [client_id]) " +
        		"VALUES(" + order_id + ", 1, 1, 1, " + client_id + ")");
		r = stmt.executeQuery("SELECT * FROM ORDER_LINE");
		int id = 0;
        while(r.next())
        {
        	int temp = Integer.valueOf(r.getString("id")); 
        	if(id < temp)
        	{
        		id = temp;
        	}
        }
        ++id;
        for(int i = 0; i < order.getListOfProducts().size(); ++i)
        {
        	stmt.executeUpdate("INSERT INTO [ORDER_LINE] ([id], [order_id], [catalog_record_id], [count]) " + 
                               "VALUES(" + id + ", " + order_id + ", " + order.getListOfProducts().get(i).getId() + ", " +
        			           order.getListOfProducts().get(i).getProduct().getCount() + ")");
        	++id;
        }
        
        r.close();
        stmt.close();
	}
	public void saveOrderWithTransportCompany(Order order)
	{

	}
	public void saveOrderWithTransportCompanyToReturn(Order order)
	{

	}
	public void saveReturn(Order order)
	{

	}
}
