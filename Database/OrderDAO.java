package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	public void deleteOrder(String id) throws SQLException
	{
		stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM ORDER_LINE WHERE order_id = " + Integer.valueOf(id));
		stmt.executeUpdate("DELETE FROM TABLE_ORDER WHERE id = " + Integer.valueOf(id));
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
	public ListOfOrders getListOfOrderForDeliver() throws SQLException
	{
		ListOfOrders array = new ListOfOrders();
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER WHERE state = 1;");
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
	public ListOfOrders getListOfReturns() throws SQLException
	{
		ListOfOrders array = new ListOfOrders();
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER WHERE state = 3");
		while(r.next()){
			Order order = new Order(r.getInt("id"), r.getInt("state"), r.getInt("deliverTransportCompany"), r.getInt("returnTransportCompany"), r.getInt("client_id"));
			array.add(order);
		}
        r.close();
        stmt.close();
        return array;
		
	}
	public ListOfOrders getListOfSendOrder() throws SQLException
	{
		ListOfOrders array = new ListOfOrders();
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER WHERE state = '2'");
		while(r.next()){
			Order order = new Order(r.getInt("id"), r.getInt("state"), r.getInt("deliverTransportCompany"), r.getInt("returnTransportCompany"), r.getInt("client_id"));
			array.add(order);
		}
        r.close();
        stmt.close();
        return array;
	}
	public Order getOrder(String id) throws SQLException
	{
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER WHERE id = " + id + ";");
		Order order = null;
		if(r.next()){
			order = new Order(r.getInt("id"), r.getInt("state"), r.getInt("deliverTransportCompany"), r.getInt("returnTransportCompany"), r.getInt("client_id"));
		}
		stmt.close();
		return order;
	}
	public Order getReturn(String id) throws SQLException
	{
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER WHERE id = " + id + ";");
		Order order = null;
		if(r.next()){
			order = new Order(r.getInt("id"), r.getInt("state"), r.getInt("deliverTransportCompany"), r.getInt("returnTransportCompany"), r.getInt("client_id"));
		}
		stmt.close();
		return order;
	}
	public void saveListOfOrders(ListOfOrders orders)
	{

	}
	public void updateOrder(Order order) throws SQLException
	{
		stmt = con.createStatement();
		int order_id = 0;
		r = stmt.executeQuery("SELECT id FROM TABLE_ORDER WHERE state = 1 AND client_id = " + order.getClient().getId());
		int count = 0;
        if(r.next())
        {
        	order_id = Integer.valueOf(r.getString("id")); 
        }
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
           	r = stmt.executeQuery("SELECT PRODUCT.count FROM PRODUCT, CATALOG_RECORD WHERE CATALOG_RECORD.id = "
        			              + order.getListOfProducts().get(i).getId() + " AND PRODUCT.id = CATALOG_RECORD.product_id");
        	if(r.next())
        	{
        		count = Integer.valueOf(r.getString("count")) - order.getListOfProducts().get(i).getProduct().getCount();
        	}
        	stmt.executeUpdate("UPDATE PRODUCT SET count = " + count + " WHERE PRODUCT.id = " + order.getListOfProducts().get(i).getId());
        	stmt.executeUpdate("INSERT INTO [ORDER_LINE] ([id], [order_id], [catalog_record_id], [count]) " + 
                               "VALUES(" + id + ", " + order_id + ", " + order.getListOfProducts().get(i).getId() + ", " +
        			           order.getListOfProducts().get(i).getProduct().getCount() + ")");
        	++id;
        }
        
        r.close();
        stmt.close();
	}
	public void saveOrder(Order order) throws SQLException
	{
		stmt = con.createStatement();
		int order_id = 0;
		r = stmt.executeQuery("SELECT * FROM TABLE_ORDER");
		int count = 0;
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
		stmt.executeUpdate("INSERT INTO [TABLE_ORDER] ([id], [state], [client_id]) " +
		        "VALUES(" + order_id + ", 1, " + client_id + ")");
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
        	r = stmt.executeQuery("SELECT PRODUCT.count FROM PRODUCT, CATALOG_RECORD WHERE CATALOG_RECORD.id = "
        			              + order.getListOfProducts().get(i).getId() + " AND PRODUCT.id = CATALOG_RECORD.product_id");
        	if(r.next())
        	{
        		count = Integer.valueOf(r.getString("count")) - order.getListOfProducts().get(i).getProduct().getCount();
        	}
        	stmt.executeUpdate("UPDATE PRODUCT SET count = " + count + " WHERE PRODUCT.id = " + order.getListOfProducts().get(i).getId());
        	stmt.executeUpdate("INSERT INTO [ORDER_LINE] ([id], [order_id], [catalog_record_id], [count]) " + 
                               "VALUES(" + id + ", " + order_id + ", " + order.getListOfProducts().get(i).getId() + ", " +
        			           order.getListOfProducts().get(i).getProduct().getCount() + ")");
        	++id;
        }
        
        r.close();
        stmt.close();
	}
	public void saveOrderWithTransportCompany(Order order) throws SQLException
	{
		stmt = con.createStatement();
		stmt.executeUpdate("UPDATE TABLE_ORDER SET deliverTransportCompany = " + order.getDeliverTransportCompany() + " , state = 2 " + " WHERE id = " + order.getId());
		stmt.close();
	}
	public void saveOrderWithTransportCompanyToReturn(Order order) throws SQLException
	{
		stmt = con.createStatement();
		stmt.executeUpdate("UPDATE TABLE_ORDER SET returnTransportCompany = " + order.getReturnTransportCompany() + " , state = 4 " + " WHERE id = " + order.getId());
		stmt.close();
	}
	public void saveReturn(Order order) throws SQLException
	{
		stmt = con.createStatement();
		stmt.executeUpdate("UPDATE TABLE_ORDER SET state = 3 " + " WHERE id = " + order.getId());
		stmt.close();
	}
	public boolean isClientHasOrder(int id) throws SQLException//++++
	{
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT TABLE_ORDER.id FROM TABLE_ORDER WHERE TABLE_ORDER.state = 1 AND TABLE_ORDER.client_id = " + id);
		boolean b = r.next();
        r.close();
        stmt.close();
        return b;
	}
	public void deleteProducts(String client_id, ArrayList<String> array) throws SQLException//+++++
	{
		stmt = con.createStatement();
		for(String str: array)
		{
			r = stmt.executeQuery("SELECT PRODUCT.id FROM PRODUCT, MANUFACTURER WHERE PRODUCT.name = '" + 
		                           str.substring(str.indexOf(" "), str.lastIndexOf(" ")).trim() + "' AND " +
		                           "PRODUCT.manufacturer_id = MANUFACTURER.id AND MANUFACTURER.manufacturer = '" +
		                           str.substring(0, str.indexOf(" ")).trim() + "'");
			if(r.next())
			{
				int id = Integer.valueOf(r.getString("id"));
				stmt.executeUpdate("UPDATE PRODUCT SET count = " + str.substring(str.lastIndexOf(" ")).trim() + " WHERE id = " + id);
			}
			r = stmt.executeQuery("SELECT id FROM TABLE_ORDER WHERE TABLE_ORDER.client_id = " + client_id);
			if(r.next())
			{
				int order_id = Integer.valueOf(r.getString("id"));
				stmt.executeUpdate("DELETE FROM ORDER_LINE WHERE order_id = " + order_id);				
			}
		}
        stmt.close();
	}
}
