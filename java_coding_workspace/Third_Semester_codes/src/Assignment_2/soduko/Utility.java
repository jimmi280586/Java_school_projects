package soduko;

public class Utility
{
   private int[][] grid;
   public Utility(int[][] grid)
   {
      this.grid = grid;
   }

   public boolean isValid(Cell cell, int value) {

      if (grid[cell.row][cell.col] != 0) {
       throw new RuntimeException(
         "Cannot call for cell which already has a value");
      }

      // if v present row, return false
      for (int c = 0; c < 9; c++) {
       if (grid[cell.row][c] == value)
        return false;
      }

      // if v present in col, return false
      for (int r = 0; r < 9; r++) {
       if (grid[r][cell.col] == value)
        return false;
      }

      // if v present in grid, return false

      // to get the grid we should calculate (x1,y1) (x2,y2)
      int x1 = 3 * (cell.row / 3);
      int y1 = 3 * (cell.col / 3);
      int x2 = x1 + 2;
      int y2 = y1 + 2;

      for (int x = x1; x <= x2; x++)
       for (int y = y1; y <= y2; y++)
        if (grid[x][y] == value)
         return false;

      // if value not present in row, col and bounding box, return true
      return true;
     }

   // simple function to get the next cell
   // read for yourself, very simple and straight forward
   public Cell getNextCell(Cell cur) {

    int row = cur.row;
    int col = cur.col;

    // next cell => col++
    col++;

    // if col > 8, then col = 0, row++
    // reached end of row, got to next row
    if (col > 8) {
     // goto next line
     col = 0;
     row++;
    }

    // reached end of matrix, return null
    if (row > 8)
     return null; // reached end

    Cell next = new Cell(row, col);
    return next;
   }

}
