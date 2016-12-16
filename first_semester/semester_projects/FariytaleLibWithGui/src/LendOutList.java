
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class creates an Arraylist for the lend out objects.
 */
public class LendOutList implements Serializable
{
	
	  
	   
	   private ArrayList<LendOut> lendOuts;

	   
	   /**
	    * Sets the field to a new Arraylist.
	    */
	   public LendOutList()
	   {
		   
	      this.lendOuts = new ArrayList<LendOut>();
	   }

	  
	   public void addLendOut(LendOut lendOut)
	   {
	      this.lendOuts.add(lendOut);
	   }

	 
	   public void removeLendOut(LendOut lendOut)
	   {
	      this.lendOuts.remove(lendOut);
	   }

	 
	   public int getNumberOfLendOut()
	   {
	      return lendOuts.size();

	   }
	   
	   public LendOut getLendOut(int index)
	   {
		   return this.lendOuts.get(index);
	   }

	  
	   public String toString()
	   {
	      return "LendOutList" + this.lendOuts;
	   }


}
