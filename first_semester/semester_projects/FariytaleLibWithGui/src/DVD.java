
import java.io.IOException;



/**
 * This is a class for the dvd, which uses the fields from the item class
 * meaning that it extends the item class 
 */
public class DVD extends Item
{
	

	private String artist;
	private MyDate date;
	private MyDate isOldDate;
	private boolean IsOld;
	
	/**
	 * Constructor for the book class where all the fields are set 
	 * including calling the fields from the super class
	 * String title, int status, string artist and a date
	 * created using the MyDate class
	 * @param title
	 * @param status
	 * @param artist
	 * @param date
	 * @param isOldDate
	 */
	public DVD(String title, int status, String artist, MyDate date, MyDate isOldDate)
	{
		
		super(title, status);
		this.artist = artist;
		this.date = date;
		this.isOldDate = isOldDate;
	}

	public String getArtist()
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}
	/**
	 * To String method used for overriding the toString() in the super class and object class.
	 * This string prints the toString() from superclass and the author and magazine from this class.
	 */
	@Override
	public String toString()
	{
		
		return super.toString() + " DVD artist = " + artist;
	}
	
	@Override
	public MyDate setDate(MyDate date)
	{
		return this.date.copy();
	}
	
	public MyDate getIsOldDate()
	{
		return isOldDate;
	}

	public void setIsOldDate(MyDate isOldDate)
	{
		this.isOldDate = isOldDate;
	}

	public void setIsOld(boolean isOld)
	{
		this.IsOld = isOld;
	}
	/**
	 * This method checks if the dvd IsOld, it returns true
	 * else it returns false
	 * @return true
	 * @return false
	 */
	public boolean getIsOld() 
	{
		
		if (IsOld == true)
		{
			return true;
		}
		
		return false;
	}
	
	/**
	 * This method checks if a dvd is the same as another dvd item
	 * If obj is not instance of dvd
	 * return false, otherwise if other dvd
	 * is instance of dvd obj, we make cast of dvd
	 * if title is equal to other dvd obj and artist is equal
	 *  to other artist,
	 *  then return true, otherwise return false.  
	 */
@Override
public boolean equals(Object obj) 
{

	if (!(obj instanceof DVD))
		{
			return false;
		}
	DVD other = (DVD) obj;
	if(this.getTitle().equals(other.getTitle()) 
			&& this.getArtist().equals(other.getArtist()))
	{
		return true;
	}
	return false;
}



}
