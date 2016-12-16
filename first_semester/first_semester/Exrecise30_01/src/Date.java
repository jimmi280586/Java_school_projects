
public class Date 
{
	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) 
	{
		this.setDay(day, month, year);
	}

	public void setDay(int day, int month, int year) 
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay()
	{
		return day;
	}

	public int getMonth()
	{
		return month;
	}

	public int getYear()
	{
		return year;
	}

	public Date copy()
	{
		return new Date(this.day, this.month, this.year);
	}
		
	public String toString() 
	{
		return this.day + "/" + this.month + "/" + this.year;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if(!(obj instanceof Date))
		{
			return false;
		}
		Date other = (Date) obj;
		return this.day == other.day 
				&& this.month == other.month 
				&& this.year == other.year;
	}	
	
}
