package Application.Controllers;
import BusinessService.Entities.*;
import Application.Forms.*;
import Database.*;


/**
 * @author user
 * @version 1.0
 * @created 01-���-2014 23:48:05
 */
public class LoginController {

	public LoginForm m_LoginForm;
	public User m_User;
	public UserDAO m_UserDAO;

	public LoginController(){
		m_LoginForm = new LoginForm(this);
		m_LoginForm.setVisible(true);
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param type
	 */
	public boolean isManager(int type){
		return false;
	}

	/**
	 * 
	 * @param name
	 * @param password
	 */
	public void login(String name, String password){

	}

	public void showLoginForm(){

	}

}