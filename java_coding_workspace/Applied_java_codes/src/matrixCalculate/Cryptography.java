// ***************************************************
// File name  : Cryptography.java
// Start date : 2014
// Programmer : Hans So.
// Java       : Java 1.7
// Description: Application to Cryptography
//              http://aix1.uottawa.ca/~jkhoury/cryptography.htm
// ***************************************************

package matrixCalculate;

public final class Cryptography
{
  private Cryptography() { }

  public static int[] stringToArray (String message)
  {	  
	  String mes1 = message.toUpperCase();
	  String[] mes = new String[mes1.length()];
	  int[] result = new int[mes.length];
	 
	  for (int i = 0; i < message.length(); i++)
	  {			  
		char letter = mes1.charAt(i);		
		mes[i] = "" + letter;
		result[i] = getAlphabetNumber(mes[i]);
	  }
	
	return result;
  }
/**
 * calculates letters to the integer of the alphabet
 * @param c
 * @return interger acording to number in the alphabet
 */
  private static int getAlphabetNumber(String c)
  {	
	  String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "*", " "};
	  int r = -1;
	  for(int i = 0; i < alphabet.length; i++)
	  {
		  if(c.equals(alphabet[i]))
		  {			  
			  r = i+1;
		  }
		  if(r == 28)
		  {
			  r = 27;
		  }
	  }
	return r;
  }

// vectorSize means number of rows im matrix
  public static int[][] arrayToUncodedMatrix (int[] arr, int vectorSize)
  { 
	  int rows = vectorSize;
	  int cols = arr.length/vectorSize;
	  if (arr.length%vectorSize > 0)
		  cols ++;
	  int[][] c = new int[rows][cols];
	  
		int i = 0, j = 0;
		for(int k = 0; k < arr.length; k++)
		{
			c[i][j] = arr[k];
			i++;
			if (i == rows)
			{
				i = 0;
				j++;
			}
		}
		return c;

  }

  public static int[][] encodeMatrix (int[][] encodingMatrix, int[][] uncodedMatrix)
  {
	  return MatrixIntOp.multiply(encodingMatrix, uncodedMatrix) ;
  }

  public static int[][] decodeMatrix (int[][] decodingMatrix, int[][] codedMatrix)
  {
	  return MatrixIntOp.multiply(decodingMatrix, codedMatrix);
  }

  public static int[] matrixToArray (int[][] matrix)
  {
	  int[] c = new int[matrix.length*matrix[0].length];
	  int c0 = 0;
		for(int i = 0; i<matrix.length;i++){
			for(int k = 0;k<matrix[0].length;k++){
					c[c0] = matrix[i][k]; 
					c0++;
			}
		}
	  
    return c;
  }

  public static String arrayToString (int[] arr)
  {
	  String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "*", " "};
	  String result = "";
	  for (int i = 0; i < arr.length; i++) 
	  {
		result += "" + alphabet[arr[i]-1] + " ";
	  }
    return "[ " + result + "]";
  }

  public static void main (String[] args)
  {
    int[][] A = {{ -3, -3, -4},
                 {  0,  1,  1},
                 {  4,  3,  4}
                };

    int[][] inverseA = {{  1,  0,  1},
                        {  4,  4,  3},
                        { -4, -3, -3}
                       };

    int[][] B = {{ 3, 5},
                 { 1, 2}
                };

    int[][] inverseB = {{  2, -5},
                        { -1,  3}
                       };

    // Show that A and inverseA really are inverse to each other.
    // The same for B and inverseB.

    // Use both A and B as examples of encoding matrices


    // Some messages:
    String message1 = "AABBCCC";
    String message2 = "Help me";
    String message3 = "PREPARE TO NEGOTIATE";
   System.out.println(arrayToString(stringToArray(message3)));
    // int[] C = stringToArray(message3);
  //  System.out.println("" + C.length);
 //   System.out.println(message3.charAt(5-1));
 

   int[] test = new int[message3.length()];
   test = stringToArray(message3);
   //int[][] test2 = encodeMatrix(A, arrayToUncodedMatrix(test, 3)); 
  System.out.println(arrayToUncodedMatrix(stringToArray(message3), 3));
  // int[][] test4 = decodeMatrix(inverseA, test2);
  // int[] test3 = matrixToArray(test4);
  // System.out.println(arrayToString(test3));
	

  }

}
