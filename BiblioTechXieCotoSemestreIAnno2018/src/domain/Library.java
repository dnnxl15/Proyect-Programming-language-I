package domain;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import control.GetInformation;
import control.RecordInformation;
import exception.CodeBookException;
import file.Writer;
import library.IConstant;

public class Library implements IConstant
{
	private ArrayList<Material> materialList;
	private ArrayList<Loan> loanList;
	private ArrayList<Person> studentList;
	private ArrayList<Person> administratorList = new ArrayList<Person>();
	
	public Library()
	{
		materialList = (ArrayList<Material>) DEFAULT_VALUE_OBJECT;
		loanList = (ArrayList<Loan>) DEFAULT_VALUE_OBJECT;
		studentList = (ArrayList<Person>) DEFAULT_VALUE_OBJECT;
		administratorList = (ArrayList<Person>) DEFAULT_VALUE_OBJECT;
	}
	
	public Library(ArrayList<Material> pMaterialList, ArrayList<Loan> pLoanList, ArrayList<Person> pStudentList, ArrayList<Person> pAdmiList)
	{
		this.materialList = pMaterialList;
		this.loanList = pLoanList;
		this.studentList = pStudentList;
		this.administratorList = pAdmiList;
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create a Student object
	 * Last modification: 02/24/2018 
	 */
	public void addStudent(String pName, String pSureName, String pIdentification, String pAddress, String pCarrer, String pLicense) throws FileNotFoundException, ClassNotFoundException
	{
		RecordInformation info = new RecordInformation();
		Student student = new Student(pName, pSureName, pIdentification, pAddress, pCarrer, pLicense);
		info.addPerson(student, true);

	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create an Administrator Object
	 * Last modification: 02/24/2018 
	 */
	public void addAdministrator(String pName, String pSureName, String pIdentification, String pAddress, String pUsername, String pPassword) throws FileNotFoundException, ClassNotFoundException
	{
		RecordInformation info = new RecordInformation();
		Administrator administrator = new Administrator(pName, pSureName, pIdentification, pAddress, pUsername, pPassword);
		info.addPerson(administrator, false);
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create an Audiovisual object
	 * Last modification: 02/24/2018 
	 */
	public void addAudiovisual(String pName, int pTotalQuantity, int pQuantityAvailable, Date pIncomingDate, boolean pStatus, String pType, String pCode) throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		RecordInformation info = new RecordInformation();
		Audiovisual audiovisual = new Audiovisual(pName, pTotalQuantity, pQuantityAvailable, pIncomingDate, pStatus, pType, pCode);
		info.addMaterial(audiovisual);
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create a Book object
	 * Last modification: 02/24/2018 
	 */
	public void addBook(String pName, int pTotalQuantity, int pQuantityAvailable, Date pIncomingDate, boolean pStatus, 
			String pType, String pCode, String pAuthor, Date pReleaseDate, int pPageQuantity) throws FileNotFoundException, ClassNotFoundException, ParseException, CodeBookException
	{
		RecordInformation info = new RecordInformation();
		Book book = new Book(pName, pTotalQuantity, pQuantityAvailable, pIncomingDate, pStatus, pType, pCode, pAuthor, pReleaseDate, pPageQuantity);
		info.addMaterial(book);
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create an Loan Object
	 * Last modification: 02/25/2018 
	 */
	public void addLoan(String pName, String pLicense, Date pStartDate, Date pEndDate, String pMaterialName) throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		RecordInformation info = new RecordInformation();
		GetInformation information = new GetInformation(); //Constructor to access all the information
		Student studentObject = (Student) information.getStudentInfo(pName, pLicense); //Get the student object
		Material materialObject = (Material) information.getMaterialInfo(pMaterialName, "Material.ser"); //Get the material object
		Loan loan = new Loan(pStartDate, pEndDate, studentObject, materialObject); //Create a Loan object
		info.addLoan(loan);
	}
	
	
	//GETTERS & SETTERS 
	public ArrayList<Material> getMaterialList() {
		return materialList;
	}
	
	public void setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
	}
	
	public ArrayList<Loan> getLoanList() {
		return loanList;
	}
	
	public void setLoanList(ArrayList<Loan> loanList) {
		this.loanList = loanList;
	}

	public ArrayList<Person> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Person> studentList) {
		this.studentList = studentList;
	}

	public ArrayList<Person> getAdministratorList() {
		return administratorList;
	}

	public void setAdministratorList(ArrayList<Person> administratorList) {
		this.administratorList = administratorList;
	}
}