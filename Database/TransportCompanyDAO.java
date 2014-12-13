package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BusinessService.Entities.*;

/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:51:14
 */
public class TransportCompanyDAO {

	private Connection con = null;
	private Statement stmt = null;
	private ResultSet r = null;

	public TransportCompanyDAO() {
		con = DBManager.getInstance().getConnection();
	}

	public void finalize() throws Throwable {

	}

	public boolean createListOfTransportCompaniesInDatabase() throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("CREATE TABLE TRANSPORT_COMPANY(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , name TEXT(300) , description TEXT(1000)  );");
        //stmt.executeUpdate(" ALTER TABLE TABLE_ORDER ADD CONSTRAINT Relation1 FOREIGN KEY (deliverTransportCompany) REFERENCES TRANSPORT_COMPANY(id) ;");
        //stmt.executeUpdate(" ALTER TABLE TABLE_ORDER ADD CONSTRAINT Relation2 FOREIGN KEY (returnTransportCompany) REFERENCES TRANSPORT_COMPANY(id) ;");
        stmt.close();
		return false;
	}

	public boolean deleteListOfTransportCompaniesInDatabase() throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("DROP TABLE TRANSPORT_COMPANY;");
        stmt.close();
		return false;
	}

	/**
	 * 
	 * @param company
	 * @throws SQLException 
	 */
	public boolean deleteSelectedTransportCompanyFrowDatabase(
			TransportCompany company) throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("DELETE FROM TRANSPORT_COMPANY WHERE id = " + company.getTransportCompanyId());
        r.close();
        stmt.close();
		return false;
	}

	public ListOfTransportCompanies getListOfTransportCompanies() throws SQLException {
		ListOfTransportCompanies array = new ListOfTransportCompanies();
		stmt = con.createStatement();
		
		r = stmt.executeQuery("SELECT * FROM \"TRANSPORT_COMPANY\";");
		while(r.next()){
			TransportCompany tranComp = new TransportCompany(r.getInt("id"),r.getString("name"),r.getString("description"));
			array.add(tranComp);
		}
		r.close();
        stmt.close();
		return array;
		
	}

	/**
	 * 
	 * @param name
	 */
	public TransportCompany getTransportCompany(String name) {
		return null;
	}

	/**
	 * 
	 * @param company
	 * @throws SQLException 
	 */
	public boolean saveChangesOfTransportCompanyInDatabase(
			TransportCompany company) throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("UPDATE TRANSPORT_COMPANY SET name = '" + company.getName() + "' , description = '" + company.getDescription() + "' WHERE id = " + company.getTransportCompanyId());
		stmt.close();
		return false;
	}

	/**
	 * 
	 * @param company
	 * @throws SQLException 
	 */
	public boolean saveNewTransportCompanyInDatabase(TransportCompany company) throws SQLException {
		stmt = con.createStatement();
		stmt.executeUpdate("INSERT INTO TRANSPORT_COMPANY ( name , description) VALUES ( '" + company.getName() + "', '" + company.getDescription() + "')");
		stmt.close();
		return false;
	}

}