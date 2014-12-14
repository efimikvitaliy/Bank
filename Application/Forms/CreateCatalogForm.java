package Application.Forms;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BusinessService.Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;


import Application.Controllers.*;
import Application.Forms.*;
import Database.*;

/**
 * @author Владимир
 * @version 1.0
 * @created 01-дек-2014 23:48:58
 */
public class CreateCatalogForm extends JDialog{

	public CatalogController m_CatalogController;
	JTextField t = new JTextField();
	public CreateCatalogForm(){
		
	}
	
	public CreateCatalogForm(CatalogController cont){
		m_CatalogController = cont;
		final JDialog jf = this;
		jf.setSize(300,300);
		jf.setLocation(300, 100);
		jf.setResizable(false);
		jf.setTitle("Create catalog");
		jf.setModalityType(Dialog.ModalityType.MODELESS.APPLICATION_MODAL);
		JLabel jl = new JLabel("Enter catalog info :");
		GridLayout gbl = new GridLayout(4,1);
		jf.setLayout(gbl);
		JButton bOk = new JButton("OK");
		JButton bCancel = new JButton("Cancel");
		bOk.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				m_CatalogController.createCatalog(t.getText());
				jf.setVisible(false);
				jf.dispose();
			}
		});
		bCancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jf.setVisible(false);
				jf.dispose();
			}
		});
		add(jl);
		add(t);
		add(bOk);
		add(bCancel);		
	}

	public void finalize() throws Throwable {

	}

	public void confirmCreating(){

	}

	public void displayFormForCreatingCatalog(){
		setVisible(true);		
	}
}