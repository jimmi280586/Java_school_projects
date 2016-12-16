import java.io.Serializable;
import java.util.ArrayList;


public class LendOutList implements Serializable
{
	// Serial vesion of the document
	  
	   // Declare array list
	   private ArrayList<LendOut> lendOuts;

	   // Constructs a new LendOutList containing customers

	   public LendOutList()
	   {

	      this.lendOuts = new ArrayList<LendOut>();
	   }

	   // Adds a new lendOuts to a list
	   public void addLendOut(LendOut lendOut)
	   {
	      this.lendOuts.add(lendOut);
	   }

	   // Remove a lendOuts to a list
	   public void removeLendOut(LendOut lendOut)
	   {
	      this.lendOuts.remove(lendOut);
	   }

	   // Looks up how many lendOuts are on the LendOut list and return the number
	   // of lendOuts
	   public int getNumberOfLendOut()
	   {
	      return lendOuts.size();

	   }
	   
	   public LendOut getLendOut(int index)
	   {
		   return this.lendOuts.get(index);
	   }

	   // Displaying the lendOuts list
	   public String toString()
	   {
	      return "LendOutList" + this.lendOuts;
	   }

	   // Compare the lists of lendOuts
	   public boolean equals(Object obj)
	   {

	      // Check if the LendOutlist is the party of object
	      if (!(obj instanceof LendOutList))
	      {
	         return false;
	      }
	      // If true compare lists
	      LendOutList other = (LendOutList) obj;

	      return this.lendOuts.equals(other.lendOuts);
	   }

}
