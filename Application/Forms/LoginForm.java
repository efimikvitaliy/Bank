package Application.Forms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import Entities.*;
import Application.Controllers.*;
import Application.Forms.*;
import Database.*;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:49:14
 */
public class LoginForm  {

	public LoginController m_LoginController;
	JFrame loginForm;
	
	public LoginForm(){
		loginForm = new JFrame("Login");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("Hello from login");
		init();
	}

	public void init(){
		JPanel panel = new JPanel(), loginPanel = new JPanel(), passwordPanel = new JPanel(), buttonPanel = new JPanel();
		JButton loginButton = new JButton(" Login");
		JTextField loginPane = new JTextField();
		JTextField passwordPane = new JTextField();
		panel.setLayout(new GridLayout(0,1,10,10));
		loginPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.weightx = 0.3;
		c.weighty = 0.5;
		c.gridx = 1; 
	    c.gridy = 0; 
		loginPanel.add(new JLabel(""), c); 
		c.weightx = 0.2;
        c.gridx = 2; 
        c.gridy = 0; 
		panel.add(new JLabel());
		loginPanel.add(new JLabel("Login:"), c); 
		c.weightx = 0.8;
		c.gridx = 3; 
        c.gridy = 0; 
		loginPanel.add(loginPane, c);
		c.weightx = 0.3;
		c.gridx = 4; 
        c.gridy = 0; 
        loginPanel.add(new JLabel(""), c); 
        c.weightx = 0.3;
		c.gridx = 1; 
	    c.gridy = 0; 
		loginPanel.add(new JLabel(""), c); 
		c.weightx = 0.2;
        c.gridx = 2; 
        c.gridy = 0; 
		loginPanel.add(new JLabel("Login:"), c); 
		c.weightx = 0.8;
		c.gridx = 3; 
        c.gridy = 0; 
		loginPanel.add(loginPane, c);
		c.weightx = 0.8;
		c.gridx = 4; 
        c.gridy = 0; 
        loginPanel.add(new JLabel(""), c); 
        c.weightx = 0.3;
		c.gridx = 1; 
	    c.gridy = 2; 
		loginPanel.add(new JLabel(""), c); 
		c.weightx = 0.2;
        c.gridx = 2; 
        c.gridy = 2; 
		loginPanel.add(new JLabel("Password:"), c); 
		c.weightx = 0.8;
		c.gridx = 3; 
        c.gridy = 2; 
		loginPanel.add(passwordPane, c);
		c.weightx = 0.3;
		c.gridx = 4; 
        c.gridy = 2; 
        loginPanel.add(new JLabel(""), c); 
        c.weightx = 0.5;
		c.gridx = 1; 
        c.gridy = 3; 
        loginPanel.add(new JLabel(""), c); 
        c.weightx = 0.3;
		c.gridx = 3; 
        c.gridy = 3; 
        loginPanel.add(loginButton, c); 
       
        panel.add(loginPanel);
		panel.add(new JLabel());
		loginForm.add(panel);
		loginForm.setSize(500,500);
		loginForm.setVisible(true);
		System.out.println("Hello from init");
	}
	/*public void finalize() throws Throwable {

	}*/

	/**
	 * 
	 * @param b
	 */
	public void show(boolean b){
		
		
	}

	public void showInterfaceOfCatalogManager(){

	}

	public void showInterfaceOfClientManager(){

	}

	public void showInterfaceOfManufactureManager(){

	}

	public void showInterfaceOfTransportManager(){

	}

}