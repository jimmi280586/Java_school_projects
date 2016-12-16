import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class WriteToFile 
{

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("type name of file");
		String name = keyboard.nextLine();
		System.out.println("type name of friends");
		System.out.println("when done type DONE");
		
	try{
			FileOutputStream os = new FileOutputStream(name);
			PrintWriter out = new PrintWriter(os);
			try
			{
				boolean type = false;	
				while (type == false) 
				{
			
				String name1 = keyboard.nextLine();
			
				if(name1.equals("DONE"))
				{
					type = true;
				}
				else
				{
					out.println("name of friend: " + name1);
				}
			
				}
			}
			finally
			{
			out.close();
			}
		}
	catch ( FileNotFoundException e)
	{
		System.out.println("no file");
	}
	keyboard.close();
	}

}
