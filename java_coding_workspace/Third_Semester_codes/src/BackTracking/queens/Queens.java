/*
 * 26.03.2014 Domain changed
 * 14.11.2011 Original version
 */

package queens;


public class Queens
{
	public static void main( String[] args )
	{
		new Queens().run();
	}


	private int[] row;

	private boolean[] rowUsed;
	private boolean[] upRightUsed;
	private boolean[] downRightUsed;

	private int solutions = 0;


	public void run()
	{
		solveNQueens( 8 );
	}


	public void solveNQueens( int N )
	{
		row = new int[N];

		rowUsed = new boolean[N];
		upRightUsed = new boolean[2*N-1];
		downRightUsed = new boolean[2*N-1];

		solutions = 0;

		placeInCol( 0 );

		System.out.println( "" + solutions + " solutions" );
	}


	private void placeInCol( int col )
	{
		if( col >= row.length )
			printSolution( row );
		else
			for( int r = 0; r < row.length; ++r ) {
				int ur = col + r;
				int dr = row.length - 1 - r + col;

				if( !rowUsed[r] && !upRightUsed[ur] && !downRightUsed[dr] ) {
					row[col] = r;

					rowUsed[r] = true;
					upRightUsed[ur] = true;
					downRightUsed[dr] = true;

					placeInCol( col + 1 );

					rowUsed[r] = false;
					upRightUsed[ur] = false;
					downRightUsed[dr] = false;
				}
			}
	}


	private void printSolution( int[] row )
	{
		if( row.length <= 10 ) {
			for( int r = 0; r < row.length; ++r ) {
				for( int c = 0; c < row.length; ++c )
					System.out.print( r == row[c] ? 'Q' : '.' );

				System.out.println();
			}

			System.out.println();
		}

		++solutions;
	}
}