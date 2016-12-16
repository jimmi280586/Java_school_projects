/*
 * 09.02.2015 Original version
 */





import java.rmi.*;
import java.rmi.registry.LocateRegistry;

import common.*;
import server.*;


public class P2PAddressServer
{
	public static void main( String[] args )
	{
		try {
			AddressServerController controller = new AddressServerController();
			AddressServerView view = new AddressServerFrame( controller );
		
			controller.setView( view );
			
			LocateRegistry.createRegistry( 1099 );
			
			Naming.rebind( AddressServerInterface.SERVICE_NAME, controller );
			
			view.println( "Address Server is running" );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
}
