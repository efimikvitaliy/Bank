package Application.Forms;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


import Application.Controllers.*;
import Application.Forms.*;
import Database.*;

/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:49:04
 */
public class EditListOfTransportCompaniesForm  {

	public EditListOfTtransportConpanyController m_EditListOfTtransportConpanyController;
	public TransportCompanyForm m_TransportCompanyForm;
	

	JFrame mainFrame;
	JButton AddItem;
	JButton DeleteItem;
	JButton EditItem;
	JButton DeleteList;
	ListOfTransportCompanyForm listForm;
	public EditListOfTransportCompaniesForm(){
		
		mainFrame = new JFrame("Edit List Of Transport Companies");
		GridBagLayout layout = new GridBagLayout();
		mainFrame.setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		
		AddItem = new JButton("Add Item");
		DeleteItem = new JButton("Delete Item");
		EditItem = new JButton("Edit Item");
		DeleteList = new JButton("Delete List");
		
		c.gridx = 1; c.gridy = 1;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.ipadx = 10000;
		c.anchor = GridBagConstraints.NORTHWEST; // установить кнопку в конец окна 
        c.insets = new Insets(10, 10, 10, 10);  // поставить заглушку 
		layout.setConstraints(AddItem, c);
		mainFrame.add(AddItem);
		c.anchor = GridBagConstraints.WEST;
		c.gridy = 2;
		layout.setConstraints(DeleteItem, c);
		mainFrame.add(DeleteItem);
		c.gridy = 3;
		layout.setConstraints(EditItem, c);
		mainFrame.add(EditItem);
		c.anchor = GridBagConstraints.SOUTHWEST;
		c.insets = new Insets(10, 10, 10, 10); 
		c.gridy = 4;
		layout.setConstraints(DeleteList, c);
		m_TransportCompanyForm = new TransportCompanyForm();
		
		mainFrame.add(DeleteList);
		mainFrame.setSize(300, 300);
		mainFrame.setLocation(500, 500);
		mainFrame.setVisible(true);
		
		AddItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m_TransportCompanyForm.displayFormForInput();
				
			}});
		DeleteItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {JFrame deleteFrame = new JFrame("Delete Frame");
				GridBagLayout layout = new GridBagLayout();
				deleteFrame.setLayout(layout);
				GridBagConstraints c = new GridBagConstraints();
				listForm = new ListOfTransportCompanyForm();
				listForm.setM_EditListOfTtransportConpanyController(m_EditListOfTtransportConpanyController);
				listForm.displayListOfTransportCompanies(m_EditListOfTtransportConpanyController.getM_ListOfTransportCompanies());
				listForm.deleteItem = true;
				listForm.deleteList = false;
				listForm.editItem = false;
				listForm.deleteFrame = deleteFrame;
				c.gridx = 0;
				c.gridy = 0;
				c.weightx = 0.3;
				layout.setConstraints(listForm, c);
				deleteFrame.add(listForm);
				deleteFrame.setSize(500, 500);
				deleteFrame.setLocation(100, 100);
				deleteFrame.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		EditItem.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m_TransportCompanyForm.displayFormForEditing();
			}});
		DeleteList.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					m_EditListOfTtransportConpanyController.deleteListOfTransportCompanies();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		
	}

	public EditListOfTtransportConpanyController getM_EditListOfTtransportConpanyController() {
		return m_EditListOfTtransportConpanyController;
	}

	public void setM_EditListOfTtransportConpanyController(
			EditListOfTtransportConpanyController m_EditListOfTtransportConpanyController) {
		m_TransportCompanyForm.m_EditListOfTtransportConpanyController = m_EditListOfTtransportConpanyController;
		this.m_EditListOfTtransportConpanyController = m_EditListOfTtransportConpanyController;
	}

	public void finalize() throws Throwable {

	}

	public void addItem(){

	}

	public void comnfirmDelete(){

	}

	public void confirmDeleting(){

	}

	public void deleteItem(){

	}

	public void displayFormWithDataOfTransportCompanyForEditing(){

	}

	public void displayListOfTransportCompanies(ListOfTransportCompanies list){
		
	}

	public void displayPossibleOperations(){

	}

	public void editItem(){

	}

	public boolean requestConfirmDeleting(){
		return false;
	}

	public void selectTrnsportCompany(){

	}

	public void showDialogToConfirmDelete(){

	}

}