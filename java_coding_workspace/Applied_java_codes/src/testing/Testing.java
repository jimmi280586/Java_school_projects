package testing;

import java.io.IOException;


public class Testing {

	public static void main(String[] args) throws IOException
	{
		WordFileReaderToStringArray ar = new WordFileReaderToStringArray();
		Generic_Sorting_Arrays<String> sort = new Generic_Sorting_Arrays<>();
		
		String[] file = ar.wordsFormTextFile();
		sort.insertionSort(file);
		sort.printArray(file);
		
	}

}
