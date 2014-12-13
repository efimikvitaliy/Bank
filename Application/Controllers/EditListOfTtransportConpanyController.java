package Application.Controllers;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BusinessService.Entities.*;
import Application.Forms.*;
import Database.*;

/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:48:01
 */
public class EditListOfTtransportConpanyController {

	public EditListOfTransportCompaniesForm m_EditListOfTransportCompaniesForm;
	public ListOfTransportCompanyForm m_ListOfTransportCompanyForm;
	public TransportCompany m_TransportCompany;
	public ListOfTransportCompanies m_ListOfTransportCompanies;
	public TransportCompanyDAO m_TransportCompanyDAO;

	public EditListOfTtransportConpanyController(){

	}

	public void finalize() throws Throwable {

	}

	public void addItem(){

	}

	/**
	 * 
	 * @param data
	 * @throws SQLException 
	 */
	public void addNewTransportCompany(TransportCompany company) throws SQLException{
		m_TransportCompanyDAO.saveNewTransportCompanyInDatabase(company);
	}

	public void deleteItem(){

	}

	public void deleteListOfTransportCompanies() throws SQLException{
		int d = JOptionPane.showConfirmDialog(null, "Delete list?", "Deleting", JOptionPane.YES_NO_CANCEL_OPTION);
		switch(d){
		case 0:
			m_TransportCompanyDAO.deleteListOfTransportCompaniesInDatabase();
		}
	}

	/**
	 * 
	 * @param company
	 * @throws SQLException 
	 */
	public void deleteSelectedTransportCompany(TransportCompany company) throws SQLException{
		m_TransportCompanyDAO.deleteSelectedTransportCompanyFrowDatabase(company);

	}

	public void editItem(){

	}

	/**
	 * 
	 * @param name
	 */
	public void getTransportCompany(String name){

	}

	public void listDoesNotContainThisCompany(){

	}

	/**
	 * 
	 * @param company
	 * @throws SQLException 
	 */
	public void setNewInformationOfTransportCompany(TransportCompany company) throws SQLException{
		m_TransportCompanyDAO.saveChangesOfTransportCompanyInDatabase(company);
	}
	
	public ListOfTransportCompanies getM_ListOfTransportCompanies() throws SQLException {
		m_ListOfTransportCompanies = m_TransportCompanyDAO.getListOfTransportCompanies();
		return m_ListOfTransportCompanies;
	}

	public void setM_ListOfTransportCompanies(
			ListOfTransportCompanies m_ListOfTransportCompanies) {
		this.m_ListOfTransportCompanies = m_ListOfTransportCompanies;
	}

	public void startRoutine() throws SQLException{
		m_TransportCompanyDAO = new TransportCompanyDAO();
		m_ListOfTransportCompanies = m_TransportCompanyDAO.getListOfTransportCompanies();
		m_EditListOfTransportCompaniesForm = new EditListOfTransportCompaniesForm();
		m_EditListOfTransportCompaniesForm.setM_EditListOfTtransportConpanyController( this );
		
		
	}
}