package lib2.domain.mediator;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class TCPClientManager implements interfaceManager
{
	public TCPClientManager() throws Exception
	{
		
	}

	public TCPClientManager(int choice) throws Exception
	{
		
	}
	
	public void sendToServer(String message) throws Exception
	{
		String sentence;
		String modifiedSentence;
		
		
		Socket clientSocket = new Socket("localhost", 6789);
		//put main menu here
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		sentence = message;
		outToServer.writeBytes(sentence + '\n');
		System.out.println("message send");
		modifiedSentence = inFromServer.readLine();
		
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}

	@Override
	public void ClientManager(int choice) throws Exception
	{
		System.out.println("now here");
		InformationThread t = new InformationThread(choice);
		
		String message = t.getMessage();
		sendToServer(message);
		
	}

}
