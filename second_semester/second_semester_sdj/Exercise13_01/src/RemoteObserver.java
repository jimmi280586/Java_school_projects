import java.rmi.Remote;
import java.rmi.RemoteException;

import javafx.beans.Observable;


public interface RemoteObserver<Message> extends Remote
{
	public void update(RemoteSubject<Message> subject, Message updateMsg) throws RemoteException;
}
