package resourse;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControlLogin
{
	@FXML private JFXButton main_btn_signUp_signUp;
	@FXML private JFXButton main_btn_signUp_hide;
	@FXML private JFXButton main_btn_signUp_close;
	
	@FXML private JFXTextField main_txt_signUp_username;
	@FXML private JFXPasswordField main_txt_signUp_password;
	
	@FXML private JFXTextField main_txt_signIn_name;
	@FXML private JFXTextField main_txt_signIn_lastname;
	@FXML private JFXTextField main_txt_signIn_identification;
	@FXML private JFXTextField main_txt_signIn_address;
	@FXML private JFXTextField main_txt_signIn_username;
	@FXML private JFXPasswordField main_txt_signIn_password;
	@FXML private JFXPasswordField main_txt_signIn_confirmPassword;
	
	/**
	 * Method sign up
	 * Author: Danny Xie Li
	 * Description: The next method sign up to the system.
	 * Last modification: 20/2/18
	 */
	public void signUp()
	{
		String username = main_txt_signUp_username.getText().toString();
		String password = main_txt_signUp_password.getText().toString();
		
		if(username.equals("") || password.equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "Complete all the fields");
			alert.showAndWait();
		}
		// Falta consultar si existe este username sino tirar un mensaje
		System.out.println(username + password);
	}
	
	public void signIn()
	{
		String name = main_txt_signIn_name.getText().toString();
		String lastname = main_txt_signIn_lastname.getText().toString();
		String identification = main_txt_signIn_identification.getText().toString();
		String address = main_txt_signIn_address.getText().toString();
		String username = main_txt_signIn_username.getText().toString();
		String password = main_txt_signIn_password.getText().toString();
		String confirmPassword = main_txt_signIn_confirmPassword.getText().toString();
		
		// Registrar al archivo y al library.
		System.out.println(username + password + lastname + identification + address);

		
		if(!password.equals(confirmPassword))
		{
			Alert alert = new Alert(AlertType.ERROR, "Password don't match");
			alert.showAndWait();
			main_txt_signIn_password.setText("");
			main_txt_signIn_confirmPassword.setText("");
		}
		else if(name.equals("") || lastname.equals("") || identification.equals("") || address.equals("") || username.equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "Complete all the fields");
			alert.showAndWait();
			return;
		}
	}
	
	/**
	 * Method close button
	 * Author: Danny Xie Li
	 * Description: The next method close the window.
	 * Last modification: 29/11/17
	 */
	public void closeAction()
	{
		Stage stage = (Stage) main_btn_signUp_close.getScene().getWindow();
		stage.close();
	}
	
	/**
	 * Method close button
	 * Author: Danny Xie Li
	 * Description: The next method hide the window.
	 * Last modification: 29/11/17
	 */
	public void hideAction()
	{
		Stage stage = (Stage) main_btn_signUp_hide.getScene().getWindow();
		stage.setIconified(true);
	}

}
