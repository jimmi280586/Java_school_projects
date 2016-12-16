package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTaskClient extends Remote {

  public void notifyOfAddedTask(String task) throws RemoteException;

}
