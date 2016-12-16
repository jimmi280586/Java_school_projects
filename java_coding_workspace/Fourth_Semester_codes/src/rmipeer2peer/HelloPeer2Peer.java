package rmipeer2peer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.ReceiveMessageInterface;

public class HelloPeer2Peer 
	 extends UnicastRemoteObject implements ReceiveMessageInterface    
	{       
	
	private static final long serialVersionUID = -4919108724185150928L;

	public HelloPeer2Peer() throws RemoteException    
	   {    
	      super();    
	   }    
	   
		@Override
		public String receiveMessage(String x) throws RemoteException {
			
			 System.out.println(x);
		     String message = "Sever got what you said"; 
		     return message; 
			
		}    
	} 

