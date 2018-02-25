package domain;

import java.io.Serializable;

public class Administrator extends Person implements Serializable
{
	private String username;
	private String password;
	
	public Administrator()
	{
		
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
