package domain;

import java.sql.Date;

public class Loan
{
	private Date startDate;
	private Date endDate;
	private Student student;
	private Administrator administrator;
	
	public Loan()
	{
		
	}
	
	public Loan(Date pStartDate, Date pEndDate, Student pStudent, Administrator pAdministrator)
	{
		this.startDate = pStartDate;
		this.endDate = pEndDate;
		this.student = pStudent;
		this.administrator = pAdministrator;
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
	 * Created: 02/24/2018
	 * Author: Esteban Coto Alfaro
	 * Description: For students to return a material
	 * Last modification: 02/24/2018 
	 */
	public void makeAReturn()
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
}
