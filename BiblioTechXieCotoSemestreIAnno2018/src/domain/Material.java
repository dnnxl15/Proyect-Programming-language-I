package domain;

import java.io.Serializable;
import java.sql.Date;

import library.IConstant;

public class Material implements Serializable, IConstant
{
	private String name;
	private int totalQuantity;
	private int quantityAvailable;
	private Date incomingDate;
	private boolean status;
	
	public Material()
	{
		name = DEFAULT_VALUE_MATERIAL_NAME;
		totalQuantity = DEFAULT_VALUE_MATERIAL_TOTAL_QUANTITY;
		quantityAvailable = DEFAULT_VALUE_MATERIAL_QUANTITY_AVAILABLE;
		incomingDate = (Date) DEFAULT_VALUE_MATERIAL_DATE;
		status = DEFAULT_VALUE_MATERIAL_STATUS;
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
	
	@Override
	public String toString()
	{
		return name;
	}
}

