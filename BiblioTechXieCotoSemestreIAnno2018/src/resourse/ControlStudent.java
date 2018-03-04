package resourse;

import java.io.FileNotFoundException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import domain.Library;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ControlStudent 
{//
	@FXML private JFXTextField main_txt_registerStudent_name;
	@FXML private JFXTextField main_txt_registerStudent_lastname;
	@FXML private JFXTextField main_txt_registerStudent_identification;
	@FXML private JFXTextField main_txt_registerStudent_address;
	@FXML private JFXTextField main_txt_registerStudent_carrer;
	@FXML private JFXTextField main_txt_registerStudent_id;
	@FXML private JFXButton main_btn_close;
	@FXML private JFXButton main_btn_hide;
	@FXML private JFXButton main_btn_registerStudent;
	
	public void register() throws FileNotFoundException, ClassNotFoundException
	{
		String name = main_txt_registerStudent_name.getText().toString();
		String lastName = main_txt_registerStudent_lastname.getText().toString();
		String identification = main_txt_registerStudent_identification.getText().toString();
		String address = main_txt_registerStudent_address.getText().toString();
		String carrer = main_txt_registerStudent_carrer.getText().toString();
		String id = main_txt_registerStudent_id.getText().toString();
		 
		if(name.equals("") || lastName.equals("") || identification.equals("") || address.equals("") || carrer.equals("") || id.equals(""))
		{
			Alert alert = new Alert(AlertType.ERROR, "Complete all the fields");
			alert.showAndWait();
			return;
		}
		else
		{
			String studentID = "";
			if(!(carrer.equals("Mecatronica") || carrer.equals("Electronica") || carrer.equals("Computacion")))
			{
				Alert alert = new Alert(AlertType.ERROR, "Carrer is not valid");
				alert.showAndWait();
			}
			else
			{
				studentID = carrer.substring(0, 1) + id;
				System.out.println(name+lastName+identification+address+carrer+ " " + studentID);
				Library library = new Library(); //The new administrator is added to the ArrayList<Administrator> in the Library class
				library.addStudent(name, lastName, identification, address, carrer, studentID);	
			}
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