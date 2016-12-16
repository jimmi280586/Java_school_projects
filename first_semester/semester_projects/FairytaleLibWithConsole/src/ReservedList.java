import java.io.Serializable;
import java.util.ArrayList;


public class ReservedList implements Serializable
{
	// Serial vesion of the document
	
	   // Declare array list
	   private ArrayList<ReserveItemOut> reserved;

	   // Constructs a new ReservedList containing customers

	   public ReservedList()
	   {

	      this.reserved = new ArrayList<ReserveItemOut>();
	   }

	   // Adds a new reserved to a list
	   public void addReserved(ReserveItemOut reserved)
	   {
	      this.reserved.add(reserved);
	   }

	   // Remove a reserved to a list
	   public void removeReserved(ReserveItemOut reserved)
	   {
	      this.reserved.remove(reserved);
	   }

	   // Looks up how many reserved are on the Reserved list and return the number
	   // of reserved objects
	   public int getNumberOfReserved()
	   {
	      return reserved.size();

	   }
	   
	   public ReserveItemOut getReserved(int index)
	   {
		   return this.reserved.get(index);
	   }

	   // Displaying the reserved list
	   public String toString()
	   {
	      return "ReservedList" + this.reserved;
	   }

	   // Compare the lists of reserved
	   public boolean equals(Object obj)
	   {

	      // Check if the Reservedlist is the party of object
	      if (!(obj instanceof ReservedList))
	      {
	         return false;
	      }
	      // If true compare lists
	      ReservedList other = (ReservedList) obj;

	      return this.reserved.equals(other.reserved);
	   }

}
