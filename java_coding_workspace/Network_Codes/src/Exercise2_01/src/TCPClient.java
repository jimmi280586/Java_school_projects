package Exercise2_01.src;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class TCPClient {

	public static void main(String argv[]) throws Exception
	{
		int sentence;
		double modifiedSentence;
		
		//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		//sentence = inFromUser.read();
		outToServer.writeInt(1);
		modifiedSentence = inFromServer.read();
		
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}

}
