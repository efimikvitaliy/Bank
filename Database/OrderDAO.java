package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessService.Entities.Catalog;
import BusinessService.Entities.CatalogRecord;
import BusinessService.Entities.Client;
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
	public void deleteOrder(String str) throws SQLException
	{
		stmt = con.createStatement();
		String fname = str.substring(0, str.indexOf(" ")).trim();
		String sname = str.substring(str.indexOf(" "), str.indexOf(",")).trim();
		String address = str.substring(str.indexOf(",") + 1, str.lastIndexOf(",")).trim();
		String email = str.substring(str.lastIndexOf(",") + 1).trim();
		r = stmt.executeQuery("SELECT TABLE_ORDER.id FROM TABLE_ORDER, CLIENT " +
				              "WHERE TABLE_ORDER.client_id = CLIENT.id AND CLIENT.firstName = '" + fname +
				              "' AND CLIENT.secondName = '" + sname + "' AND CLIENT.address = '" + address + 
				              "' AND CLIENT.email = '" + email + "'");
		if(r.next())
		{
			int id = Integer.valueOf(r.getString("id"));
			stmt.executeUpdate("DELETE FROM ORDER_LINE WHERE order_id = " + id);
			stmt.executeUpdate("DELETE FROM TABLE_ORDER WHERE id = " + id);
		}
		else
		{
			throw new SQLException();
		}
		r.close();
        stmt.close();
	}
	public ListOfOrders getListOfOrder() throws SQLException
	{
		ListOfOrders array = new ListOfOrders();
		stmt = con.createStatement();
		/*  Â ÎÐÄÅÐÅ Ó ÍÀÑ ÕÐÀÍÈÒÑß ÒÎËÜÊÎ Id ÊËÈÅÍÒÀ,  À ÍÅ ÂÅÑÜ ÊËÈÅÍÒ!!!!!
		 *  ÒÅÌ ÁÎËÅÅ Â ÎÐÄÅÐÅ ÅÑÒÜ ÌÅÒÎÄ getClient, ÊÎÒÎÐÛÉ ÏÎ ÑÓÒÈ ÂÛÏÎËÍßÅÒ ÒÎ ÆÅ ÑÀÌÎÅ
		 * 
		 * r = stmt.executeQuery("SELECT CLIENT.id, CLIENT.firstName, CLIENT.secondName, CLIENT.address, CLIENT.email FROM TABLE_ORDER, CLIENT WHERE TABLE_ORDER.client_id = CLIENT.id");
		while(r.next())
		{
			Client client = new Client(r.getString("id"), r.getString("firstName"), r.getString("secondName"));
			client.setAddress(r.getString("address"));
			client.setEmail(r.getString("email"));
			Order order = new Order(0, null, client);
			array.add(order);
		}
        r.close();*/
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER;");
		while(r.next()){
			Order order = new Order(r.getInt("id"), r.getInt("state"), r.getInt("deliverTransportCompany"), r.getInt("returnTransportCompany"), r.getInt("client_id"));
			array.add(order);
		}
		r.close();
        stmt.close();
		return array;
	}
	public ListOfOrders getListOfOrderWithClient() throws SQLException
	{
		ListOfOrders array = new ListOfOrders();
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT id, client_id FROM TABLE_ORDER WHERE TABLE_ORDER.state = 1");
		while(r.next())
		{
			Client client = new Client();
			client.setId(r.getString("client_id"));
			Order order = new Order(0, null, client);
			order.setId(Integer.valueOf(r.getString("id")));
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
