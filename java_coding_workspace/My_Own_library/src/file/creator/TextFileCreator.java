package file.creator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileCreator
{
private String filename;
	
	public TextFileCreator(String filename)
	{
		this.filename = filename;
	}
	public static void writeText(String content)
	{
	try
	{	

		File file = new File("/users/mkyong/filename.txt");

		// if file doesnt exists, then create it
		if (!file.exists()) 
		{
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		bw.close();

		System.out.println("Done");

	}
	catch (IOException e)
	{
		e.printStackTrace();
	}
	}

}
