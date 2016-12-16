package chat.domain.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.annotation.processing.Messager;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import chat.domain.model.AbstractMessage;
import chat.domain.model.PublicMessage;

public class Proxy implements ModelInterface
{
	private static int PORT = 3333;
	private static String HOST = "localhost";

	private Socket clientSocket;
	private PrintWriter outToServer;
	private BufferedReader inFromServer;
	private int id;

	public Proxy(ClientModelManager model) throws UnknownHostException,
			IOException
	{
		clientSocket = new Socket(HOST, PORT);
		outToServer = new PrintWriter(clientSocket.getOutputStream(), true);

		inFromServer = new BufferedReader(new InputStreamReader(
				clientSocket.getInputStream()));

		ClientReceiverThread receiver = new ClientReceiverThread(
				model, inFromServer);

		receiver.start();

	}

	public void login() throws ParserConfigurationException,
			TransformerException
	{
		PublicMessage pmsg = new PublicMessage(0, "jimmi", "login");
		
		outToServer.println(pmsg + "false");
	}

	public void logout() throws TransformerException,
			ParserConfigurationException
	{
		PublicMessage pmsg = new PublicMessage(0, "jimmi", "logout");
		
		outToServer.println(pmsg + "false");
	}

	public void add(AbstractMessage message) throws TransformerException,
			ParserConfigurationException
	{
		
		outToServer.println(message + "false");
	}

}
