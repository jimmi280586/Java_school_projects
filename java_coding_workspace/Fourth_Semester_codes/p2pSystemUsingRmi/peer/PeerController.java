/*
 * 10.02.2015 Original version
 */


package peer;


import common.*;
import model.*;

import java.rmi.*;
import java.rmi.server.*;


public class PeerController
	extends UnicastRemoteObject
	implements PeerInterface
{
	private PeerView view;
	
	private AddressServerInterface adr;
	
	private Peer me;
	private PeerList cache = new PeerList();
	
	
	public PeerController()
		throws RemoteException
	{
	}
	
	
	public void setView( PeerView view )
	{
		this.view = view;
	}
	
	
	public void begin()
	{
		try {
			String alias = view.inputAlias();
			while( alias == null || "".equals( alias ) )
				alias = view.inputAlias();
		
			view.displayAlias( alias );
		
			me = new Peer( alias, this );
		
			adr = (AddressServerInterface) Naming.lookup( "rmi://localhost/" + AddressServerInterface.SERVICE_NAME );
			adr.registerPeer( me );
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}
	
	
	public void send( String toAlias, String text )
	{
		try {
			Peer receiver = findReceiver( toAlias );
		
			if( receiver == null ) {
				view.error( "Could not find " + toAlias );
			
				return;
			}
		
			Message msg = new Message( text, me, receiver );
		
			receiver.getServant().deliverMessage( msg );
		} catch( Exception ex ) {
			ex.printStackTrace();
			
			view.error( "Trouble sending to " + toAlias );
		}
	}
	
	
	private Peer findReceiver( String alias )
		throws RemoteException
	{
		Peer peer = cache.find( alias );
		
		if( peer == null ) {
			peer = adr.findPeer( alias );
			
			if( peer != null )
				cache.add( peer );
		}
		
		return peer;
	}
	
	
	public void deliverMessage( Message message )
		throws RemoteException
	{
		view.println( message.getFrom().getAlias() + ": " + message.getText() );
		
		if( cache.find( message.getFrom().getAlias() ) == null )
			cache.add( message.getFrom() );
	}
}
