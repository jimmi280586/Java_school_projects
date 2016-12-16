import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;


public class AbstractRemoteSubject<Message> implements RemoteSubject, RemoteObserver
{
	private Thread notifyRemoteObserversThread;
	private ArrayList<RemoteObserver> remote = new ArrayList<RemoteObserver>();
	
	public AbstractRemoteSubject()
	{
		super();
	}
	
	public AbstractRemoteSubject(RemoteSubject<Message> subject)
	{
	
	}

	@Override
	public void update(RemoteSubject subject, Object updateMsg) throws RemoteException
	{
		for (RemoteObserver remoteObserver : remote) {
			try {
			((RemoteObserver) remote).update(this, updateMsg);
			} catch (RemoteException e) {
			remote.remove(remoteObserver);
			e.printStackTrace();
			}
			}	
	}

	@Override
	public void addObserver(RemoteObserver o)
	{
		remote.add(o);		
	}

	@Override
	public void deleteObserver(RemoteObserver o)
	{
		remote.remove(o);
	}
	
	public int countObserver()
	{
		return remote.size();
	}
	
	protected void notifyObserver(Message msg)
	{
		
	}
	
	protected RemoteObserver<?>[] getObservers[];
}
