package database_codes.assignment1_01_dreamhome.com.dreamhome.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Lease implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int apartmentNo;
	private LocalDateTime leaseFrom;
	private LocalDateTime leaseTo;
	private int price;
	private int lesseeId;
	
	public Lease() {
		// TODO Auto-generated constructor stub
	}

	public Lease(int apartmentNo, LocalDateTime leaseFrom, LocalDateTime leaseTo, int price,
			int lesseeId) {
		super();
		this.apartmentNo = apartmentNo;
		this.leaseFrom = LocalDateTime.of(leaseFrom.getYear(), leaseFrom.getMonth(), leaseFrom.getDayOfMonth(),
				leaseFrom.getHour(), leaseFrom.getMinute(), leaseFrom.getSecond(), leaseFrom.getNano());
		if (leaseTo != null)
			this.leaseTo= LocalDateTime.of(leaseTo.getYear(), leaseTo.getMonth(), leaseTo.getDayOfMonth(),
					leaseTo.getHour(), leaseTo.getMinute(), leaseTo.getSecond(), leaseTo.getNano());
		else
			this.leaseTo = null;
		this.price = price;
		this.lesseeId = lesseeId;
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
	 * @return the leaseFrom
	 */
	public LocalDateTime getLeaseFrom() {
		return leaseFrom;
	}

	/**
	 * @param leaseFrom the leaseFrom to set
	 */
	public void setLeaseFrom(LocalDateTime leaseFrom) {
		this.leaseFrom = leaseFrom;
	}

	/**
	 * @return the leaseTo
	 */
	public LocalDateTime getLeaseTo() {
		return leaseTo;
	}

	/**
	 * @param leaseTo the leaseTo to set
	 */
	public void setLeaseTo(LocalDateTime leaseTo) {
		this.leaseTo = leaseTo;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
