package Application.Controllers;

import java.sql.SQLException;
import javax.swing.SwingUtilities;
import Application.Forms.LoginForm;
import BusinessService.Entities.User;
import Database.UserDAO;

public class LoginController
{
	private User m_User;
	private UserDAO m_UserDAO;
	private LoginForm m_LoginForm;
	
	public LoginController(){}
	public boolean isManager(int type)
	{
		boolean b = false;
		switch(type)
		{
		case 1:
			b = true;
			LoginForm.showInterfaceOfTransportManager();
			break;
		case 2:
			b = true;
			LoginForm.showInterfaceOfManufactureManager();
			break;
		case 3:
			b = true;
			LoginForm.showInterfaceOfClientManager();
			break;
		case 4:
			b = true;
			LoginForm.showInterfaceOfCatalogManager();
			break;
		}
		return b;
	}
	public void login(String name, String password) throws SQLException
	{
		m_User = User.create(name, password);
		m_UserDAO = new UserDAO();
		int type = m_UserDAO.getTypeOfUserWithThisLoginAndPassword(m_User);
		m_User.setType(type);
	}
	public void showLoginForm()
	{
		m_LoginForm = new LoginForm();
		m_LoginForm.setVisible(true);
	}
	public void setUser(User u)
	{
		m_User = u;
	}
	public User getUser()
	{
		return m_User;
	}
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				(new LoginController()).showLoginForm();
			}
		});
	}
}
