package resourse;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import domain.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import library.IConstant;

public class ControlLoan implements Initializable, IConstant
{
	@FXML private TextField main_autxt_registerLoan;
	@FXML private JFXButton main_btn_close;
	@FXML private JFXButton main_btn_hide;
	@FXML private JFXTextField main_txt_registerLoan_studentName;
	@FXML private JFXTextField main_txt_registerLoan_idStudent;
	@FXML private JFXButton main_btn_registerLoan_checkStudent;
	@FXML private RadioButton main_rd_registerLoan_materialType;
	@FXML private DatePicker main_date_registerLoan_loanDate;
	@FXML private DatePicker main_date_registerLoan_devolutionDate;
	@FXML private JFXButton main_btn_registerLoan_register;	
	@FXML private Label main_lbl_registerLoan_labelName;
	@FXML private JFXButton main_btn_registerLoan_return;
	@FXML private TableView<Material> main_tbt_registerLoan_tableName;
	@FXML private TableColumn<Material,String> main_col_registerLoan_nameColumn;
	@FXML private ObservableList<Material> materialData; // FALTA CARGAR MATERIAL A DEVOLVER DE UN ESTUDIANTE.

	/**
	 * Method initialize
	 * Author: Danny Xie Li
	 * Description: The next method initialize the window fxml.
	 * Created: 1/03/18
	 * Last modification: 1/03/18
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// FALTA CARGAR MATERIAL A DEVOLVER DE UN ESTUDIANTE en el checkStudent.
		materialData = FXCollections.observableArrayList();
		materialData.add(new Material("Libro",0,0,null,false));
		//FALTA CARGAR LOS POSIBLES NOMBRES Y POR CODIGO DE AUDIOVISUAL, LIBROS
		//Ejemplo
		String[] word = {"Hello", "Hel"};
		TextFields.bindAutoCompletion(main_autxt_registerLoan, word);
		setVisibleMaterialElement(true);
		
		main_col_registerLoan_nameColumn.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		main_tbt_registerLoan_tableName.setItems(materialData);
		main_tbt_registerLoan_tableName.getSelectionModel().selectedItemProperty().addListener(
	            (observable, oldValue, newValue) -> selectItem((Material) newValue));
	}
	
	/**
	 * Method selectItem
	 * Author: Danny Xie Li
	 * Description: The next method show the item selected in the table to the label.
	 * Created: 1/03/18
	 * Last modification: 1/03/18
	 */
	public void selectItem(Material pValue)
	{
		main_lbl_registerLoan_labelName.setText(pValue.getName());
	}
	
	/**
	 * Method return Material
	 * Author: Danny Xie Li
	 * Description: The next method return the material, get the student info and then call the method return material.
	 * Created: 1/03/18
	 * Last modification: 1/03/18
	 */
	public void returnMaterial()
	{		
		Alert alert; // Message 
		String name = main_txt_registerLoan_studentName.getText().toString();
		String id = main_txt_registerLoan_idStudent.getText().toString();
		String material = main_lbl_registerLoan_labelName.getText().toString();
		if(material.equals("Name"))
		{
			alert = new Alert(AlertType.ERROR, MESSAGE_ERROR_SELECT_ITEM);
			alert.showAndWait();
		}
		else
		{
			//FALTA DEVOLVER EL MATERIAL.
		}
	}
	
	/**
	 * Method check student
	 * Author: Danny Xie Li
	 * Description: The next method check student if the student exits in the register.
	 * Created: 1/03/18
	 * Last modification: 1/03/18
	 */
	public void checkStudent()
	{
		String name = main_txt_registerLoan_studentName.getText().toString();
		String id = main_txt_registerLoan_idStudent.getText().toString();
		// FALTA COMPROBAR SI EL ESTUDIANTE EXISTE
		boolean condicion = true;
		if(condicion)
		{
			setVisibleMaterialElement(false);
		}
		else
		{
			setVisibleMaterialElement(true);
		}
	}
	
	/**
	 * Method setVisibleMaterialElement
	 * Author: Danny Xie Li
	 * Description: The next method set visible to the elements.
	 * Created: 1/03/18
	 * Last modification: 1/03/18
	 */
	public void setVisibleMaterialElement(boolean pValue)
	{
		main_rd_registerLoan_materialType.setDisable(pValue); 
		main_autxt_registerLoan.setDisable(pValue);
		main_date_registerLoan_loanDate.setDisable(pValue);
		main_date_registerLoan_devolutionDate.setDisable(pValue);
		main_btn_registerLoan_register.setDisable(pValue);
		main_btn_registerLoan_return.setDisable(pValue);
	}
	
	/**
	 * Method close button
	 * Author: Danny Xie Li
	 * Description: The next method close the window.
	 * Created: 27/11/17
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
	 * Created: 27/11/17
	 * Last modification: 29/11/17
	 */
	public void hideAction()
	{
		Stage stage = (Stage) main_btn_hide.getScene().getWindow();
		stage.setIconified(true);
	}
}