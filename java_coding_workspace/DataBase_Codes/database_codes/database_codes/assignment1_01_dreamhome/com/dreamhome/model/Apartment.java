package database_codes.assignment1_01_dreamhome.com.dreamhome.model;

import java.io.Serializable;

public class Apartment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int apartmentNo;
	private String address;
	private int ownerNo;

	public Apartment() {
		// TODO Auto-generated constructor stub
	}

	public Apartment(int apartmentNo, String address, int ownerNo) {
		super();
		this.apartmentNo = apartmentNo;
		this.address = address;
		this.ownerNo = ownerNo;
	}

	/**
	 * @return the apartmentNo
	 */
	public int getApartmentNo() {
		return apartmentNo;
	}

	/**
	 * @param apartmentNo the apartmentNo to set
	 */
	public void setApartmentNo(int apartmentNo) {
		this.apartmentNo = apartmentNo;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
