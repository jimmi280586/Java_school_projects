package chat.domain.mediator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import chat.domain.model.AbstractMessage;
import chat.domain.model.PublicMessage;

public class Proxy implements ModelInterface
{
	private static int PORT = 2112;
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

		ClientReceiverThread receiver = new ClientReceiverThread(inFromServer,
				model, inFromServer);

		receiver.start();

	}

	public void login() throws ParserConfigurationException,
			TransformerException
	{
		PublicMessage pmsg = new PublicMessage(0, "Alice", "login");
		MessageXmlWriter writer = new MessageXmlWriter();
		String msgXml = writer.toXml(pmsg, false);
		outToServer.println(msgXml);
	}

	public void logout() throws TransformerException,
			ParserConfigurationException
	{
		PublicMessage pmsg = new PublicMessage(0, "Alice", "logout");
		MessageXmlWriter writer = new MessageXmlWriter();
		String msgXml = writer.toXml(pmsg, false);
		outToServer.println(msgXml);
	}

	public void add(AbstractMessage message) throws TransformerException,
			ParserConfigurationException
	{
		MessageXmlWriter writer = new MessageXmlWriter();
		String msgXml = writer.toXml(message, false);
		writer.toXml(message, "mulishani?");
		outToServer.println(msgXml);
	}

}
