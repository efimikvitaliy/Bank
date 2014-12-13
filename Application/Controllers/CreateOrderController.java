package Application.Controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import Application.Forms.CatalogForm;
import Application.Forms.ListOfClientsForm;
import Application.Forms.OrderForm;
import BusinessService.Entities.CatalogRecord;
import BusinessService.Entities.Client;
import BusinessService.Entities.Catalog;
import BusinessService.Entities.ManufacturersAndProducts;
import BusinessService.Entities.Order;
import BusinessService.Entities.ListOfClients;
import Database.CatalogDAO;
import Database.ClientsDAO;
import Database.OrderDAO;

public class CreateOrderController
{
	private OrderDAO m_OrderDAO;
	private EditOrderController m_EditOrderController; 
	private ClientsDAO m_ClientsDAO;
	private CatalogDAO m_CatalogDAO;
	private Client m_Client;
	private Catalog m_Catalog;
	private Order m_Order;
	private CatalogForm m_CatalogForm;
	private ListOfClientsForm m_ListOfClientsForm;
	private static OrderForm m_OrderForm;
	private ListOfClients m_ListOfClients;
	private int type = -1;

	public CreateOrderController()
	{
		m_OrderDAO = new OrderDAO();
		m_ClientsDAO = new ClientsDAO();
		m_CatalogDAO = new CatalogDAO();
		m_ListOfClientsForm = new ListOfClientsForm();
		setM_EditOrderController(new EditOrderController());
		m_EditOrderController.setM_CreateOrderController(this);
		m_CatalogForm = new CatalogForm();
	}
	public Catalog getCatalog() throws SQLException
	{
		return m_CatalogDAO.getCatalog();
	}
	public ListOfClients getListOfClients() throws SQLException
	{
		return m_ClientsDAO.getListOfClients();
	}
	public Client getClient(String id) throws SQLException
	{
		return m_ClientsDAO.getClient(id);
	}
	public void saveOrder(Order order) throws SQLException
	{
		ArrayList<CatalogRecord> list = order.getListOfProducts();
		for(int i = 0; i < list.size(); ++i)
		{
			CatalogRecord cr = list.get(i);
			String str = m_CatalogDAO.getIdFromCatalogRecord(cr.getProduct().getProducts(), cr.getProduct().getManufacturers());
			cr.setId(str);
		}
		m_OrderDAO.saveOrder(order);
	}
	public void showCatalogForm()
	{
		m_CatalogForm.setM_CreateOrderController(this);
		m_CatalogForm.setM_EditOrderController(m_EditOrderController);
		m_CatalogForm.init();
		m_CatalogForm.setVisible(true);
	}
	public void showOrderForm()
	{
		m_OrderForm = new OrderForm();
		m_OrderForm.setClient(m_Client);
		m_OrderForm.init(m_CatalogForm.createOrderList());
		m_OrderForm.setArray(m_CatalogForm.getArray());
		m_OrderForm.setArrayCountsProducts(m_CatalogForm.getArrayCountsProducts());
		m_OrderForm.setM_CreateOrderController(this);
		m_OrderForm.setM_EditOrderController(m_EditOrderController);
		m_OrderForm.setVisible(true);
	}
	public void showListOfClientsForm()
	{
		m_ListOfClientsForm.setM_CreateOrderController(this);
		m_ListOfClientsForm.setVisible(true);
	}
	public int getIndexProducts(String str, String s[])
	{
		for(int i = 0; i < s.length; ++i)
		{
			if(s[i].equals(str))
			{
				return i;
			}
		}
		return -1;
	}
	public boolean isClientHasOrder(int id) throws SQLException
	{
		return m_OrderDAO.isClientHasOrder(id);
	}
	public String createOrderList(ArrayList<String> array, int counts[]) throws NumberFormatException
	{
		int totalPrice = 0;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < array.size(); ++i)
		{
			int count = counts[i];
			int price = Integer.valueOf(array.get(i).substring(array.get(i).lastIndexOf("ce: ") + 3, array.get(i).lastIndexOf(",")).trim());
			sb.append((i + 1) + ". " + array.get(i).substring(0, array.get(i).lastIndexOf(",")) + "x" + count + " = " + (price*count) + "\n");
			array.set(i, array.get(i).substring(0, array.get(i).lastIndexOf(" ")) + " " + count);
			totalPrice += count*price;
		}
		sb.append("Total price = " + totalPrice);
		return sb.toString();
	}
	public Order createOrder(int totalPrice, ArrayList<String> array, Client client)
	{
		ArrayList<CatalogRecord> arrayCatalogRecord = new ArrayList<>();
		for(String str: array)
		{
			int count = Integer.valueOf(str.substring(str.lastIndexOf("Count") + 7).trim());
			StringTokenizer st = new StringTokenizer(str, ":,");
			st.nextToken();
			String manuf = st.nextToken().trim();
			st.nextToken();
			String prod = st.nextToken().trim();
			
			ManufacturersAndProducts mp = new ManufacturersAndProducts(0, manuf, prod);
			mp.setCount(count);
			CatalogRecord cr = new CatalogRecord(0, "", mp);
			arrayCatalogRecord.add(cr);
		}
		Order order = new Order(totalPrice, arrayCatalogRecord, client);
		return order;
	}
	public Client getM_Client()
	{
		return m_Client;
	}
	public void setM_Client(Client m_Client)
	{
		this.m_Client = m_Client;
	}
	public Catalog getM_Catalog()
	{
		return m_Catalog;
	}
	public void setM_Catalog(Catalog m_Catalog)
	{
		this.m_Catalog = m_Catalog;
	}
	public ArrayList<String> getProductCountOrder(String id) throws SQLException
	{
		return m_CatalogDAO.getProductCountOrder(id);
	}
	public EditOrderController getM_EditOrderController()
	{
		return m_EditOrderController;
	}
	public void setM_EditOrderController(EditOrderController m_EditOrderController)
	{
		this.m_EditOrderController = m_EditOrderController;
	}
	public int getType() 
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
}
