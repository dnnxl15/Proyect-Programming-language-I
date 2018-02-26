package control;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import domain.Administrator;
import domain.Loan;
import domain.Material;
import domain.Student;
import file.Reader;
import file.Writer;

public class LoanControl
{
	/* 
	 * Created: 02/26/2018
	 * Author: Esteban Coto Alfaro
	 * Description: Verify if the information is true
	 * Last modification: 02/26/2018 
	 */
	public boolean verifyInformation(Student pStudent, Material pMaterial) throws FileNotFoundException, ClassNotFoundException
	{
		Reader read = new Reader(); //Reader constructor
		ArrayList<Loan> loanList = new ArrayList<Loan>(); //Create a new ArrayList for Loan objects
		loanList = read.readLoan(); //Read the Loan File and charge the objects
		for(int position = 0; position < loanList.size(); position++) //Analyze each position of the arrayList charged
		{
			//Analyze when the name of the student and name of the material that is received is equal in the arrayList
			if(loanList.get(position).getStudent().getName().toString().equals(pStudent.getName().toString()) &&
					loanList.get(position).getMaterial().getName().toString().equals(pMaterial.getName().toString()))
			{
				return true; //return true when the information is valid
			}
		}
		return false; //return false if the information is false
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: For students to return a material
	 * Last modification: 02/25/2018 
	 */
	public void makeAReturn(Student pStudent, Material pMaterial) throws FileNotFoundException, ClassNotFoundException
	{
		Reader read = new Reader(); //Reader constructor
		ArrayList<Loan> loanList = new ArrayList<Loan>(); //Create a new ArrayList for Loan objects
		loanList = read.readLoan(); //Read the Loan File and charge the objects
		Loan loan = new Loan(); //Create a new loan constructor
		for(int position = 0; position < loanList.size(); position++) //Analyze each position of the arrayList charged
		{
			//Analyze when the name of the student and name of the material that is received is equal in the arrayList
			if(loanList.get(position).getStudent().getName().toString().equals(pStudent.getName().toString()) &&
					loanList.get(position).getMaterial().getName().toString().equals(pMaterial.getName().toString()))
			{
				loan = loanList.get(position); //Assign the loan object when is founded
				loanList.remove(position); //the object is removed from the list
			}
		}
		Writer write = new Writer(); //Create a new Writer constructor
		write.saveReturn(loanList, loan); //Call the method to remove the material from the loan file
	}
}


