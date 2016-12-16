package test;

import java.util.Scanner;

public class Exercise2
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
         System.out.println("match nr ");
         System.out.println("home team");
         homescore[index] = keyboard.nextInt();
      
         System.out.println("Away team");
         Awayscore[index] = keyboard.nextInt();
      }      
      for (int index = 0; index < Awayscore.length; index++)
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
      keyboard.close();
     }


   }


