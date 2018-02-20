package resourse;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControlStudent 
{
	@FXML private JFXTextField main_txt_registerStudent_name;
	@FXML private JFXTextField main_txt_registerStudent_lastname;
	@FXML private JFXTextField main_txt_registerStudent_identification;
	@FXML private JFXTextField main_txt_registerStudent_address;
	@FXML private JFXTextField main_txt_registerStudent_carrer;
	@FXML private JFXTextField main_txt_registerStudent_id;
	@FXML private JFXButton main_btn_close;
	@FXML private JFXButton main_btn_hide;
	@FXML private JFXButton main_btn_registerStudent;
	
	public void register()
	{
		String name = main_txt_registerStudent_name.getText().toString();
		String lastName = main_txt_registerStudent_lastname.getText().toString();
		String identification = main_txt_registerStudent_identification.getText().toString();
		String address = main_txt_registerStudent_address.getText().toString();
		String carrer = main_txt_registerStudent_carrer.getText().toString();
		String id = main_txt_registerStudent_id.getText().toString();
		
		// Falta registrar 
		System.out.println(name+lastName+identification+address+carrer+id);
		if(name.equals("") || lastName.equals("") || identification.equals("") || address.equals("") || carrer.equals("") || id.equals(""))
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
		Stage stage = (Stage) main_btn_close.getScene().getWindow();
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
		Stage stage = (Stage) main_btn_hide.getScene().getWindow();
		stage.setIconified(true);
	}

}
