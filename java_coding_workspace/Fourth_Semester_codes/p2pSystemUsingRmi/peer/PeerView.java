/*
 * 10.02.2015 Original version
 */


package peer;


public interface PeerView
{
	public void println( String text );
	
	public String inputAlias();
	
	public void displayAlias( String alias );
	
	public void error( String text );
}
