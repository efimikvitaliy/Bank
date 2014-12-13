package Application.Forms;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
	public EditOrderController getM_EditOrderController() {
		return m_EditOrderController;
	}

	/*
	 * устанавливаем все контроллеры кроме нужного null
	 * на обработке кнопки смотрим свой
	 */
	public void setM_EditOrderController(EditOrderController m_EditOrderController) {
		m_AssignOrderTheTransportCompanyController = null;
		m_AssignReturnTheTransportCompanyController = null;
		m_OrderReturnController = null;
		this.m_EditOrderController = m_EditOrderController;
	}

	public AssignOrderTheTransportCompanyController getM_AssignOrderTheTransportCompanyController() {
		
		return m_AssignOrderTheTransportCompanyController;
	}

	public void setM_AssignOrderTheTransportCompanyController(
			AssignOrderTheTransportCompanyController m_AssignOrderTheTransportCompanyController) {
		m_EditOrderController = null;
		m_AssignReturnTheTransportCompanyController = null;
		m_OrderReturnController = null;
		this.m_AssignOrderTheTransportCompanyController = m_AssignOrderTheTransportCompanyController;
	}

	public AssignReturnTheTransportCompanyController getM_AssignReturnTheTransportCompanyController() {
		return m_AssignReturnTheTransportCompanyController;
	}

	public void setM_AssignReturnTheTransportCompanyController(
			AssignReturnTheTransportCompanyController m_AssignReturnTheTransportCompanyController) {
		m_EditOrderController = null;
		m_AssignOrderTheTransportCompanyController = null;
		m_OrderReturnController = null;
		this.m_AssignReturnTheTransportCompanyController = m_AssignReturnTheTransportCompanyController;
	}

	public OrderReturnController getM_OrderReturnController() {
		return m_OrderReturnController;
	}

	public void setM_OrderReturnController(
			OrderReturnController m_OrderReturnController) {
		m_EditOrderController = null;
		m_AssignOrderTheTransportCompanyController = null;
		m_AssignReturnTheTransportCompanyController = null;
		this.m_OrderReturnController = m_OrderReturnController;
	}

	public OrderReturnController m_OrderReturnController;
	JTable table;
	JTextField id;
	public ListOfOrderForm(){
		super();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("state");
		model.addColumn("client id");
		table = new JTable(model);
		table.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				Point point = arg0.getPoint();
                int column = table.columnAtPoint(point);
                int row = table.rowAtPoint(point);
                id.setText(table.getModel().getValueAt(row, 0).toString());
                
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		
		JLabel label = new JLabel("Id: ");
		id = new JTextField("",20);
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					if(m_AssignOrderTheTransportCompanyController != null)
						m_AssignOrderTheTransportCompanyController.selectOrder(id.getText());
					if(m_AssignReturnTheTransportCompanyController != null)
						m_AssignReturnTheTransportCompanyController.getSelectedReturn(id.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		JScrollPane scp = new JScrollPane(table);
		JScrollBar verticalScrollBar = new 	JScrollBar();
		scp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		scp.setVerticalScrollBar(verticalScrollBar);
		table.setSize(new Dimension(400, 190));
		table.setPreferredSize(new Dimension(400, 190));
		scp.setSize(new Dimension(400, 190));
		scp.setPreferredSize(new Dimension(400, 190));
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
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Order order;
		for(int i=0;i<list.size();++i){
			order = list.get(i);
			model.addRow(new Object[]{order.getId(),order.getState(),order.getClient_id()});
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