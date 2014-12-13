package Application.Controllers;
import java.sql.SQLException;

import javax.swing.JFrame;

import BusinessService.Entities.*;
import Application.Forms.*;
import Database.*;

import Application.Forms.*;
import Database.*;

/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:47:53
 */
public class AssignReturnTheTransportCompanyController {

	public ListOfTransportCompanyForm m_ListOfTransportCompanyForm;
	public OrderFormJustForm m_ReturnForm;
	public Order m_Order;
	public ListOfOrders m_ListOfOrders;
	public ListOfTransportCompanies m_ListOfTransportCompanies;
	public ListOfOrderForm m_ListOfOrderForm;
	public OrderDAO m_OrderDAO;
	public TransportCompanyDAO m_TransportCompanyDAO;
	public JFrame mainFrame;

	public AssignReturnTheTransportCompanyController(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param name
	 * @throws SQLException 
	 */
	public void getSelectedReturn(String id) throws SQLException{
		m_Order = m_OrderDAO.getReturn(id);
		m_ReturnForm.displayDataAboutOrder(m_Order);
		m_ListOfTransportCompanies = m_TransportCompanyDAO.getListOfTransportCompanies();
		m_ListOfTransportCompanyForm.displayListOfTransportCompanies(m_ListOfTransportCompanies);

	}

	/**
	 * 
	 * @param company
	 * @throws SQLException 
	 */
	public void transportCompanySelected(TransportCompany company) throws SQLException{
		m_Order.setReturnTransportCompany(company.getTransportCompanyId());
		m_Order.setState(4);
		m_OrderDAO.saveOrderWithTransportCompanyToReturn(m_Order);
	}

	public void setMainFrame(JFrame frame) {
		// TODO Auto-generated method stub
		mainFrame = frame;
		
		
	}

	public void startRoutine() throws SQLException {
		// TODO Auto-generated method stub
		m_OrderDAO = new OrderDAO();
		m_TransportCompanyDAO = new TransportCompanyDAO();
		m_ListOfOrders = m_OrderDAO.getListOfReturns();
		m_ListOfOrderForm.setM_AssignReturnTheTransportCompanyController(this);
		m_ListOfOrderForm.displayListOfOrders(m_ListOfOrders);
		m_ListOfTransportCompanyForm.m_AssignReturnTheTransportCompanyController = this;
	}

}