package database_codes.assignment1_01_dreamhome.com.dreamhome.model;

import java.io.Serializable;

public class Lessee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lesseeId;
	private String lesseeName;
	
	public Lessee() {
		// TODO Auto-generated constructor stub
	}


	public Lessee(int lesseeId, String lesseeName) {
		super();
		this.lesseeId = lesseeId;
		this.lesseeName = lesseeName;
	}
	
	/**
	 * @return the lesseeId
	 */
	public int getLesseeId() {
		return lesseeId;
	}

	/**
	 * @param lesseeId the lesseeId to set
	 */
	public void setLesseeId(int lesseeId) {
		this.lesseeId = lesseeId;
	}

	/**
	 * @return the lesseeName
	 */
	public String getLesseeName() {
		return lesseeName;
	}

	/**
	 * @param lesseeName the lesseeName to set
	 */
	public void setLesseeName(String lesseeName) {
		this.lesseeName = lesseeName;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
