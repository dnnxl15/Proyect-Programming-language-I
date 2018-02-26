package domain;

import java.sql.Date;

import library.IConstant;

public class Audiovisual extends Material implements IConstant
{
	private String type;
	private int code;
	
	public Audiovisual()
	{
		type = DEFAULT_VALUE_AUDIOVISUAL_TYPE;
		code = DEFAULT_VALUE_AUDIOVISUAL_CODE;
	}
	
	public Audiovisual(String pName, int pTotalQuantity, int pQuantityAvailable, Date pIncomingDate, boolean pStatus, String pType, int pCode)
	{
		super(pName, pTotalQuantity, pQuantityAvailable, pIncomingDate, pStatus);
		this.type = pType;
		this.code = pCode;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
}
