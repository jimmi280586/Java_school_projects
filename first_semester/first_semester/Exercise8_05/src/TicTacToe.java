import java.util.Scanner;
public class TicTacToe
{
public static void main(String[] args)
{
// Create a non-functional tic-tac-toe board
// I'm creating it with user input
Scanner key = new Scanner(System.in);
// Create 3x3 board
char[][] board = new char[3][3];
// Get values
// Go through the rows
for (int i = 0; i < board.length; i++)
{
// Then set the values in each row
for (int j = 0; j < board[i].length; j++)
{
System.out.println("Give me an O or an X for row: " + (i+1) + ", column: " + (j+1));
System.out.println("Type any key for a blank space");
String choice = key.nextLine();
// All keys that aren't o or O or x or X default to blank space
if (choice.toUpperCase().charAt(0) != 'O' && choice.toUpperCase().charAt(0) != 'X')
{
board[i][j] = ' ';
}
else
{
board[i][j] = choice.toUpperCase().charAt(0);
}
}
}
// Print out the array
// This loops through each row
for (int i = 0; i < board.length; i++)
{
System.out.printf(" %c | %c | %c %n", board[i][0], board[i][1], board[i][2]); // Probably shouldn't hard code the values
// Print a line after all but the last row
if (i < (board.length -1))
System.out.println("-----------");
}
}
}
