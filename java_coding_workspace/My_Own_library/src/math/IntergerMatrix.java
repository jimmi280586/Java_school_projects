// ***************************************************
// File name  : MatrixIntOp.java
// Start date : 2015
// Programmer : Hans So.
// Java       : Java 1.7 
// Description: 
// ***************************************************

package math;

public class IntergerMatrix
{
  private IntergerMatrix() { }

  // Addition: A + B
  // Precondition: A and B have the same dimensions (m-by-n)
  public static int[][] add (int[][] A, int[][] B)
  {
    int m = A.length;
    int n = A[0].length;
    int[][] C = new int[m][n];

    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++)
        C[i][j] = A[i][j] + B[i][j];

    return C;
  }

  // Subtraction: A - B
  public static int[][] subtract (int[][] A, int[][] B)
  {
	  int m = A.length;
	    int n = A[0].length;
	    int[][] C = new int[m][n];

	    for (int i = 0; i < m; i++)
	      for (int j = 0; j < n; j++)
	        C[i][j] = A[i][j] - B[i][j];

	    return C;
  }

  // Scalar multiplication: cA
  public static int[][] multiply (int c, int[][] A)
  {
	  int m = A.length;
	    int n = A[0].length;
	    int[][] C = new int[m][n];

	    for (int i = 0; i < m; i++)
	      for (int j = 0; j < n; j++)
	        C[i][j] = A[i][j] * c;

	    return C;
	  
  }

  // Matrix multiplication: AB
  // Precondition: A (m-by-n), B (n-by-p)
  // Postcondition: AB (m-by-p)
  public static int[][] multiply (int[][] A, int[][] B)
  {
	    int p = B[0].length;
	    int m = A.length;
	    int n = A[0].length;
	    int[][] C = new int[m][n];

	    for (int i = 0; i < m; i++)
	    	for (int j = 0; j < p; j++)
	    	for (int r = 0; r < n; r++)
	    	C[i][j] += A[i][r] * B[r][j];
	        

	    return C;
  }

  /**
   * asString can be called in this way:
   *   System.out.println (MatrixOp.asString(A));
   */
  public static String asString (int[][] A)
  {
    int m = A.length;
    int n = A[0].length;

    StringBuffer buf = new StringBuffer ();

    for (int i = 0; i < m; i++)
    {
      for (int j = 0; j < n; j++)
      {
        buf.append(A[i][j]);
        buf.append('\t');
      }
      buf.append('\n');
    }

    return buf.toString();
  }


  public static void main (String[] args)
  {
    int[][] A = { { 1, 0, 2},
                  {-1, 3, 1}
                };

    int[][] B = { { 3, 1},
                  { 2, 1},
                  { 1, 0}
                };
   
    int[][] F = { { 3, 1,2},
            { 2, 1,5}
           
          };
    
    int[][] C = multiply(A, B);
    
    int[][] D = multiply(2, A);
    
    int[][] E = subtract(A, F);
    
    int[][] G = add(A, F);
    
    System.out.println (IntergerMatrix.asString(A) + "matrix A");
    System.out.println (IntergerMatrix.asString(B) + "matrix B");
    System.out.println (IntergerMatrix.asString(F) + "matrix F");
    System.out.println(IntergerMatrix.asString(C) + "multyply matrix A and B");
    System.out.println(IntergerMatrix.asString(D) + "multyply constant to matrix A");
    System.out.println(IntergerMatrix.asString(E) + "subtract matrix A and F");
    System.out.println(IntergerMatrix.asString(G) + "add matrix A and F");
  }
}
