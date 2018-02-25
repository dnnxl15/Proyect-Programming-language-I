package domain;

import java.io.Serializable;

import library.IConstant;

public class Student extends Person implements Serializable, IConstant
{
	private String carrer;
	private String license;
	
	public Student()
	{
		carrer = DEFAULT_VALUE_STUDENT_CARRER;
		license = DEFAULT_VALUE_STUDENT_ID;
	}
	
	public Student(String pName, String pSureName, String pIdentification, String pAddress, String pCarrer, String pLicense)
	{
		super(pName, pSureName, pIdentification, pAddress);
		this.carrer = pCarrer;
		this.license = pLicense;
	}
	
	public String getCarrer() {
		return carrer;
	}
	
	public void setCarrer(String carrer) {
		this.carrer = carrer;
	}
	
	public String getLicense() {
		return license;
	}
	
	public void setLicense(String license) {
		this.license = license;
	}
}