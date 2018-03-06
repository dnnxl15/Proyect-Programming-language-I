package resourse;

import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import com.gluonhq.charm.glisten.control.AutoCompleteTextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import control.EditInformation;
import control.GetInformation;
import domain.*;
import file.ControlFile;
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
	@FXML private ObservableList<Material> materialData;

	/**
	 * Method initialize
	 * Author: Danny Xie Li
	 * Description: The next method initialize the window fxml.
	 * Created: 1/03/18
	 * Last modification: 03/03/18 by Esteban Coto
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ControlFile control = new ControlFile(); //ControlFile constructor to call functions of that class
		ArrayList<Object> list = new ArrayList<Object>(); //Create a new arraylist to store values
		try 
		{
			list = control.readFile("Material.ser"); //Call and store the arrayList of the file
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] materialName = new String[list.size()];
		for(int position = 0; position < list.size(); position++)
		{
			materialName[position] = ((Material)list.get(position)).getName();
		}
		TextFields.bindAutoCompletion(main_autxt_registerLoan, materialName);
		setVisibleMaterialElement(true);
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
	 * Method to Save a Loan
	 * Author: Esteban Coto Alfaro
	 * Description: The method receive the information for do a loan
	 * Created: 03/03/18
	 * Last modification: 03/03/18
	 * @throws ParseException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public void saveLoan() throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		Alert alert; // Message variable
		Date startDate;
		Date endDate;
		String name = main_txt_registerLoan_studentName.getText().toString();
		String id = main_txt_registerLoan_idStudent.getText().toString();
		String materialName = main_autxt_registerLoan.getText().toString();
		try
		{
			startDate = Date.valueOf(main_date_registerLoan_loanDate.getValue());
			endDate = Date.valueOf(main_date_registerLoan_devolutionDate.getValue());
		}
		catch(Exception e)
		{
			// Null pointer exception, when there is no data in the fields
			alert = new Alert(AlertType.ERROR, COMPLETE_FIELDS);
			alert.showAndWait();
			return;
		}
		if (materialName.equals(QUOTE))
		{
			alert = new Alert(AlertType.ERROR, COMPLETE_FIELDS);
			alert.showAndWait();
			return;
		}
		else
		{
			GetInformation info = new GetInformation();
			Material material = ((Material)info.getMaterialInfo(materialName, "Material.ser"));
			if (material.getQuantityAvailable() == 0)
			{
				alert = new Alert(AlertType.ERROR, MESSAGE_NOT_AVAILABLE_ITEM);
				alert.showAndWait();
				return;
			}
			else
			{
				EditInformation information = new EditInformation();
				information.removeAvailableQuantity(materialName, "Material.ser"); //Call the edit information to remove one avaiable item
				Library library = new Library(); //Library constructor is made
				library.addLoan(name, id, startDate, endDate, materialName);
			}
		}
	}
	
	/**
	 * Method return Material
	 * Author: Danny Xie Li
	 * Description: The next method return the material, get the student info and then call the method return material.
	 * Created: 1/03/18
	 * Last modification: 05/03/18 by Esteban Coto Alfaro
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public void returnMaterial() throws ClassNotFoundException, FileNotFoundException
	{		
		Alert alert; // Message 
		String name = main_txt_registerLoan_studentName.getText().toString(); //Get the name of the student
		String id = main_txt_registerLoan_idStudent.getText().toString(); //the id of the student
		String material = main_lbl_registerLoan_labelName.getText().toString(); //read the name of the material
		if(material.equals("Name")) //validate if there is some material selected
		{
			alert = new Alert(AlertType.ERROR, MESSAGE_ERROR_SELECT_ITEM);
			alert.showAndWait();
		}
		else
		{
			ControlFile file = new ControlFile(); //Create a constructor
			ArrayList<Object> objectList = file.readFile("Loan.ser"); //Charche the loan file to search
			boolean verify = false; //to validate if the loan exists
			for (int position = 0; position < objectList.size(); position++) //search the loan
			{
				if(((Loan)objectList.get(position)).getStudent().getLicense().toString().equals(id.toString()) &&
						((Loan)objectList.get(position)).getMaterial().getName().toString().equals(material.toString())) //if the loan if found
				{
					Date endDate = ((Loan)objectList.get(position)).getEndDate(); //get the end date of the loan
					LocalDate now = LocalDate.now(); //To get the day (Today)
					Date today = Date.valueOf(now); //today day
					if(endDate.before(today)) //verify if the endDate is before
					{
						int day = (int) ((today.getTime() - endDate.getTime()) / 86400000); //to know how many day are between
						alert = new Alert(AlertType.CONFIRMATION, "Su multa es de: $" + day*FINE_PER_DAY); //show the alert
						alert.showAndWait();
						
					}
					objectList.remove(position); //remove the loan from the list
					verify = true;
					break;
				}
			}
			if (verify == false) //if the loan is not found
			{
				alert = new Alert(AlertType.ERROR, "No se encuentra prestamo");
				alert.showAndWait();
			}
			else //if it is found call the method to save the changes
			{
				EditInformation information = new EditInformation();
				information.addAvailableQuantity(material, "Material.ser"); //Call the method to add one to the available quantity
				file.writeArray("Loan.ser", objectList);
			}
			
		}
	}
	
	/**
	 * Method check student
	 * Author: Danny Xie Li
	 * Description: The next method check student if the student exits in the register.
	 * Created: 1/03/18
	 * Last modification: 03/03/18 by Esteban Coto Alfaro
	 * @throws ClassNotFoundException 
	 */
	public void checkStudent() throws ClassNotFoundException
	{
		String name = main_txt_registerLoan_studentName.getText().toString(); //read the namee of the student
		String id = main_txt_registerLoan_idStudent.getText().toString(); //read the id of the student
		boolean condition = true; 
		ControlFile file = new ControlFile();
		ArrayList<Object> objectList = file.readFile("Student.ser"); //charge the arrayList from thee file
		for(int position = 0; position < objectList.size(); position++) //search the student
		{
			if(((Student)objectList.get(position)).getName().toString().equals(name) && ((Student)objectList.get(position)).getLicense().toString().equals(id))
			{	
				condition = false;
			}
		}
		if(condition == false) //if the student is founded
		{
			materialData = FXCollections.observableArrayList();
			ControlFile control = new ControlFile(); //ControlFile constructor to call functions of that class
			ArrayList<Object> materialList = new ArrayList<Object>(); //Create a new arraylist to store material values
			try 
			{
				materialList = control.readFile("Material.ser"); //Call and store the arrayList of the file
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int position = 0; position < materialList.size(); position++)//get the name of each material
			{
				materialData.add(((Material)materialList.get(position)));
			}
			main_col_registerLoan_nameColumn.setCellValueFactory(cellData->new SimpleStringProperty((cellData.getValue()).getName()));
			main_tbt_registerLoan_tableName.setItems(materialData);
			main_tbt_registerLoan_tableName.getSelectionModel().selectedItemProperty().addListener(
		            (observable, oldValue, newValue) -> selectItem((Material) newValue));
			setVisibleMaterialElement(false); //set the visibility 
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