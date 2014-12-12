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
	ListOfTransportCompanies listOfTransportCompanies;
	JTable table;
	JTextField id;
	
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
					
					m_AssignOrderTheTransportCompanyController.transportCompanySelected(listOfTransportCompanies.getWithId(Integer.parseInt(id.getText())));
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