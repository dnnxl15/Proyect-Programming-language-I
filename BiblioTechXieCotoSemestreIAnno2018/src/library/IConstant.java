package library;

import java.util.ArrayList;
import java.util.Date;

public interface IConstant
{
	public final static String DEFAULT_VALUE_STUDENT_CARRER = "No carrer";
	
	public final static String DEFAULT_VALUE_STUDENT_ID = "No id";

	public final static String DEFAULT_VALUE_PERSON_NAME = "None name";
	
	public final static String DEFAULT_VALUE_PERSON_SURENAME = "None surename";
	
	public final static String DEFAULT_VALUE_PERSON_IDENTIFICATION = "0";
	
	public final static String DEFAULT_VALUE_PERSON_ADDRESS = "No address";

	public final static String DEFAULT_VALUE_MATERIAL_NAME = "No name";
	
	public final static int DEFAULT_VALUE_MATERIAL_TOTAL_QUANTITY = 0;
	
	public final static int DEFAULT_VALUE_MATERIAL_QUANTITY_AVAILABLE = 0;
	
	public final static Date DEFAULT_VALUE_MATERIAL_DATE = null;
	
	public final static boolean DEFAULT_VALUE_MATERIAL_STATUS = false;
	
	public final static Date DEFAULT_VALUE_START_DAY = null;
	
	public final static Date DEFAULT_VALUE_END_DAY = null;
		
	public final static Object DEFAULT_VALUE_OBJECT = null;

	public final static String DEFAULT_VALUE_BOOK_TYPE = "No type";

	public final static String DEFAULT_VALUE_BOOK_CODE = "No code";

	public final static String DEFAULT_VALUE_BOOK_AUTHOR = "No author";

	public final static Date DEFAULT_VALUE_BOOK_RELEASE_DATE = null;

	public final static int DEFAULT_VALUE_BOOK_PAGE_QUANTITY = 0;

	public final static String DEFAULT_VALUE_AUDIOVISUAL_TYPE = "No type";

	public final static String DEFAULT_VALUE_AUDIOVISUAL_CODE = "No code";

	public final static String DEFAULT_VALUE_ADMINISTRATOR_USERNAME = "No username";

	public final static String DEFAULT_VALUE_ADMINISTRATOR_PASSWORD = "No password";

	public final static String WINDOW_REGISTER_STUDENT = "RegisterStudent.fxml";
	
	public final static String WINDOW_REGISTER_MATERIAL = "RegisterMaterial.fxml";
	
	public final static String WINDOW_MAIN_PRINCIPAL = "MainWindow.fxml";
	
	public final static String WINDOW_LOAN_AND_DEVOLUTION = "RegisterLoan.fxml";
	
	public final static int ONE_HUNDRED = 100;
	
	public final static int ONE_THOUSAND = 1000;
	
	public final static String[] BOOK_VALUES = {"Digital", "Physical"};

	public final static int ISBN_VALUE = 10;
	
	public final static String BOOK = "Book";
	
	public final static String AUDIOVISUAL = "Audiovisual";

	public final static String MESSAGE_FAILED = "Error";
	
	public final static String QUOTE = "";
	
	public final static String COMPLETE_FIELDS = "Complete all the fields";
	
	public final static String MESSAGE_SUCCESS  = "Register with success";

	public final static String MESSAGE_ERROR_SELECT_ITEM = "Please select an item";
	
	public final static String MESSAGE_NOT_AVAILABLE_ITEM = "Material is not available";
	
	public final static int FINE_PER_DAY = 5;
}