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

	public boolean createListOfTransportCompaniesInDatabase() {
		return false;
	}

	public boolean deleteListOfTransportCompaniesInDatabase() {
		return false;
	}

	/**
	 * 
	 * @param company
	 */
	public boolean deleteSelectedTransportCompanyFrowDatabase(
			TransportCompany company) {
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
	 */
	public boolean saveChangesOfTransportCompanyInDatabase(
			TransportCompany company) {
		return false;
	}

	/**
	 * 
	 * @param company
	 */
	public boolean saveNewTransportCompanyInDatabase(TransportCompany company) {
		return false;
	}

}