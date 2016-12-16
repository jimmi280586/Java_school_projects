package domain.model;





/**
	 * This is a class for the book item which uses the fields from the item class
	 * meaning that it extends the item class 
	 */
public class Book extends Item
{

	private String author;
	private String isbn;
	
	/**
	 * Constructor for the book class where all the fields are set 
	 * including calling the fields from the super class
	 * String title, int status, string author, string isbn 
	 * @param title
	 * @param status
	 * @param author
	 * @param isbn
	 * 
	 */
	public Book(String title, int status, String author, String isbn)
	{
	
	
		super(title, status);
		this.author = author;
		this.isbn = isbn;
		
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
