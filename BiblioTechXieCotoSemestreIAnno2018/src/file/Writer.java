package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import control.EditInformation;
import domain.Administrator;
import domain.Audiovisual;
import domain.Book;
import domain.Loan;
import domain.Material;
import domain.Student;

public class Writer 
{
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a new Student in a file
	 * Last modification: 02/24/2018 
	 */
	public void saveStudent(Student pStudent) throws FileNotFoundException, ClassNotFoundException
	{
		Reader readFile = new Reader(); //FileReader constructor
		ArrayList<Student> studentList = new ArrayList<Student>(); //ArrayList with Student Object
		File file = new File("Student.ser"); //this is to verify if the file already exists
		if(file.exists()) //condition to know if the file exists
		{
			studentList =  readFile.readStudent();//do a call to charge the file
		}
		System.out.println(studentList.size());	
		studentList.add(pStudent); //add the new Student object to the ArrayList
		System.out.println(studentList.size());
	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("Student.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//Ithis implements the method writeObject
		    objectE.writeObject(studentList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a new Administrator in a file
	 * Last modification: 02/24/2018 
	 */
	public void saveAdministrator(Administrator pAdministrator) throws FileNotFoundException, ClassNotFoundException
	{
		Reader readFile = new Reader(); //FileReader constructor
		ArrayList<Administrator> administratorList = new ArrayList<Administrator>(); //ArrayList with Administrator Object
		File file = new File("Administrator.ser"); //this is to verify if the file already exists
		if(file.exists()) //condition to know if the file exists
		{
			administratorList =  readFile.readAdministrator();//do a call to charge the file
		}
		System.out.println(administratorList.size());	
		administratorList.add(pAdministrator); //add the new Administrator object to the ArrayList
		System.out.println(administratorList.size());
	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("Administrator.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//Ithis implements the method writeObject
		    objectE.writeObject(administratorList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a new Material by an Audiovisual Object in a file
	 * Last modification: 02/24/2018 
	 */
	public void saveAudiovisualMaterial(Audiovisual pAudiovisual) throws FileNotFoundException, ClassNotFoundException
	{
		Reader readFile = new Reader(); //FileReader constructor
		ArrayList<Material> materialList = new ArrayList<Material>(); //ArrayList with Material Object
		File file = new File("Material.ser"); //this is to verify if the file already exists
		if(file.exists()) //condition to know if the file exists
		{
			materialList = readFile.readMaterial();//do a call to charge the file
		}
		System.out.println(materialList.size());	
		materialList.add(pAudiovisual); //add the new Material -> Audiovisual object to the ArrayList
		System.out.println(materialList.size());
	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("Material.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//this implements the method writeObject
		    objectE.writeObject(materialList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a new Material in a file
	 * Last modification: 02/24/2018 
	 */
	public void saveBookMaterial(Book pBook) throws FileNotFoundException, ClassNotFoundException
	{
		Reader readFile = new Reader(); //FileReader constructor
		ArrayList<Material> materialList = new ArrayList<Material>(); //ArrayList with Material Object
		File file = new File("Material.ser"); //this is to verify if the file already exists
		if(file.exists()) //condition to know if the file exists
		{
			materialList = readFile.readMaterial();//do a call to charge the file
		}
		System.out.println(materialList.size());	
		materialList.add(pBook); //add the new Material -> Book object to the ArrayList
		System.out.println(materialList.size());
	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("Material.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//this implements the method writeObject
		    objectE.writeObject(materialList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a new Loan in a file
	 * Last modification: 02/25/2018 
	 */
	public void saveLoan(Loan pLoan) throws FileNotFoundException, ClassNotFoundException
	{
		Reader readFile = new Reader(); //FileReader constructor
		ArrayList<Loan> loanList = new ArrayList<Loan>(); //ArrayList with Loan Object
		File file = new File("Loan.ser"); //this is to verify if the file already exists
		if(file.exists()) //condition to know if the file exists
		{
			loanList = readFile.readLoan();//do a call to charge the file
		}
		System.out.println(loanList.size());	
		loanList.add(pLoan); //add the new Loan to the ArrayList
		System.out.println(loanList.size());
	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("Loan.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//this implements the method writeObject
		    EditInformation editInfo = new EditInformation();
		    editInfo.removeAvailableQuantity(pLoan);
		    objectE.writeObject(loanList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a the Loan file with the returns
	 * Last modification: 02/25/2018 
	 */
	public void saveReturn(ArrayList<Loan> pLoanList, Loan pLoan) throws FileNotFoundException, ClassNotFoundException
	{
		try
		{
			FileOutputStream fileE = new FileOutputStream("Loan.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//this implements the method writeObject
		    EditInformation editInfo = new EditInformation();
		    editInfo.addAvailableQuantity(pLoan); //Call the method to add 1 to the available quantity 
		    objectE.writeObject(pLoanList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a new Material in a file
	 * Last modification: 02/25/2018 
	 */
	public void saveMaterialList(ArrayList<Material> pMaterialList) throws FileNotFoundException, ClassNotFoundException
	{	    
		try
		{
			FileOutputStream fileE = new FileOutputStream("Material.ser"); //This line is to create the file or use an existing one
		    ObjectOutputStream objectE = new ObjectOutputStream(fileE);//this implements the method writeObject
		    objectE.writeObject(pMaterialList); //Here the object is write on the file
		    objectE.close(); //This line close the file
		    fileE.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
