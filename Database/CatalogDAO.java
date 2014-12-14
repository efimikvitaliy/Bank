package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		Catalog array = getLastPublishCatalog();
		if (array == null) {
			return new Catalog();
		}
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT CATALOG_RECORD.id, CATALOG_RECORD.price, CATALOG_RECORD.information, PRODUCT.count, PRODUCT.name, MANUFACTURER.manufacturer FROM CATALOG_RECORD, PRODUCT, MANUFACTURER WHERE CATALOG_RECORD.product_id = PRODUCT.id AND PRODUCT.manufacturer_id = MANUFACTURER.id AND PRODUCT.count > 0 " 
		                  + "AND CATALOG_RECORD.catalog_id ='" + array.id + "'");
        while(r.next())
        {
        	ManufacturersAndProducts mp = new ManufacturersAndProducts(0, r.getString("manufacturer"), r.getString("name"));
        	mp.setCount(Integer.valueOf(r.getString("count")));
        	CatalogRecord cr = new CatalogRecord(Integer.valueOf(r.getString("price")), r.getString("information"), mp);
        	cr.setId(r.getString("id"));
        	array.addRecord(cr);
        }
        r.close();
        stmt.close();
		return array;
	}
	
	public Catalog getLastPublishCatalog() throws SQLException {
		Catalog array = new Catalog();
		stmt = con.createStatement();
		array.setInformation("");
		r = stmt.executeQuery("SELECT sqlite_sequence.seq FROM sqlite_sequence WHERE sqlite_sequence.name = 'CATALOG_CONFIG'");		
		int n = r.getInt("seq");
		System.out.println(n);
		r.close();	 
		r = stmt.executeQuery("SELECT CATALOG_CONFIG.catalogInfo FROM CATALOG_CONFIG WHERE CATALOG_CONFIG.id = '" + n + "'");       
	    while(r.next())
	    {
	    	array.setInformation(r.getString("catalogInfo"));
	    	System.out.println(array.getInformation());
	    }    
	    r.close();
	    r = stmt.executeQuery("SELECT CATALOG_CONFIG.catalogPublicationDate FROM CATALOG_CONFIG WHERE CATALOG_CONFIG.id = '" + n + "'");       
	    while(r.next())
	    {
	        array.setDate(r.getInt("catalogPublicationDate"));
	        System.out.println(array.getDate());
	    }    
	    r.close();
	    array.id = n;
		if (array.getDate() == 0) {
			n -= 1;
			if (n < 1) {
				stmt.close();
				return null;
			}
			r = stmt.executeQuery("SELECT CATALOG_CONFIG.catalogInfo FROM CATALOG_CONFIG WHERE CATALOG_CONFIG.id = '" + n + "'");       
		    while(r.next())
		    {
		    	array.setInformation(r.getString("catalogInfo"));
		    	System.out.println(array.getInformation());
		    }    
		    r.close();
		    r = stmt.executeQuery("SELECT CATALOG_CONFIG.catalogPublicationDate FROM CATALOG_CONFIG WHERE CATALOG_CONFIG.id = '" + n + "'");       
		    while(r.next())
		    {
		        array.setDate(r.getInt("catalogPublicationDate"));
		        System.out.println(array.getDate());
		    }    
		    array.id = n;
		    r.close();
		}
		stmt.close();
		System.out.println("Get CUrrent Correct");
		return array;
	}
	
	public Catalog getCurrentCatalog() throws SQLException {
		Catalog array = new Catalog();
		stmt = con.createStatement();
		array.setInformation("");
		r = stmt.executeQuery("SELECT sqlite_sequence.seq FROM sqlite_sequence WHERE sqlite_sequence.name = 'CATALOG_CONFIG'");		
		int n = r.getInt("seq");
		System.out.println(n);
		r.close();	 
		r = stmt.executeQuery("SELECT CATALOG_CONFIG.catalogInfo FROM CATALOG_CONFIG WHERE CATALOG_CONFIG.id = '" + n + "'");       
	    while(r.next())
	    {
	    	array.setInformation(r.getString("catalogInfo"));
	    	System.out.println(array.getInformation());
	    }    
	    r.close();
	    r = stmt.executeQuery("SELECT CATALOG_CONFIG.catalogPublicationDate FROM CATALOG_CONFIG WHERE CATALOG_CONFIG.id = '" + n + "'");       
	    while(r.next())
	    {
	        array.setDate(r.getInt("catalogPublicationDate"));
	        System.out.println(array.getDate());
	    }    
	    r.close();	
	    r = stmt.executeQuery("SELECT CATALOG_RECORD.id, CATALOG_RECORD.price, CATALOG_RECORD.information, PRODUCT.count, PRODUCT.name, MANUFACTURER.manufacturer FROM CATALOG_RECORD, PRODUCT, MANUFACTURER WHERE CATALOG_RECORD.product_id = PRODUCT.id AND PRODUCT.manufacturer_id = MANUFACTURER.id AND PRODUCT.count > 0 " 
                + "AND CATALOG_RECORD.catalog_id ='" + n + "'");
	    while(r.next())
	    {
	    	ManufacturersAndProducts mp = new ManufacturersAndProducts(0, r.getString("manufacturer"), r.getString("name"));
	    	mp.setCount(Integer.valueOf(r.getString("count")));
	    	CatalogRecord cr = new CatalogRecord(Integer.valueOf(r.getString("price")), r.getString("information"), mp);
	    	cr.setId(r.getString("id"));
	    	array.addRecord(cr);
	    }
	    r.close();
		stmt.close();
		System.out.println("Get CUrrent Correct");
		return array;
	}
	
	public String getIdFromCatalogRecord(String product, String manufacturer) throws SQLException//++++
	{
		stmt = con.createStatement();
		int id = 0;
		r = stmt.executeQuery("SELECT CATALOG_RECORD.id FROM CATALOG_RECORD, PRODUCT, MANUFACTURER " +
	              "WHERE CATALOG_RECORD.product_id = PRODUCT.id AND PRODUCT.manufacturer_id = MANUFACTURER.id " +
	              " AND PRODUCT.name = '" + product + "' AND MANUFACTURER.manufacturer = '" + manufacturer + "'");
		if(r.next())
        {
        	id = Integer.valueOf(r.getString("id"));
        }
        r.close();
        stmt.close();
		return new String("" + id);
	}
	public ArrayList<String> getProductCountOrder(String id) throws SQLException
	{
		ArrayList<String> array = new ArrayList<>();
		stmt = con.createStatement();
        int count = 0;
		r = stmt.executeQuery("SELECT ORDER_LINE.count, PRODUCT.name, MANUFACTURER.manufacturer FROM ORDER_LINE," +
	              " PRODUCT, MANUFACTURER, CATALOG_RECORD, TABLE_ORDER WHERE TABLE_ORDER.client_id = " + id +
	              " AND TABLE_ORDER.id = ORDER_LINE.order_id AND ORDER_LINE.catalog_record_id = CATALOG_RECORD.id" + 
	              " AND CATALOG_RECORD.product_id = PRODUCT.id AND PRODUCT.manufacturer_id = MANUFACTURER.id");
		while(r.next())
        {
        	count = Integer.valueOf(r.getString("count"));
        	array.add("" + r.getString("manufacturer") + " " + r.getString("name") + " " + count);
        }
        r.close();
        stmt.close();
		return array;
	}
	public CatalogRecord getCatalogRecord(String id) throws SQLException 
	{
		CatalogRecord cr = null;
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT CATALOG_RECORD.id, CATALOG_RECORD.information, CATALOG_RECORD.price, PRODUCT.count, PRODUCT.name, MANUFACTURER.manufacturer FROM CATALOG_RECORD, PRODUCT, MANUFACTURER WHERE CATALOG_RECORD.product_id = PRODUCT.id AND PRODUCT.manufacturer_id = MANUFACTURER.id AND PRODUCT.count > 0 " 
		                  + "AND CATALOG_RECORD.id ='" + id + "'");
        while(r.next())
        {
        	ManufacturersAndProducts mp = new ManufacturersAndProducts(0, r.getString("manufacturer"), r.getString("name"));
        	mp.setCount(Integer.valueOf(r.getString("count")));
        	cr = new CatalogRecord(Integer.valueOf(r.getString("price")), r.getString("information"), mp);
        	cr.setId(r.getString("id"));        	
        }
        r.close();
        stmt.close();
		return cr;
	}
	public void deleteCatalog(Catalog catalog) throws SQLException {
		stmt = con.createStatement();
		System.out.println("catalog deleting");
		stmt.executeUpdate("DELETE * FROM CATALOG_CONFIG WHERE ");
		System.out.println("catalog saving 1");
		stmt.executeUpdate("INSERT INTO CATALOG_CONFIG (id, catalogInfo, catalogPublicationDate) VALUES"
							 + "('1', '" + catalog.getInformation() + "', '0')");
		System.out.println("catalog saving 2");	
		if (catalog.getInformation().equals(""))
			stmt.executeUpdate("DELETE FROM CATALOG_RECORD");
		System.out.println("catalog saving");
		r.close();
		stmt.close();
	}
	
	public void saveCatalog(Catalog catalog, boolean isCreated) throws SQLException {
		stmt = con.createStatement();
		if (!isCreated) {
			System.out.println("New version");
			stmt.executeUpdate("INSERT INTO CATALOG_CONFIG (catalogInfo, catalogPublicationDate) VALUES"
					 + "('" + catalog.getInformation() + "', '0')");
		}
		else {
			System.out.println("Rewrite version");
			r = stmt.executeQuery("SELECT sqlite_sequence.seq FROM sqlite_sequence WHERE sqlite_sequence.name = 'CATALOG_CONFIG'");	
			int n = r.getInt("seq");
			r.close();
			stmt.executeUpdate("UPDATE CATALOG_CONFIG SET catalogInfo ='" 
								+ catalog.getInformation() 
								+ "' WHERE CATALOG_CONFIG.id = '" 
								+ n	+ "'");
			stmt.executeUpdate("DELETE FROM CATALOG_RECORD WHERE catalog_id ='" 
					            + n	+ "'");
		}
		stmt.close();
	}
	public void savePublicationDate(Catalog catalog) throws SQLException
	{
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT sqlite_sequence.seq FROM sqlite_sequence WHERE sqlite_sequence.name = 'CATALOG_CONFIG'");	
		int n = r.getInt("seq");
		r.close();
		System.out.println( ""+catalog.getDate()  + " catalog publishing " + n);
		stmt.executeUpdate("UPDATE 'CATALOG_CONFIG' SET catalogPublicationDate = '"
							+ catalog.getDate() 
							+ "' WHERE CATALOG_CONFIG.id = '" 
							+ n	+ "'");
		stmt.close();
	}
	
	public void addCatalogRecord(int price, String information, Product product) throws SQLException {
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT sqlite_sequence.seq FROM sqlite_sequence WHERE sqlite_sequence.name = 'CATALOG_CONFIG'");	
		int n = r.getInt("seq");
		r.close();
		stmt.executeUpdate("INSERT INTO 'CATALOG_RECORD'" 
		                   + "('catalog_id','information','price','product_id')"
		                   + "VALUES('"
		                   + n + "','"
		                   + information + "','"
		                   + price + "','"
						   + product.getId()+"')");
		stmt.close();
	}
	public void deleteCatalogRecord(CatalogRecord record) throws SQLException{
		stmt = con.createStatement();
		//r = stmt.executeQuery("SELECT sqlite_sequence.seq FROM sqlite_sequence WHERE sqlite_sequence.name = 'CATALOG_CONFIG'");	
		//int n = r.getInt("seq");
		//r.close();
		stmt.executeUpdate("DELETE FROM 'CATALOG_RECORD' " 
		                   + "WHERE "
		                   + "CATALOG_RECORD.id ='"
		                  + record.getId() +"'");
		stmt.close();
	}
	
	public void updateCatalogRecord(CatalogRecord record) throws SQLException{
		stmt = con.createStatement();
		//r = stmt.executeQuery("SELECT sqlite_sequence.seq FROM sqlite_sequence WHERE sqlite_sequence.name = 'CATALOG_CONFIG'");	
		//int n = r.getInt("seq");
		//r.close();
		stmt.executeUpdate("UPDATE 'CATALOG_RECORD' SET information = '"
				+ record.getInformation() 
				+ "', price = '" 
				+ record.getPrice() 
				+ "' WHERE CATALOG_RECORD.id = '" 
				+ record.getId()+ "'");
		stmt.close();
	}
}
