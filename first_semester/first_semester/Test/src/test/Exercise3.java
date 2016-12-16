package test;

import java.util.Scanner;

public class Exercise3
{

   public static void main(String[] args)
   {
      
            
            int matches = 6; // how many matches
            int[] homescore; 
            int[] Awayscore;
            
            Scanner keyboard = new Scanner(System.in);
           
            homescore = new int[matches];
            Awayscore = new int[matches];
            
            for (int index = 0; index < matches; index++)
            {
               System.out.println("match nr " + (index + 1));
               System.out.println("home team");
               homescore[index] = keyboard.nextInt();
            
               System.out.println("Away team");
               Awayscore[index] = keyboard.nextInt();
            }      
            System.out.println("pools coupon:");
            
            for (int index = 0; index < Awayscore.length; index++)
            {
            
            	int nr = (index + 1);
            System.out.println("match " + (nr));
            {
            if (homescore[index] == Awayscore[index])
            {
               System.out.println("result is x");
            }
            if (homescore[index] < Awayscore[index])
            {
               System.out.println("result is 2");
            }
            if (homescore[index] > Awayscore[index])
            {
               System.out.println("result is 1");
            }
         
            }
           }
keyboard.close();

   }

   }


