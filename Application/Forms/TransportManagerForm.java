package Application.Forms;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Application.Controllers.AssignOrderTheTransportCompanyController;

public class TransportManagerForm extends JFrame {
	JButton AssignOrderButton;
	JButton AssignReturnButton;
	JButton CreateListOfTransportCompaniesButton;
	JButton EditListOfTransportComanies;

	public TransportManagerForm(){
		super("Transport Manager Form");
		init();
	}
	
	void init(){
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		
		AssignOrderButton = new JButton("Assign Order Transport Company");
		AssignReturnButton = new JButton("Assign Return Transport Company");
		CreateListOfTransportCompaniesButton = new JButton("Create List Of Transport Companies Button");
		EditListOfTransportComanies = new JButton("Edit List Of Transport Comanies");
		
		c.gridx = 1; c.gridy = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipadx = 10000;
		c.anchor = GridBagConstraints.NORTHWEST; // ���������� ������ � ����� ���� 
        c.insets = new Insets(10, 10, 10, 10);  // ��������� �������� 
		layout.setConstraints(AssignOrderButton, c);
		this.add(AssignOrderButton);
		c.anchor = GridBagConstraints.WEST;
		c.gridy = 2;
		layout.setConstraints(AssignReturnButton, c);
		this.add(AssignReturnButton);
		c.gridy = 3;
		layout.setConstraints(CreateListOfTransportCompaniesButton, c);
		this.add(CreateListOfTransportCompaniesButton);
		c.anchor = GridBagConstraints.SOUTHWEST;
		c.insets = new Insets(10, 10, 10, 10); 
		c.gridy = 4;
		layout.setConstraints(EditListOfTransportComanies, c);
		this.add(EditListOfTransportComanies);
		this.setSize(300, 300);
		this.setLocation(500, 500);
		
		AssignOrderButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					AssignOrderTheTransportCompanyController controller = new AssignOrderTheTransportCompanyController();
					JFrame frame = new JFrame("Assign Order The Transport Company");
					ListOfOrderForm listOfOrderForm = new ListOfOrderForm();
					
					frame.setSize(500, 500);
					GridBagLayout layout = new GridBagLayout();
					frame.setLayout(layout);
					GridBagConstraints c = new GridBagConstraints();
					
					c.gridx = 1;
					c.gridy = 1;
					layout.setConstraints(listOfOrderForm, c);
					frame.add(listOfOrderForm);
					controller.setMainFrame(frame);
					controller.m_ListOfOrderForm = listOfOrderForm;
					frame.setVisible(true);
					controller.startRoutine();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "SQLError");
				}
				
			}});
		AssignReturnButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		CreateListOfTransportCompaniesButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
		EditListOfTransportComanies.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
	}
	
	
}
