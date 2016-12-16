/*
 * 26.03.2014 domain change
 * 07.11.2011 Original version
 */

package maze;


public class MazeSolver
{
	public static void main( String[] args )
	{
		new MazeSolver().run();
	}


	private char[][] maze =
	{
		{ '*', '*', '*', '*', '*', '*', '*', '*', '*' },
		{ '*', ' ', ' ', ' ', '*', ' ', ' ', ' ', '*' },
		{ '*', ' ', '*', ' ', '*', '*', ' ', '*', '*' },
		{ '*', ' ', '*', '*', '*', ' ', ' ', ' ', '*' },
		{ '*', ' ', ' ', ' ', ' ', ' ', '*', ' ', '*' },
		{ '*', '*', '*', '*', '*', '*', '*', '*', '*' },
	};

	private int endRow = maze.length - 2;
	private int endCol = maze[endRow].length - 2;


	private void run()
	{
		printMaze();

		tryPosition( 1, 1 );
	}


	private void tryPosition( int row, int col )
	{
		if( row == endRow && col == endCol ) {
			maze[row][col] = '#';

			printMaze();
		} else if( maze[row][col] == ' ' ) {
			maze[row][col] = '#';

			tryPosition( row - 1, col ); // up
			tryPosition( row, col + 1 ); // right
			tryPosition( row + 1, col ); // down
			tryPosition( row, col - 1 ); // left

			maze[row][col] = '.';
		}
	}


	private void printMaze()
	{
		for( int i = 0; i < maze.length; ++i ) {
			for( int j = 0; j < maze[i].length; ++j )
				System.out.print( maze[i][j] );
			System.out.println();
		}
		System.out.println();
	}
}