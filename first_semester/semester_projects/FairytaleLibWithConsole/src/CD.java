import java.io.IOException;
import java.sql.Date;




public class CD extends Item
{

	private String artist;
	private MyDate date;
	
	
	public CD(String title, int status, String artist, MyDate date)
	{
		
		super(title, status);
		this.artist = artist;
		this.date = date.copy();
	
	}
	
	//getter for artist
	public String getArtist()
	{
		return artist;
	}

	//setter for artist
	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	@Override
	public String toString()
	{
		
		return super.toString() + " CD artist = " + artist;
	}
	
	// setter for the date object was created takes a date object
	public MyDate setAddDate(MyDate date)
	{
		return this.date.copy();
	}
	

	public boolean isOld() 
	{
		
		//creates a ned date object with the get day from the added date
		//and the month  but it sets the year to the year from the adddate but increments by 1
		MyDate Calculated = new MyDate(date.getDay(), date.getMonth(), (date.getYear() + 1));
		
		//checks if new date created is less then the current date
		if((date.getMonth() > Calculated.getMonth() && date.getYear() > Calculated.getYear())
				|| (date.getMonth() < Calculated.getMonth() && date.getYear() > Calculated.getYear()) )
		{
			//if the current date is bigger the the ned date return true
			return true;
		}
		// if the 2 dates is equal return true
		if (date.equals(Calculated))
		{
			return true;
		}
		//if none of the above is true return false
		return false;
	}
	
	@Override
	public Item copy()
	{
		
		return new CD(this.artist, getStatus(), getTitle(), date.copy());
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
