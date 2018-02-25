package domain;

import java.sql.Date;

public class Material 
{
	private String name;
	private int totalQuantity;
	private int quantityAvailable;
	private Date incomingDate;
	private boolean status;
	
	public Material()
	{
		
	}
	
	public Material(String pName, int pTotalQuantity, int pQuantityAvailable, Date pIncomingDate, boolean pStatus)
	{
		this.name = pName;
		this.totalQuantity = pTotalQuantity;
		this.quantityAvailable = pQuantityAvailable;
		this.incomingDate = pIncomingDate;
		this.status = pStatus;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	public Date getIncomingDate() {
		return incomingDate;
	}
	public void setIncomingDate(Date incomingDate) {
		this.incomingDate = incomingDate;
	}
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
