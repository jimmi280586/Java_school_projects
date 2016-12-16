/**
 * 02.02.2016 Now using reworked data structures
 * 23.08.2011 Original version
 */

package stacks;

import arrayStack.ArrayStack;
import exceptions.EmptyCollectionException;
import linkedStack.LinkedStack;
import stackInterface.StackADT;

public class Stacks
{
	public static void main( String[] args )
	{
		new Stacks().run();
	}


	private void run()
	{
		example1();
		example2();
		example3();
		example4();
	}


	private void example1()
	{
		try {
			StackADT<String> s1 = new ArrayStack<String>();

			System.out.println( "size(): " + s1.size() );
			System.out.println( "isEmpty(): " + s1.isEmpty() );

			s1.push( "one" );
			s1.push( "two" );
			s1.push( "three" );

			System.out.println( "size(): " + s1.size() );
			System.out.println( "isEmpty(): " + s1.isEmpty() );

			System.out.println( "peek(): " + s1.peek() );

			while( !s1.isEmpty() )
				System.out.println( "pop(): " + s1.pop() );

			try {
				s1.pop();
			} catch( EmptyCollectionException ex ) {
				System.out.println( "pop on empty stack" );
			}

			System.out.println( "---" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}


	private void example2()
	{
		try {
			StackADT<String> s2 = new LinkedStack<String>();

			System.out.println( "size(): " + s2.size() );
			System.out.println( "isEmpty(): " + s2.isEmpty() );

			s2.push( "one" );
			s2.push( "two" );
			s2.push( "three" );

			System.out.println( "size(): " + s2.size() );
			System.out.println( "isEmpty(): " + s2.isEmpty() );

			System.out.println( "peek(): " + s2.peek() );

			while( !s2.isEmpty() )
				System.out.println( "pop(): " + s2.pop() );

			try {
				s2.pop();
			} catch( EmptyCollectionException ex ) {
				System.out.println( "pop on empty stack" );
			}

			System.out.println( "---" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}


	private void example3()
	{
		System.out.println( reverse( "January" ) );
		System.out.println( reverse( "February" ) );
		System.out.println( reverse( "March" ) );
		System.out.println( reverse( "April" ) );

		System.out.println( "---" );
	}


	private String reverse( String str )
	{
		try {
			StackADT<Character> stack = new ArrayStack<Character>();

			for( int i = 0; i < str.length(); ++i )
				stack.push( str.charAt(i) );

			String res = "";
			while( !stack.isEmpty() )
				res += stack.pop();

			return res;
		} catch( Exception ex ) {
			ex.printStackTrace();

			return null;
		}
	}


	private void example4()
	{
		StackADT<Integer> s4 = StackFactory.createStack( 10 );
		System.out.println( s4.getClass() );

		s4.push( 4711 );

		StackADT<Boolean> s5 = StackFactory.createStack( 100 );
		System.out.println( s5.getClass() );

		s5.push( true );

		System.out.println( "---" );
	}
}