import java.util.Random;
import java.util.Scanner;


public class MoreInterestingGame
{
	private int NUMBER_OF_SIDES;
	private int dice1;
	private int dice2;
	private int p1;
	private int p2;
	private int turn;
	private Random rand;

	private String player1;
	private String player2;
	
	public MoreInterestingGame()
	{
				
	}
	
	public void interesting(int goaul1, String player1, String player2, int sides, int p1, int p2, int turn)
	   {  
			int goaul = goaul1 * 10;
			this.player1 = player1;
			this.player2 = player2;
			this.NUMBER_OF_SIDES = sides + 6;
			this.p1 = p1;
			this.p2 = p2;
			this.turn = turn;
			this.rand = new Random();
			
			Scanner kb = new Scanner(System.in);
			System.out.println("Game continues with sides of dice = 24 and goaul = " + goaul);
	      
	      while(true)
	      {
	         System.out.println("Turn " + this.turn);
	         
	         
	         if(this.p1==goaul)
	         {
	            System.out.println(player1 + " has won!");
	            break;
	         }
	         if(this.p1<goaul)
	         {
	            dice1 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            dice2 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            this.p1 = this.p1+roll(dice1, dice2);
	            System.out.println(player1 + " has rolled: " + dice1 + " " + dice2);
	            System.out.println(player1 + ": " + this.p1);
	         }
	                  
	         if(this.p2==goaul)
	         {
	            System.out.println(player2 + " has won!");
	            break;
	         }
	         if(this.p2<goaul)
	         {
	            dice1 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            dice2 = rand.nextInt(NUMBER_OF_SIDES-1 + 1) + 1;
	            this.p2 = this.p2 + roll(dice1, dice2);
	            System.out.println(player2 + " has rolled: " + dice1 + " " + dice2);
	            System.out.println(player2 + ": " + this.p2);
	         }
	         if(this.p1>goaul && this.p2>goaul)
	         {
	            System.out.println("Draw");
	            System.out.println("Do you want to continue the game type yes or no");
	            String next = kb.nextLine();
	            if(next.equalsIgnoreCase("yes"))
	            {
	            	interesting(goaul, player1, player2, NUMBER_OF_SIDES, this.p1, this.p2, this.turn);
	            	break;
	            }
	            
	            	System.out.println("Game Over thanks for playing");
	            	break;
	            
	            
	         }
	         this.turn++;
	      }
	      
	   }
	   private static int roll(int d1, int d2)
	   {
	      return d1+d2;
	   }
}
