package teacher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListOpen
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      try {
         System.out.println("Type a filename: ");
         String name = keyboard.nextLine();
         FileInputStream is = 
                 new FileInputStream(name);
         Scanner in = new Scanner(is);
         // Read from in using readInt(), 
         // readDouble(), readLine() and so on.
         try {
            while (in.hasNext()) {
                String l = in.nextLine();
                System.out.println(l);
            }
        } finally {
            in.close();
        }
     } catch (FileNotFoundException e) {
         System.out.println("No file");
     }

   }
}
