
import java.io.IOException;
import java.sql.Date;



/**
 * class for the cd item witch uses the fields from the item class
 * meaning that it extends the item class.
 */
public class CD extends Item
{
	
	//fields
	private String artist;
	private MyDate date;
	private MyDate isOldDate;
	private boolean IsOld;
	/**
	 * Constructor for the book class where all the fields are set 
	 * including calling the fields from the super class
	 * String title, int status, string artist and a date
	 * created using the mydate class.
	 * @param title
	 * @param status
	 * @param artist
	 * @param date
	 * @param isOldDate
	 */
	public CD(String title, int status, String artist, MyDate date, MyDate isOldDate)
	{
	
		super(title, status);
		this.artist = artist;
		this.date = date;
		this.isOldDate = isOldDate;
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
	/**
	 * To String method used for overriding the toString() in the super class and object class.
	 * This string prints the toString() from superclass and the author and magazine from this class.
	 */
	@Override
	public String toString()
	{
	
		return super.toString() + " CD artist = " + artist;
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
	 * this getter checks if the field IsOld is set to true it returns true
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
	 * 
	 * This method checks if the Cd item is the same as another Cd item
	 * If obj is not instance of Cd
	 * return false, otherwise if other Cd
	 * is instance of CD obj, we make cast of Cd
	 * if title is equal to other Cd obj and artist is equal
	 *  to other artist,
	 *  then return true, otherwise return false.  
	 */
	@Override
	public boolean equals(Object obj) 
	{

		if (!(obj instanceof CD))
			{
				return false;
			}
		CD other = (CD) obj;
		if(this.getTitle().equals(other.getTitle()) 
				&& this.getArtist().equals(other.getArtist()))
		{
			return true;
		}
		return false;
	}


	
	
}
