package testfileToArray;
// *****************************************************************************
// File name  : FileReader.java
// Start date : Mar 24, 2012
// Programmer : Hans So.
// Java       : Java 1.6.0 
// Description: 
//
// Revision history:
//   date     init  comment
//
// *****************************************************************************



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordFileReaderToStringArray
{ 
  public static String[] readFile(String fileName)
  {
    ArrayList<String> wordList = new ArrayList<String>();
    String[] result = null;
    BufferedReader input;
    try
    {
      input = new BufferedReader(new FileReader(fileName));
      
      // delimeter is "space"
      char [] parse = {' '};
      String delims = new String(parse);
   
      // read first line
      String line = input.readLine();
   
      // read line while not end of file
      while(line != null)
      {
        String [] lineWords = line.split(delims);
   
        // add the words to the list
        for (int i = 0; i < lineWords.length; i++) 
        {
          wordList.add(lineWords[i]);                                
        }
        // read next line
        line = input.readLine();
      }
      input.close();
      
      result = new String[wordList.size()];
      wordList.toArray(result);
      
    }
    catch (FileNotFoundException e)
    {      
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    return result;
  }
  
  public static String[] wordsFormTextFile() throws IOException 
  {
   
    String[] result = 
      readFile("D:\\src\\applied_Java_Programming\\Textfile_To_Array\\Bible.txt");
    System.out.println ("#Words: " + result.length);
	return result; 
  }
}
