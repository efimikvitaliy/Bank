package Application.Forms;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


import Application.Controllers.*;
import Application.Forms.*;
import Database.*;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:49:11
 */
public class ListOfOrderForm extends JPanel {

	public EditOrderController m_EditOrderController;
	public AssignOrderTheTransportCompanyController m_AssignOrderTheTransportCompanyController;
	public AssignReturnTheTransportCompanyController m_AssignReturnTheTransportCompanyController;
	public OrderReturnController m_OrderReturnController;
	JTable table;
	public ListOfOrderForm(){
		super();
		table = new JTable(0,5);
		JLabel label = new JLabel("Id: ");
		JTextField id = new JTextField("",20);
		JButton ok = new JButton("OK");
		JScrollPane scp = new JScrollPane(table);
		JScrollBar verticalScrollBar = new 	JScrollBar();
		scp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scp.setVerticalScrollBar(verticalScrollBar);
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 4;
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.3;
		layout.setConstraints(scp, c);
		this.add(scp);
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		layout.setConstraints(label, c);
		this.add(label);
		c.gridx = 2;
		c.gridy = 2;
		layout.setConstraints(id, c);
		this.add(id);
		c.gridx = 3;
		c.gridy = 2;
		layout.setConstraints(ok, c);
		this.add(ok);

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param list
	 */
	public void displayListOfOrders(ListOfOrders list){
		for(int i=0;i<list.size();++i){
			
		}
	}

	/**
	 * 
	 * @param list
	 */
	public void displayListOfReturns(ListOfOrders list){

	}

	public void selectOrder(){

	}

	/**
	 * 
	 * @param b
	 */
	public void setVisible(boolean b){

	}

}