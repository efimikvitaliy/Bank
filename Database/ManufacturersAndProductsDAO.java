package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BusinessService.Entities.ListOfManufacturersAndProducts;
import BusinessService.Entities.ListOfProducts;
import BusinessService.Entities.ManufacturersAndProducts;
import BusinessService.Entities.Product;

public class ManufacturersAndProductsDAO
{
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet r = null;
    
	public ManufacturersAndProductsDAO()
	{
		con = DBManager.getInstance().getConnection();
	}
	public void createListOfManufacturersAndProducts() throws SQLException
	{
		stmt = con.createStatement();
		stmt.executeUpdate("CREATE TABLE MANUFACTURER(id int(10) NOT NULL, manufacturer TEXT(30) NOT NULL, PRIMARY KEY (id))");
        stmt.executeUpdate("CREATE TABLE PRODUCT(id int(10) NOT NULL, name varchar(20)" + 
		                   " NOT NULL, count int(10) NOT NULL, manufacturer_id int(10)," +
        		           " PRIMARY KEY (id), FOREIGN KEY(manufacturer_id)" +
        		           " REFERENCES MANUFACTURER(id), FOREIGN KEY(id)" +
        		           " REFERENCES CATALOG_RECORD(product_id))");
        stmt.close();
	}
	public void deleteListOfManufacturersAndProducts() throws SQLException
	{
		stmt = con.createStatement();
		stmt.executeUpdate("DROP TABLE PRODUCT");
        stmt.executeUpdate("DROP TABLE MANUFACTURER");
        stmt.close();
	}
	public void add(ManufacturersAndProducts m) throws SQLException
	{
        stmt = con.createStatement();
        r = stmt.executeQuery("SELECT MANUFACTURER.id, MANUFACTURER.manufacturer FROM MANUFACTURER");
        int manufacter_id = -1;
        int max_id_product = 0;
        int i = 0;
        while(r.next())
        {
        	if(r.getString("manufacturer").equals(m.getManufacturers()))
        	{
        		manufacter_id = Integer.valueOf(r.getString("id"));
        		break;
        	}
        	else
        	{
        		i = Integer.valueOf(r.getString("id"));
        	}
        }
       	++i;
        if(manufacter_id == -1)
        {
            stmt.executeUpdate("INSERT INTO [MANUFACTURER] ([id], [manufacturer]) VALUES (" + i + ", '" + m.getManufacturers() + "')");
            manufacter_id = i;
        }
        r = stmt.executeQuery("SELECT * FROM PRODUCT");
        while(r.next())
        {
        	if(max_id_product < Integer.valueOf(r.getString("id")))
        	{
        		max_id_product = Integer.valueOf(r.getString("id"));
        	}
        }
        ++max_id_product;
        stmt.executeUpdate("INSERT INTO [PRODUCT] ([id], [name], [count], [manufacturer_id]) VALUES (" 
                               + max_id_product + ", '" + m.getProducts() + "', " + m.getCount() + ", " + manufacter_id +")");
        r.close();
        stmt.close();
	}
	public void update(ManufacturersAndProducts m) throws SQLException
	{
		stmt = con.createStatement();
		r = stmt.executeQuery("SELECT * FROM PRODUCT WHERE id = " + m.getId());
		r.next();
		int manufacter_id = Integer.valueOf(r.getString("manufacturer_id"));
		r = stmt.executeQuery("SELECT * FROM MANUFACTURER");
		while(r.next())
		{
			if(r.getString("manufacturer").equals(m.getManufacturers()))
			{
				manufacter_id = Integer.valueOf(r.getString("id"));
			}
		}
		stmt.executeUpdate("UPDATE MANUFACTURER SET manufacturer = '" + m.getManufacturers() + "' WHERE id = " + manufacter_id);
        stmt.executeUpdate("UPDATE PRODUCT SET name = '" + m.getProducts() + "', count = " + m.getCount() + " WHERE id = " + m.getId());
        r.close();
        stmt.close();
	}
	public void delete(int index) throws SQLException
	{
		stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM PRODUCT WHERE id = " + index);
        r.close();
        stmt.close();
	}
	public ListOfManufacturersAndProducts getListOfManufacturersAndProducts() throws SQLException
	{
        stmt = con.createStatement();
        r = stmt.executeQuery("SELECT PRODUCT.count, PRODUCT.id, MANUFACTURER.manufacturer, PRODUCT.name FROM MANUFACTURER, PRODUCT WHERE MANUFACTURER.id = PRODUCT.manufacturer_id");
        ListOfManufacturersAndProducts array = new ListOfManufacturersAndProducts();
        while(r.next())
        {
        	ManufacturersAndProducts m = new ManufacturersAndProducts(Integer.valueOf(r.getString("id")), r.getString("manufacturer"), r.getString("name"));
        	m.setCount(Integer.valueOf(r.getString("count")));
        	array.add(m);
        }
        r.close();
        stmt.close();
		return array;
	}
	public ListOfProducts getListOfProducts()
	{
		return null;
	}
	public Product getProduct(String id)
	{
		return null;
	}
	public void saveListOfManufacturersAndProducts(ListOfManufacturersAndProducts list)
	{
		
	}
	public void saveListOfProducts(ListOfProducts list)
	{

	}
}
