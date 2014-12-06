package Application.Controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import Application.Forms.CatalogForm;
import Application.Forms.ListOfOrderForm;
import Application.Forms.OrderForm;
import BusinessService.Entities.CatalogRecord;
import BusinessService.Entities.Client;
import BusinessService.Entities.ListOfOrders;
import BusinessService.Entities.Order;
import BusinessService.Entities.Catalog;
import Database.CatalogDAO;
import Database.ClientsDAO;
import Database.OrderDAO;

public class EditOrderController
{
	private ClientsDAO m_ClientsDAO;
	public CatalogForm m_CatalogForm;
	public OrderForm m_OrderForm;
	public ListOfOrderForm m_ListOfOrderForm;
	public ListOfOrders m_ListOfOrders;
	public Order m_Order;
	public Catalog m_Catalog;
	public CatalogDAO m_CatalogDAO;
	public OrderDAO m_OrderDAO;

	public EditOrderController()
	{
		m_OrderDAO = new OrderDAO();
		m_CatalogDAO = new CatalogDAO();
		m_ClientsDAO = new ClientsDAO();
	}
	public void deleteOrder(String id) throws SQLException
	{
		m_OrderDAO.deleteOrder(id);
	}
	public ListOfOrders getListOfOrders() throws SQLException
	{
		return m_OrderDAO.getListOfOrder();
	}
	public void getOrder(String id)
	{

	}
	public void showCatalogForm()
	{
		m_OrderForm.showProducts();
	}
	public void showListOfOrderForm(int i)
	{
		m_OrderForm = new OrderForm(this);
		if(i == 0)
		{
			m_OrderForm.showListOfOrderEdit();
		}
		else if(i == 1)
		{
			m_OrderForm.showListOfOrderDelete();
		}
	}
	public void updateOrder(Order order) throws SQLException
	{
		ArrayList<CatalogRecord> list = order.getListOfProducts();
		for(int i = 0; i < list.size(); ++i)
		{
			CatalogRecord cr = list.get(i);
			String str = m_CatalogDAO.getIdFromCatalogRecord(cr.getProduct().getProducts(), cr.getProduct().getManufacturers());
			cr.setId(str);
		}
		m_OrderDAO.updateOrder(order);
	}
	public Client getClient(String id) throws SQLException
	{	
		return m_ClientsDAO.getClient(id);
	}
	public ArrayList<String> getProductCountOrder(String id) throws SQLException
	{
		return m_CatalogDAO.getProductCountOrder(id);
	}
	public Catalog getCatalog() throws SQLException
	{
		return m_CatalogDAO.getCatalog();
	}
	public int getIndexByProducts(ArrayList<String> array, String string)
	{
		for(int i = 0; i < array.size(); ++i)
		{
			String str = array.get(i);
			boolean manufacturer = str.substring(0, str.indexOf(" ")).trim().equals(string.substring(string.indexOf(":") + 1, string.indexOf(",")).trim());
			String substring1 = string.substring(string.indexOf(",") + 1);
			boolean product = str.substring(str.indexOf(" "), str.lastIndexOf(" ")).trim().equals(substring1.substring(substring1.indexOf(":") + 1, substring1.indexOf(",")).trim());
			if(product && manufacturer)
			{
				return i;
			}
		}
		return -1;
	}
	public void deleteProducts(String client_id, ArrayList<String> array) throws SQLException
	{
		m_OrderDAO.deleteProducts(client_id, array);
	}
}
