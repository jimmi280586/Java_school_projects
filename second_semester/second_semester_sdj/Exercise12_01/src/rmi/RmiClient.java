package rmi;

import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RmiClient implements Serializable {

  private static final long serialVersionUID = -9154321877613063471L;

  private ServerInterface server;

  public RmiClient() throws RemoteException {
    super();
    try {
      server = (ServerInterface) Naming.lookup("rmi://localhost:1099/addMessage");

      boolean keepGoing = true;
      String message;
      Scanner userInput = new Scanner(System.in);
      while (keepGoing) {
        System.out.println("Input message: ");
        message = userInput.nextLine();
        if (message.equalsIgnoreCase("quit")) {
          keepGoing = false;
        } else {
          server.addMessage(message);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws RemoteException {
    RmiClient client = new RmiClient();
  }


}
