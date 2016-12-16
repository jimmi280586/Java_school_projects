/*
 * 09.02.2015 Original version
 */


package model;


import java.util.*;


public class PeerList
{
	private TreeMap< String, Peer > list = new TreeMap< String, Peer >();
	
	
	public boolean exists( Peer peer )
	{
		return list.containsKey( peer.getAlias() );
	}
	
	
	public void add( Peer peer )
	{
		list.put( peer.getAlias(), peer );
	}
	
	
	public Peer find( String alias )
	{
		return list.get( alias );
	}
}
