package src.system.domain.mediator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Class ServerConnectionThread.
 */
public class ServerConnectionThread implements Runnable {
	Socket clientSocket = null;
	private ServerModelManager model;
	private static String stringFromClient;

	/**
	 * Instantiates a new server connection thread. for receiving information
	 * from client using the socket and buffered reader
	 * 
	 * @param clientSocket
	 *            the client socket
	 * @param model
	 *            the model
	 */
	public ServerConnectionThread(Socket clientSocket, ServerModelManager model) {
		this.clientSocket = clientSocket;
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			while (true) {
				stringFromClient = "";
				System.out.println("Server receiving...");
				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(clientSocket.getInputStream()));
				stringFromClient = inFromClient.readLine();
				System.out.println("Received: " + stringFromClient);

				this.model.setFromClientMessage(stringFromClient);

				if (!stringFromClient.equals(null))
					break;

			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
