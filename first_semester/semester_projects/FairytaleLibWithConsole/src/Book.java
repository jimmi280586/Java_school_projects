


public class Book extends Item
{

	private String author;
	private String isbn;
	private MyDate date;
	
	public Book(String title, int status, String author, String isbn, MyDate date)
	{
		
	
		super(title, status);
		this.author = author;
		this.isbn = isbn;
		this.date = date;
	}

	//getter for author
	public String getAuthor() 
	{
		return author;
	}

	// setter for author
	public void setAuthor(String author)
	{
		this.author = author;
	}

	//getter for isbn number
	public String getIsbn()
	{
		return isbn;
	}

	//setter for isbn number
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	@Override
	public String toString() 
	{
		/**
		 * 
		 */
		return super.toString() + " Book author = " + author + ", book isbn = " + isbn;
	}
	// setter for the date the object was created you need to set a date object
	public MyDate setAddDate(MyDate date)
	{
		return this.date;
	}

	@Override
	public Item copy()
	{
		
		return new Book(this.author, getStatus(), this.isbn, getTitle(), date);
	}

	@Override
	public boolean equals(Object obj) {
		
		return false;
	}



	
	
}
