package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import domain.Administrator;
import domain.Audiovisual;
import domain.Book;
import domain.Library;
import domain.Loan;
import domain.Material;
import domain.Person;
import domain.Student;
import exception.CodeBookException;
import file.ControlFile;

public class RecordInformation
{
	/* 
	 * Created: 03/02/2018
	 * Author: Esteban Coto Alfaro
	 * Description: To save a Person object
	 * Last modification: 03/02/2018 
	 */
	public void addPerson(Person pPerson, boolean pBool) throws ClassNotFoundException
	{
		if (pBool == true)
			saveData("Student.ser", pPerson);
		else
			saveData("Administrator.ser", pPerson);
	}
	
	/* 
	 * Created: 03/02/2018
	 * Author: Esteban Coto Alfaro
	 * Description: To save a Material object
	 * Last modification: 03/02/2018 
	 */
	public void addMaterial(Material pMaterial) throws ClassNotFoundException
	{
		saveData("Material.ser", pMaterial);
	}
	
	/* 
	 * Created: 03/02/2018
	 * Author: Esteban Coto Alfaro
	 * Description: To save a Loan object
	 * Last modification: 03/02/2018 
	 */
	public void addLoan(Loan pLoan) throws ClassNotFoundException, FileNotFoundException
	{
		//EditInformation info = new EditInformation();
		//info.removeAvailableQuantity(pLoan);
		saveData("Loan.ser", pLoan);
	}
	
	/* 
	 * Created: 03/02/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Private saveData function to call the file
	 * Last modification: 03/02/2018 
	 */
	private void saveData(String pFile, Object pObject) throws ClassNotFoundException
	{
		ControlFile controlFile = new ControlFile();
		controlFile.writeFile(pFile, pObject);
	}
}