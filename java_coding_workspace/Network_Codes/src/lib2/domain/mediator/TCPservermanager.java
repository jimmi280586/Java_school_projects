package lib2.domain.mediator;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPservermanager
{
	public void StartServer() throws Exception
	{
		String clientSentence;
		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		
		while(true)
		{
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient =
					new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			System.out.println("Received: " + clientSentence);
			
			TranslationThread t = new TranslationThread(clientSentence);
			
			capitalizedSentence = t.getReturnMessage() + '\n';
			System.out.println(capitalizedSentence);
			outToClient.writeBytes(capitalizedSentence);
		}
	}
}
