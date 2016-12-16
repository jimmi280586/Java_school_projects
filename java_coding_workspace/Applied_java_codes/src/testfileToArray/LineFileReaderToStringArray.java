package testfileToArray;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LineFileReaderToStringArray 
{
	private String path;
	
	public LineFileReaderToStringArray(String file_path)
	{
		this.path = file_path;
	}
	
	public String[] OpenFile() throws IOException
	{
		FileReader fr = new FileReader(this.path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
	
		for(int i = 0; i < numberOfLines; i++ )
		{
			textData[i] = textReader.readLine();
		}
		
		textReader.close();
		return textData;
		
	}
	
	public int readLines() throws IOException
	{
		FileReader file_to_read = new FileReader(this.path);
		BufferedReader bf = new BufferedReader(file_to_read);
		
		String aLine;
		int numberOfLines = 0;
		
		while ((aLine = bf.readLine()) != null)
		{
			numberOfLines++;
		}
		
		bf.close();
		
		return numberOfLines;
	}
}
