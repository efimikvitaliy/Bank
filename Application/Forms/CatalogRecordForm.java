package Application.Forms;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


/**
 * @author Владимир
 * @version 1.0
 * @created 01-дек-2014 23:48:57
 */
public class CatalogRecordForm extends JFrame{

	public CatalogController m_CatalogController;
	private JPanel panel;
	private JButton bOk, bCancel;
	
	public CatalogRecordForm(){
		final CatalogRecordForm fr = this;
		setLayout(new BorderLayout());
		setSize(300,300);
		setLocation(100, 100);
		setResizable(false);
		panel = new JPanel();
		bOk = new JButton("Next");
		bCancel = new JButton("Cancel");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		panel.setLayout(new FlowLayout());
		panel.add(bOk);
		panel.add(bCancel);
		add(panel, BorderLayout.SOUTH);
		
		
		bCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fr.setVisible(false); //you can't see me!
				fr.dispose();
			}			
		});		
	}

	public void finalize() throws Throwable {

	}

	public void confirmAdding(){

	}

	public void confirmDeleting(){

	}

	public void confirmEditing(){

	}

	/**
	 * 
	 * @param product
	 */
	public void displayRecordFormForCreating(final Product product){
		m_CatalogController = new CatalogController();
		final CatalogRecordForm fr = this;
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1));
		JLabel l = new JLabel(product.getName());
		add(l, BorderLayout.NORTH);
		JLabel l1 = new JLabel("Enter info about product");
		final JTextField tf1 = new JTextField("info");
		JLabel l2 = new JLabel("Enter price product");
		final JTextField tf2 = new JTextField("123");
		panel1.add(l1);
		panel1.add(tf1);
		panel1.add(l2);
		panel1.add(tf2);
		add(panel1, BorderLayout.CENTER);
		setVisible(true);
		bOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tf1.getText().equals("")) {
					JOptionPane.showConfirmDialog(null,
						    "Enter product info", 
						    "Attention",
						    JOptionPane.CANCEL_OPTION);
					return;
				}
				if (tf2.getText().equals("")) {
					JOptionPane.showConfirmDialog(null,
						    "Enter product price", 
						    "Attention",
						    JOptionPane.CANCEL_OPTION);
					return;
				}
				try {
					int price = Integer.parseInt(tf2.getText());
					m_CatalogController.addRecordToCatalog(price, tf1.getText(), product);
					fr.setVisible(false); //you can't see me!
					fr.dispose();
				}
				catch (NumberFormatException exc) {
					JOptionPane.showConfirmDialog(null,
						    "Enter correct product price", 
						    "Attention",
						    JOptionPane.CANCEL_OPTION);
					return;
				}
				
			}			
		});	
	}

	/**
	 * 
	 * @param record
	 */
	public void displayRecordFormForDeleting(final CatalogRecord record){
		m_CatalogController = new CatalogController();
		final CatalogRecordForm fr = this;
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1));
		JLabel l = new JLabel(record.getProduct().getProducts());
		add(l, BorderLayout.NORTH);
		JLabel l1 = new JLabel("Info about product");
		final JTextField tf1 = new JTextField(record.getInformation());
		JLabel l2 = new JLabel("Product price");
		final JTextField tf2 = new JTextField(record.getPrice());
		panel1.add(l1);
		panel1.add(tf1);
		panel1.add(l2);
		panel1.add(tf2);
		tf1.setEditable(false);
		tf2.setEditable(false);
		add(panel1, BorderLayout.CENTER);
		setVisible(true);
		bOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				m_CatalogController.deleteCatalogRecord(record);
				fr.setVisible(false); //you can't see me!
				fr.dispose();					
			}			
		});	
	}

	/**
	 * 
	 * @param record
	 */
	public void displayRecordFormForEditing(final CatalogRecord record){
		m_CatalogController = new CatalogController();
		final CatalogRecordForm fr = this;
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1));
		JLabel l = new JLabel(record.getProduct().getProducts());
		add(l, BorderLayout.NORTH);
		JLabel l1 = new JLabel("Info about product");
		final JTextField tf1 = new JTextField(record.getInformation());
		JLabel l2 = new JLabel("Product price");
		System.out.println(record.getPrice());
		final JTextField tf2 = new JTextField(String.valueOf(record.getPrice()));
		panel1.add(l1);
		panel1.add(tf1);
		panel1.add(l2);
		panel1.add(tf2);
		add(panel1, BorderLayout.CENTER);
		setVisible(true);
		bOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if (tf1.getText().equals("")) {
					JOptionPane.showConfirmDialog(null,
						    "Enter product info", 
						    "Attention",
						    JOptionPane.CANCEL_OPTION);
					return;
				}
				if (tf2.getText().equals("")) {
					JOptionPane.showConfirmDialog(null,
						    "Enter product price", 
						    "Attention",
						    JOptionPane.CANCEL_OPTION);
					return;
				}
				try {
					int price = Integer.parseInt(tf2.getText());
					record.setPrice(price);
					record.setInformation(tf1.getText());
					m_CatalogController.updateCatalogRecord(record);
					fr.setVisible(false); //you can't see me!
					fr.dispose();
				}
				catch (NumberFormatException exc) {
					JOptionPane.showConfirmDialog(null,
						    "Enter correct product price", 
						    "Attention",
						    JOptionPane.CANCEL_OPTION);
					return;
				}				
			}			
		});	
	}

}