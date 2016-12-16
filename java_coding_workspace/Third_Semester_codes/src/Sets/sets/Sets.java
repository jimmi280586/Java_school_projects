/**
 * 06.02.2016 Original version
 */


package sets;


import interfaces.SetADT;
import linkedSet.LinkedSet;


public class Sets
{
	public static void main( String[] args )
	{
		new Sets().run();
	}


	private void run()
	{
		try {
			SetADT<Integer> s1 = new LinkedSet<Integer>();

			s1.add( 4711 );
			s1.add( 42 );
			s1.add( 7 );
			s1.add( 9 );
			s1.add( 13 );

			System.out.println( "Members:" + s1 );
			System.out.println( "Remove: " + s1.remove( 7 ) );
			System.out.println( "Remove: " + s1.removeRandom() );
			System.out.println( "Members:" + s1 );

			SetADT<Integer> s2 = new LinkedSet<Integer>();
			s2.add( 7 );
			s2.add( 22 );
			s2.add( 9 );
			s2.add( 18 );
			s2.add( 13 );

			SetADT<Integer> s3 = s1.union( s2 );
			System.out.println( "Members:" + s2 );
			System.out.println( "Members:" + s3 );

			SetADT<Integer> s4 = new LinkedSet<Integer>();
			s4.add( 9 );
			s4.add( 13 );
			s4.add( 7 );
			s4.add( 22 );
			s4.add( 18 );

			System.out.println( "Equals: " + s2.equals( s4 ) );

			for( int i: s3 )
				System.out.println( "Member: " + i );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
