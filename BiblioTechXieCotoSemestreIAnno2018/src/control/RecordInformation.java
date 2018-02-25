package control;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import domain.Administrator;
import domain.Audiovisual;
import domain.Book;
import domain.Student;
import file.FileWriter;

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
		FileWriter writeFile = new FileWriter();
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
		FileWriter writeFile = new FileWriter();
		Administrator administrator = new Administrator(pName, pSureName, pIdentification, pAddress, pUsername, pPassword);
		//writeFile.saveAdministrator(administrator);
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
		FileWriter writeFile = new FileWriter();
		Audiovisual audiovisual = new Audiovisual(pName, pTotalQuantity, pQuantityAvailable, incomingDate, pStatus, pType, pCode);
		writeFile.saveAudiovisualMaterial(audiovisual);
		//saveAudiovisualMaterial(audiovisual);
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
		Date incomingDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(pIncomingDate);
		Date releaseDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(pReleaseDate);
		FileWriter writeFile = new FileWriter();
		Book book = new Book(pName, pTotalQuantity, pQuantityAvailable, incomingDate, pStatus, pType, pCode, pAuthor, releaseDate, pPageQuantity);
		writeFile.saveBookMaterial(book);
		//saveBookMaterial(book);
	}
}
