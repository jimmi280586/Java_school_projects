
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class creates an ArrayList for reservedOut objects.
 * 
 */
public class ReservedList implements Serializable
{
	
	
	   private ArrayList<ReserveItemOut> reserved;

	   
	   /**
	    * Sets the field to a new ArrayList.
	    */
	   public ReservedList()
	   {
		   
	      this.reserved = new ArrayList<ReserveItemOut>();
	   }

	   
	   public void addReserved(ReserveItemOut reserved)
	   {
	      this.reserved.add(reserved);
	   }

	  
	   public void removeReserved(ReserveItemOut reserved)
	   {
	      this.reserved.remove(reserved);
	   }

	   
	   public int getNumberOfReserved()
	   {
	      return reserved.size();

	   }
	   
	   public ReserveItemOut getReserved(int index)
	   {
		   return this.reserved.get(index);
	   }

	   
	   public String toString()
	   {
	      return "ReservedList" + this.reserved;
	   }



}
