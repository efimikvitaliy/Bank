package Application.Forms;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Application.Controllers.ListOfManufacturersAndProductsController;

public class ManufactureManagerForm
{
	private JFrame jf;
	private JButton jb1;
	private JButton jb2;
	
	public ManufactureManagerForm()
	{
		jf = new JFrame("ManufactureManager");
		jf.setSize(300,300);
		jf.setLocation(100, 100);
		jf.setResizable(false);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jf.setLayout(gbl);
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jb1 = new JButton("Create list manufacturers and products");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbl.setConstraints(jb1, gbc);
		jf.add(jb1);
		
		jb2 = new JButton("Edit list manufacturers and products");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jb2, gbc);
		jf.add(jb2);
		
		jb1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					ListOfManufacturersAndProductsController contr = new ListOfManufacturersAndProductsController();
					if(!contr.listIsExist())
					{
						int res = JOptionPane.showConfirmDialog(jf, "Do you want create list of manufacturers and products?", "Exit", JOptionPane.YES_NO_OPTION);
						switch(res)
						{
						case JOptionPane.YES_OPTION:
							contr.createList();
							break;
						case JOptionPane.NO_OPTION:
							break;
						}
					}
					else
					{
						JOptionPane.showMessageDialog(jf, "Table is exist");
					}
				}
				catch(SQLException e1)
				{
					JOptionPane.showMessageDialog(jf, "The database is not available");
				}
			}
		});
		jb2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] operation = { "add" , "edit" , "delete" , "delete list" };
				int response = JOptionPane.showOptionDialog(jf, "Choice operation", "Operations",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, operation,
						"add");
				EditListOfManufacturersAndProductsForm l1 = new EditListOfManufacturersAndProductsForm();
				switch(response)
				{
				case 0:
					l1.showDialogAdd();
					break;
				case 1:
					l1.showDialogEdit();
					break;
				case 2:
					l1.showDialogDelete();
					break;
				case 3:
					l1.showDialogDeleteList();
					break;
				}
			}
		});
		jf.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				int res = JOptionPane.showConfirmDialog(jf, "Do you want exit?", "Exit", JOptionPane.YES_NO_OPTION);
				switch(res)
				{
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					break;
				}
			}
		});
	}	
	public void setVisible(boolean b)
	{
		jf.setVisible(b);
	}	
}
