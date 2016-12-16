import java.io.Serializable;


public abstract class Item  implements Serializable
{
   
	       /**
	           * 
	           */
	  
	       // need to be protected for the copy method in subclasses
	       private String title;
	       private int status;
	       private int count = 1;

	       public Item(String title, int status)
	       {
	          /**
	           * cunstruktor for abstract item class initialises fields of title ans
	           * status
	           */
	          this.title = title;
	          this.status = status;
	       }

	       public String getTitle()
	       {
	          /**
	           * standard getter for title returns title
	           */

	          return this.title;
	       }

	       public void setTitle(String title)
	       {
	          /**
	           * standard setter for setting the title sets the title of the object
	           */
	          this.title = title;
	       }

	       public int getStatus()
	       {
	          /**
	           * standard getter for status returns integer from 1-3 1 = HOME 2 = Lend
	           * OUT 3 = RESERVED
	           */
	          return this.status;
	       }

	       public void setStatus(int status)
	       {
	    	   this.status = status;
	    	  

	          
	       }
	       
	      
	       @Override
		public String toString() 
	       {
			return "title = " + title + ", status = " + status;
	       }

		@Override
	       public boolean equals(Object obj)
	       {
	          /**
	           * equals method this one checs to se if the object is an instance of item
	           * if not it returns false if it is it checs to se if the to object are
	           * the same first it checs to se if the objects have the same title and
	           * the it checs to se if they have the same status number
	           */

	          if (!(obj instanceof Item))
	          {
	             return false;
	          }
	          Item other = (Item) obj;
	          return this.title.equals(other.title) && this.status == (other.status);

	       }

		public abstract MyDate setAddDate(MyDate date);

		public abstract Item copy();

}
