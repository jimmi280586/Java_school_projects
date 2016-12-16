package domain.model;


import java.io.Serializable;

/**This is an abstract class with the subclasses Book, Article, CD and DVD. The class sets the title
 * of the items as well as their lending status. It also contains the abstract methods setAddDate() and copy()
 * that are defined in the subclasses.
    */ 
public abstract class Item  implements Serializable
{
   
	      

	       private String title;
	       private int status;
	       private String StatusToString;
	       /**
	           * Constructor for abstract item class initializes the fields title and
	           * status. 
	           * @param title
	           * @param status
	           */
	       public Item(String title, int status)
	       {
	         
	          this.title = title;
	          this.status = status;
	       }

	       public String getTitle()
	       {
	          return this.title;
	       }

	       public void setTitle(String title)
	       {
	        
	          this.title = title;
	       }
	       /**
    	    * This method translates the get status integer to 
    	    * a string which is the use in toString method
    	    * @return statusToString
    	    */
	       public String getStatusToString()
	       {
	    	  
	       
	    	   if (status == 1)
		          {
		        	  return " item is HOME";
		          }
		          if (status == 2)
		          {
		        	  return " item is LEND OUT";
		          }
		          if (status == 3)
		          {
		        	  return " item is RESERVED";
		          }
		        return " check item STATUS";
	    	   
	       }

	       public int getStatus()
	       {
	    	   return status;
	       }
	       
	       public void setStatus(int status)
	       {
	    	   this.status = status;
	       }
	       /**Overrides the object toString() and returns
    	    * this class' fields except the status is changed to a string.
    		 */
	       @Override
		public String toString() 
	       {	              
			return "title = " + title + ", status = " + getStatusToString();
	       }
    		 	  
	    public abstract boolean equals(Object obj);		
	
		
		

}
