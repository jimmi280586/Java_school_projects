import java.util.Random;
import java.util.Scanner;


public class DiceGame
{
	
	
	public static void main(String[] args)
	   {
	      int NUMBER_OF_SIDES;
	      int dice1;
	      int dice2;
	      int p1 = 0;
	      int p2 = 0;
	      int turn = 1;
	      Random rand = new Random();
	      int goaul = 60;
		  String player1;
		  String player2;
		  
	      MoreInterestingGame more = new MoreInterestingGame();
	     
	      Scanner kb1 = new Scanner(System.in);
	      Scanner kb = new Scanner(System.in);
	      
	      System.out.println("input player one : ");
	      player1 = kb1.nextLine();
	      
	      System.out.println("input player two : ");
	      player2 =kb1.nextLine();  
	      
	      System.out.println("Specify number of sides: ");
	      NUMBER_OF_SIDES = kb.nextInt();
	     
	     
	      boolean b = true;
		while(b  == true)
	      {
	         System.out.println("Turn " + turn);
	         
	         
	         if(p1==goaul)
	         {
	            System.out.println(player1 + " has won!");
	            break;
	         }
	         if(p1<goaul)
	         {
	            dice1 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            dice2 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            p1 = p1+roll(dice1, dice2);
	            System.out.println(player1 + " has rolled: " + dice1 + " " + dice2);
	            System.out.println(player1 + ": " + p1);
	         }
	                  
	         if(p2==goaul)
	         {
	            System.out.println(player2 + " has won!");
	            break;
	         }
	         if(p2<goaul)
	         {
	            dice1 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            dice2 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            p2 = p2 + roll(dice1, dice2);
	            System.out.println(player2 + " has rolled: " + dice1 + " " + dice2);
	            System.out.println(player2 + ": " + p2);
	         }
	         if(p1>goaul && p2>goaul)
	         {
	            System.out.println("Draw");
	            System.out.println("Do you want to continue the game type yes or no");
	            String next = kb1.nextLine();
	            if(next.equalsIgnoreCase("yes"))
	            {
	            	more.interesting(goaul, player1, player2, NUMBER_OF_SIDES, p1, p2, turn);
	            	break;
	            }
	            
	            	System.out.println("Game Over thanks for playing");
	            	break;
	            
	         }
	         turn++;
	      }
	      
	   }
	   private static int roll(int d1, int d2)
	   {
	      return d1+d2;
	   }
	
}
