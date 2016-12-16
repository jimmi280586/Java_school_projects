/**
 * 16.02.2016 New structure
 * 18.09.2011 Original version
 */

package linkedbinarytree;


import java.util.Iterator;

import linked.binary.tree.LinkedBinaryTree;
import interfaces.LinkedBinarysearchTreeADT;


public class TestLinkedBinaryTree
{
	public static void main( String[] args )
	{
		new TestLinkedBinaryTree().run();
	}


	private void run()
	{
		test( buildTree() );
		test( buildTree2() );
	}


	private void test( LinkedBinarysearchTreeADT<String> tree )
	{
		System.out.println( "size: " + tree.size() );
		System.out.println( "isEmpty: " + tree.isEmpty() );
		System.out.println( "contains: " + tree.contains( "A" ) );
		System.out.println( "contains: " + tree.contains( "X" ) );
		System.out.println( "contains: " + tree.contains( "N" ) );
		System.out.println( "toString: " + tree );
		System.out.println( "height: " + tree.height() );
		System.out.println( "isFull: " + tree.isFull() );
		System.out.println( "isBalanced: " + tree.isBalanced() );

		printTraversal( "Pre:  ", tree.iteratorPreOrder() );
		printTraversal( "In:   ", tree.iteratorInOrder() );
		printTraversal( "Post: ", tree.iteratorPostOrder() );
		printTraversal( "Level:", tree.iteratorLevelOrder() );

		System.out.println( "---" );
	}


	private LinkedBinaryTree<String> buildTree()
	{
		LinkedBinaryTree<String> lTree = new LinkedBinaryTree<String>( "L" );
		LinkedBinaryTree<String> mTree = new LinkedBinaryTree<String>( "M" );
		LinkedBinaryTree<String> nTree = new LinkedBinaryTree<String>( "N" );
		LinkedBinaryTree<String> oTree = new LinkedBinaryTree<String>( "O" );
		LinkedBinaryTree<String> pTree = new LinkedBinaryTree<String>( "P" );

		LinkedBinaryTree<String> gTree = new LinkedBinaryTree<String>( "G" );
		LinkedBinaryTree<String> hTree = new LinkedBinaryTree<String>( "H", lTree, mTree );
		LinkedBinaryTree<String> iTree = new LinkedBinaryTree<String>( "I" );
		LinkedBinaryTree<String> jTree = new LinkedBinaryTree<String>( "J", nTree, null );
		LinkedBinaryTree<String> kTree = new LinkedBinaryTree<String>( "K", oTree, pTree );

		LinkedBinaryTree<String> dTree = new LinkedBinaryTree<String>( "D", gTree, hTree );
		LinkedBinaryTree<String> eTree = new LinkedBinaryTree<String>( "E", iTree, null );
		LinkedBinaryTree<String> fTree = new LinkedBinaryTree<String>( "F", jTree, kTree );

		LinkedBinaryTree<String> bTree = new LinkedBinaryTree<String>( "B", dTree, eTree );
		LinkedBinaryTree<String> cTree = new LinkedBinaryTree<String>( "C", null, fTree );

		linked.binary.tree.LinkedBinaryTree<String> aTree = new LinkedBinaryTree<String>( "A", bTree, cTree );

		return aTree;
	}


	private LinkedBinaryTree<String> buildTree2()
	{
		LinkedBinaryTree<String> dTree = new LinkedBinaryTree<String>( "D" );
		LinkedBinaryTree<String> eTree = new LinkedBinaryTree<String>( "E" );
		LinkedBinaryTree<String> fTree = new LinkedBinaryTree<String>( "F" );
		LinkedBinaryTree<String> gTree = new LinkedBinaryTree<String>( "G" );

		LinkedBinaryTree<String> bTree = new LinkedBinaryTree<String>( "B", dTree, eTree );
		LinkedBinaryTree<String> cTree = new LinkedBinaryTree<String>( "C", fTree, gTree );

		LinkedBinaryTree<String> aTree = new LinkedBinaryTree<String>( "A", bTree, cTree );

		return aTree;
	}


	private void printTraversal( String text, Iterator<String> iterator )
	{
		System.out.print( text );

		while( iterator.hasNext() )
			System.out.print( " " + iterator.next() );

		System.out.println();
	}
}