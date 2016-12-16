package file.reader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class BinaryFileReader 
{
	private String filename;
	
	public BinaryFileReader(String filename)
	{
		this.filename = filename;
	}
	 public ArrayList<Object> read() throws IOException
	   {
		 
	      FileInputStream fis = new FileInputStream(this.filename);
	      ObjectInputStream ois = new ObjectInputStream(fis);
	      
	      try
	      {
	         ArrayList<Object> input = (ArrayList<Object>) 
	         ois.readObject();
	         return input;
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
