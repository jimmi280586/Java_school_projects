package soduko;

public class Cell
{
   protected int row;
   protected int col;

   public Cell (int row, int col)
   {
      this.row = row;
      this.col = col;
   }

   @Override
public String toString()
   {
      return "Cell [row = " + row + ", col = " + col + "]";
   }
}
