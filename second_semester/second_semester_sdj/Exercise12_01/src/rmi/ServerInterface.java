package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

  public void addMessage(String msg) throws RemoteException;

}
