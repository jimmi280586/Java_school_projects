
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * The purpose of this class is to write and read binary files from the library. 
 * This one handles the list of lend outs.
 */
public class LendOutFile implements Serializable
{
	
	   private String  filename;
	   
	    
	   public LendOutFile(String filename)
	   {
	      this.filename = filename;
	   }
	   /**
	    * Writes a list of lent out items to the specified file. Creates the file if it doesn't exist
	    * and overwrites it if it does.
	    * @param lendOuts is the list of items lent out and the customers that borrowed them.
	    * @throws IOException is thrown if the system failed to write to a file.
	    */
	  public void writeLendOutList(LendOutList  lendOuts) throws IOException
	   {
		
	      FileOutputStream file = new FileOutputStream(filename);
	      ObjectOutputStream out = new ObjectOutputStream(file);
	   
	   try
	   {
		   
	      out.writeObject(lendOuts);
	   }
	   finally
	   {
	      out.close();
	   }
	   
	   }
	  
	
	  /**
	    * Reads a list of lent out items from the specified file. The file must exist.
	    * @return returns the binary file.
	    * @throws IOException Throws an exception if the file does not exist.
	    */
	   public LendOutList readLendOutList() throws IOException
	   {
		 
	      FileInputStream fis = new FileInputStream("LendOutlist.obj");
	      ObjectInputStream ois = new ObjectInputStream(fis);
	      
	      try
	      {
	         LendOutList lendOuts = (LendOutList) 
	        		 ois.readObject();
	         return lendOuts;
	      }
	      
	      catch(ClassNotFoundException e)
	      {
	         throw new ClassCastException(e.getMessage());
	      }
	      finally
	      {
	         ois.close();
	      }
	   }
}
