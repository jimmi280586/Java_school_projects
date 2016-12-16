import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class ReservedFile implements Serializable
{
	   /**
	 * 
	 */
	
	private String  filename;
	   
	   //Constructs a new ReservedlistFile 
	   
	   public ReservedFile(String filename)
	   {
	      this.filename = filename;
	   }
	   
	   //Write a ReservedList to the specified file.Create the file if it doesn't exist
	   //OverWrites it if it does exist.
	   //ReservedList object to write to the file.
	   //Throws IOException if the write operation failed.
	   
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
	   
	   //Read a ReservedList from the specified file.File must exist
	   //return the object read from the file.
	   
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
