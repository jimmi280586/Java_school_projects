package src.system.domain.mediator;

import java.io.DataOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * The Class ServerCommunicationThread.
 */
public class ServerCommunicationThread extends Thread {
	Socket clientSock = null;
	private String message;
	private String returnString;
	private ServerDatabaseReciver model = new ServerDatabaseReciver();

	/**
	 * Instantiates a new server communication thread for translating the
	 * information from the client and uses it to get the information from the
	 * database and relays to the client.
	 *
	 * @param clientSock
	 *            the client sock
	 * @param message
	 *            the message
	 */
	public ServerCommunicationThread(Socket clientSock, String message) {
		this.clientSock = clientSock;
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			while (true) {
				System.out.println("Server sending...");
				DataOutputStream outToClient = new DataOutputStream(
						clientSock.getOutputStream());
				// ---------------------------------------------------------------------/
				this.returnString = model.execute(this.message);
				System.out.println(this.message);
				// -------------------------------------------------------------------/
				outToClient.writeBytes(returnString + '\n');
				System.out.println("Sent: " + returnString);

				if (!returnString.equals(null))
					break;

			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
