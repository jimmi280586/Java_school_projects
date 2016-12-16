package teacher;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ListSave
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      try {
         System.out.println("Type filename: ");
         String name = keyboard.nextLine();
         // Creates and opens a file for writing:
         FileOutputStream os = 
                new FileOutputStream(name);
         // Prepare to print text to the file.
         PrintWriter out = new PrintWriter(os);
         try 
         {
            System.out.println("Type name of friend: ");
            String friendName = keyboard.nextLine();
            while(!friendName.equals("DONE")) {
               out.println(friendName);
               System.out.println("Type name of friend: ");
               friendName = keyboard.nextLine();
            }
         }
         finally // Means: always do this.
         {
             out.close();
         }
     } catch (FileNotFoundException e) {
         System.out.println("No file");
     }
      keyboard.close();
   }
}
