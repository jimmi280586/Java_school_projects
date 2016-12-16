/*
 * 09.02.2015 Original version
 */


package common;


import java.rmi.*;

import model.*;

public interface AddressServerInterface
	extends Remote
{
	public boolean registerPeer( Peer peer ) throws RemoteException;
	
	public Peer findPeer( String alias ) throws RemoteException;
	
	
	public static final String SERVICE_NAME = "p2padr";
}
