package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager
{
    private static DBManager _instance = null;
    private Connection _con = null;
    
    private DBManager()
    {
        _con = getDBConnection();
    }
    
    public static synchronized DBManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new DBManager();
        }
        return _instance;
    }

    public Connection getConnection()
    {
        return _con;
    }

    private static Connection getDBConnection()
    {
        Connection con = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:/temp/bank.db";
            con = DriverManager.getConnection(url);
        }
        catch(Exception se)
        {
            System.out.println(se);
        }
        return con;
    }

    public void close()
    {
        try
        {
            _con.close();
        }
        catch (Exception e)
        {
            System.err.println("Error in closing dbase");
        }
    }
}

