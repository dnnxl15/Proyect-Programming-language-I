package domain;

import java.io.Serializable;

import library.IConstant;

public class Person implements Serializable, IConstant
{
	private String name;
	private String sureName;
	private String identification;
	private String address;
	
	public Person()
	{
		name = DEFAULT_VALUE_PERSON_NAME;
		sureName = DEFAULT_VALUE_PERSON_SURENAME;
		identification = DEFAULT_VALUE_PERSON_IDENTIFICATION;
		address = DEFAULT_VALUE_PERSON_ADDRESS;
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
