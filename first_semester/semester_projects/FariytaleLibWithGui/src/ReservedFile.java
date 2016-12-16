
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The purpose of this class is to write and read binary files from the library. This one handles the list of reserved items.
 *
 */
public class ReservedFile implements Serializable
{
	
	
	private String  filename;
	   
	  
	   
	   public ReservedFile(String filename)
	   {
	      this.filename = filename;
	   }
	   
	   /**
	    * Writes a list of reserved items to the specified file. Creates the file if it doesn't exist
	    * and overwrites it if it does.
	    * @param reserved is the list of items reserved and the customers that reserved them.
	    * @throws IOException is thrown if the system failed to write to a file.
	    */
	   
	   public void writeReservedList(ReservedList  reserved) throws IOException
	   {
		
	      FileOutputStream file = new FileOutputStream(filename);
	      ObjectOutputStream out = new ObjectOutputStream(file);
	   
	   try
	   {
	      out.writeObject(reserved);
	   }
	   finally
	   {
	      out.close();
	   }
	   
	   }
	  
	   /**
	    * Reads a list of reserved items from the specified file. The file must exist.
	    * @return returns the binary file.
	    * @throws IOException Throws an exception if the file does not exist.
	    */
	   public ReservedList readReservedList() throws IOException
	   {
		
	      FileInputStream fis = new FileInputStream("ReservedList.obj");
	      ObjectInputStream ois = new ObjectInputStream(fis);
	      
	      try
	      {
	         ReservedList reserved = (ReservedList) 
	        		 ois.readObject();
	         return reserved;
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
