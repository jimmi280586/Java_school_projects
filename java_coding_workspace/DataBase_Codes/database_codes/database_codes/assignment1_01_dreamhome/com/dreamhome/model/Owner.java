package database_codes.assignment1_01_dreamhome.com.dreamhome.model;

import java.io.Serializable;

public class Owner implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ownerNo;
	private String ownerName;

	public Owner() {
		// TODO Auto-generated constructor stub
	}

	public Owner(int ownerNo, String ownerName) {
		super();
		this.ownerNo = ownerNo;
		this.ownerName = ownerName;
	}

	/**
	 * @return the ownerNo
	 */
	public int getOwnerNo() {
		return ownerNo;
	}

	/**
	 * @param ownerNo the ownerNo to set
	 */
	public void setOwnerNo(int ownerNo) {
		this.ownerNo = ownerNo;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
