/*
 * 09.02.2015 Original version
 */


package model;


import java.io.*;

import common.*;


public class Peer
	implements Serializable
{
	private String alias;
	private PeerInterface servant;
	
	
	public Peer( String alias, PeerInterface servant )
	{
		this.alias = alias;
		this.servant = servant;
	}
	
	
	public String getAlias()
	{
		return alias;
	}
	
	
	public PeerInterface getServant()
	{
		return servant;
	}
}
