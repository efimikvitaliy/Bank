package Application.Controllers;
import java.sql.SQLException;

import javax.swing.JFrame;

import BusinessService.Entities.*;
import Application.Forms.*;
import Database.*;

/**
 * @author user
 * @version 1.0
 * @created 02-дек-2014 0:06:56
 */
public class AssignOrderTheTransportCompanyController {

	public ListOfTransportCompanyForm m_ListOfTransportCompanyForm;
	public OrderDAO m_OrderDAO;
	public TransportCompanyDAO m_TransportCompanyDAO;
	public Order m_Order;
	public ListOfOrders m_ListOfOrders;
	public OrderForm m_OrderForm;
	public ListOfTransportCompanies m_ListOfTransportCompanies;
	public ListOfOrderForm m_ListOfOrderForm;
	public JFrame mainFrame;

	public AssignOrderTheTransportCompanyController(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param name
	 */
	public void selectOrder(String name){

	}

	/**
	 * 
	 * @param company
	 */
	public void transportCompanySelected(TransportCompany company){

	}
	
	public void setMainFrame(JFrame frame){
		mainFrame = frame;
	}
	public void startRoutine() throws SQLException{
		m_OrderDAO = new OrderDAO();
		m_ListOfOrders = m_OrderDAO.getListOfOrder();
		m_ListOfOrderForm.displayListOfOrders(m_ListOfOrders);
		
	}

}