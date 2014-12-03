package Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import BusinessService.Entities.User;

public class UserDAO
{
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet r = null;
    
	public UserDAO()
	{
        con = DBManager.getInstance().getConnection();
	}
	public int getTypeOfUserWithThisLoginAndPassword(User user) throws SQLException
	{
        stmt = con.createStatement();
        r = stmt.executeQuery("SELECT * FROM USER WHERE login = '" + user.getLogin() + "' AND password = '" + user.getPassword() + "'");
        int type = 0;
        if(r.next())
        {
        	type = Integer.valueOf(r.getString("type"));
        }
        r.close();
        stmt.close();
		return type;
	}
}
