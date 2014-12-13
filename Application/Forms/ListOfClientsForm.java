package Application.Forms;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Application.Controllers.CreateOrderController;
import BusinessService.Entities.Client;
import BusinessService.Entities.ListOfClients;

public class ListOfClientsForm
{
	private CreateOrderController m_CreateOrderController;
	private JButton jb1;
	private JButton jb2;
	private int index = -1;
	private Client client;
	private JFrame jf;
	private JDialog jdl1;
	private JList<String> jlist;
	private JScrollPane jsp1;
	private String[] s;
	private ListOfClients listOfClient;

	public ListOfClientsForm()
	{
		jf = new JFrame();
		jdl1 = new JDialog(jf, "Choice client", true);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
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
		
		jb1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(index != -1)
				{
					try
					{
						String str = listOfClient.get(index).getId();
						client = m_CreateOrderController.getClient(str);
						if(m_CreateOrderController.isClientHasOrder(Integer.valueOf(client.getId())))
						{
							JOptionPane.showMessageDialog(jf, "This client has order");	
							return;
						}
						m_CreateOrderController.setM_Client(client);
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
		jlist.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				index = jlist.getSelectedIndex();
			}
		});
	}
	public void setVisible(boolean b)
	{
		try
		{
			listOfClient= m_CreateOrderController.getListOfClients();
			s = listOfClient.getElementsInStringArray();
			DefaultListModel<String> model = new DefaultListModel<>();
			for(String str: s)
			{
				model.addElement(str);
			}
			jlist.setModel(model);
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
			return;
		}
		jdl1.setVisible(b);
	}
	public CreateOrderController getM_CreateOrderController()
	{
		return m_CreateOrderController;
	}
	public void setM_CreateOrderController(CreateOrderController m_CreateOrderController)
	{
		this.m_CreateOrderController = m_CreateOrderController;
	}
}
