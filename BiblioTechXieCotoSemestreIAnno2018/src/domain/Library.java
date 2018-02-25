package domain;

import java.util.ArrayList;

import library.IConstant;

public class Library implements IConstant
{
	private ArrayList<Material> materialList = new ArrayList<Material>();
	private ArrayList<Loan> loanList = new ArrayList<Loan>();
	
	public Library()
	{
		materialList = (ArrayList<Material>) DEFAULT_VALUE_OBJECT;
		loanList = (ArrayList<Loan>) DEFAULT_VALUE_OBJECT;
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