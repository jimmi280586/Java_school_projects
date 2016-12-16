import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RemoteSubject<Message> extends Remote
{
	public void addObserver(RemoteObserver<Message> o) throws RemoteException;
	public void deleteObserver(RemoteObserver<Message> o) throws RemoteException;
}
