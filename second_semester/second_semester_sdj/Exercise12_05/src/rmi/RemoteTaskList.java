package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTaskList extends Remote {

  public void add(String task, RemoteTaskClient sender) throws RemoteException;
  public void remove() throws RemoteException;
  public int size() throws RemoteException;

}
