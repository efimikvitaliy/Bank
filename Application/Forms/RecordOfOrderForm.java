package Application.Forms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import Application.Controllers.EditOrderController;
import BusinessService.Entities.ListOfOrders;

public class RecordOfOrderForm
{
	private EditOrderController m_EditOrderController;
	private ListOfOrders list;
	private JFrame jf;
	private JDialog jdl4;
	private JList<String> jlist1;
	private JScrollPane jsp3;
	private JButton jb7;
	private JButton jb8;
	private String[] s;
	private int orderIndex = -1;
	private int type = -1;

	public RecordOfOrderForm()
	{
		jf = new JFrame();
		jdl4 = new JDialog(jf, "Choice order", true);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
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
		
		jlist1.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				orderIndex = jlist1.getSelectedIndex();
			}
		});
	}
	public void initListOfOrders()
	{
		try
		{
			list = m_EditOrderController.getListOfOrders();
			s = list.getElementsInStringArray();
			DefaultListModel<String> model = new DefaultListModel<>();
			for(String str: s)
			{
				model.addElement(str);
			}
			jlist1.setModel(model);
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
			return;
		}
		if(type == 1)
		{
			jb7.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(orderIndex != -1)
					{
						try
						{
							String str = String.valueOf((list).get(orderIndex).getId());
							m_EditOrderController.getM_CreateOrderController().setM_Client(m_EditOrderController.getClient(str));
							m_EditOrderController.getM_CreateOrderController().showCatalogForm();
							jdl4.setVisible(false);
						}
						catch(SQLException e1)
						{
							JOptionPane.showMessageDialog(jf, "The database is not available");
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
		}
		else if(type == 2)
		{
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
								m_EditOrderController.deleteOrder(s[orderIndex].substring(s[orderIndex].indexOf("=") + 1, s[orderIndex].indexOf(",")).trim());
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
		}
	}
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public void displayListOfReturns(ListOfOrders list)
	{

	}
	public void selectOrder()
	{

	}
	public void setVisible(boolean b)
	{
		jdl4.setVisible(b);
	}
	public EditOrderController getM_EditOrderController()
	{
		return m_EditOrderController;
	}
	public void setM_EditOrderController(EditOrderController m_EditOrderController)
	{
		this.m_EditOrderController = m_EditOrderController;
	}
}
