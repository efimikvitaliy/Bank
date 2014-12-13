package Application.Forms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Application.Controllers.CreateOrderController;
import Application.Controllers.EditOrderController;
import BusinessService.Entities.Catalog;
import BusinessService.Entities.Client;
import BusinessService.Entities.ListOfClients;
import BusinessService.Entities.ListOfOrders;
import BusinessService.Entities.Order;

public class OrderForm
{
	private CreateOrderController m_CreateOrderController;
	private EditOrderController m_EditOrderController;
	private Client client;
	//public OrderReturnController m_OrderReturnController;
	private JDialog jdl3;
	private JFrame jf;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private JLabel jl5;
	private JButton jb5;
	private JButton jb6;
	private JTextArea jta1;
	private JScrollPane jsp2;
	private int totalPrice = 0;
	private ArrayList<String> array;
	private ArrayList<String> arrayCountsProducts;
	private String s[];
	
	public OrderForm()
	{
		jf = new JFrame();
		jdl3 = new JDialog(jf, "Order", true);
		jdl3.setLocation(400, 100);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jdl3.setSize(500, 500);
		jdl3.setResizable(false);
		jdl3.setLayout(gbl);
		jdl3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jl1 = new JLabel("First Name: ");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbl.setConstraints(jl1, gbc);
		jdl3.add(jl1);
		
		jl2 = new JLabel("Second Name: ");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jl2, gbc);
		jdl3.add(jl2);
		
		jl3 = new JLabel("Email: ");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbl.setConstraints(jl3, gbc);
		jdl3.add(jl3);
		
		jl4 = new JLabel("Address: ");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbl.setConstraints(jl4, gbc);
		jdl3.add(jl4);
		
		jl5 = new JLabel("Products: ");
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbl.setConstraints(jl5, gbc);
		jdl3.add(jl5);
		
		jta1 = new JTextArea();
		jta1.setEditable(false);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridx = 1;
		gbc.gridy = 6;
		jta1.setLineWrap(true);
		jta1.setWrapStyleWord(true);
		jsp2 = new JScrollPane(jta1);
		jsp2.setPreferredSize(new Dimension(400, 50));
		gbl.setConstraints(jsp2, gbc);
		jdl3.add(jsp2);		
		
		jb5 = new JButton("OK");
		gbc.fill = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,0,0,100);
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbl.setConstraints(jb5, gbc);
		jdl3.add(jb5);
		
		jb6 = new JButton("Cancel");
		gbc.fill = GridBagConstraints.CENTER;
    	gbc.gridx = 2;
		gbc.gridy = 7;
		gbl.setConstraints(jb6, gbc);
		jdl3.add(jb6);
		

		
		jb5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					if(m_CreateOrderController.getType() == 1)
					{
						Order order = m_CreateOrderController.createOrder(totalPrice, array, client);
						m_CreateOrderController.saveOrder(order);
					}
					else if(m_CreateOrderController.getType() == 2)
					{
						m_EditOrderController.deleteProducts(client.getId(), arrayCountsProducts);
						Order order = m_CreateOrderController.createOrder(totalPrice, array, client);
						m_EditOrderController.updateOrder(order);
					}
					jdl3.setVisible(false);
				}
				catch(SQLException e1)
				{
					JOptionPane.showMessageDialog(jf, "The database is not available");
				}
			}
		});
		jb6.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdl3.setVisible(false);
			}
		});
	}
	public void init(String st)
	{
		jl1.setText(jl1.getText() + client.getFirstName());
		jl2.setText(jl2.getText() + client.getSecondName());
		jl3.setText(jl3.getText() + client.getEmail());
		jl4.setText(jl4.getText() + client.getAddress());
		jta1.append(st);
	}
	public void confirmMakeOrder()
	{

	}
	public void displayDataAboutOrder(Order order)
	{

	}
	public ArrayList<String> getArrayCountsProducts()
	{
		return arrayCountsProducts;
	}
	public void setArrayCountsProducts(ArrayList<String> arrayCountsProducts)
	{
		this.arrayCountsProducts = arrayCountsProducts;
	}
	public CreateOrderController getM_CreateOrderController()
	{
		return m_CreateOrderController;
	}
	public void setM_CreateOrderController(CreateOrderController m_CreateOrderController)
	{
		this.m_CreateOrderController = m_CreateOrderController;
	}
	public EditOrderController getM_EditOrderController()
	{
		return m_EditOrderController;
	}
	public void setM_EditOrderController(EditOrderController m_EditOrderController)
	{
		this.m_EditOrderController = m_EditOrderController;
	}
	public Client getClient() 
	{
		return client;
	}
	public void setClient(Client client)
	{
		this.client = client;
	}
	public void setArray(ArrayList<String> array)
	{
		this.array = array;
	}
	public void setVisible(boolean b)
	{
		jdl3.setVisible(true);
	}
}
