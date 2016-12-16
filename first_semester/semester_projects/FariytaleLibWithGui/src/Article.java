


/**
	 * This is a class for the article item which uses the fields from the item class
	 *  meaning that it extends the item class 
	 */
public class Article extends Item
{
	
	//fields
	private String author;
	private String magazine;
	private MyDate date;
	/**
	 * Constructor for the article class where all the fields are set 
	 * including calling the fields from the super class
	 * String title, int status, string author, string magazine and a date
	 * created using the MyDate class
	 * @param title
	 * @param status
	 * @param author
	 * @param magazine
	 * @param date
	 */
	public Article(String title, int status, String author, String magazine, MyDate date)
	{
	
		super(title, status);
		this.author = author;
		this.magazine = magazine;
		this.date = date;
	}

	
	public String getAuthor()
	{
		return author;
	}


	public void setAuthor(String author)
	{
		this.author = author;
	}

	
	public String getMagazine()
	{
		return magazine;
	}

	
	public void setMagazine(String magazine)
	{
		this.magazine = magazine;
	}
	/**
	 * To String method used for overriding the toString() in the super class and object class.
	 * This string prints the toString() from superclass and the author and magazine from this class.
	 */
	@Override
	public String toString() 
	{
		
		return super.toString() + " Article author = " + author + ", magazine = " + magazine;
	}
	
	
	public MyDate setDate(MyDate date)
	{
		return this.date;
	}

	@Override  //This method is not used 
    //  in this class, it's here because it's a subclass--inheritance relation
	public void setIsOld(boolean old) 
	{
		
	}

	@Override  //This method is not used 
    //  in this class, it's here because it's a subclass--inheritance relation
	
	public MyDate getIsOldDate() 
	{
		return null;
	}
	/**
	 * this method checks if an article item is the same as another article item
	 * If obj is not instance of article
	 * return false, otherwise if other article
	 * is instance of article obj, we make cast of article
	 * if title is equal to other article obj and author is equal
	 *  to other author and magazine is equal to other magazine,
	 *  then return true, otherwise return false.  
	 */
	@Override
	public boolean equals(Object obj) 
	{
	
		if (!(obj instanceof Article))
			{
				return false;
			}
		Article other = (Article) obj;
		if(this.getTitle().equals(other.getTitle()) 
				&& this.getAuthor().equals(other.getAuthor())
				&& this.getMagazine().equals(other.getMagazine()))
		{
			return true;
		}
		return false;
	}
	
	
}
