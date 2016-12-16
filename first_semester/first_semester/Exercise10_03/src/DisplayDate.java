import java.util.Scanner;


public class DisplayDate
{

  public static void Display()
  {
    MyDate me = new MyDate(); 
      
     
    Scanner keyboard = new Scanner(System.in);
    System.out.println("input day");
    int a = keyboard.nextInt();
    System.out.println("input month");
    int b = keyboard.nextInt();
    System.out.println("input year");
    int c = keyboard.nextInt();
    
    me.setday(a);
     me.setmonth(b);
     me.setyear(c);
      
      
      
 System.out.println("date of birth " + me.getday() + "/" + me.getmonth() + "/" + me.getyear() );
   
   }

}
