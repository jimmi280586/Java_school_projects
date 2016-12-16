import java.util.Scanner;


public class AreaArrays
{

   public static void main(String[] args)
   {
     // user input of the arrays size implementet by number of areas
      Scanner keyboard = new Scanner(System.in);
      System.out.println("input number of areas");
      int n = keyboard.nextInt();
     // creates an array          
     Rectangle[] rec = new Rectangle[n];
     
     for (int i = 0; i < rec.length; i++)
     {
        //use this in the for loop as it creates an object every time
        rec[i] = new Rectangle();
        
        // gets the input for the object from keyboard
        rec[i].setWidth(keyboard.nextDouble());
        rec[i].setHeight(keyboard.nextDouble());
              
     }
     
     
     for (int i = 0; i < rec.length; i++)
     {
        
        // prints number of the object plus one as you start at zero
        int count = (i + 1);
       
        // prints out the area and the number of the object
        System.out.println("area of rectangle " + count + " is");
        System.out.println(rec[i].getArea());            
       
        
     }
     
     
   }

}
