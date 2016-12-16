package file.creator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BinaryFileCreator 
{
	private String filename;
	
	public BinaryFileCreator(String filename)
	{
		this.filename = filename;
	}
	  public void write(ArrayList<Object>  input) throws IOException
	   {
		
	      FileOutputStream file = new FileOutputStream(filename);
	      ObjectOutputStream out = new ObjectOutputStream(file);
	   
	   try
	   {		   
	      out.writeObject(input);
	   }
	   finally
	   {
	      out.close();
	   }
	   
	   }
}
