package nimgame;

import Heaps.NimArrayMaxHeap;
import exceptions.EmptyCollectionException;

public class GameFunctions implements Cloneable
{
   private int pinsLeft;
   private boolean AIoneTurn;
   private boolean AITurn;
   private NimArrayMaxHeap<Integer> node;
   private int[] board;
   private int count = 0;

   public GameFunctions(NimArrayMaxHeap<Integer> heap2 , boolean t, boolean s) throws EmptyCollectionException
   {
      node = heap2;
      board = new int[node.size()];
      for (int i = 0; i < node.size(); i++)
      {
        board[i] = node.findMax();
        count  += board[i];
      }
      pinsLeft = count;
      AIoneTurn = t;
      AITurn = s;

   }

   public static void printStory()
   {
      System.out.println("\nTHE RULES OF NIM: ");
      System.out.println("The game starts with the user entering the number of rows in the game.");
      System.out.println("The user then enter how many pins in each row.");
      System.out.println("The computer takes 1 or all pins from one row picked at random.");
      System.out.println("The game continues until there are no buttons left.");
      System.out.println("Whoever takes the final pin lose.");

   }

   @Override
public Object clone()
   {
      try {
         return super.clone();
      }
      catch (CloneNotSupportedException cantHappen)
      {
         System.err.println("NimModel.clone: caught an unexpected exception");
         cantHappen.printStackTrace(System.err);
         System.exit(1);
         return null;
          }
       }

    public void makeMove(int pinsToTake)
    {
      pinsLeft = pinsLeft - pinsToTake;
      AIoneTurn = !AIoneTurn;
      AITurn = !AITurn;
    }

    public boolean isAIoneTurn()
    {
      return AIoneTurn;
    }

    public boolean isAITurn()
    {
       return AITurn;
     }

    public boolean isGameOver()
    {
       return (pinsLeft == 0);
    }

    public boolean isLegalMove(int pinsToTake)
    {
      return (pinsToTake > 0 && pinsToTake <= 3 && pinsToTake <= pinsLeft);
    }

    public boolean AIoneWins()
    {
       return (pinsLeft == 0 && !AIoneTurn);
    }

    public int minimaxone()
    {

       if(isGameOver())
       {
          if (AITurn) return 1;
          else return 0;
       }
       else
       {
          if(AITurn)
          {
             int max = 0;
             for(int b = 0; b <= pinsLeft; b++ ) if(isLegalMove(b))
             {
                GameFunctions AI  = (GameFunctions)clone();
                AI.makeMove(b);
                max = Math.max(max, AI.minimax());
             }
             return max;
          }

          else
          {
             int min = 1;
             for(int b = 0; b <= pinsLeft; b++) if(isLegalMove(b))
             {
                GameFunctions AI = (GameFunctions)clone();
                AI.makeMove(b);
                min = Math.min(min, AI.minimax());
             }
             return min;
          }
       }
    }

    public int minimax()
    {

       if(isGameOver())
       {
          if (AIoneTurn) return 0;
          else return 1;
       }
       else
       {
          if(AIoneTurn)
          {
             int max = 0;
             for(int b = 0; b <= pinsLeft; b++ ) if(isLegalMove(b))
             {
                GameFunctions AI  = (GameFunctions)clone();
                AI.makeMove(b);
                max = Math.max(max, AI.minimax());
             }
             return max;
          }

          else
          {
             int min = 1;
             for(int b = 0; b <= pinsLeft; b++) if(isLegalMove(b))
             {
                GameFunctions AI = (GameFunctions)clone();
                AI.makeMove(b);
                min = Math.min(min, AI.minimax());
             }
             return min;
          }
       }
    }

    public int getAIMove()
    {

      for (int b = 0; b <= pinsLeft; b++) if (isLegalMove(b))
      {

            GameFunctions AI = (GameFunctions)clone();
             AI.makeMove(b);
             if (AI.minimax() == 0)
            return b;
       }
      int b = 0;
      while (!isLegalMove(b)) b++;
      return b;
    }

    public int getAIoneMove()
    {

       for (int b = 0; b <= pinsLeft; b++) if (isLegalMove(b))
       {

             GameFunctions AI = (GameFunctions)clone();
              AI.makeMove(b);
              if (AI.minimaxone() == 0)
             return b;
        }
       int b = 0;
       while (!isLegalMove(b)) b++;
       return b;
     }

    @Override
	public String toString()
    {

      StringBuffer result = new StringBuffer();

      for (int i = 0; i < pinsLeft; i++)
          result.append('*');

      return result.toString();
    }



}
