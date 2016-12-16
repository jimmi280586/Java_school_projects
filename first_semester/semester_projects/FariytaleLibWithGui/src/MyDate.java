
import java.io.Serializable;

/**
 * This class controls a date of three fields
 * day, month, year.
 */
public class MyDate implements Serializable
{
	
	
	private int day;
	private int month;
	private int year;
	/**
	 * The constructor sets the field using the variables it gets when called
	 * @param day
	 * @param month
	 * @param year
	 */
	public MyDate(int day, int month, int year)
	{
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
		
	public int getDay() 
	{
		return this.day;
	}

	public void setDay(int day) 
	{
		this.day = day;
	}

	public int getMonth()
	{
		return month;
	}

	public void setMonth(int month)
	{
		this.month = month;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String toString()
	{
		return " " + day + "/" + month + "/" + year;
	}
	/**
	 * This method checks to see if the year is a leap year
	 */
	public boolean isLeapYear()
	{
		
	   return (this.year % 4 == 0) && (this.year % 100 != 0 || this.year % 400 == 0);
	}
	/**
	 * This method checks the month and
	 * 
	 * @return returns the number of days in that month
	 */
	public int getLengthOfMonth()
	{
		
	   if (this.month == 2 && !this.isLeapYear())
	   {
	      return 28;
	   }
	   else if (this.month == 2 && this.isLeapYear())
	   {
	      return 29;
	   }
	   else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11)
	   {
	      return 30;
	   }
	   else
	   {
	      return 31;
	   }
	}

	/**
	 * This method compares fields of one object to other object fields
	 * and if they are the same
	 * @return returns true.
	 */
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyDate other = (MyDate) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	
	public MyDate copy()
	{
	   return new MyDate(this.day, this.month, this.year);
	}
}
