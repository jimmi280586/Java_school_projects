import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PhoneBillFile
{
	private String fileName;
	
	public PhoneBillFile(String fileName)
	{
		this.fileName = fileName;
	}
	
	public void WritePhoneBill(PhoneBill bill) throws IOException
	{
		FileOutputStream fos = new FileOutputStream("phonebill.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		try
		{
			oos.writeObject(bill);
		}
		finally
		{
			oos.close();
		}
	}
	
	public PhoneBill readPhoneBill() throws IOException
	{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		try
		{
			PhoneBill phoneBill = (PhoneBill) ois.readObject();
			return phoneBill;
		} 
		catch (ClassNotFoundException e)
		{
			throw new IOException(e);
		} 
		finally
		{
			ois.close();
		}	
	}
}
