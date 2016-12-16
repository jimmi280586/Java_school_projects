import java.io.IOException;




public class DVD extends Item
{
	/**
	 * 
	 */

	private String artist;
	private MyDate date;

	
	public DVD(String title, int status, String artist, MyDate date)
	{
		super(title, status);
		this.artist = artist;
		this.date = date.copy();
		
	}

	public String getArtist()
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	@Override
	public String toString()
	{
		return super.toString() + " DVD artist = " + artist;
	}
	
	public MyDate setAddDate(MyDate date)
	{
		return this.date.copy();
	}

	public MyDate calculate()
	{
		
		
		int a = date.getDay();
		int b = date.getMonth();
		int c = date.getYear() + 1;
		
		MyDate Calculated1 = new MyDate(a, b, c);
		
		return Calculated1;
	}
	
	public boolean isOld() 
	{
		
		
		if (date.equals(calculate()))
		{
			return true;
		}
		return false;
	}
	
	@Override
	public Item copy()
	{
		return new DVD(this.artist, getStatus(), getTitle(), date.copy());
	}

	
}
