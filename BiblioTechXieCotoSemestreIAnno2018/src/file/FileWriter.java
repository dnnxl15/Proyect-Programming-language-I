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

import domain.Administrator;
import domain.Audiovisual;
import domain.Book;
import domain.Material;
import domain.Student;

public class FileWriter 
{
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Save a new Student in a file
	 * Last modification: 02/24/2018 
	 */
	public void saveStudent(Student pStudent) throws FileNotFoundException, ClassNotFoundException
	{
		FileReader readFile = new FileReader(); //FileReader constructor
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
		FileReader readFile = new FileReader(); //FileReader constructor
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
		FileReader readFile = new FileReader(); //FileReader constructor
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
		FileReader readFile = new FileReader(); //FileReader constructor
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
}
