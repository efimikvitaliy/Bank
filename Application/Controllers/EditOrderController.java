package Application.Controllers;

import java.sql.SQLException;

import Application.Forms.CatalogForm;
import Application.Forms.ListOfOrderForm;
import Application.Forms.OrderForm;
import BusinessService.Entities.ListOfOrders;
import BusinessService.Entities.Order;
import BusinessService.Entities.Catalog;
import Database.CatalogDAO;
import Database.OrderDAO;

public class EditOrderController
{

	public CatalogForm m_CatalogForm;
	public static OrderForm m_OrderForm;
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
	}
	public void deleteOrder(String name) throws SQLException
	{
		m_OrderDAO.deleteOrder(name);
	}
	public ListOfOrders getListOfOrders() throws SQLException
	{
		return m_OrderDAO.getListOfOrder();
	}
	public void getOrder(String name)
	{

	}
	public void newCatalog()
	{

	}
	public void saveOrder(Order order)
	{

	}
	public void showCatalogForm()
	{

	}
	public void showListOfOrderForm(int i)
	{
		m_OrderForm = new OrderForm();
		if(i == 0)
		{
			m_OrderForm.showListOfOrderEdit();
		}
		else if(i == 1)
		{
			m_OrderForm.showListOfOrderDelete();
		}
	}
	public void showOrderForm()
	{

	}
	public void showOrderOperationForm()
	{

	}
	public void showRequestOfDeleteOrderForm()
	{

	}
	public void updateOrder(Order order)
	{

	}
}
