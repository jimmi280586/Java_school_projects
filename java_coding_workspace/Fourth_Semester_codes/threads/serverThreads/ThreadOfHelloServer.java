package serverThreads;

import interfaces.ReceiveMessageInterface;
import rmipeer2peer.HelloPeer2Peer;

import java.rmi.Naming;    
import java.rmi.registry.LocateRegistry;   

public class ThreadOfHelloServer implements Runnable   
{    
   public void run()    
   {    
      try   
      {
         LocateRegistry.createRegistry(1099);    
         ReceiveMessageInterface hello = new HelloPeer2Peer();    
         Naming.rebind("Hello", hello);    
         //Naming.rebind("//" + Inet4Address.getLocalHost().getHostAddress() + ":80/" + "Hello",hello);    
            
         System.out.println("Hello Server is ready.");    
      }    
      catch (Exception e)    
      {    
         System.out.println("Hello Server failed: " + e);    
      }    
   }    
   
   public static void main(String [] args)    
   {    
	 new ThreadOfHelloServer().run();
   } 
}   



