package Application.Controllers;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BusinessService.Entities.*;
import Application.Forms.*;
import Database.*;

import Application.Forms.*;
import Database.*;

/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:47:57
 */
public class CreatingListOfTransportCompanyController {

	public CreateListOfTransportCompanyForm m_CreateListOfTransportCompanyForm;
	public TransportCompanyDAO m_TransportCompanyDAO;
	public ListOfTransportCompanies m_ListOfTransportCompanies;

	public CreatingListOfTransportCompanyController(){

	}

	public void finalize() throws Throwable {

	}

	public void createConfirm() throws SQLException{
		m_TransportCompanyDAO.createListOfTransportCompaniesInDatabase();
	}

	public boolean isListNotCreated(){
		try
		{
			m_TransportCompanyDAO = new TransportCompanyDAO();
			m_TransportCompanyDAO.getListOfTransportCompanies();
		}
		catch(SQLException e1)
		{
			return true;
		}
		return false;

	}
	
	public void startRoutine() throws SQLException{
		if(isListNotCreated()){
			int d = JOptionPane.showConfirmDialog(null, "Create list?", "Creating", JOptionPane.YES_NO_CANCEL_OPTION);
			switch(d){
			case 0:
				createConfirm();
				
			}
			
		}
		else{
			JOptionPane.showMessageDialog(null, "Just Created");
		}
	}

}