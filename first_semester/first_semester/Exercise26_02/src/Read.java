import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Read {

	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner(System.in);
		
		try {
			
			System.out.println("what file do you want");
			String name = keyboard.nextLine();
			
			
			FileInputStream is = new FileInputStream(name);
			Scanner in = new Scanner(is);
			try
			{
				String line = in.nextLine();
				int number = in.nextInt();
				
				while (in.hasNext())
				{
					String l = in.nextLine();
					System.out.println(l);
				}
			}
			finally
			{
				in.close();
			}
		
			} 
			catch (FileNotFoundException e) 
			
			{
			System.out.println("No file");
			}
		keyboard.close();
	}

}
