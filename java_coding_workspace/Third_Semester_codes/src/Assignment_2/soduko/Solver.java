package soduko;

public class Solver
{
   protected int N;
   protected int[][] grid;
   private Utility utility;

   public Solver(int[][] grid, int N)
   {
      this.grid = grid;
      this.N = N;
      this.utility = new Utility(this.grid);
   }


// everything is put together here
 // very simple solution
 // must return true, if the soduku is solved, return false otherwise
 public boolean solve(Cell cur) {

  // if the cell is null, we have reached the end
  if (cur == null)
   return true;

  // if grid[cur] already has a value, there is nothing to solve here,
  // continue on to next cell
  if (grid[cur.row][cur.col] != 0) {
   // return whatever is being returned by solve(next)
   // i.e the state of soduku's solution is not being determined by
   // this cell, but by other cells
   return solve(utility.getNextCell(cur));
  }

  // this is where each possible value is being assigned to the cell, and
  // checked if a solutions could be arrived at.

  // if grid[cur] doesn't have a value
  // try each possible value
  for (int i = 1; i <= 9; i++) {
   // check if valid, if valid, then update
   boolean valid = utility.isValid(cur, i);

   if (!valid) // i not valid for this cell, try other values
    continue;

   // assign here
   grid[cur.row][cur.col] = i;

   // continue with next cell
   boolean solved = solve(utility.getNextCell(cur));
   // if solved, return, else try other values
   if (solved)
    return true;
   else
    grid[cur.row][cur.col] = 0; // reset
   // continue with other possible values
  }

  // if you reach here, then no value from 1 - 9 for this cell can solve
  // return false
  return false;
}
}
