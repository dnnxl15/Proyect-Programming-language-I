package domain;

import java.io.Serializable;
import java.sql.Date;

import exception.CodeBookException;
import library.IConstant;

public class Book extends Material implements Serializable, IConstant
{
	private String type;
	private String code;
	private String author;
	private Date releaseDate;
	private int pageQuantity;
	
	public Book()
	{
		type = DEFAULT_VALUE_BOOK_TYPE;
		code = DEFAULT_VALUE_BOOK_CODE;
		author = DEFAULT_VALUE_BOOK_AUTHOR;
		releaseDate = (Date) DEFAULT_VALUE_BOOK_RELEASE_DATE;
		pageQuantity = DEFAULT_VALUE_BOOK_PAGE_QUANTITY;
	}
	
	public Book(String pName, int pTotalQuantity, int pQuantityAvailable, Date pIncomingDate, boolean pStatus, String pType, String pCode,
			String pAuthor, Date pReleaseDate, int pPageQuantity) throws CodeBookException
	{
		super(pName, pTotalQuantity, pQuantityAvailable, pIncomingDate, pStatus);
		this.type = pType;
		this.code = pCode;
		this.author = pAuthor;
		this.releaseDate = pReleaseDate;
		this.pageQuantity = pPageQuantity;
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
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public int getPageQuantity() {
		return pageQuantity;
	}
	public void setPageQuantity(int pageQuantity) {
		this.pageQuantity = pageQuantity;
	}
}
