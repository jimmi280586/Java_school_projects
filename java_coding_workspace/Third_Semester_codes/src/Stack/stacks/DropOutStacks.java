/*
 * 23.08.2011 Original version
 */

package stacks;

import dropOutLinkedStack.DropLinkedStack;
import dropOutStack.DropArrayStack;
import exceptions.EmptyCollectionException;
import stackInterface.StackADT;

public class DropOutStacks
{
   public static void main( String[] args ) throws EmptyCollectionException
   {
      new DropOutStacks().run();
   }

   private void run() throws EmptyCollectionException
   {
      example1();
      example2();
   }

   private void example1() throws EmptyCollectionException
   {
      StackADT<String> s1 = new DropArrayStack<String>( 3 );

      s1.push( "one" );
      s1.push( "two" );
      s1.push( "three" );
      s1.push( "four" );

      System.out.println( "size=" + s1.size() );

      while( !s1.isEmpty() )
         System.out.println( "pop: " + s1.pop() );

      System.out.println( "---" );
   }

   private void example2() throws EmptyCollectionException
   {
      StackADT<String> s2 = new DropLinkedStack<String>( 3 );

      s2.push( "one" );
      s2.push( "two" );
      s2.push( "three" );
      s2.push( "four" );

      System.out.println( "size=" + s2.size() );

      while( !s2.isEmpty() )
         System.out.println( "pop: " + s2.pop() );

      System.out.println( "---" );
   }
}