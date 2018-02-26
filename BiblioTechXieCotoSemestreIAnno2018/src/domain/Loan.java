package domain;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.util.ArrayList;

import file.Reader;
import file.Writer;
import library.IConstant;

public class Loan implements IConstant
{
	private Date startDate;
	private Date endDate;
	private Student student;
	private Administrator administrator;
	private Material material;
	
	public Loan()
	{
		startDate = (Date) DEFAULT_VALUE_START_DAY;
		endDate = (Date) DEFAULT_VALUE_END_DAY;
		student = (Student) DEFAULT_VALUE_OBJECT;
		administrator = (Administrator) DEFAULT_VALUE_OBJECT;
		material = (Material) DEFAULT_VALUE_OBJECT;
	}
	
	public Loan(Date pStartDate, Date pEndDate, Student pStudent, Administrator pAdministrator, Material pMaterial)
	{
		this.startDate = pStartDate;
		this.endDate = pEndDate;
		this.student = pStudent;
		this.administrator = pAdministrator;
		this.material = pMaterial;
	}
	
	/* 
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: For students to make a loan
	 * Last modification: 02/24/2018 
	 */
	public void makeALoan()
	{

	}
	
	/*
	 * GETTERS and SETTERS 
	 */
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}
}
