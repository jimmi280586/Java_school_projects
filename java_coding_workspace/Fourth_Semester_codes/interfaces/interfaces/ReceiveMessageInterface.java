package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReceiveMessageInterface extends Remote
{
	public String receiveMessage(String x) throws RemoteException;
}
