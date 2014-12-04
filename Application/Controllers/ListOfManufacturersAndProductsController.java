package Application.Controllers;

import java.sql.SQLException;

import Application.Forms.ListOfManufacturersAndProductsForm;
import BusinessService.Entities.ManufacturersAndProducts;
import BusinessService.Entities.ListOfManufacturersAndProducts;
import Database.ManufacturersAndProductsDAO;

public class ListOfManufacturersAndProductsController {

	public ListOfManufacturersAndProductsForm m_ListOfManufacturersAndProductsForm;
	public ManufacturersAndProductsDAO m_ManufacturersAndProductsDAO;
	public ManufacturersAndProducts m_ManufacturersAndProducts;
	public ListOfManufacturersAndProducts m_ListOfManufacturersAndProducts;

	public ListOfManufacturersAndProductsController(){}
	public ListOfManufacturersAndProductsController getList()
	{
		return null;
	}
	public boolean listIsExist()
	{
		try
		{
			m_ManufacturersAndProductsDAO = new ManufacturersAndProductsDAO();
			m_ManufacturersAndProductsDAO.getListOfManufacturersAndProducts();
		}
		catch(SQLException e1)
		{
			return false;
		}
		return true;
	}
	public void createList() throws SQLException
	{
		m_ManufacturersAndProductsDAO.createListOfManufacturersAndProducts();
	}
}
