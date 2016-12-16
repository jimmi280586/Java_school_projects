/*
 * 09.02.2015 Original version
 */


package common;


import java.rmi.*;


import model.*;


public interface PeerInterface
	extends Remote
{
	public void deliverMessage( Message message ) throws RemoteException;
}
