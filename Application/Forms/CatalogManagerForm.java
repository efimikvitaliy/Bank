package Application.Forms;

import java.awt.Dialog.ModalExclusionType;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Application.Controllers.CatalogController;
import Application.Controllers.CreateOrderController;
import Application.Controllers.EditOrderController;

public class CatalogManagerForm
{
	private JFrame jf;
	private JButton jbCrCtlg;
	private JButton jb2;
	private JButton jb3;
	CatalogController contr = new CatalogController();
	
	public CatalogManagerForm()
	{
		
		JLabel lable = new JLabel("<html><font size=\"5\" color=\"red\" face=\"Arial\">Catalog Manager Actions:</font>");
		jf = new JFrame("Catalog Manager");
		jf.setSize(300,300);
		jf.setLocation(100, 100);
		jf.setResizable(false);
		jf.setFocusable(true);
		jf.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		jf.add(lable);
		GridLayout gbl = new GridLayout(4,1);
		jf.setLayout(gbl);
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		jbCrCtlg = new JButton("Create catalog");
		jf.add(jbCrCtlg);
		
		jb2 = new JButton("Edit catalog");
		jf.add(jb2);
		
		jb3 = new JButton("Publish catalog");
		jf.add(jb3);
		
		jbCrCtlg.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				jf.setVisible(false);
				contr.startRoutine();
				jf.setVisible(true);
			}
		});
		jb2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String[] operation = {"create", "edit or delete" };
				int response = JOptionPane.showOptionDialog(jf, "Choice operation with RECORDS", "Operations",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, operation,
						"edit");
				EditOrderController ed = new EditOrderController();
				switch(response)
				{
				case 0:
					contr.startCreateRecordRoutine();
					break;
				case 1:
					contr.startEditRecordRoutine();
					break;
				}
			}
		});
		jb3.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				jf.setVisible(false);
				contr.publishCatalogRoutine();
				jf.setVisible(true);
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
