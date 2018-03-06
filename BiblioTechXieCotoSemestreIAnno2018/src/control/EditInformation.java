package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import domain.Material;
import file.ControlFile;


public class EditInformation 
{
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Remove one Available quantity of the material when a loan is made
	 * Last modification: 06/03/2018 by Esteban Coto Alfaro
	 */
	public void removeAvailableQuantity(String pMaterialName, String pFile) throws FileNotFoundException, ClassNotFoundException
	{
		ControlFile control = new ControlFile();
		ArrayList<Object> objectList = control.readFile("Material.ser"); //Call the Material file
		for(int position = 0; position < objectList.size(); position++)
		{
			if(((Material)objectList.get(position)).getName().toString().equals(pMaterialName)) //find the material in the list
			{
				((Material)objectList.get(position)).setQuantityAvailable(((Material)objectList.get(position)).getQuantityAvailable()-1); //remove one of the available quantity
				control.writeArray("Material.ser", objectList); //save the updated file
				break;
			}
		}
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Remove one Available quantity of the material when a loan is made
	 * Last modification: 06/03/2018 by Esteban Coto
	 */
	public void addAvailableQuantity(String pMaterialName, String pFile) throws FileNotFoundException, ClassNotFoundException
	{
		ControlFile control = new ControlFile();
		ArrayList<Object> objectList = control.readFile("Material.ser"); //call the material file to charge all the objects
		for(int position = 0; position < objectList.size(); position++)
		{
			if(((Material)objectList.get(position)).getName().toString().equals(pMaterialName))
			{
				((Material)objectList.get(position)).setQuantityAvailable(((Material)objectList.get(position)).getQuantityAvailable()+1); //Add one to the available quantity
				control.writeArray("Material.ser", objectList); //save the changes
				break;
			}
		}
	}
}