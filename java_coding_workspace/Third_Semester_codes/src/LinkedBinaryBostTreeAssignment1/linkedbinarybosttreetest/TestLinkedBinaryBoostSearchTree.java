
package linkedbinarybosttreetest;

import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import interfaces.BinaryBostSearchTreeADT;
import interfaces.BinaryBostTreeADT;
import linkedbinarybosttree.LinkedBinaryBostSearchTree;


public class TestLinkedBinaryBoostSearchTree
{
   public static void main( String[] args ) throws ElementNotFoundException, EmptyCollectionException
   {
      new TestLinkedBinaryBoostSearchTree().run();
   }

   private void run() throws ElementNotFoundException, EmptyCollectionException
   {
      BinaryBostTreeADT<Integer> tree = buildTree();

      System.out.println( tree );
      checkContaining(tree);
      printTree(tree);

      tree.ChangeBribe(7, 15);
      tree.ChangeBribe(13, 10);
      tree.ChangeBribe(3, 20);
        printTree(tree);
        System.out.println("Is ordered: " + tree.BribeBalanced());
       System.out.println( "tree hight = " + tree.height() );
       System.out.println( "is the tree balanced = " + tree.isBalanced());
    }

   private void checkContaining(BinaryBostTreeADT<Integer> tree){
        for( int i = 1; i < 20; ++i )
            System.out.println( "contains(" + i + "): " + tree.contains( i ) );

        System.out.println();

    }

    private void printTree(BinaryBostTreeADT<Integer> tree){
        Iterator<Integer> iterator = tree.iteratorLevelOrder();
        System.out.print("Tree in order:");
        while( iterator.hasNext() )
            System.out.print( " " + iterator.next() );
        System.out.println();
    }


   private BinaryBostTreeADT<Integer> buildTree()
   {
      BinaryBostSearchTreeADT<Integer> tree = new LinkedBinaryBostSearchTree<>();

      tree.addElement( 10 );
      tree.addElement( 15 );
      tree.addElement( 13 );
      tree.addElement( 5 );
      tree.addElement( 3 );
      tree.addElement( 7 );

      return tree;
   }
}