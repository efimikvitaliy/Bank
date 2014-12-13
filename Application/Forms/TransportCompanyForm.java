package Application.Forms;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:49:20
 */
public class TransportCompanyForm {

	public EditListOfTtransportConpanyController m_EditListOfTtransportConpanyController;
	JFrame addFrame;
	JFrame editFrame;
	TransportCompany trComp1;
	ListOfTransportCompanyForm listForm;
	public TransportCompanyForm(){

	}

	public void finalize() throws Throwable {

	}

	public void confirmData(){

	}

	public void confirmEditing(){

	}

	public void displayFormForInput(){
		if(addFrame == null){
			addFrame = new JFrame("Add Frame");
		GridBagLayout layout = new GridBagLayout();
		addFrame.setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		JLabel idLabel = new JLabel("id:");
		JLabel nameLabel = new JLabel("name:");
		JLabel descriptionLabel = new JLabel("description:");
		final JLabel idField = new JLabel("autom");
		final JTextField nameField = new JTextField("",20);
		final JTextField descriptionField = new JTextField("",20);
		JButton ok = new JButton("OK");
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.3;
		layout.setConstraints(idLabel, c);
		addFrame.add(idLabel);
		c.gridx = 1;
		c.gridy = 0;
		layout.setConstraints(idField, c);
		addFrame.add(idField);
		c.gridx = 0;
		c.gridy = 1;
		layout.setConstraints(nameLabel, c);
		addFrame.add(nameLabel);
		c.gridx = 1;
		c.gridy = 1;
		layout.setConstraints(nameField, c);
		addFrame.add(nameField);
		c.gridx = 0;
		c.gridy = 2;
		layout.setConstraints(descriptionLabel, c);
		addFrame.add(descriptionLabel);
		c.gridx = 1;
		c.gridy = 2;
		layout.setConstraints(descriptionField, c);
		addFrame.add(descriptionField);
		c.gridx = 1;
		c.gridy = 3;
		layout.setConstraints(ok, c);
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					TransportCompany company = new TransportCompany(0, nameField.getText(), descriptionField.getText() );
				
					m_EditListOfTtransportConpanyController.addNewTransportCompany(company);
					addFrame.setVisible(false);
					nameField.setText("");
					descriptionField.setText("");
					JOptionPane.showMessageDialog(null, "Ok");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		addFrame.add(ok);
		addFrame.setSize(500, 500);
		addFrame.setLocation(100, 100);}
		addFrame.setVisible(true);
	}

	public void displayFormForEditing(){
		try {if(editFrame == null){
			editFrame = new JFrame("Edit Frame");
		GridBagLayout layout = new GridBagLayout();
		editFrame.setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		JLabel idLabel = new JLabel("id:");
		JLabel nameLabel = new JLabel("name:");
		JLabel descriptionLabel = new JLabel("description:");
		final JLabel idField = new JLabel("autom");
		final JTextField nameField = new JTextField("",20);
		final JTextField descriptionField = new JTextField("",20);
		listForm = new ListOfTransportCompanyForm();
		listForm.setM_EditListOfTtransportConpanyController(m_EditListOfTtransportConpanyController);
		
		listForm.deleteItem = false;
		listForm.deleteList = false;
		listForm.editItem = true;
		listForm.editFrame = editFrame;
		listForm.nameField = nameField;
		listForm.descriptionField = descriptionField;
		
		trComp1 = new TransportCompany();
		listForm.trComp = trComp1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		layout.setConstraints(listForm, c);
		editFrame.add(listForm);
		JButton ok = new JButton("OK");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.weightx = 0.3;
		layout.setConstraints(idLabel, c);
		editFrame.add(idLabel);
		c.gridx = 1;
		c.gridy = 1;
		layout.setConstraints(idField, c);
		editFrame.add(idField);
		c.gridx = 0;
		c.gridy = 2;
		layout.setConstraints(nameLabel, c);
		editFrame.add(nameLabel);
		c.gridx = 1;
		c.gridy = 2;
		layout.setConstraints(nameField, c);
		editFrame.add(nameField);
		c.gridx = 0;
		c.gridy = 3;
		layout.setConstraints(descriptionLabel, c);
		editFrame.add(descriptionLabel);
		c.gridx = 1;
		c.gridy = 3;
		layout.setConstraints(descriptionField, c);
		editFrame.add(descriptionField);
		c.gridx = 1;
		c.gridy = 4;
		layout.setConstraints(ok, c);
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					
					trComp1.setName(nameField.getText());
					trComp1.setDescription(descriptionField.getText());
					m_EditListOfTtransportConpanyController.setNewInformationOfTransportCompany(trComp1);
					editFrame.setVisible(false);
					nameField.setText("");
					descriptionField.setText("");
					JOptionPane.showMessageDialog(null, "Ok");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		editFrame.add(ok);
		editFrame.setSize(500, 500);
		editFrame.setLocation(100, 100);}
		listForm.displayListOfTransportCompanies(m_EditListOfTtransportConpanyController.getM_ListOfTransportCompanies());
		
		editFrame.setVisible(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void editExistingData(){

	}

	public void inputData(){

	}

	public boolean requestConfirmingOfEditing(){
		return false;
	}

}