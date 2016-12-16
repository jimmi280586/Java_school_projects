

import java.util.Scanner;

	public class GenderTest
{
	
	public static void main(String[] args)
{
	
   Scanner input = new Scanner(System.in);
   System.out.print("Type gender (M or F): ");
   String line = input.nextLine();
   char gender = line.charAt(0);
   System.out.println("what is your age");        
   int age = input.nextInt();
   if (gender == 'M')
{
   if (age >= 18)
      System.out.print("Man");
   else
      System.out.print("boy");    
}
   else
{
   if (age >= 18)
      System.out.print("woman");
   else
      System.out.print("girl");    
}

}
}