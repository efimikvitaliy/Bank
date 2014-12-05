package Application.Forms;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Application.Controllers.LoginController;

public class LoginForm {
	private LoginController m_LoginController;
	private JFrame jf;
	private JButton jb1;
	private JButton jb2;
	private JLabel jl1;
	private JLabel jl2;
	private JTextField jtf1;
	private JTextField jtf2;

	public LoginForm() {
		jf = new JFrame("Login");
		jf.setSize(600, 600);
		jf.setLocation(100, 100);
		jf.setResizable(false);
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		jf.setLayout(gbl);
		jf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		jl1 = new JLabel("Login: ");
		gbc.insets = new Insets(0, 0, 50, 0);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(jl1, gbc);
		jf.add(jl1);

		jtf1 = new JTextField("", 20);
		gbc.insets = new Insets(0, 50, 50, 0);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbl.setConstraints(jtf1, gbc);
		jf.add(jtf1);

		jl2 = new JLabel("Password: ");
		gbc.insets = new Insets(0, 0, 50, 0);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(jl2, gbc);
		jf.add(jl2);

		jtf2 = new JTextField("", 20);
		gbc.insets = new Insets(0, 50, 50, 0);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(jtf2, gbc);
		jf.add(jtf2);

		jb1 = new JButton("OK");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbl.setConstraints(jb1, gbc);
		jf.add(jb1);

		jb2 = new JButton("Exit");
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbl.setConstraints(jb2, gbc);
		jf.add(jb2);

		jb1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (jtf1.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(jf, "Entered your name");
				} else if (jtf2.getText().trim().length() == 0) {
					JOptionPane.showMessageDialog(jf, "Entered your password");
				} else {
					try {
						m_LoginController = new LoginController();
						m_LoginController.login(jtf1.getText().trim(),

						jtf2.getText().trim());
						boolean b =

						m_LoginController.isManager(m_LoginController.getUser()
								.getType());
						if (b) {
							jf.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(jf, "User not found");
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(jf,
								"DataBase is not available");
					}
				}
			}
		});
		jb2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int res = JOptionPane.showConfirmDialog(jf,
						"Do you want exit?", "Exit",

						JOptionPane.YES_NO_OPTION);
				switch (res) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					break;
				}
			}
		});
		jf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int res = JOptionPane.showConfirmDialog(jf,
						"Do you want exit?", "Exit",

						JOptionPane.YES_NO_OPTION);
				switch (res) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					break;
				}
			}
		});
	}

	public void setVisible(boolean b) {
		jf.setVisible(b);
	}

	public static void showInterfaceOfCatalogManager() {
		
	}

	public static void showInterfaceOfClientManager() {
		new ClientManagerForm().setVisible(true);
	}

	public static void showInterfaceOfManufactureManager() {
		new ManufactureManagerForm().setVisible(true);
	}

	public static void showInterfaceOfTransportManager() {
		new TransportManagerForm().setVisible(true);
	}
}
