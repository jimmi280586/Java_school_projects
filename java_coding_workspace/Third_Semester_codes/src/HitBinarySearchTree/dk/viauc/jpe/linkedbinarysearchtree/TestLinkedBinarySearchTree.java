/*
 * 27.03.2014 Misspelling fixed
 * 25.09.2011 Original version
 */

package dk.viauc.jpe.linkedbinarysearchtree;


import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import jss2.BinaryHitTree;
import jss2.BinaryHitTreeADT;


public class TestLinkedBinarySearchTree
{
	public static void main( String[] args )
	{
		try {
			new TestLinkedBinarySearchTree().run();
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyCollectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void run() throws ElementNotFoundException, EmptyCollectionException
	{
		BinaryHitTreeADT<Integer> tree = buildTree();

		System.out.println( tree );
		checkContaining(tree);
		printTree(tree);
        System.out.println("Searching several numbers in the list for several times should change the order");
		searchNumber(10, 5, tree);
		searchNumber(7, 7, tree);
		searchNumber(5, 8, tree);
        searchNumber(10, 5, tree);
        printTree(tree);
        System.out.println("Is ordered: " + tree.isHitCountBalanced());
    }

    private void searchNumber(Integer number, int times, BinaryHitTreeADT<Integer> tree) throws ElementNotFoundException, EmptyCollectionException{
        for (int i=0; i<times; i++){
            tree.find(number);
        }
    }

    private void checkContaining(BinaryHitTreeADT<Integer> tree){
        for( int i = 1; i < 20; ++i )
            System.out.println( "contains(" + i + "): " + tree.contains( i ) );

        System.out.println();

    }

    private void printTree(BinaryHitTreeADT<Integer> tree) throws EmptyCollectionException{
        Iterator<Integer> iterator = tree.iteratorLevelOrder();
        System.out.print("Tree in order:");
        while( iterator.hasNext() )
            System.out.print( " " + iterator.next() );
        System.out.println();
    }


	private BinaryHitTreeADT<Integer> buildTree()
	{
		BinaryHitTreeADT<Integer> tree = new BinaryHitTree<>();

		tree.addElement( 10 );
		tree.addElement( 15 );
		tree.addElement( 13 );
		tree.addElement( 5 );
		tree.addElement( 3 );
		tree.addElement( 7 );

		return tree;
	}

}