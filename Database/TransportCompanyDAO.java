package Database;

import Entities.*;


/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:51:14
 */
public class TransportCompanyDAO {

	public TransportCompanyDAO(){

	}

	public void finalize() throws Throwable {

	}

	public boolean createListOfTransportCompaniesInDatabase(){
		return false;
	}

	public boolean deleteListOfTransportCompaniesInDatabase(){
		return false;
	}

	/**
	 * 
	 * @param company
	 */
	public boolean deleteSelectedTransportCompanyFrowDatabase(TransportCompany company){
		return false;
	}

	public ListOfTransportCompanies getListOfTransportCompanies(){
		return null;
	}

	/**
	 * 
	 * @param name
	 */
	public TransportCompany getTransportCompany(String name){
		return null;
	}

	/**
	 * 
	 * @param company
	 */
	public boolean saveChangesOfTransportCompanyInDatabase(TransportCompany company){
		return false;
	}

	/**
	 * 
	 * @param company
	 */
	public boolean saveNewTransportCompanyInDatabase(TransportCompany company){
		return false;
	}

}