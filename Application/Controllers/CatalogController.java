package Application.Controllers;
import Entities.*;
import Application.Forms.*;
import Database.*;

import Entities.CatalogRecord;
import Entities.ListOfProducts;
import Entities.Product;
import Entities.ListOfClients;

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

	public CatalogController(){

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

	}

	/**
	 * 
	 * @param information
	 */
	public void createCatalog(String information){

	}

	/**
	 * 
	 * @param record
	 */
	public void deleteCatalogRecord(CatalogRecord record){

	}

	/**
	 * 
	 * @param id
	 */
	public void getCatalogRecord(String id){

	}

	/**
	 * 
	 * @param id
	 */
	public void getProduct(String id){

	}

	public boolean isCatalogCreated(){
		return false;
	}

	/**
	 * 
	 * @param catalog
	 */
	public void publishCatalog(Catalog catalog){

	}

	public void sendCatalogToClient(){

	}

	/**
	 * 
	 * @param record
	 */
	public void updateCatalogRecord(CatalogRecord record){

	}

}