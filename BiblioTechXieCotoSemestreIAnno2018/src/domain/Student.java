package domain;

import java.io.Serializable;

public class Student extends Person implements Serializable
{
	private String carrer;
	private String license;
	
	public Student()
	{
		
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
