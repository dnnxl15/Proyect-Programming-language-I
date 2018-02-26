package resourse;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.IConstant;

public class ControlMainWindow implements IConstant
{
	@FXML private JFXButton main_btn_principal_registerStudent;
	@FXML private JFXButton main_btn_principal_registerMaterial;
	@FXML private JFXButton main_btn_principal_registerLoan;
	@FXML private JFXButton main_btn_principal_registerDevolution;
	@FXML private JFXButton main_btn_principal_signOut;
	@FXML private JFXButton main_btn_close;
	@FXML private JFXButton main_btn_hide;
	
	/**
	 * Method open window register student
	 * Author: Danny Xie Li
	 * Description: The next method open the register form student.
	 * Last modification: 25/02/18
	 */
	public void openWindowRegisterStudent() throws IOException
	{
         Parent root = FXMLLoader.load(getClass().getResource(WINDOW_REGISTER_STUDENT));
         Stage stage = new Stage();
         stage.setScene(new Scene(root));  
         stage.initStyle(StageStyle.TRANSPARENT);
         stage.show();
	}

	/**
	 * Method open window register material
	 * Author: Danny Xie Li
	 * Description: The next method open the register form material.
	 * Last modification: 25/02/18
	 */
	public void openWindowRegisterMaterial() throws IOException
	{
         Parent root = FXMLLoader.load(getClass().getResource(WINDOW_REGISTER_MATERIAL));
         Stage stage = new Stage();
         stage.setScene(new Scene(root));  
         stage.initStyle(StageStyle.TRANSPARENT);
         stage.show();
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
