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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;




/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:49:13
 */
public class ListOfTransportCompanyForm extends JPanel{

	public AssignOrderTheTransportCompanyController m_AssignOrderTheTransportCompanyController;
	public EditListOfTtransportConpanyController m_EditListOfTtransportConpanyController;
	public AssignReturnTheTransportCompanyController m_AssignReturnTheTransportCompanyController;
	public AssignOrderTheTransportCompanyController getM_AssignOrderTheTransportCompanyController() {
		
		return m_AssignOrderTheTransportCompanyController;
	}

	public void setM_AssignOrderTheTransportCompanyController(
			AssignOrderTheTransportCompanyController m_AssignOrderTheTransportCompanyController) {
		m_EditListOfTtransportConpanyController = null;
		m_AssignReturnTheTransportCompanyController = null;
		this.m_AssignOrderTheTransportCompanyController = m_AssignOrderTheTransportCompanyController;
	}

	public EditListOfTtransportConpanyController getM_EditListOfTtransportConpanyController() {
		return m_EditListOfTtransportConpanyController;
	}

	public void setM_EditListOfTtransportConpanyController(
			EditListOfTtransportConpanyController m_EditListOfTtransportConpanyController) {
		m_AssignOrderTheTransportCompanyController = null;
		m_AssignReturnTheTransportCompanyController = null;
		this.m_EditListOfTtransportConpanyController = m_EditListOfTtransportConpanyController;
	}

	public AssignReturnTheTransportCompanyController getM_AssignReturnTheTransportCompanyController() {
		return m_AssignReturnTheTransportCompanyController;
	}

	public void setM_AssignReturnTheTransportCompanyController(
			AssignReturnTheTransportCompanyController m_AssignReturnTheTransportCompanyController) {
		m_AssignOrderTheTransportCompanyController = null;
		m_EditListOfTtransportConpanyController = null;
		this.m_AssignReturnTheTransportCompanyController = m_AssignReturnTheTransportCompanyController;
	}

	ListOfTransportCompanies listOfTransportCompanies;
	JTable table;
	JTextField id;
	public boolean deleteItem;
	public boolean deleteList;
	public boolean editItem;
	
	public JFrame deleteFrame;
	public JFrame editFrame;
	
	public JTextField nameField;
	public JTextField descriptionField;
	
	public TransportCompany trComp;
	int check;
	public ListOfTransportCompanyForm(){
		super();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("id");
		model.addColumn("name");
		model.addColumn("description");
		
		
		JLabel label = new JLabel("Id: ");
		id = new JTextField("",20);
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					if(m_AssignOrderTheTransportCompanyController != null)
						m_AssignOrderTheTransportCompanyController.transportCompanySelected(listOfTransportCompanies.getWithId(Integer.parseInt(id.getText())));
					if(m_AssignReturnTheTransportCompanyController != null)
						m_AssignReturnTheTransportCompanyController.transportCompanySelected(listOfTransportCompanies.getWithId(Integer.parseInt(id.getText())));
					if(m_EditListOfTtransportConpanyController != null){
						if(deleteItem){
							m_EditListOfTtransportConpanyController.deleteSelectedTransportCompany(listOfTransportCompanies.getWithId(Integer.parseInt(id.getText())));
							id.setText("");
							deleteFrame.setVisible(false);
						}
						if(editItem){
							TransportCompany temp = listOfTransportCompanies.getWithId(Integer.parseInt(id.getText()));
							trComp.setTransportCompanyId(temp.getTransportCompanyId());
							trComp.setName(temp.getName());
							trComp.setDescription(temp.getDescription());
							nameField.setText(trComp.getName());
							descriptionField.setText(trComp.getDescription());
							
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		
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
                check = row;
                id.setText(table.getModel().getValueAt(row, 0).toString());
                
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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

	public void confirmSelectedTransportCompany(){

	}

	/**
	 * 
	 * @param list
	 */
	public void displayListOfTransportCompanies(ListOfTransportCompanies list){
		listOfTransportCompanies = list;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0; i<model.getRowCount(); ){
			model.removeRow(i);
		}
		TransportCompany transComp;
		for(int i=0;i<list.size();++i){
			transComp = list.get(i);
			model.addRow(new Object[]{transComp.getTransportCompanyId(),transComp.getName(),transComp.getDescription()});
			//System.out.println(transComp.getTransportCompanyId()+transComp.getName()+transComp.getDescription());
		}
		this.repaint();
	}

	public boolean requestConfirmOfTransportCompany(){
		return false;
	}

	public void selectTransportCompany(){

	}

}