package chat.domain.mediator;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Observable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import chat.domain.model.AbstractMessage;

public class ClientModelManager extends Observable implements ModelInterface // Is the observable
{
	// delegates work to the proxy
	private Proxy prx;

	   public ClientModelManager() throws UnknownHostException, IOException
	   {
	      this.prx = new Proxy(this);
	   }

	   public void logout() throws TransformerException,
	         ParserConfigurationException
	   {
	      prx.logout();
	   }

	   public void update(AbstractMessage message)
	   {
	      super.setChanged();
	      super.notifyObservers(message);
	   }

	   @Override
	   public void add(AbstractMessage message) throws TransformerException,
	         ParserConfigurationException
	   {
	      prx.add(message);
	   }
}
