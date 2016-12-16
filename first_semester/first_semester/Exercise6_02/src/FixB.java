import java.util.Scanner;


public class FixB
{

  

  

   public static void main(String[] args)
   {
      
      Scanner keyboard = new Scanner(System.in);
      java.util.Random random = new java.util.Random();
     String answer;
  
     do
      {
         
         int randomNumber = random.nextInt(1000);
         System.out.println(randomNumber);
         System.out.println("continue?");
         answer = keyboard.nextLine();
      
      } while (!answer.equals("no") && !answer.equals("No"));

   }

}

