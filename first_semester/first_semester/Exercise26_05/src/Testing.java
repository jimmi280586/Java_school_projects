import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Testing {

	public static void main(String[] args) throws IOException 
	{
		PhoneBill phonebill = new PhoneBill("79413131");
		phonebill.addItem(new PhoneCall("06/11/14", "85215235", 6, 2.2));
		phonebill.addItem(new PhoneCall("03/11/14", "83543531", 4, 2.2));
		phonebill.addItem(new PhoneCall("10/11/14", "83543531", 3, 2.4));
		FileOutputStream fos = new FileOutputStream("phonebill");
		ObjectOutputStream oss = new ObjectOutputStream(fos);
		
		try
		{
			
		}
		finally
		{
			oss.close();
		}
	}

}
