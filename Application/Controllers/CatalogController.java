package Application.Controllers;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BusinessService.Entities.*;
import Application.Forms.*;
import Database.*;

/**
 * @author Владимир
 * @version 1.0
 * @created 01-дек-2014 23:47:56
 */
public class CatalogController {

	public Catalog m_Catalog;
	public CreateCatalogForm m_CreateCatalogForm;
	public CatalogDAO m_CatalogDAO;
	public ManufacturersAndProductsDAO m_ManufacturersAndProductsDAO;
	public CatalogRecordForm m_CatalogRecordForm;
	public EditCatalogForm m_EditCatalogForm;
	public CatalogRecord m_CatalogRecord;
	public ListOfProductsForm m_ListOfProductsForm;
	public ListOfProducts m_ListOfProducts;
	public Product m_Product;
	public ListOfCatalogRecordsForm m_ListOfCatalogRecordsForm;
	public ListOfClients m_ListOfClients;
	public CatalogPublishForm m_CatalogPublishForm;
	public ClientsDAO m_ClientsDAO;
	public boolean isCreated;
	public CatalogController(){
		m_CatalogDAO = new CatalogDAO();
		m_ManufacturersAndProductsDAO = new ManufacturersAndProductsDAO();
		m_CatalogRecordForm = new CatalogRecordForm();
		isCreated = false;
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param price
	 * @param information
	 * @param product
	 */
	public void addRecordToCatalog(int price, String information, Product product){
		try {
			m_CatalogDAO.addCatalogRecord(price, information, product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param record
	 */
	public void deleteCatalogRecord(CatalogRecord record){
		try {
			m_CatalogDAO.deleteCatalogRecord(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCatalogRecord(CatalogRecord record){
		try {
			m_CatalogDAO.updateCatalogRecord(record);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param information
	 */
	public void createCatalog(String information){
		m_Catalog.setInformation(information);
		try {
			m_CatalogDAO.saveCatalog(m_Catalog, isCreated);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	/**
	 * 
	 * @param id
	 */
	public void getCatalogRecord(String id){
		CatalogRecord p;
		try {
			p = m_CatalogDAO.getCatalogRecord(id);
			String[] operation = {"edit", "delete" };
			int response = JOptionPane.showOptionDialog(null, "Choice operation with RECORDS", "Operations",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, operation,
					"edit");
			EditOrderController ed = new EditOrderController();
			switch(response)
			{
			case 0:
				m_CatalogRecordForm.displayRecordFormForEditing(p);
				break;
			case 1:
				m_CatalogRecordForm.displayRecordFormForDeleting(p);
				break;
			}		
		} catch (SQLException e) {
			
		}
		
	}

	/**
	 * 
	 * @param id
	 */
	public void getProduct(int id){
		Product p = m_ManufacturersAndProductsDAO.getProduct(id);
		m_CatalogRecordForm.displayRecordFormForCreating(p);
	}

	public boolean isCatalogCreated(){
		if (m_Catalog.getDate() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param catalog
	 */
	public void publishCatalogRoutine(){
		m_Catalog = new Catalog();
		try {
			m_Catalog = m_CatalogDAO.getCurrentCatalog();
			if (isCatalogCreated()) {
				int n = JOptionPane.showConfirmDialog(null,
					    "<html>Catalog created\n" +
					    "Info : " + m_Catalog.getInformation() +  "\n" +
					    "Do you want to publish?\n",
					    "Attention",
					    JOptionPane.YES_NO_OPTION);
				if (n == 0) 
				{
					m_Catalog.setDate(getCurrentYear());
					m_CatalogDAO.savePublicationDate(m_Catalog);
				}								
			}	
			else {
				JOptionPane.showConfirmDialog(null,
				    "<html>Catalog didn't created", 
				    "Attention",
				    JOptionPane.CANCEL_OPTION);
			}
			
		} catch (SQLException e) {
			System.out.println("catch");
		}
	}
	
	public static int getCurrentYear()
	{
		java.util.Calendar calendar = java.util.Calendar.getInstance(java.util.TimeZone.getDefault(), java.util.Locale.getDefault());
	    calendar.setTime(new java.util.Date());
	    return calendar.get(java.util.Calendar.YEAR);
	}
	
	public void publishCatalog(Catalog catalog){
		
	}

	public void sendCatalogToClient(){

	}

	
	
	public void startRoutine() {
		m_Catalog = new Catalog();
		try {
			m_Catalog = m_CatalogDAO.getCurrentCatalog();
			isCreated = false;
			if (isCatalogCreated()) {
				int n = JOptionPane.showConfirmDialog(null,
					    "<html>Catalog already created\n" +
					    "Info : " + m_Catalog.getInformation() +  "\n" +
					    "Do you want to delete last catalog version\n" +
					    "and create new?",
					    "Attention",
					    JOptionPane.YES_NO_OPTION);
				if (n == 0) 
				{
					System.out.println("yes");
					isCreated = true;
				}
				else {
					System.out.println("no");
					return;
				}				
			}
			m_CreateCatalogForm = new CreateCatalogForm(this);
			m_CreateCatalogForm.displayFormForCreatingCatalog();
			
		} catch (SQLException e) {
			System.out.println("catch");
		}
	}
	public void startCreateRecordRoutine() {
		m_ListOfProductsForm = new ListOfProductsForm();
		m_Catalog = new Catalog();
		try {
			m_Catalog = m_CatalogDAO.getCurrentCatalog();
			isCreated = false;
			if (isCatalogCreated()) {
				m_ListOfProducts = m_ManufacturersAndProductsDAO.getListOfProducts();
				m_ListOfProductsForm.displayListOfProducts(m_ListOfProducts);
			}
			else {
				JOptionPane.showConfirmDialog(null,
					    "<html>Catalog didn't created", 
					    "Attention",
					    JOptionPane.CANCEL_OPTION);
			}
		}
		catch (SQLException e) {
			System.out.println("catch");
		}
	}
	
	public void startEditRecordRoutine() {
		m_ListOfCatalogRecordsForm = new ListOfCatalogRecordsForm();
		m_Catalog = new Catalog();
		try {
			m_Catalog = m_CatalogDAO.getCurrentCatalog();
			isCreated = false;
			if (isCatalogCreated()) {
				m_ListOfCatalogRecordsForm.displayRecords(m_Catalog);
			}
			else {
				JOptionPane.showConfirmDialog(null,
					    "<html>Catalog didn't created", 
					    "Attention",
					    JOptionPane.CANCEL_OPTION);
			}
		}
		catch (SQLException e) {
			System.out.println("catch");
		}
	}

}