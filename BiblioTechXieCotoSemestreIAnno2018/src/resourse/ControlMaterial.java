package resourse;

import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import domain.Material;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.util.Callback;
import library.*;

public class ControlMaterial implements IConstant, IFunction
{
	@FXML private JFXButton main_btn_registerMaterial_audioType;
	@FXML private JFXButton main_btn_registerMaterial_registerAudio;
	@FXML private JFXButton main_btn_registerMaterial_registerBook;

	@FXML private JFXButton main_btn_signUp_close;
	@FXML private JFXButton main_btn_signUp_hide;

	@FXML private JFXTextField main_txt_registerMaterial_nameMaterial;
	@FXML private JFXTextField main_txt_registerMaterial_nameAudio;
	@FXML private JFXTextField main_txt_registerMaterial_codeAudio;
	@FXML private JFXTextField main_txt_registerMaterial_codeBook;
	@FXML private JFXTextField main_txt_registerMaterial_nameAuthorBook;
	
	@FXML private RadioButton main_rd_registerMaterial_Audiovisual;
	
	@FXML private JFXComboBox main_cmb_registerMaterial_quantityMaterial;
	@FXML private JFXComboBox main_cmb_registerMaterial_audioType;
	@FXML private JFXComboBox main_cmb_registerMaterial_typeBook;
	@FXML private JFXComboBox main_cmb_registerMaterial_pageQuantityBook;

	@FXML private JFXDatePicker main_date_registerMaterial_incomingDateMaterial;
	@FXML private JFXDatePicker main_date_registerMaterial_releaseDateBook;
	
	@FXML private ObservableList<String> listElement; // The type audiovisual register
	@FXML private ObservableList<Material> materialData; // The material data register
	
	@FXML private TableView<Material> main_table_registerMaterial;
	@FXML private TableColumn<Material,String> main_col_registerMaterial_Name;
	@FXML private TableColumn<Material,Number> main_col_registerMaterial_Quantity;
	@FXML private TableColumn<Material,String> main_col_registerMaterial_IncomingDate;
	
	/**
	 * Method initialize
	 * Author: Danny Xie Li
	 * Description: The next method initialize the .fxml ControlMaterial.
	 * Created: 27/02/18
	 * Last modification: 27/02/18
	 */
	@FXML public void initialize() 
	{
		materialData = FXCollections.observableArrayList();
		// Initialize the variable listElement
		listElement = FXCollections.observableArrayList();
		setVisibleBook(false); // Set false visible to the book elements
		main_rd_registerMaterial_Audiovisual.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent arg0)
	        {
	        	if(main_rd_registerMaterial_Audiovisual.isSelected())
	        	{
	        		main_rd_registerMaterial_Audiovisual.setText(BOOK);
	        		setVisibleAudio(false);
	        		setVisibleBook(true);
	        	}
	        	else
	        	{
	        		main_rd_registerMaterial_Audiovisual.setText(AUDIOVISUAL);
	        		setVisibleAudio(true);
	        		setVisibleBook(false);
	        	}
	        }
        });
		// ComboBox add elements
		main_cmb_registerMaterial_quantityMaterial.getItems().addAll(IFunction.getValue(ONE_HUNDRED));
		main_cmb_registerMaterial_pageQuantityBook.getItems().addAll(IFunction.getValue(ONE_THOUSAND));
		main_cmb_registerMaterial_typeBook.getItems().removeAll(BOOK_VALUES);
		main_cmb_registerMaterial_typeBook.getItems().addAll(BOOK_VALUES);
		main_cmb_registerMaterial_audioType.getItems().removeAll(listElement);
		main_cmb_registerMaterial_audioType.getItems().addAll(listElement);
		// Column values and the elements
		main_col_registerMaterial_Name.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getName()));
		main_col_registerMaterial_Quantity.setCellValueFactory(cellData->new SimpleIntegerProperty(cellData.getValue().getTotalQuantity()));
		main_col_registerMaterial_IncomingDate.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getIncomingDate().toLocalDate().toString()));
		main_table_registerMaterial.setItems(materialData);
	}
	
	/**
	 * Method registerBook
	 * Author: Danny Xie Li
	 * Description: The next method register a book to the register.
	 * Created: 27/02/18
	 * Last modification: 27/02/18
	 */
	public void registerBook()
	{
		Alert alert; // Message variable
		// Variables of the book
		String codeBook = main_txt_registerMaterial_codeBook.getText().toString(); 
		String authorBook = main_txt_registerMaterial_nameAuthorBook.getText().toString();
		String nameMaterial = main_txt_registerMaterial_nameMaterial.getText().toString();
		int quantity;
		Date incomingDate;
		String typeBook;
		Date releaseDate;
		int pageQuantity;
		try
		{
			// Get the data from the textfields
			quantity = Integer.parseInt(main_cmb_registerMaterial_quantityMaterial.getSelectionModel().getSelectedItem().toString());
			incomingDate = Date.valueOf(main_date_registerMaterial_incomingDateMaterial.getValue());
			typeBook = main_cmb_registerMaterial_typeBook.getSelectionModel().getSelectedItem().toString();
			releaseDate = Date.valueOf(main_date_registerMaterial_releaseDateBook.getValue());
			pageQuantity = Integer.parseInt(main_cmb_registerMaterial_pageQuantityBook.getSelectionModel().getSelectedItem().toString());
		}
		catch(NullPointerException e)
		{
			// Null pointer exception, when there is no data in the fields
			alert = new Alert(AlertType.ERROR, COMPLETE_FIELDS);
			alert.showAndWait();
			return;
		}
		if(codeBook.equals(QUOTE) || authorBook.equals(QUOTE) || nameMaterial.equals(QUOTE))
		{
			// If the text are empty.
			alert = new Alert(AlertType.ERROR, COMPLETE_FIELDS);
			alert.showAndWait();
			return;
		}
		// FALTA CREAR AUDIOVISUAL, GUARDARLO EN EL ARCHIVO Y EN LIBRARY
		alert = new Alert(AlertType.INFORMATION, MESSAGE_SUCCESS);
		alert.showAndWait();
		cleanTextField();
		//Example
		// FALTAR CARGAR TODOS LOS MATERIALES EN UNA LISTA
		Material newMaterial = new Material(nameMaterial, quantity, quantity, incomingDate, true);
		materialData.add(newMaterial);
		main_table_registerMaterial.setItems(materialData);
	}
	
	/**
	 * Method registerAudiovisual
	 * Author: Danny Xie Li
	 * Description: The next method register an audiovisual material to the register.
	 * Created: 27/02/18
	 * Last modification: 27/02/18
	 */
	public void registerAudiovisual()
	{
		Alert alert; // Message 
		// Audiovisual attributes 
		String nameMaterial = main_txt_registerMaterial_nameMaterial.getText().toString(); 
		String code = main_txt_registerMaterial_codeAudio.getText().toString();
		int quantity;
		Date incomingDate;
		String typeAudio;
		try
		{
			//Get the data from the userinterface
			quantity = Integer.parseInt(main_cmb_registerMaterial_quantityMaterial.getSelectionModel().getSelectedItem().toString());
			incomingDate = Date.valueOf(main_date_registerMaterial_incomingDateMaterial.getValue());
			typeAudio = main_cmb_registerMaterial_audioType.getSelectionModel().getSelectedItem().toString();
		}
		catch(NullPointerException e)
		{ 
			// When the textfield are empty or less of data 
			alert = new Alert(AlertType.ERROR, COMPLETE_FIELDS);
			alert.showAndWait();
			return;
		}
		if(nameMaterial.equals("") || code.equals(""))
		{
			// If the textfields have empty spaces, throw a error, saying that it must complete the fields.
			alert = new Alert(AlertType.ERROR, COMPLETE_FIELDS);
			alert.showAndWait();
			return;
		}
		// FALTA CREAR AUDIOVISUAL, GUARDARLO EN EL ARCHIVO Y EN LIBRARY
		alert = new Alert(AlertType.INFORMATION, MESSAGE_SUCCESS);
		alert.showAndWait();
		cleanTextField();
		//Example
		// FALTAR CARGAR TODOS LOS MATERIALES EN UNA LISTA
		Material newMaterial = new Material(nameMaterial, quantity, quantity, incomingDate, true);
		materialData.add(newMaterial);
		main_table_registerMaterial.setItems(materialData);
	}
	
	/**
	 * Method cleanTextField
	 * Author: Danny Xie Li
	 * Description: The next method clean all the text fields.
	 * Created: 27/02/18
	 * Last modification: 27/02/18
	 */
	private void cleanTextField()
	{
		main_txt_registerMaterial_nameMaterial.setText(QUOTE);
		main_txt_registerMaterial_nameAudio.setText(QUOTE);
		main_txt_registerMaterial_codeAudio.setText(QUOTE);
		main_txt_registerMaterial_codeBook.setText(QUOTE);
		main_txt_registerMaterial_nameAuthorBook.setText(QUOTE);
	}
	
	/**
	 * Method addTypeAudiovisual
	 * Author: Danny Xie Li
	 * Description: The next method add type audio visual in the combobox.
	 * Created: 27/02/18
	 * Last modification: 27/02/18
	 */
	@FXML public void addTypeAudiovisual(ActionEvent arg0)
	{
		String type = main_txt_registerMaterial_nameAudio.getText().toString();
		listElement.add(type);
		main_cmb_registerMaterial_audioType.getItems().removeAll(listElement);
		main_cmb_registerMaterial_audioType.getItems().addAll(listElement);
	}
	
	/**
	 * Method setVisibleAudio
	 * Author: Danny Xie Li
	 * Description: The next method set the visibility to the audio objects.
	 * Created: 27/02/18
	 * Last modification: 27/02/18
	 */
	private void setVisibleAudio(boolean pValue)
	{	
		main_txt_registerMaterial_nameAudio.setVisible(pValue);
		main_btn_registerMaterial_audioType.setVisible(pValue);
		main_cmb_registerMaterial_audioType.setVisible(pValue);
		main_txt_registerMaterial_codeAudio.setVisible(pValue);
		main_btn_registerMaterial_registerAudio.setVisible(pValue);
	}
	
	/**
	 * Method setVisibleBook
	 * Author: Danny Xie Li
	 * Description: The next method set the visibility to the book objects.
	 * Created: 27/02/18
	 * Last modification: 27/02/18
	 */
	private void setVisibleBook(boolean pValue)
	{	
		main_cmb_registerMaterial_typeBook.setVisible(pValue);
		main_txt_registerMaterial_codeBook.setVisible(pValue);
		main_txt_registerMaterial_nameAuthorBook.setVisible(pValue);
		main_date_registerMaterial_releaseDateBook.setVisible(pValue);
		main_cmb_registerMaterial_pageQuantityBook.setVisible(pValue);
		main_btn_registerMaterial_registerBook.setVisible(pValue);
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
		Stage stage = (Stage) main_btn_signUp_close.getScene().getWindow();
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
		Stage stage = (Stage) main_btn_signUp_hide.getScene().getWindow();
		stage.setIconified(true);
	}
}