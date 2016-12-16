

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * The purpose of this class is to write and read binary files from the library. This one handles the customerList.
 *
 */
public class CustomerListFile implements Serializable
{
	
   

	private String  filename;
   
  
	/**
	   * constructor for setting the filename to field
	   * @param filename
	   */
   public CustomerListFile(String filename)
   {
	  
      this.filename = filename;
   }
   
  
   /**
    * Writes a customerList to the specified file. Creates the file if it doesn't exist
    * and overwrites it if it does.
    * @param customers is the customerList.
    * @throws IOException is thrown if the system failed to write to a file.
    */
   public void writeCustomerList(CustomerList  customers) throws IOException
   {
	  
      FileOutputStream file = new FileOutputStream(filename);
      ObjectOutputStream out = new ObjectOutputStream(file);
   
   try
   {
      out.writeObject(customers);
   }
   finally
   {
      out.close();
   }
   
   }
   /**
    * Reads a customerList from the specified file. The file must exist
    * or the system will throw an exception.
    * @return returns the binary file.
    * @throws IOException thrown if the file does not exist.
    */
   public CustomerList readCustomerList() throws IOException
   {
	 
      FileInputStream fis = new FileInputStream("customerlist.obj");
      ObjectInputStream ois = new ObjectInputStream(fis);
      
      try
      {
         CustomerList customers = (CustomerList) 
        		 ois.readObject();
         return customers;
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


  

   


