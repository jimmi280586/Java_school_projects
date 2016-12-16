package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RmiServer extends UnicastRemoteObject implements ServerInterface {

  private static final long serialVersionUID = 724887908984646040L;
  private ArrayList<String> list = new ArrayList<String>();


  public RmiServer() throws RemoteException {
    super();
  }

  @Override
  public void addMessage(String message, ReplyTo sender) throws RemoteException {
    this.list.add(message);
    System.out.println("List: \n" + list.toString());
    sender.replyMessage("Message received: " + message);
  }

  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.createRegistry(1099);
      ServerInterface rmiServer = new RmiServer();
      Naming.bind("addMessage", rmiServer);
      System.out.println("Starting server");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
