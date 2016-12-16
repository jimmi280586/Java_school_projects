import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class LendOutFile implements Serializable
{
	   private String  filename;
	   
	   //Constructs a new LendOutlistFile 
	   
	   public LendOutFile(String filename)
	   {
	      this.filename = filename;
	   }
	   
	   //Write a LendOutList to the specified file.Create the file if it doesn't exist
	   //OverWrites it if it does exist.
	   //LendOutList object to write to the file.
	   //Throws IOException if the write operation failed.
	   
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
	   
	   //Read a LendOutList from the specified file.File must exist
	   //return the object read from the file.
	   
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
