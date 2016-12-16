package clientThreads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.rmi.Naming;

import interfaces.ReceiveMessageInterface;

public class ThreadOfHelloClient implements Runnable{

	public void run(){
		try   
		{    
		   ReceiveMessageInterface hello = (ReceiveMessageInterface) Naming.lookup("Hello");    
		   //HelloInterface hello = (HelloInterface)Naming.lookup("//" + Inet4Address.getLocalHost().getHostAddress() + ":80/" + "Hello");    
		   
		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   String said;
		   while((said=br.readLine())!=null){      
		   System.out.println(hello.receiveMessage(said));
		   }
		}    
		catch (Exception e)    
		{    
		   System.out.println("HelloClient exception: " + e);    
		}       
	}

public static void main(String [] args){
	new ThreadOfHelloClient().run();
	}
}
