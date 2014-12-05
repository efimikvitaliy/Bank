package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import BusinessService.Entities.Catalog;
import BusinessService.Entities.CatalogRecord;
import BusinessService.Entities.Client;
import BusinessService.Entities.ListOfClients;
import BusinessService.Entities.ManufacturersAndProducts;
import BusinessService.Entities.Product;

public class CatalogDAO
{
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet r = null;
    
	public CatalogDAO()
	{
		con = DBManager.getInstance().getConnection();
	}
	public Catalog getCatalog() throws SQLException
	{
		stmt = con.createStatement();
        r = stmt.executeQuery("SELECT CATALOG_RECORD.price, PRODUCT.count, PRODUCT.name, MANUFACTURER.manufacturer FROM CATALOG_RECORD, PRODUCT, MANUFACTURER WHERE CATALOG_RECORD.product_id = PRODUCT.id AND PRODUCT.manufacturer_id = MANUFACTURER.id AND PRODUCT.count > 0");
        Catalog array = new Catalog();
        while(r.next())
        {
        	ManufacturersAndProducts mp = new ManufacturersAndProducts(0, r.getString("manufacturer"), 

r.getString("name"));
        	mp.setCount(Integer.valueOf(r.getString("count")));
        	CatalogRecord cr = new CatalogRecord(Integer.valueOf(r.getString("price")), "", mp);
        	array.addRecord(cr);
        }
        r.close();
        stmt.close();
		return array;
	}
	public String getIdAndCountCatalogRecord(String product, String manufacturer) throws SQLException
	{
		stmt = con.createStatement();
		int id = 0, count = 0;
		r = stmt.executeQuery("SELECT CATALOG_RECORD.id FROM CATALOG_RECORD, PRODUCT, MANUFACTURER " +
        		              "WHERE CATALOG_RECORD.product_id = PRODUCT.id AND PRODUCT.name = '" + 

product + "' AND " +
        		              "MANUFACTURER.manufacturer = '" + manufacturer + "'");
		if(r.next())
        {
        	id = Integer.valueOf(r.getString("id"));
        }
        r.close();
        stmt.close();
		return new String("" + id);
	}
	public CatalogRecord getCatalogRecord(String id)
	{
		return null;
	}
	public void saveCatalog(Catalog catalog)
	{

	}
	public void savePubliсationData()
	{

	}
}
