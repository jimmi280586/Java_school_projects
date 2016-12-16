package soduko;

import java.util.ArrayList;

public class Tester
{
   private static int N = 9;

   private static int grid[][] = { { 5, 3, 0, 0, 7, 0, 0, 0, 0 }, //
         { 6, 0, 0, 1, 9, 5, 0, 0, 0 }, //
         { 0, 9, 8, 0, 0, 0, 0, 6, 0 }, //
         { 8, 0, 0, 0, 6, 0, 0, 0, 3 }, //
         { 4, 0, 0, 8, 0, 3, 0, 0, 1 }, //
         { 7, 0, 0, 0, 2, 0, 0, 0, 6 }, //
         { 0, 6, 0, 0, 0, 0, 2, 8, 0 }, //
         { 0, 0, 0, 4, 1, 9, 0, 0, 5 }, //
         { 0, 0, 0, 0, 8, 0, 0, 7, 9 } };



   public static void main(String[] args)
   {
      Solver s = new Solver(grid, N);
      boolean solved = s.solve(new Cell(0, 0));
      if (!solved) {
       System.out.println("SUDOKU cannot be solved.");
       return;
      }
      System.out.println("SOLUTION\n");
      printGrid(grid);
     }

     // utility to print the grid
     static void printGrid(int grid[][])
     {
        ArrayList<String> list = new ArrayList<>();
        String rows = "";
      for (int row = 0; row < N; row++)
      {
       for (int col = 0; col < N; col++)
       {
        rows += grid[row][col] + " ";
       if(col == 2 || col == 5)
       {
          rows += "| ";
       }
       }
       list.add(rows);
       rows = "";
      }

      for (int i = 0; i < list.size(); i++)
      {

         if (i == 2 || i == 5)
         {
            System.out.println(list.get(i));
            System.out.println("----------------------");
         }
         else
            {
               System.out.println(list.get(i));
            }
      }
     }

}
