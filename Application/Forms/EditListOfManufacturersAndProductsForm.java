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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Application.Controllers.EditListOfManufacturersAndProductsController;
import BusinessService.Entities.ListOfManufacturersAndProducts;
import BusinessService.Entities.ManufacturersAndProducts;

public class EditListOfManufacturersAndProductsForm
{
	private EditListOfManufacturersAndProductsController m_EditListOfManufacturersAndProductsController;
	private JFrame jf;
	private JDialog jdl;
	private JDialog jdlc;
	private JTextField jtf1;
	private JTextField jtf2;
	private JTextField jtf3;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel jl3;
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;
	private JButton jb4;
	private JScrollPane jsp1;
	private JList<String> jlist;
	private int index = -1;

	public EditListOfManufacturersAndProductsForm()
	{
		jf = new JFrame();
		m_EditListOfManufacturersAndProductsController = new EditListOfManufacturersAndProductsController();
		jdl = new JDialog(jf, "Add", true);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jdl.setLayout(gbl);
		jdl.setSize(350, 350);
		
		jl1 = new JLabel("Manufacture: ");
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbl.setConstraints(jl1, gbc);
		jdl.add(jl1);
		
		jtf1 = new JTextField(15);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbl.setConstraints(jtf1, gbc);
		jdl.add(jtf1);
		
		jl2 = new JLabel("Product: ");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jl2, gbc);
		jdl.add(jl2);
		
		jtf2 = new JTextField(15);
    	gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(jtf2, gbc);
		jdl.add(jtf2);
		
		jl3 = new JLabel("Count: ");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbl.setConstraints(jl3, gbc);
		jdl.add(jl3);
		
		jtf3 = new JTextField(15);
    	gbc.gridx = 2;
		gbc.gridy = 3;
		gbl.setConstraints(jtf3, gbc);
		jdl.add(jtf3);
		
		jb1 = new JButton("OK");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbl.setConstraints(jb1, gbc);
		jdl.add(jb1);
		
		jb2 = new JButton("Cancel");
    	gbc.gridx = 2;
		gbc.gridy = 4;
		gbl.setConstraints(jb2, gbc);
		jdl.add(jb2);
		
		jdlc = new JDialog(jf, "Choice", true);
		jdlc.setLayout(gbl);
		jdlc.setSize(300, 300);
		
		jlist = new JList<>();
		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jsp1 = new JScrollPane(jlist);
		jsp1.setPreferredSize(new Dimension(200, 200));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbl.setConstraints(jsp1, gbc);
		jdlc.add(jsp1);
		
		jb3 = new JButton("OK");
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jb3, gbc);
		jdlc.add(jb3);
		
		jb4 = new JButton("Cancel");
    	gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(jb4, gbc);
		jdlc.add(jb4);
		
		jlist.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				index = jlist.getSelectedIndex();
			}
		});
    }
	
	public void showDialogAdd()
	{
		jb1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EditListOfManufacturersAndProductsController list = new EditListOfManufacturersAndProductsController();
				if(!jtf1.getText().trim().equals("") && !jtf2.getText().trim().equals("") && !jtf3.getText().trim().equals(""))
				{
					try
					{
						ManufacturersAndProducts l = new ManufacturersAndProducts(-1, jtf1.getText(), jtf2.getText());
						l.setCount(Integer.valueOf(jtf3.getText()));
						list.add(l);
						jdl.setVisible(false);
					}
					catch (SQLException e1)
					{
						JOptionPane.showMessageDialog(jf, "The database is not available");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(jdl, "Fill in the fields");
				}
			}
		});
		jb2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdl.setVisible(false);
			}
		});
		jdl.setVisible(true);
	}
	
	public void showDialogEdit()
	{
		try
		{
			ListOfManufacturersAndProducts list = m_EditListOfManufacturersAndProductsController.getListOfManufacturersAndProducts();
			String[] s = list.getElementsInStringArray();
			DefaultListModel<String> model = new DefaultListModel<>();
			for(String str: s)
			{
				model.addElement(str);
			}
			jlist.setModel(model);
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available or list of manufacturers and products is not exist");
			return;
		}
		jb1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EditListOfManufacturersAndProductsController list = new EditListOfManufacturersAndProductsController();
				if(!jtf1.getText().trim().equals("") && !jtf2.getText().trim().equals("") && !jtf3.getText().trim().equals(""))
				{
					try
					{
						ManufacturersAndProducts l = new ManufacturersAndProducts(index, jtf1.getText(), jtf2.getText());
						l.setCount(Integer.valueOf(jtf3.getText()));
						list.add(l);
						jdl.setVisible(false);
					}
					catch (SQLException e1)
					{
						JOptionPane.showMessageDialog(jf, "The database is not available");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(jdl, "Fill in the fields");
				}
			}
		});
		jb2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdl.setVisible(false);
			}
		});
		jb3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(index != -1)
				{
					ListOfManufacturersAndProducts list = null;
					try
					{
						list = m_EditListOfManufacturersAndProductsController.getListOfManufacturersAndProducts();
						jtf1.setText(list.get(index).getManufacturers());
						jtf2.setText(list.get(index).getProducts());
						jtf3.setText(String.valueOf(list.get(index).getCount()));
						index = list.get(index).getId();
						jdlc.setVisible(false);
						jdl.setVisible(true);
					}
					catch(SQLException e1)
					{
						JOptionPane.showMessageDialog(jf, "The database is not available");
					}
				}
			}
		});
		jb4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdlc.setVisible(false);
			}
		});
		jdlc.setVisible(true);
	}
	
	public void showDialogDelete()
	{
		try
		{
			ListOfManufacturersAndProducts list = m_EditListOfManufacturersAndProductsController.getListOfManufacturersAndProducts();
			String[] s = list.getElementsInStringArray();
			DefaultListModel<String> model = new DefaultListModel<>();
			for(String str: s)
			{
				model.addElement(str);
			}
			jlist.setModel(model);
		}
		catch(SQLException e1)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available or list of manufacturers and products is not exist");
			return;
		}
		jb3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(index != -1)
				{
					ListOfManufacturersAndProducts list = null;
					try
					{
						list = m_EditListOfManufacturersAndProductsController.getListOfManufacturersAndProducts();
						int res = JOptionPane.showConfirmDialog(jf, "Do you want delete this element?", "Delete element", JOptionPane.YES_NO_OPTION);
						switch(res)
						{
						case JOptionPane.YES_OPTION:
							index = list.get(index).getId();
							m_EditListOfManufacturersAndProductsController.deleteManufacturersAndProducts(index);
							break;
						case JOptionPane.NO_OPTION:
							break;
						}
						jdlc.setVisible(false);
					}
					catch(SQLException e1)
					{
						JOptionPane.showMessageDialog(jf, "The database is not available");
					}
				}
			}
		});
		jb4.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jdlc.setVisible(false);
			}
		});
		jdlc.setVisible(true);
	}
	
	public void showDialogDeleteList()
	{
		try
		{
			int res = JOptionPane.showConfirmDialog(jf, "Do you want delete list of manufacturers and products?", "Delete list", JOptionPane.YES_NO_OPTION);
			switch(res)
			{
			case JOptionPane.YES_OPTION:
				m_EditListOfManufacturersAndProductsController.deleteListOfManufacturersAndProducts();
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
		}
	}
}
