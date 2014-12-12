package Application.Forms;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


/**
 * @author User
 * @version 1.0
 * @created 01--2014 23:49:16
 */
public class OrderFormJustForm extends JPanel {

	public CreateOrderController m_CreateOrderController;
	public EditOrderController m_EditOrderController;
	public EditOrderController getM_EditOrderController() {
		return m_EditOrderController;
	}

	public CreateOrderController getM_CreateOrderController() {
		return m_CreateOrderController;
	}

	public void setM_CreateOrderController(
			CreateOrderController m_CreateOrderController) {
		this.m_CreateOrderController = m_CreateOrderController;
	}

	public OrderReturnController getM_OrderReturnController() {
		return m_OrderReturnController;
	}

	public void setM_OrderReturnController(
			OrderReturnController m_OrderReturnController) {
		this.m_OrderReturnController = m_OrderReturnController;
	}

	public void setM_EditOrderController(EditOrderController m_EditOrderController) {
		this.m_EditOrderController = m_EditOrderController;
	}

	public OrderReturnController m_OrderReturnController;
	JLabel id;
	JLabel state;
	JLabel deliv;
	JLabel retu;
	JLabel client;
	JLabel idD;
	JLabel stateD;
	JLabel delivD;
	JLabel retuD;
	JLabel clientD;
	public OrderFormJustForm(){
		super();
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		id = new JLabel("id: ");
		state = new JLabel("state: ");
		deliv = new JLabel("deliver Transport Company: ");
		retu = new JLabel("return Transport Company: ");
		client = new JLabel("client_id: ");
		idD = new JLabel();
		stateD = new JLabel();
		delivD = new JLabel();
		retuD = new JLabel();
		clientD = new JLabel();
		
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.3;
		layout.setConstraints(id, c);
		this.add(id);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.3;
		layout.setConstraints(idD, c);
		this.add(idD);
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0.3;
		layout.setConstraints(state, c);
		this.add(state);
		c.gridwidth = 1;
		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 0.3;
		layout.setConstraints(stateD, c);
		this.add(stateD);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.3;
		layout.setConstraints(deliv, c);
		this.add(deliv);
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.3;
		layout.setConstraints(delivD, c);
		this.add(delivD);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0.3;
		layout.setConstraints(retu, c);
		this.add(retu);
		c.gridwidth = 2;
		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 0.3;
		layout.setConstraints(retuD, c);
		this.add(retuD);
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		c.weightx = 0.3;
		layout.setConstraints(client, c);
		this.add(client);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 0.3;
		layout.setConstraints(clientD, c);
		this.add(clientD);
		
		
	}

	public void finalize() throws Throwable {

	}

	public void confirmMakeOrder(){

	}

	/**
	 * 
	 * @param order
	 */
	public void displayDataAboutOrder(Order order){
		idD.setText(Integer.toString(order.getId()));
		stateD.setText(Integer.toString(order.getState()));
		delivD.setText(Integer.toString(order.getDeliverTransportCompany()));
		retuD.setText(Integer.toString(order.getReturnTransportCompany()));
		clientD.setText(Integer.toString(order.getClient_id()));

	}

	/**
	 * 
	 * @param b
	 */
	public void setVisible(boolean b){

	}

}