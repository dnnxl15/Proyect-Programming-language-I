package domain;

import java.io.Serializable;

import library.IConstant;

public class Administrator extends Person implements Serializable, IConstant
{
	private String username;
	private String password;
	
	public Administrator()
	{
		username = DEFAULT_VALUE_ADMINISTRATOR_USERNAME;
		password = DEFAULT_VALUE_ADMINISTRATOR_PASSWORD;
	}
	
	public Administrator(String pName, String pSureName, String pIdentification, String pAddress, String pUsername, String pPassword)
	{
		super(pName, pSureName, pIdentification, pAddress);
		this.username = pUsername;
		this.password = pPassword;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
