package chat.domain.mediator;

import java.util.ArrayList;
import java.util.Observable;

import chat.domain.model.AbstractMessage;
import chat.domain.model.MessageList;
// is the observable class for the servermodel manager
public class ServerModelManager extends Observable
{
	private MessageList messages;
	
	public ServerModelManager()
	{
		messages = new MessageList();
	}
	
	
	public void add(AbstractMessage message)
	{
		messages.add(message);
	}
}
