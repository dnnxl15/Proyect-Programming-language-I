package domain;

import java.io.Serializable;
import java.sql.Date;

import library.IConstant;

public class Audiovisual extends Material implements Serializable, IConstant
{
	private String type;
	private String code;
	
	public Audiovisual()
	{
		type = DEFAULT_VALUE_AUDIOVISUAL_TYPE;
		code = DEFAULT_VALUE_AUDIOVISUAL_CODE;
	}
	
	public Audiovisual(String pName, int pTotalQuantity, int pQuantityAvailable, Date pIncomingDate, boolean pStatus, String pType, String pCode)
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
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
}
