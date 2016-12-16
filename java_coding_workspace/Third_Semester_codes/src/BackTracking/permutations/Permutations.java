/*
 * 26.03.2014 domain change
 * 07.11.2011 Original version
 */

package permutations;


public class Permutations
{
	public static void main( String[] args )
	{
		new Permutations().run();
	}


	private void run()
	{
		permute( new String[]{ "A", "B", "C", "D" } );
	}


	private void permute( String[] s )
	{
		String[] result = new String[ s.length ];
		boolean used[] = new boolean[ s.length ];

		permute( 0, s, used, result );
	}


	private void permute( int pos, String[] s, boolean used[], String[] res )
	{
		if( pos == res.length ) {
			System.out.print( res[0] );
			for( int i = 1; i < res.length; ++i )
				System.out.print( " " + res[i] );
			System.out.println();
		} else {
			for( int i = 0; i < used.length; ++i )
				if( !used[i] ) {
					used[i] = true;
					res[pos] = s[i];

					permute( pos + 1, s, used, res );

					used[i] = false;
				}
		}
	}
}