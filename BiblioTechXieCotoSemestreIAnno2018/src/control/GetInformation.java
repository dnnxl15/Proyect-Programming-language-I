package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import domain.Administrator;
import domain.Material;
import domain.Person;
import domain.Student;
import file.ControlFile;
import file.Reader;

public class GetInformation 
{
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Get an administrator object by receiving username and password
	 * Last modification: 03/06/2018
	 * Modificated by: Danny Xie Li
	 */
	public Administrator getAdmiInfo(String pUsername, String pPassword) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Administrator> admiList = new ArrayList<Administrator>(); //Would store an arayList with all the saved objects
		Reader reader = new Reader(); //constructor to call readAdministrator function
		Administrator admi; //Administrator object
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
	 * Last modification: 03/06/2018
	 * Modificated by: Danny Xie Li
	 */
	public Object getStudentInfo(String pName, String pLicense) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Object> objectList = new ArrayList<Object>(); //Would store an arayList with all the saved objects
		ControlFile reader = new ControlFile(); //constructor to call readStudent function
		Object object; //Student object
		object = null;
		objectList = reader.readFile("Student.ser"); //call the method to read the student file
		for(int position = 0; position < objectList.size(); position++) //Analyze every register form the arrayList
		{
			//Condition when the name and license is equal
			if(((Student) objectList.get(position)).getName().toString().equals(pName) && ((Student) objectList.get(position)).getLicense().toString().equals(pLicense))
				object = objectList.get(position);
		}
		return object;
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Get a Material object by receiving name
	 * Last modification: 02/25/2018 
	 */
	public Object getMaterialInfo(String pName, String pFile) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Object> objectList = new ArrayList<Object>(); //Would store an arayList with all the saved objects
		ControlFile reader = new ControlFile(); //constructor to call readStudent function
		Object object = new Object(); //Material object
		objectList = reader.readFile(pFile); //call the method to read the material file
		for(int position = 0; position < objectList.size(); position++) //Analyze every register form the arrayList
		{
			//Condition when the material name is equal
			if(((Material)objectList.get(position)).getName().toString().equals(pName))
			{
				object = objectList.get(position);
			}
		}
		return object;
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
