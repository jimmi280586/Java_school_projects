


public class Article extends Item
{
	/**
	 * class for the article item witch uses the filds from the item class
	 * meaning that it extends the item class 
	 */
	//fields
	private String author;
	private String magazine;
	private MyDate date;
	
	public Article(String title, int status, String author, String magazine, MyDate date)
	{
		/**
		 * constructor for the article you need to set 
		 * all fields for this item including the fields from the super class
		 * String title, int status, string author, string magazine and a date
		 * created using the mydate class
		 */
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

	@Override
	public String toString() 
	{
		/**
		 * to string method used for overriding the to string in the super class an object class
		 * this string prints the to string method from superclass and the author and magazine
		 */
		return super.toString() + " Article author = " + author + ", magazine = " + magazine;
	}
	

	public MyDate setAddDate(MyDate date)
	{
		return this.date;
	}

	@Override
	public Item copy()
	{
		/**
		 * copy method for copying all the fields when used
		 */
		return new Article(this.author, getStatus(), this.magazine, getTitle(), date);
	}

	@Override
	public boolean equals(Object obj) {
	
		return false;
	}

	
	
	
}
