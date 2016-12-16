package teacher;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class OutputPhoneBill
{
   public static void main(String[] args) throws Exception
   {
      PhoneBill phoneBill = new PhoneBill("12345678");
      phoneBill.addItem(new PhoneCall("11-02-2014", "87654321", 24, .12));
      phoneBill.addItem(new PhoneCall("11-02-2014", "+44 12121212", 4, .72));
      phoneBill.addItem(new TextMessage("11-02-2014", "87654321", .05, 0));
      // Creating a file we can write to.
      FileOutputStream fos = new FileOutputStream("phonebill.obj");
      // Preparing to write objects to the file.
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      try
      {
         // Writing an object to the file.
         oos.writeObject(phoneBill);
      }
      finally
      {
         // Done with the stream, we need to close it.
         oos.close();
      }
   }
}
