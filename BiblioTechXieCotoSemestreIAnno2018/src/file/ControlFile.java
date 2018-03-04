package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import domain.Administrator;
import domain.Material;
import domain.Student;

public class ControlFile 
{
	private File fileName;
	
	public ArrayList<Object> readFile(String pFile) throws ClassNotFoundException
	{
		ArrayList<Object> objectList = new ArrayList<Object>(); //the arrayList would store Administrator objects
		File file = new File(pFile);
		if(file.exists())
		{
			try
			{
				FileInputStream fileIS = new FileInputStream(pFile); //open the file
				ObjectInputStream objectIS = new ObjectInputStream(fileIS); //read the file
				objectList = (ArrayList<Object>) objectIS.readObject(); //The method readObject() take the reader object
				objectIS.close(); 
				fileIS.close();
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return objectList;
	}
	
	public void writeFile(String pFile, Object pObject) throws ClassNotFoundException
	{
		ArrayList<Object> objectList = new ArrayList<Object>(); //ArrayList with Objects
		File file = new File(pFile);
		if(file.exists()) //condition to know if the file exists
		{
			objectList = readFile(pFile);//do a call to charge the file
		}
		objectList.add(pObject); //add the new object to the ArrayList
		try
		{
			FileOutputStream fileOS = new FileOutputStream(pFile); //This line is to create the file or use an existing one
		    ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);//Ithis implements the method writeObject
		    objectOS.writeObject(objectList); //Here the object is write on the file
		    objectOS.close(); //This line close the file
		    fileOS.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
	
	public void writeArray(String pFile, ArrayList<Object> pArrayList) throws ClassNotFoundException
	{
		try
		{
			FileOutputStream fileOS = new FileOutputStream(pFile); //This line is to create the file or use an existing one
		    ObjectOutputStream objectOS = new ObjectOutputStream(fileOS);//Ithis implements the method writeObject
		    objectOS.writeObject(pArrayList); //Here the object is write on the file
		    objectOS.close(); //This line close the file
		    fileOS.close();
		}
		catch(FileNotFoundException e){
		    e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}		
	}
}
