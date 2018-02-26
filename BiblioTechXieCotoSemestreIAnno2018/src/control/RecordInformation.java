package control;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import domain.Administrator;
import domain.Audiovisual;
import domain.Book;
import domain.Loan;
import domain.Material;
import domain.Student;
import file.Writer;

public class RecordInformation
{
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create a Student object
	 * Last modification: 02/24/2018 
	 */
	public void addStudent(String pName, String pSureName, String pIdentification, String pAddress, String pCarrer, String pLicense) throws FileNotFoundException, ClassNotFoundException
	{
		Writer writeFile = new Writer();
		Student student = new Student(pName, pSureName, pIdentification, pAddress, pCarrer, pLicense);
		writeFile.saveStudent(student);
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create an Administrator Object
	 * Last modification: 02/24/2018 
	 */
	public void addAdministrator(String pName, String pSureName, String pIdentification, String pAddress, String pUsername, String pPassword) throws FileNotFoundException, ClassNotFoundException
	{
		Writer writeFile = new Writer();
		Administrator administrator = new Administrator(pName, pSureName, pIdentification, pAddress, pUsername, pPassword);
		writeFile.saveAdministrator(administrator);
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create an Audiovisual object
	 * Last modification: 02/24/2018 
	 */
	public void addAudiovisual(String pName, int pTotalQuantity, int pQuantityAvailable, String pIncomingDate, boolean pStatus, String pType, int pCode) throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		Date incomingDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(pIncomingDate);
		Writer writeFile = new Writer();
		Audiovisual audiovisual = new Audiovisual(pName, pTotalQuantity, pQuantityAvailable, incomingDate, pStatus, pType, pCode);
		writeFile.saveAudiovisualMaterial(audiovisual);
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create a Book object
	 * Last modification: 02/24/2018 
	 */
	public void addBook(String pName, int pTotalQuantity, int pQuantityAvailable, String pIncomingDate, boolean pStatus, 
			String pType, String pCode, String pAuthor, String pReleaseDate, int pPageQuantity) throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		Date incomingDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(pIncomingDate); //Change from String to Date
		Date releaseDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(pReleaseDate); //Change from String to Date
		Writer writeFile = new Writer();
		Book book = new Book(pName, pTotalQuantity, pQuantityAvailable, incomingDate, pStatus, pType, pCode, pAuthor, releaseDate, pPageQuantity);
		writeFile.saveBookMaterial(book); //Call the saveBookMaterial in a material file
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Create an Loan Object
	 * Last modification: 02/25/2018 
	 */
	public void addLoan(String pUsername, String pPassword, String pName, String pLicense, String pStartDate, String pEndDate, String pMaterialName) throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		Date startDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(pStartDate); //Change from String to Date
		Date endDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(pEndDate); //Change from String to Date
		Writer writeFile = new Writer();
		GetInformation info = new GetInformation(); //Constructor to access all the information
		Administrator admiObject = info.getAdmiInfo(pUsername, pPassword); //Get the administrator object
		Student studentObject = info.getStudentInfo(pName, pLicense); //Get the student object
		Material materialObject = info.getMaterialInfo(pMaterialName); //Get the material object
		Loan loan = new Loan(startDate, endDate, studentObject, admiObject, materialObject); //Create a Loan object
		writeFile.saveLoan(loan); //Save the new Loan object in the file
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Make a return of a material
	 * Last modification: 02/26/2018 
	 */
	public void makeReturn(String pName, String pLicense, String pMaterialName) throws FileNotFoundException, ClassNotFoundException, ParseException
	{
		GetInformation info = new GetInformation(); //Constructor to access all the information
		Student studentObject = info.getStudentInfo(pName, pLicense); //Get the student object
		Material materialObject = info.getMaterialInfo(pMaterialName); //Get the material object
		LoanControl loan = new LoanControl(); //Constructor for the loan control
		boolean boolResult = loan.verifyInformation(studentObject, materialObject); //Verify if the information exists
		if(boolResult == true)
		{
			loan.makeAReturn(studentObject, materialObject); //Call the return method from Loan class
		}
	}
}

