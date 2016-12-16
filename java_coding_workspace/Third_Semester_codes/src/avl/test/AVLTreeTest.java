package test;

import tree.AVLTree;

public class AVLTreeTest
{
   private static AVLTree<String> avltree = new AVLTree<>();

   public static void main(String[] args)
   {

      int nbre = 10; // you can change this value

           for(int i = 0; i < nbre; i++)
           {
             for(int j = 0; j < i; j++)
             {
               try
               {
                 if (! check(i, j, false))
                 {
                   System.out.println();
                   System.out.println("fail with check("+i+", "+j+")");

                   check(i, j, true);
                 }
               }
               catch(Exception e)
               {
                 System.out.println();
                 System.err.println("exception with check("+i+", "+j+")");

                 e.printStackTrace();
               }

             }

           }
   }

   public static boolean check(int nbre, int indexToRemove, boolean print)
   {
     AVLTree<Integer> avlTree = new AVLTree<Integer>();

     for(int i = 0; i < nbre; i++)
     {
          avlTree.insert(i);
          System.out.println("insert " + i);
     }

        System.out.println("remove " + indexToRemove);
        avlTree.remove(indexToRemove);

     boolean result = true;

      int count = 0;

     for(int i = 0; i < nbre; i++)
     {
       if (!avlTree.contains(i))
       {
         count++;
         result &= (indexToRemove == i);
         if (print)
           System.out.println(i + " not present");
       }

     }

     return count == 1 && result;

   }


}
