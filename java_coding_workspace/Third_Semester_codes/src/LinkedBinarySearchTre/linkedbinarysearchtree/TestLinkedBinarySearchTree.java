/*
 * 27.03.2014 Misspelling fixed
 * 25.09.2011 Original version
 */

package linkedbinarysearchtree;


import java.util.Iterator;

import interfaces.BinarySearchTreeADT;
import linked.binary.search.tree.LinkedBinarySearchTree;


public class TestLinkedBinarySearchTree
{
	public static void main( String[] args )
	{
		new TestLinkedBinarySearchTree().run();
	}


	private void run()
	{
		BinarySearchTreeADT<Integer> tree = buildTree();

		System.out.println( tree );

		for( int i = 1; i < 20; ++i )
			System.out.println( "contains(" + i + "): " + tree.contains( i ) );

		Iterator<Integer> iterator = tree.iteratorLevelOrder();

		while( iterator.hasNext() )
			System.out.print( " " + iterator.next() );

		System.out.println();
	}


	private BinarySearchTreeADT<Integer> buildTree()
	{
		BinarySearchTreeADT<Integer> tree = new LinkedBinarySearchTree<Integer>();

		tree.addElement( 10 );
		tree.addElement( 15 );
		tree.addElement( 13 );
		tree.addElement( 5 );
		tree.addElement( 3 );
		tree.addElement( 7 );

		return tree;
	}
}