package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import domain.Administrator;
import domain.Material;
import domain.Student;
import file.Reader;

public class GetInformation 
{
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Get an administrator object by receiving username and password
	 * Last modification: 02/25/2018 
	 */
	public Administrator getAdmiInfo(String pUsername, String pPassword) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Administrator> admiList = new ArrayList<Administrator>(); //Would store an arayList with all the saved objects
		Reader reader = new Reader(); //constructor to call readAdministrator function
		Administrator admi = new Administrator(); //Administrator object
		admi = null;
		admiList = reader.readAdministrator(); //call the method to read the administrator file
		for(int position = 0; position < admiList.size(); position++) //Analyze every register form the arrayList
		{
			if(admiList.get(position).getUsername().toString().equals(pUsername) && admiList.get(position).getPassword().toString().equals(pPassword))
				admi = admiList.get(position);
		}
		return admi;
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Get an student object by receiving name and license
	 * Last modification: 02/25/2018 
	 */
	public Student getStudentInfo(String pName, String pLicense) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Student> studentList = new ArrayList<Student>(); //Would store an arayList with all the saved objects
		Reader reader = new Reader(); //constructor to call readStudent function
		Student student = new Student(); //Student object
		student = null;
		studentList = reader.readStudent(); //call the method to read the student file
		for(int position = 0; position < studentList.size(); position++) //Analyze every register form the arrayList
		{
			//Condition when the name and license is equal
			if(studentList.get(position).getName().toString().equals(pName) && studentList.get(position).getLicense().toString().equals(pLicense))
				student = studentList.get(position);
		}
		return student;
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Get a Material object by receiving name
	 * Last modification: 02/25/2018 
	 */
	public Material getMaterialInfo(String pName) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Material> materialList = new ArrayList<Material>(); //Would store an arayList with all the saved objects
		Reader reader = new Reader(); //constructor to call readStudent function
		Material material = new Material(); //Material object
		material = null;
		materialList = reader.readMaterial(); //call the method to read the material file
		for(int position = 0; position < materialList.size(); position++) //Analyze every register form the arrayList
		{
			//Condition when the material name is equal
			if(materialList.get(position).getName().toString().equals(pName))
				material = materialList.get(position);
		}
		return material;
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Return a ArrayList with the name of the available materials
	 * Last modification: 02/25/2018 
	 */
	public ArrayList<String> availableMaterial() throws FileNotFoundException, ClassNotFoundException
	{
		Reader read = new Reader(); //Read file constructor
		ArrayList<Material> materialList = new ArrayList<Material>(); //New ArrayList with the material objects
		materialList = read.readMaterial(); //Read the file and would be stored in materialList
		ArrayList<String> materialAvailable = new ArrayList<String>(); //ArrayList to store all the names of available materials
		for(int position = 0; position < materialList.size(); position++)
		{
			if(materialList.get(position).getQuantityAvailable() > 0) //Contition to know if the material is available
				materialAvailable.add(materialList.get(position).getName().toString()); //The material name is added to the list
		}
		return materialAvailable; //The List is returned
	}
}