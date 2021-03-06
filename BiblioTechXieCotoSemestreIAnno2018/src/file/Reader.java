package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import domain.Administrator;
import domain.Loan;
import domain.Material;
import domain.Student;

public class Reader 
{
	public Reader()
	{
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Read the Student file into an ArrayList<Student>
	 * Last modification: 02/24/2018 
	 */
	public ArrayList<Student> readStudent() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Student> studentList = new ArrayList<Student>(); //the arrayList would store Student objects
		try
		{
			FileInputStream fileIS = new FileInputStream("Student.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			studentList = (ArrayList<Student>) objectIS.readObject(); //The method readObject() take the reader object
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return studentList;
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Read the Administrator file into an ArrayList<Administrator>
	 * Last modification: 02/24/2018 
	 */
	public ArrayList<Administrator> readAdministrator() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Administrator> administratorList = new ArrayList<Administrator>(); //the arrayList would store Administrator objects
		Administrator admi = new Administrator();
		try
		{
			FileInputStream fileIS = new FileInputStream("Administrator.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			admi = (Administrator) objectIS.readObject(); //The method readObject() take the reader object
			administratorList.add(admi);
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return administratorList;
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Read the Material file into an ArrayList<Material>
	 * Last modification: 02/24/2018 
	 */
	public ArrayList<Material> readMaterial() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Material> materialList = new ArrayList<Material>(); //the arraylist would store Material objects
		try
		{
			FileInputStream fileIS = new FileInputStream("Material.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			materialList = (ArrayList<Material>) objectIS.readObject(); //The method readObject() take the reader object
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return materialList;
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Read the Loan file into an ArrayList<Loan>
	 * Last modification: 02/25/2018 
	 */
	public ArrayList<Loan> readLoan() throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Loan> loanList = new ArrayList<Loan>(); //the arraylist would store Loan objects
		try
		{
			FileInputStream fileIS = new FileInputStream("Loan.ser"); //open the file
			ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
			loanList = (ArrayList<Loan>) objectIS.readObject(); //The method readObject() take the reader object
			objectIS.close(); 
			fileIS.close();
		}catch(FileNotFoundException e){
		  e.printStackTrace();
		}catch(IOException e){
		  e.printStackTrace();
		}
		return loanList;
	}
}