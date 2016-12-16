
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


// A customerlistFile represents a file for reading or writing 
public class CustomerListFile implements Serializable
{

   

private String  filename;
   
   //Constructs a new customerlistFile 
   
   public CustomerListFile(String filename)
   {
      this.filename = filename;
   }
   
   //Write a customerList to the specified file.Create the file if it doesn't exist
   //OverWrites it if it does exist.
   //CustomerList object to write to the file.
   //Throws IOException if the write operation failed.
   
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
   
   //Read a customerList from the specified file.File must exist
   //return the object read from the file.
   
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


  

   


