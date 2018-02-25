package domain;

import java.sql.Date;

public class Book extends Material
{
	private String type;
	private String code;
	private String author;
	private Date releaseDate;
	private int pageQuantity;
	
	public Book()
	{
		
	}
	
	public Book(String pName, int pTotalQuantity, int pQuantityAvailable, Date pIncomingDate, boolean pStatus, String pType, String pCode,
			String pAuthor, Date pReleaseDate, int pPageQuantity)
	{
		super( pName, pTotalQuantity, pQuantityAvailable, pIncomingDate, pStatus);
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
