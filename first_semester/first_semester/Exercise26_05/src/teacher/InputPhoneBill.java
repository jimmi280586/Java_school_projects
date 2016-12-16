package teacher;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class InputPhoneBill
{
   public static void main(String[] args) throws Exception
   {
      // Opening the file for reading 
      FileInputStream fis = new FileInputStream("phonebill.obj");
      // Preparing to read objects from the file.
      ObjectInputStream ois = new ObjectInputStream(fis);
      try {
         // Reading the PhoneBill from the file. 
         // Note that we need to cast, or it would be an Object. 
         PhoneBill phoneBill = (PhoneBill) ois.readObject();
         for(int i = 0; i < phoneBill.getNumberOfItems(); i++)
         {
            System.out.println(phoneBill.getItem(i));
         }
      }
      finally 
      {
         // Done with the file we need to close it.
         ois.close();
      }
   }
}
