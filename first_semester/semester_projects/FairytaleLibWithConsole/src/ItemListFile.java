
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//ItemlistFile represents a file for reading or writing
public class ItemListFile implements Serializable
{

   private String filename;

   // Constructs a new ItemlistFile

   public ItemListFile(String filename)
   {
      this.filename = filename;
   }

   // Write an ItemList to the specified file.Create the file if it doesn't
   // exist
   // OverWrites it if it does exist.
   // ItemList object to write to the file.
   // Throws IOException if the write operation failed.

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

   // Read an ItemList from the specified file.File must exist
   // return the object read from the file.

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
