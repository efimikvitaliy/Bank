package Application.Controllers;

import java.sql.SQLException;
import Application.Forms.EditListOfManufacturersAndProductsForm;
import Application.Forms.ListOfManufacturersAndProductsForm;
import BusinessService.Entities.ListOfManufacturersAndProducts;
import BusinessService.Entities.ManufacturersAndProducts;
import Database.ManufacturersAndProductsDAO;

public class EditListOfManufacturersAndProductsController
{
	public ListOfManufacturersAndProducts m_ListOfManufacturersAndProducts;
	public ManufacturersAndProducts m_ManufacturersAndProducts;
	public ManufacturersAndProductsDAO m_ManufacturersAndProductsDAO;
	public EditListOfManufacturersAndProductsForm m_EditListOfManufacturersAndProductsForm;
	public ListOfManufacturersAndProductsForm m_ListOfManufacturersAndProductsForm;

	public EditListOfManufacturersAndProductsController()
	{
		m_ManufacturersAndProductsDAO = new ManufacturersAndProductsDAO();
	}
	public void add(ManufacturersAndProducts m) throws SQLException
	{
		m_ListOfManufacturersAndProducts = m_ManufacturersAndProductsDAO.getListOfManufacturersAndProducts();
		boolean b = m_ListOfManufacturersAndProducts.itemIsContainedInTheList(m); 
		if(m.getId() == -1 && !b)
		{
			m.setId(m_ListOfManufacturersAndProducts.getMaxId());
			m_ManufacturersAndProductsDAO.add(m);
		}
		else if(m.getId() != -1)
		{
			m_ManufacturersAndProductsDAO.update(m);
		}
	}
	public void deleteListOfManufacturersAndProducts() throws SQLException
	{
		m_ManufacturersAndProductsDAO.deleteListOfManufacturersAndProducts();
	}
	public void deleteManufacturersAndProducts(int index) throws SQLException
	{
		m_ManufacturersAndProductsDAO.delete(index);
	}
	public ListOfManufacturersAndProducts getListOfManufacturersAndProducts() throws SQLException
	{
		return m_ManufacturersAndProductsDAO.getListOfManufacturersAndProducts();
	}
}
