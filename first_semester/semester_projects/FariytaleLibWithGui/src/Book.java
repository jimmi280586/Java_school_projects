


/**
	 * This is a class for the book item which uses the fields from the item class
	 * meaning that it extends the item class 
	 */
public class Book extends Item
{

	private String author;
	private String isbn;
	private MyDate date;
	/**
	 * Constructor for the book class where all the fields are set 
	 * including calling the fields from the super class
	 * String title, int status, string author, string isbn and a date
	 * created using the mydate class
	 * @param title
	 * @param status
	 * @param author
	 * @param isbn
	 * @param date
	 */
	public Book(String title, int status, String author, String isbn, MyDate date)
	{
	
	
		super(title, status);
		this.author = author;
		this.isbn = isbn;
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

	
	public String getIsbn()
	{
		return isbn;
	}

	
	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}
	/**
	 * To String method used for overriding the toString() in the super class and object class.
	 * This string prints the toString() from superclass and the author and magazine from this class.
	 */
	@Override
	public String toString() 
	{
		
		return super.toString() + " Book author = " + author + ", book isbn = " + isbn;
	}
	
	
	public MyDate setDate(MyDate date)
	{
		return this.date;
	}

	@Override // This method is not used 
			  //  in this class, it's here because it's a subclass--inheritance relation
	public MyDate getIsOldDate()
	{
		return null;
	}

	@Override //This method is not used 
	          //  in this class, it's here because it's a subclass--inheritance relation
	public void setIsOld(boolean old)
	{
			
	}
	/**
	 * This method checks if a book item is the same as another book item
	 * If obj is not instance of book
	 * return false, otherwise if other book
	 * is instance of book obj, we make a cast of book
	 * if title is equal to other book obj and author is equal
	 *  to other author and isbn is equal to other isbn,
	 *  then return true, otherwise return false.  
	 */
	@Override
	public boolean equals(Object obj) 
	{
		
		
		if (!(obj instanceof Book))
			{
				return false;
			}
		Book other = (Book) obj;
		if(this.getTitle().equals(other.getTitle()) 
				&& this.getAuthor().equals(other.getAuthor())
				&& this.getIsbn().equals(other.getIsbn()))
		{
			return true;
		}
		return false;
	}

	
	
}
