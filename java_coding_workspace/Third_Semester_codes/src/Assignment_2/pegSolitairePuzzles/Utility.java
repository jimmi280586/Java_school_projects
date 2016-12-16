package pegSolitairePuzzles;

public class Utility
{
   protected final String[] DIRECTIONS = { "UP", "RIGHT", "DOWN", "LEFT" };
   protected int pegs;
   protected int height;
   protected int length;
   protected char[][] board;
   private Solver solv = new Solver(this);

   public Utility()
   {
      Board board = new Board();
      this.pegs = board.getPegs();
      this.height = board.getHeight();
      this.length = board.getLength();
      this.board = board.getBoard();
   }

   public int[][] setMove(int row, int col, String direction)
   {
      int[][] move = new int[3][2];
      move[0][0] = row;
      move[0][1] = col;

      switch (direction)
      {

         case "UP":
            move[1][0] = row + 1;
            move[1][1] = col;
            move[2][0] = row + 2;
            move[2][1] = col;
            break;

         case "LEFT":
            move[1][0] = row;
            move[1][1] = col - 1;
            move[2][0] = row;
            move[2][1] = col - 2;
            break;

         case "RIGHT":
            move[1][0] = row;
            move[1][1] = col + 1;
            move[2][0] = row;
            move[2][1] = col + 2;
            break;

         case "DOWN":
            move[1][0] = row - 1;
            move[1][1] = col;
            move[2][0] = row - 2;
            move[2][1] = col;
            break;

         default:

            break;
      }

      return move;
   }

   public void makeMove(int[][] move)
   {
      board[move[0][0]][move[0][1]] = '.';
      board[move[1][0]][move[1][1]] = '.';
      board[move[2][0]][move[2][1]] = 'o';

      pegs--;
   }

   public void undo(int[][] move)
   {
      // System.out.println("undo");

      board[move[0][0]][move[0][1]] = 'o';
      board[move[1][0]][move[1][1]] = 'o';
      board[move[2][0]][move[2][1]] = '.';

      pegs++;
   }

   public boolean legalMove(int[][] move)
   {

      if (move[2][0] >= 7 || move[2][1] >= 7 || move[2][0] < 0
            || move[2][1] < 0)
         return false;

      return (board[move[0][0]][move[0][1]] == 'o')
            && (board[move[1][0]][move[1][1]] == 'o')
            && (board[move[2][0]][move[2][1]] == '.');
   }

   public void printBoard()
   {

      for (int i = 0; i < height; i++)
      {
         for (int j = 0; j < length; j++)
         {
            System.out.print(board[i][j] + " ");
         }

         System.out.println();
      }

      System.out.println();

   }

   protected void run()
   {
      printBoard();

      System.out.println("Solving... ");

      if (!solv.findSolution())
         System.out.println("\nSolution was not found!");

   }
}
