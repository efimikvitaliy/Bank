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
	private CreateOrderController m_CreateOrderController = new CreateOrderController();
	private EditOrderController m_EditOrderController = new EditOrderController();
	private Client client;
	//public OrderReturnController m_OrderReturnController;
	private JDialog jdl1;
	private JDialog jdl2;
	private JDialog jdl3;
	private JDialog jdl4;
	private JFrame jf;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private JLabel jl5;
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;
	private JButton jb4;
	private JButton jb5;
	private JButton jb6;
	private JButton jb7;
	private JButton jb8;
	private JList<String> jlist;
	private JList<String> jlist1;
	private JTextArea jta1;
	private JScrollPane jsp1;
	private JScrollPane jsp2;
	private JScrollPane jsp3;
	private JCheckBox jcb[];
	private JTextField jtf[];
	private int index = -1;
	private int orderIndex = -1;
	private Object obj;
	private int totalPrice = 0;
	private int editOrDelete = -1;
	//private int size = 0;
	private ArrayList<String> array;
	private String s[];
	
	public OrderForm()
	{
		jf = new JFrame();
		m_CreateOrderController = new CreateOrderController();
		m_EditOrderController = new EditOrderController();
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
		
		jdl1 = new JDialog(jf, "Choice client", true);
		jdl1.setLayout(gbl);
		jdl1.setSize(300, 300);
		jdl1.setLocation(400, 100);
		
		jlist = new JList<>();
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jsp1 = new JScrollPane(jlist);
		jsp1.setPreferredSize(new Dimension(250, 190));
		gbc.insets = new Insets(0,0,0,0);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(jsp1, gbc);
		jdl1.add(jsp1);
		
		jb1 = new JButton("OK");
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jb1, gbc);
		jdl1.add(jb1);
		
		jb2 = new JButton("Cancel");
    	gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(jb2, gbc);
		jdl1.add(jb2);
		
		jdl4 = new JDialog(jf, "Choice order", true);
		jdl4.setLayout(gbl);
		jdl4.setSize(300, 300);
		jdl4.setLocation(400, 100);
		
		jlist1 = new JList<>();
		jlist1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jsp3 = new JScrollPane(jlist1);
		jsp3.setPreferredSize(new Dimension(250, 190));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(jsp3, gbc);
		jdl4.add(jsp3);
		
		jb7 = new JButton("OK");
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jb7, gbc);
		jdl4.add(jb7);
		
		jb8 = new JButton("Cancel");
    	gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(jb8, gbc);
		jdl4.add(jb8);
		
		jb1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(index != -1)
				{
					try
					{
						String str = ((ListOfClients) obj).get(index).getId();
						client = m_CreateOrderController.getClient(str);
						jl1.setText(jl1.getText() + client.getFirstName());
						jl2.setText(jl2.getText() + client.getSecondName());
						jl3.setText(jl3.getText() + client.getEmail());
						jl4.setText(jl4.getText() + client.getAddress());
						jdl1.setVisible(false);
						m_CreateOrderController.showCatalogForm();
					}
					catch(SQLException e1)
					{
						JOptionPane.showMessageDialog(jf, "The database is not available");
					}
				}
			}
		});
		jb2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdl1.setVisible(false);
			}
		});
		jb5.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Order order = m_CreateOrderController.createOrder(totalPrice, array, client);
				try
				{
					m_CreateOrderController.saveOrder(order);
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
		jlist.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				index = jlist.getSelectedIndex();
			}
		});
		jlist1.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				orderIndex = jlist1.getSelectedIndex();
			}
		});
	}
	public void confirmMakeOrder()
	{

	}
	public void displayDataAboutOrder(Order order)
	{

	}
	public void showProducts()
	{
		jdl2 = new JDialog(jf, "Choice products", true);
		jdl2.setLocation(400, 100);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jdl2.setLayout(gbl);
		jdl2.setSize(700, 400);
		m_CreateOrderController = new CreateOrderController();
		array = new ArrayList<>();
		try
		{
			Catalog list = m_CreateOrderController.getCatalog();
			s = list.getElementsInStringArray();
			jcb = new JCheckBox[list.size()];
			jtf = new JTextField[list.size()];
			gbc.weightx = 0.0;
			gbc.weighty = 1.0;
			for(int i = 1; i <= list.size(); ++i)
			{
				jcb[i - 1] = new JCheckBox(s[i - 1]);
				gbc.gridx = 1;
				gbc.gridy = i;
				gbl.setConstraints(jcb[i - 1], gbc);
				jcb[i - 1].addItemListener(new ItemListener()
				{
					@Override
					public void itemStateChanged(ItemEvent e)
					{
						JCheckBox cb = (JCheckBox) e.getItem();
						if(cb.isSelected())
						{
							array.add(cb.getText());
							int t = m_CreateOrderController.getIndexProducts(cb.getText(), s);
							jtf[t].setEnabled(true);
						}
						else
						{
							array.remove(cb.getText());
							int t = m_CreateOrderController.getIndexProducts(cb.getText(), s);
							jtf[t].setEnabled(false);
						}
					}
				});
				jdl2.add(jcb[i - 1]);
				
				jtf[i - 1] = new JTextField(15);
				jtf[i - 1].setEnabled(false);
				gbc.gridx = 2;
				gbc.gridy = i;
				gbl.setConstraints(jtf[i - 1], gbc);
				jdl2.add(jtf[i - 1]);
			}
			jb3 = new JButton("OK");
			gbc.gridwidth = 1;
			gbc.gridx = 1;
			gbc.gridy = list.size() + 1;
			gbl.setConstraints(jb3, gbc);
			jdl2.add(jb3);
			
			jb4 = new JButton("Cancel");
	    	gbc.gridx = 2;
			gbc.gridy = list.size() + 1;
			gbl.setConstraints(jb4, gbc);
			jdl2.add(jb4);
			
			jb3.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(array.size() != 0)
					{
						try
						{
							int q = isCurrentCount();
							if(q == -1)
							{
								createOrderList();
								jdl2.setVisible(false);
								jdl3.setVisible(true);
							}
							else
							{
								JOptionPane.showMessageDialog(jdl2, jcb[q].getText() + " decrease the value");
							}
						}
						catch(NumberFormatException e1)
						{
							JOptionPane.showMessageDialog(jdl2, "Not number type in field");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(jdl2, "Entered products");
					}
				}
			});
			jb4.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					jdl2.setVisible(false);
				}
			});
			jdl2.setVisible(true);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
			return;
		}
	}
	public void showClients()
	{
		try
		{
			ListOfClients list = m_CreateOrderController.getListOfClients();
			s = list.getElementsInStringArray();
			DefaultListModel<String> model = new DefaultListModel<>();
			for(String str: s)
			{
				model.addElement(str);
			}
			jlist.setModel(model);
			obj = list;
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
			return;
		}
		jdl1.setVisible(true);
	}
	public void showListOfOrderEdit()
	{
		try
		{
			ListOfOrders list = m_EditOrderController.getListOfOrders();
			s = list.getElementsInStringArray();
			DefaultListModel<String> model = new DefaultListModel<>();
			for(String str: s)
			{
				model.addElement(str);
			}
			jlist1.setModel(model);
			obj = list;
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
			return;
		}
		jb7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				/*if(orderIndex != -1)
				{
					
				}
				catch(SQLException e1)
				{
					JOptionPane.showMessageDialog(jf, "The database is not available");
					return;
				}*/
			}
		});
		jb8.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdl4.setVisible(false);
			}
		});
		jdl4.setVisible(true);
	}
	public void showListOfOrderDelete()
	{
		try
		{
			ListOfOrders list = m_EditOrderController.getListOfOrders();
			s = list.getElementsInStringArray();
			DefaultListModel<String> model = new DefaultListModel<>();
			for(String str: s)
			{
				model.addElement(str);
			}
			jlist1.setModel(model);
			obj = list;
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
			return;
		}
		jb7.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(orderIndex != -1)
				{
					try
					{
						int res = JOptionPane.showConfirmDialog(jf, "Do you want delete this order?", "Exit", JOptionPane.YES_NO_OPTION);
						switch(res)
						{
						case JOptionPane.YES_OPTION:
							m_EditOrderController.deleteOrder(s[orderIndex]);
							break;
						case JOptionPane.NO_OPTION:
							break;
						}
						jdl4.setVisible(false);
					}
					catch(SQLException e1)
					{
						JOptionPane.showMessageDialog(jf, "The database is not available");
						return;
					}
				}
			}
		});
		jb8.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdl4.setVisible(false);
			}
		});
		jdl4.setVisible(true);
	}
	public void createOrderList() throws NumberFormatException
	{
		int counts[] = new int[array.size()];
		for(int i = 0; i < counts.length; ++i)
		{
			counts[i] = Integer.valueOf(jtf[m_CreateOrderController.getIndexProducts(array.get(i), s)].getText());
		}
		String str = m_CreateOrderController.createOrderList(array, counts);
		totalPrice = Integer.valueOf(str.substring(str.lastIndexOf(" ")).trim());
		jta1.append(str);
	}
	public int isCurrentCount()
	{
		for(int i = 0; i < jtf.length; ++i)
		{
			if(jtf[i].isEnabled())
			{
				int count1 = Integer.valueOf(jtf[i].getText().trim());
				int count2 = Integer.valueOf(s[i].substring(s[i].lastIndexOf(" ")).trim());
				if(count1 > count2)
				{
					return i;
				}
			}
		}
		return -1;
	}
}
