package pegSolitairePuzzles;

public class Board
{
   private char[][] board = { { ' ', ' ', 'o', 'o', 'o', ' ', ' ' },
         { ' ', ' ', 'o', 'o', 'o', ' ', ' ' },
         { 'o', 'o', 'o', 'o', 'o', 'o', 'o' },
         { 'o', 'o', 'o', '.', 'o', 'o', 'o' },
         { 'o', 'o', 'o', 'o', 'o', 'o', 'o' },
         { ' ', ' ', 'o', 'o', 'o', ' ', ' ' },
         { ' ', ' ', 'o', 'o', 'o', ' ', ' ' } };

   private int height = board.length;
   private int length = board[height - 1].length;
   private int pegs = 32;

   public Board()
   {

   }

   public char[][] getBoard()
   {
      return this.board;
   }

   public int getHeight()
   {
      return this.height;
   }

   public int getLength()
   {
      return this.length;
   }

   public int getPegs()
   {
      return this.pegs;
   }
}
