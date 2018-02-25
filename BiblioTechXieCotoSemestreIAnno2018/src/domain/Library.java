package domain;

import java.util.ArrayList;

public class Library
{
	private ArrayList<Material> materialList = new ArrayList<Material>();
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	
	public Library()
	{
		
	}
	
	public Library(ArrayList<Material> pMaterialList, ArrayList<Loan> pLoanList)
	{
		this.materialList = pMaterialList;
		this.loanList = pLoanList;
	}
	
	public ArrayList<Material> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
	}
	
	public ArrayList<Loan> getLoanList() {
		return loanList;
	}
	public void setLoanList(ArrayList<Loan> loanList) {
		this.loanList = loanList;
	}
	
}
