package rmipeer2peer;

import clientThreads.ThreadOfHelloClient;
import serverThreads.ThreadOfHelloServer;

public class ServerPeer2PeerStart{
	
	   public static void main(String[] argv)
	   {    
	      try   
	      {
	    	 ThreadOfHelloServer ths = new ThreadOfHelloServer();
	    	 Thread ts = new Thread(ths);

	    	 ThreadOfHelloClient thc = new ThreadOfHelloClient();
	         Thread tc = new Thread(thc);
	         
	         ts.start();
	         ts.join();
	         tc.start();

	      }    
	      catch (Exception e)    
	      {    
	         System.out.println("Server failed, " + e);    
	      }    
	   }    
	}   