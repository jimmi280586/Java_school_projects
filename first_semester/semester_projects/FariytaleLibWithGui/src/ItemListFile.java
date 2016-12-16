

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The purpose of this class is to write and read binary files from the library. This one handles the itemList.
 *
 */
public class ItemListFile implements Serializable
{
	
   private String filename;
   /**
    * Constructor for setting the filename to field
   	* @param filename
    */
   public ItemListFile(String filename)
   {
	  
      this.filename = filename;
   }

 
   /**
    * Writes an itemList to the specified file. Creates the file if it doesn't exist
    * and overwrites it if it does.
    * @param items is the itemlist.
    * @throws IOException is thrown if the system failed to write to a file.
    */
   public void writeItemList(ItemList items) throws IOException
   {
	 
      FileOutputStream file = new FileOutputStream("itemslist.obj");
      ObjectOutputStream out = new ObjectOutputStream(file);

      try
      {
         out.writeObject(items);
      }
      finally
      {
         out.close();
      }

   }

   /**
    * Reads a list of items from the specified file. The file must exist.
    * @return returns the binary file.
    * @throws IOException Throws an exception if the file does not exist.
    */
   public ItemList readItemList() throws IOException
   {
	  
      FileInputStream fis = new FileInputStream(filename);
      ObjectInputStream ois = new ObjectInputStream(fis);
      
      try
      {
         ItemList items = (ItemList) ois.readObject();
         return items;
      }

      catch (ClassNotFoundException e)
      {
    	
         throw new ClassCastException(e.getMessage());
      }
      finally
      {
         ois.close();
      }
   }

}
