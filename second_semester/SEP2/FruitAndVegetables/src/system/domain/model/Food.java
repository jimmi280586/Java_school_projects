package src.system.domain.model;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class Food stores all information about the object of food.
 */
public class Food {

	private String name;
	private int barcode;
	private String history;

	private String tast;
	private double cookingtime;
	private String growingStart;
	private String growingEnd;
	private String SecondName;	
	private String originCountryName;
	private String CountryCode;
	private int countryId;
	private int subId;
	private int secondNameId;
	private int infoId;
	private int growingPeriodId;

	/**
	 * Instantiates a new food element.
	 *
	 * @param name
	 *            the name
	 * @param barcode
	 *            the barcode
	 * @param history
	 *            the history
	 * @param tast
	 *            the tast
	 * @param cookingtime
	 *            the cookingtime
	 * @param growingStart
	 *            the growing start
	 * @param growingEnd
	 *            the growing end
	 * @param secondName
	 *            the second name
	 * @param origins
	 *            the origins
	 * @param subID
	 *            the sub id
	 * @param CountryCode
	 *            the country code
	 * @param countryId
	 *            the country id
	 * @param secondNameId
	 *            the second name id
	 * @param infoId
	 *            the info id
	 * @param growingPeriodId
	 *            the growing period id
	 */
	public Food(String name, int barcode, String history, String tast,
			double cookingtime, String growingStart, String growingEnd,
			String secondName, String origins, int subID, String CountryCode,
			int countryId, int secondNameId, int infoId, int growingPeriodId) {
		this.subId = subID;
		this.name = name;
		this.barcode = barcode;
		this.history = history;
		this.tast = tast;
		this.cookingtime = cookingtime;
		this.growingStart = growingStart;
		this.growingEnd = growingEnd;
		this.SecondName = secondName;
		this.originCountryName = origins;
		this.CountryCode = CountryCode;
		this.countryId = countryId;
		this.secondNameId = secondNameId;
		this.infoId = infoId;
		this.growingPeriodId = growingPeriodId;
	}

	public String getName() {
		return name;
	}

	public int getBarcode() {
		return barcode;
	}

	public String getHistory() {
		return history;
	}

	public String getTast() {
		return tast;
	}

	public double getCookingtime() {
		return cookingtime;
	}

	public String getGrowingStart() {
		return growingStart;
	}

	public String getGrowingEnd() {
		return growingEnd;
	}

	public String getSecondName() {
		return SecondName;
	}

	public String getOriginCountryName() {
		return originCountryName;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public int getCountryId() {
		return countryId;
	}

	public int getSubId() {
		return subId;
	}

	public int getSecondNameId() {
		return secondNameId;
	}

	public int getInfoId() {
		return infoId;
	}

	public int getGrowingPeriodId() {
		return growingPeriodId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public void setTast(String tast) {
		this.tast = tast;
	}

	public void setCookingtime(double cookingtime) {
		this.cookingtime = cookingtime;
	}

	public void setGrowingStart(String growingStart) {
		this.growingStart = growingStart;
	}

	public void setGrowingEnd(String growingEnd) {
		this.growingEnd = growingEnd;
	}

	public void setSecondName(String secondName) {
		SecondName = secondName;
	}

	public void setOriginCountryName(String originCountryName) {
		this.originCountryName = originCountryName;
	}

	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public void setSecondNameId(int secondNameId) {
		this.secondNameId = secondNameId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public void setGrowingPeriodId(int growingPeriodId) {
		this.growingPeriodId = growingPeriodId;
	}

	/*
	 * String method for printing all information about the Food object to a String element
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		return "Food name = " + name + "," + " /&   /&barcode = " + barcode + ", "
				+ "/&   /&history = " + history + "," + " /&  /&taste = " + tast + ", "
				+ "/&  /&cookingtime = " + cookingtime + " ,"
				+ "/&   /&growingStart = " + growingStart + ", "
				+ "/&  /&growingEnd = " + growingEnd + "," + " /&  /&SecondName = "
				+ SecondName + "," + " /&  /&originCountryName = "
				+ originCountryName + ", " + "/&   /&CountryCode = " + CountryCode
				+ ", " + "/&  /&countryId = " + countryId + "," + " /&  /&subId = "
				+ subId + "," + "/&  /&secondNameId = " + secondNameId + ", "
				+ "/&  /&infoId = " +  infoId + ", " + "/&  /&growingPeriodId = "
				+ growingPeriodId + "";
	}
}
