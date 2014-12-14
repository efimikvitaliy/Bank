package Application.Controllers;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BusinessService.Entities.*;
import Application.Forms.*;
import Database.*;

/**
 * @author Владимир
 * @version 1.0
 * @created 01-дек-2014 23:48:07
 */
public class OrderReturnController {

	public OrderDAO m_OrderDAO;
	public ListOfReturnsForm m_ListOfReturnsForm;
	public OrderFormJustForm m_OrderForm;
	public ListOfOrders m_ListOfOrders;
	public Order m_Order;

	public OrderReturnController(){
		m_OrderDAO = new OrderDAO();
	}

	public void finalize() throws Throwable {
		
	}

	/**
	 * 
	 * @param id
	 */
	public void getOrder(String id){
		try {
			Order order = m_OrderDAO.getOrder(id);
			int n = JOptionPane.showConfirmDialog(null,
				    "<html>Make return Order?\n" +
				    "Info Client_id: " + order.getClient_id() +  "\n" +
				    "Info Deliver TrComp: " + order.getDeliverTransportCompany() +  "\n" +
				    "Info Price: " + order.getPrice() +  "\n",
				    "Attention",
				    JOptionPane.YES_NO_OPTION);
			if (n == 0) 
			{
				m_OrderDAO.saveReturn(order);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param order
	 */
	public void makeOrderReturn(Order order){
		try {
			m_OrderDAO.saveReturn(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void startRoutine() {
		try {
			m_ListOfOrders = m_OrderDAO.getListOfSendOrder();
			if (m_ListOfOrders.getListOfOrder().isEmpty()) {
				JOptionPane.showConfirmDialog(null,
					    "<html>No sended orders", 
					    "Attention",
					    JOptionPane.CANCEL_OPTION);
			}
			else {
				m_ListOfReturnsForm = new ListOfReturnsForm();
				m_ListOfReturnsForm.setOrderReturnController(this);
				m_ListOfReturnsForm.displayListOfReturns(m_ListOfOrders);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}