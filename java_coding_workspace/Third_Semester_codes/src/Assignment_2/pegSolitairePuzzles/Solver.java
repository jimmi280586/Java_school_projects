package pegSolitairePuzzles;

public class Solver
{
   private Utility util;

   public Solver(Utility util)
   {
      this.util = util;
   };

   public boolean findSolution()
   {

      if (util.pegs == 1 && util.board[3][3] == 'o')
      {
         System.out.println("Done!");
         util.printBoard();
         return true;
      }
      else
      {
         for (int i = 0; i < util.length; i++)
            for (int j = 0; j < util.height; j++)
               for (int k = 0; k < util.DIRECTIONS.length; k++)
               {
                  int[][] move = util.setMove(j, i, util.DIRECTIONS[k]);
                  if (util.legalMove(move))
                  {
                     util.makeMove(move);

                     // printBoard();

                     if (findSolution())
                        return true;

                     util.undo(move);
                  }
               }

         return false;
      }
   }

}
