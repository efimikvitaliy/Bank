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
	public OrderFormJustForm m_OrderForm;
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
	 * @throws SQLException 
	 */
	public void selectOrder(String id) throws SQLException{
		m_Order = m_OrderDAO.getOrder(id);
		m_OrderForm.displayDataAboutOrder(m_Order);
		m_ListOfTransportCompanies = m_TransportCompanyDAO.getListOfTransportCompanies();
		m_ListOfTransportCompanyForm.displayListOfTransportCompanies(m_ListOfTransportCompanies);
		
	}

	/**
	 * 
	 * @param company
	 * @throws SQLException 
	 */
	public void transportCompanySelected(TransportCompany company) throws SQLException{
		m_Order.setDeliverTransportCompany(company.getTransportCompanyId());
		m_OrderDAO.saveOrderWithTransportCompany(m_Order);

	}
	
	public void setMainFrame(JFrame frame){
		mainFrame = frame;
	}
	public void startRoutine() throws SQLException{
		m_OrderDAO = new OrderDAO();
		m_TransportCompanyDAO = new TransportCompanyDAO();
		m_ListOfOrders = m_OrderDAO.getListOfOrder();
		m_ListOfOrderForm.setM_AssignOrderTheTransportCompanyController(this);
		m_ListOfOrderForm.displayListOfOrders(m_ListOfOrders);
		m_ListOfTransportCompanyForm.m_AssignOrderTheTransportCompanyController = this;
		
		
	}

}