package domain.mediator;


import java.net.Socket;
import java.util.Observable;



public class ClientModelManager extends Observable 
{
	private String what;
	private String title;
	private String type;
	
	public ClientModelManager(String what, String title, String type)
	{
		this.title = title;
		this.type = type;
		this.what = what;
	}
	public ClientModelManager()
	{
		try {
			Socket sock = new Socket("localhost", 6789);
			ClientCommunicationThread sendThread = new ClientCommunicationThread(sock, what, title, type);
			Thread thread = new Thread(sendThread);
			thread.start();
			ClientReceiverThread recieveThread = new ClientReceiverThread(sock);
			Thread thread2 = new Thread(recieveThread);
			thread2.start();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		} 
		
	}
	
}
