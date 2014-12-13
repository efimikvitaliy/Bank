package Application.Forms;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Application.Controllers.CreateOrderController;
import Application.Controllers.EditOrderController;

public class ClientManagerForm
{
	private JFrame jf;
	private JButton jb1;
	private JButton jb2;
	private JButton jb3;
	private CreateOrderController contr;
	
	public ClientManagerForm()
	{
		jf = new JFrame("ManagerClients");
		contr = new CreateOrderController();
		jf.setSize(300,300);
		jf.setLocation(100, 100);
		jf.setResizable(false);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jf.setLayout(gbl);
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jb1 = new JButton("Make an order");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbl.setConstraints(jb1, gbc);
		jf.add(jb1);
		
		jb2 = new JButton("Edit order");
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jb2, gbc);
		jf.add(jb2);
		
		jb3 = new JButton("Make Order Return");
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbl.setConstraints(jb3, gbc);
		jf.add(jb3);
		
		jb1.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				contr.setType(1);
				contr.showListOfClientsForm();
			}
		});
		jb2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] operation = { "edit" , "delete" };
				int response = JOptionPane.showOptionDialog(jf, "Choice operation", "Operations",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, operation,
						"edit");
				EditOrderController ed = contr.getM_EditOrderController();
				contr.setType(2);
				switch(response)
				{
				case 0:
					ed.showListOfOrderForm(0);
					break;
				case 1:
					ed.showListOfOrderForm(1);
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
