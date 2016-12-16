package nimgame;

import java.util.Scanner;

import Heaps.NimArrayMaxHeap;
import exceptions.EmptyCollectionException;

public class Menu
{
   private int rows;
   private NimArrayMaxHeap<Integer> heap;
   private int pins;
   private int index = 0;

   public void run() throws InterruptedException, EmptyCollectionException
   {
      System.out.println("Welcome to my nim game");
      GameFunctions.printStory();
      Thread.sleep(500);

      System.out.println("please enter number of rows");
      @SuppressWarnings("resource")
      Scanner scan = new Scanner(System.in);
      rows = scan.nextInt();
      heap = new NimArrayMaxHeap<Integer>(rows);
      while(index != rows)
      {
      System.out.println("please enter number of pins in row " + (index + 1) );
      pins = scan.nextInt();
      heap.addElement(pins);
      index++;
      }
     System.out.println(heap.toString());
     play(this.heap);
   }


   private void play(NimArrayMaxHeap<Integer> heap2) throws EmptyCollectionException
   {
      GameFunctions test = new GameFunctions(heap2, true, false);
      GameFunctions game;
      if (test.minimax() == 0) game = test;
      else game = new GameFunctions(heap2, false, true);



      while (!game.isGameOver())
          {
         System.out.println(game);

         if (game.isAIoneTurn()){
            int computerMove = game.getAIoneMove();
            game.makeMove(computerMove);
            System.out.println("AIone takes " + computerMove + " pin(s)");
         }
         else{
            int computerMove = game.getAIMove();
            game.makeMove(computerMove);
            System.out.println("AI takes " + computerMove + " pin(s)");
         }
      }

      if (game.AIoneWins()) System.out.println("AIone lost.");

      else System.out.println("AI lost =(");

   }


}
