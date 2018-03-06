package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import domain.Material;
import domain.Student;
import file.ControlFile;

public class GetInformation 
{

	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Get an student object by receiving name and license
	 * Last modification: 02/25/2018 
	 */
	public Object getStudentInfo(String pName, String pLicense) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Object> objectList = new ArrayList<Object>(); //Would store an arayList with all the saved objects
		ControlFile reader = new ControlFile(); //constructor to call readStudent function
		Object object = new Object(); //Student object
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
}