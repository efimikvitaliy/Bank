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
import Application.Controllers.AssignReturnTheTransportCompanyController;
import Application.Controllers.CreatingListOfTransportCompanyController;
import Application.Controllers.EditListOfTtransportConpanyController;

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
		c.anchor = GridBagConstraints.NORTHWEST; // установить кнопку в конец окна 
        c.insets = new Insets(10, 10, 10, 10);  // поставить заглушку 
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
					
					frame.setSize(500, 1000);
					GridBagLayout layout = new GridBagLayout();
					frame.setLayout(layout);
					GridBagConstraints c = new GridBagConstraints();
					
					c.gridx = 1;
					c.gridy = 1;
					layout.setConstraints(listOfOrderForm, c);
					frame.add(listOfOrderForm);
					
					OrderFormJustForm orderForm = new OrderFormJustForm();
					
					c.gridx = 1;
					c.gridy = 2;
					layout.setConstraints(orderForm, c);
					frame.add(orderForm);
					
					ListOfTransportCompanyForm transForm = new ListOfTransportCompanyForm();
					
					c.gridx = 1;
					c.gridy = 3;
					layout.setConstraints(transForm, c);
					frame.add(transForm);
					
					controller.setMainFrame(frame);
					controller.m_ListOfOrderForm = listOfOrderForm;
					controller.m_OrderForm = orderForm;
					controller.m_ListOfTransportCompanyForm = transForm;
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
			try{
				AssignReturnTheTransportCompanyController controller = new AssignReturnTheTransportCompanyController();
				JFrame frame = new JFrame("Assign Return The Transport Company");
				ListOfOrderForm listOfOrderForm = new ListOfOrderForm();
				
				frame.setSize(500, 1000);
				GridBagLayout layout = new GridBagLayout();
				frame.setLayout(layout);
				GridBagConstraints c = new GridBagConstraints();
				
				c.gridx = 1;
				c.gridy = 1;
				layout.setConstraints(listOfOrderForm, c);
				frame.add(listOfOrderForm);
				
				OrderFormJustForm returnForm = new OrderFormJustForm();
				
				c.gridx = 1;
				c.gridy = 2;
				layout.setConstraints(returnForm, c);
				frame.add(returnForm);
				
				ListOfTransportCompanyForm transForm = new ListOfTransportCompanyForm();
				
				c.gridx = 1;
				c.gridy = 3;
				layout.setConstraints(transForm, c);
				frame.add(transForm);
				
				controller.setMainFrame(frame);
				controller.m_ListOfOrderForm = listOfOrderForm;
				controller.m_ReturnForm = returnForm;
				controller.m_ListOfTransportCompanyForm = transForm;
				frame.setVisible(true);
				controller.startRoutine();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "SQLError");
			}
				
			}});
		CreateListOfTransportCompaniesButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CreatingListOfTransportCompanyController controller = new CreatingListOfTransportCompanyController();
				try {
					controller.startRoutine();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
		EditListOfTransportComanies.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					EditListOfTtransportConpanyController controller = new EditListOfTtransportConpanyController();

					controller.startRoutine();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
	}
	
	
}
