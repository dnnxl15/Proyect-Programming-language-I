package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import domain.Loan;
import domain.Material;
import file.ControlFile;
import file.Reader;
import file.Writer;

public class EditInformation 
{
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Remove one Available quantity of the material when a loan is made
	 * Last modification: 02/25/2018 
	 */
	public void removeAvailableQuantity(Loan pLoan) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Object> objectList = new ArrayList<Object>(); //ArrayList would store Material Objects
		ControlFile file = new ControlFile(); //Reader constructor
		objectList = file.readFile("Material"); //Charge the ArrayList with the Material
		for(int position = 0; position < objectList.size(); position++) //Search each position of the list
		{
			//When the name of the material in the Loan Object is equal with the name in the Material Object in the list
			if(pLoan.getMaterial().getName().toString().equals(((Material) objectList.get(position)).getName().toString()))
			{
				//Set the value by discounting one in the Material object
				((Material) objectList.get(position)).setQuantityAvailable(((Material) objectList.get(position)).getQuantityAvailable() - 1);
			}
		}
		file.writeArray("Material.ser", objectList);
	}
	
	/* 
	 * Created: 02/25/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Add one Available quantity of the material when a return is made
	 * Last modification: 02/25/2018 
	 */
	public void addAvailableQuantity(Loan pLoan) throws FileNotFoundException, ClassNotFoundException
	{
		ArrayList<Material> materialList = new ArrayList<Material>(); //ArrayList would store Material Objects
		Reader readFile = new Reader(); //Reader constructor
		materialList = readFile.readMaterial(); //Charge the ArrayList with all the Material objects
		for(int position = 0; position < materialList.size(); position++) //Analyze each position of the list
		{
			//When the name of the material in the Loan Object is equal with the name in the Material Object in the list
			if(pLoan.getMaterial().getName().toString().equals(materialList.get(position).getName().toString()))
			{
				//Set the value by adding one in the Material object
				materialList.get(position).setQuantityAvailable(materialList.get(position).getQuantityAvailable() + 1);
			}
		}
		Writer write = new Writer(); //Writer constructor
		write.saveMaterialList(materialList); //Save updated list
	}
}