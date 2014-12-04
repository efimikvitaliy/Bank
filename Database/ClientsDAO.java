package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import BusinessService.Entities.Client;
import BusinessService.Entities.ListOfClients;

public class ClientsDAO
{
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet r = null;
    
	public ClientsDAO()
	{
		con = DBManager.getInstance().getConnection();
	}
	public ListOfClients getListOfClients() throws SQLException
	{
        stmt = con.createStatement();
        r = stmt.executeQuery("SELECT * FROM CLIENT");
        ListOfClients array = new ListOfClients();
        while(r.next())
        {
        	Client m = new Client(r.getString("id"), r.getString("firstName"), r.getString("secondName"));
        	array.add(m);
        }
        r.close();
        stmt.close();
		return array;
	}
	public Client getClient(String id) throws SQLException
	{
        stmt = con.createStatement();
        r = stmt.executeQuery("SELECT * FROM CLIENT WHERE id = " + Integer.valueOf(id));
        r.next();
        Client client = new Client(r.getString("id"), r.getString("firstName"), r.getString("secondName"));
        client.setAddress(r.getString("address"));
        client.setEmail(r.getString("email"));
        r.close();
        stmt.close();
		return client;
	}
}
