package Application.Forms;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Application.Controllers.CreateOrderController;
import Application.Controllers.EditOrderController;
import BusinessService.Entities.Catalog;
import BusinessService.Entities.Order;

public class CatalogForm
{
	private CreateOrderController m_CreateOrderController;
	private EditOrderController m_EditOrderController;
	private JFrame jf;
	private JDialog jdl2;
	private ArrayList<String> array;
	private String[] countProducts;
	private JCheckBox[] jcb;
	private JTextField[] jtf;
	private ArrayList<String> arrayCountsProducts;
	private JButton jb4;
	private JButton jb3;

	public CatalogForm(){}
	public void init()
	{
		jf = new JFrame();
		jdl2 = new JDialog(jf, "Choice products", true);
		jdl2.setLocation(400, 100);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jdl2.setLayout(gbl);
		jdl2.setSize(700, 400);
		array = new ArrayList<>();
		try
		{
			Catalog list = m_CreateOrderController.getCatalog();
			countProducts = list.getElementsInStringArray();
			jcb = new JCheckBox[list.size()];
			jtf = new JTextField[list.size()];
			gbc.weightx = 0.0;
			gbc.weighty = 1.0;
			arrayCountsProducts = m_CreateOrderController.getProductCountOrder(m_CreateOrderController.getM_Client().getId());
			for(int i = 1; i <= list.size(); ++i)
			{
				if(arrayCountsProducts.size() != 0)
				{
					int k = m_EditOrderController.getIndexByProducts(arrayCountsProducts, countProducts[i - 1]);
					if(k != -1)
					{
						String ss = arrayCountsProducts.get(k).substring(arrayCountsProducts.get(k).lastIndexOf(" ")).trim();
						int c = Integer.valueOf(ss) + Integer.valueOf(countProducts[i - 1].substring(countProducts[i - 1].lastIndexOf(" ")).trim());
						jcb[i - 1] = new JCheckBox(countProducts[i - 1].substring(0, countProducts[i - 1].lastIndexOf(" ")) + " " + c);
						array.add(jcb[i - 1].getText());
						jtf[i - 1] = new JTextField("" + ss, 15);
						countProducts[i - 1] = jcb[i - 1].getText();
						jcb[i - 1].setSelected(true);
						jtf[i - 1].setEnabled(true);
						arrayCountsProducts.set(k, arrayCountsProducts.get(k).substring(0, arrayCountsProducts.get(k).lastIndexOf(" ")) + " " + c);
					}
					else
					{
						jcb[i - 1] = new JCheckBox(countProducts[i - 1]);
						jtf[i - 1] = new JTextField(15);
						jtf[i - 1].setEnabled(false);
					}
				}
				else
				{
					jcb[i - 1] = new JCheckBox(countProducts[i - 1]);
					jtf[i - 1] = new JTextField(15);
					jtf[i - 1].setEnabled(false);
				}
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
							int t = m_CreateOrderController.getIndexProducts(cb.getText(), countProducts);
							jtf[t].setEnabled(true);
						}
						else
						{
							array.remove(cb.getText());
							int t = m_CreateOrderController.getIndexProducts(cb.getText(), countProducts);
							jtf[t].setEnabled(false);
						}
					}
				});
				jdl2.add(jcb[i - 1]);
				
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
								jdl2.setVisible(false);
								m_CreateOrderController.showOrderForm();
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
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(jf, "The database is not available");
			return;
		}
	}
	public int isCurrentCount()
	{
		for(int i = 0; i < jtf.length; ++i)
		{
			if(jtf[i].isEnabled())
			{
				int count1 = Integer.valueOf(jtf[i].getText().trim());
				int count2 = Integer.valueOf(countProducts[i].substring(countProducts[i].lastIndexOf(" ")).trim());
				if(count1 > count2 || count1 <= 0)
				{
					return i;
				}
			}
		}
		return -1;
	}
	public String createOrderList()
	{
		int counts[] = new int[array.size()];
		for(int i = 0; i < counts.length; ++i)
		{
			counts[i] = Integer.valueOf(jtf[m_CreateOrderController.getIndexProducts(array.get(i), countProducts)].getText());
		}
		String str = m_CreateOrderController.createOrderList(array, counts);
		return str;
	}
	public void setVisible(boolean b)
	{
		jdl2.setVisible(b);
	}
	public CreateOrderController getM_CreateOrderController()
	{
		return m_CreateOrderController;
	}
	public ArrayList<String> getArrayCountsProducts()
	{
		return arrayCountsProducts;
	}
	public void setArrayCountsProducts(ArrayList<String> arrayCountsProducts)
	{
		this.arrayCountsProducts = arrayCountsProducts;
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
	public ArrayList<String> getArray()
	{
		return array;
	}
	public void setArray(ArrayList<String> array)
	{
		this.array = array;
	}
	public String[] getCountProducts()
	{
		return countProducts;
	}
	public void setCountProducts(String[] countProducts)
	{
		this.countProducts = countProducts;
	}
}
