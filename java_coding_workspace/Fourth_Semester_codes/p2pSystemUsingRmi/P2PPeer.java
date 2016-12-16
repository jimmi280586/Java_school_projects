/*
 * 09.02.2015 Original version
 */




import peer.*;


public class P2PPeer
{
	public static void main( String[] args )
	{
		try {
			PeerController controller = new PeerController();
			PeerView view = new PeerFrame( controller );
	
			controller.setView( view );
			controller.begin();
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
