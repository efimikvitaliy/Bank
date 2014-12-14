package Application.Forms;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


/**
 * @author Владимир
 * @version 1.0
 * @created 01-дек-2014 23:49:07
 */
public class ListOfCatalogRecordsForm extends JFrame{

	public CatalogController m_CatalogController;
	private JPanel panel;
	private JButton bOk, bCancel;
	
	public ListOfCatalogRecordsForm(){
		final ListOfCatalogRecordsForm fr = this;
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

	/**
	 * 
	 * @param catalog
	 */
	public void displayRecords(Catalog catalog){
		m_CatalogController = new CatalogController();
		ArrayList<CatalogRecord> list = catalog.getCatalogRecords();
		if (list.isEmpty()) {
			JOptionPane.showConfirmDialog(null,
				    "<html>No catalog records or Catalog didn't created", 
				    "Attention",
				    JOptionPane.CANCEL_OPTION);
		}
		else {
			final ListOfCatalogRecordsForm fr = this;
			DefaultListModel<CatalogRecord> listModel = new DefaultListModel<CatalogRecord>();
			for (CatalogRecord p : list) {
				listModel.addElement(p);
			}
			final JList<CatalogRecord> jlist = new JList<CatalogRecord>(listModel);
			add(jlist);
			bOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (jlist.getSelectedIndex() >= 0) {
						CatalogRecord p = jlist.getSelectedValue();
						m_CatalogController.getCatalogRecord(p.getId());
						fr.setVisible(false); //you can't see me!
						fr.dispose();
					}
					else {
						JOptionPane.showConfirmDialog(null,
							    "<html>No selected value", 
							    "Attention",
							    JOptionPane.CANCEL_OPTION);
					}					
				}			
			});
			setVisible(true);
		}
	}

	public void selectRecord(){

	}

}