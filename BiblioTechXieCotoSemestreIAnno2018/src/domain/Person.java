package domain;

import java.io.Serializable;

public class Person implements Serializable
{
	private String name;
	private String sureName;
	private String identification;
	private String address;
	
	public Person()
	{
		
	}
	
	public Person(String pName, String pSureName, String pIdentification, String pAddress)
	{
		this.name = pName;
		this.sureName = pSureName;
		this.identification = pIdentification;
		this.address = pAddress;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSureName() {
		return sureName;
	}
	public void setSureName(String sureName) {
		this.sureName = sureName;
	}
	
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
