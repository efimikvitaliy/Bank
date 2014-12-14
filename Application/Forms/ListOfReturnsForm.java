package Application.Forms;
import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.glass.events.WindowEvent;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


/**
 * @author Владимир
 * @version 1.0
 * @created 01-дек-2014 23:49:12
 */
public class ListOfReturnsForm extends JDialog{

	public OrderReturnController m_OrderReturnController;
	private JPanel panel;
	private JButton bOk, bCancel;
	
	public ListOfReturnsForm(){
		final ListOfReturnsForm fr = this;
		setLayout(new BorderLayout());
		setSize(300,300);
		setLocation(100, 100);
		setResizable(false);
		panel = new JPanel();
		bOk = new JButton("Next");
		bCancel = new JButton("Cancel");
		setModalityType(Dialog.ModalityType.MODELESS.APPLICATION_MODAL);
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
	
	public void setOrderReturnController(OrderReturnController r) {
		 m_OrderReturnController = r;
	}

	public void displayListOfReturns(ListOfOrders listOfRt){		
		ArrayList<Order> list = listOfRt.getListOfOrder();
		if (list.isEmpty()) {
			JOptionPane.showConfirmDialog(null,
				    "<html>No sended orders", 
				    "Attention",
				    JOptionPane.CANCEL_OPTION);
		}
		else {
			final ListOfReturnsForm fr = this;
			DefaultListModel<Order> listModel = new DefaultListModel<Order>();
			for (Order p : list) {
				listModel.addElement(p);
			}
			final JList<Order> jlist = new JList<Order>(listModel);
			add(jlist);
			bOk.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (jlist.getSelectedIndex() >= 0) {
						Order p = jlist.getSelectedValue();
						m_OrderReturnController.getOrder(String.valueOf(p.getId()));
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

	public void selectProduct(){

	}

}