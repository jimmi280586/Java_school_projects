package chat.domain.model;

import java.util.ArrayList;

public class MessageList
{
	private ArrayList<AbstractMessage> messages;

	   public MessageList()
	   {
	      this.messages = new ArrayList<>();
	   }

	   public AbstractMessage getMessage(int index)
	   {
	      return messages.get(index);
	   }

	   public int count()
	   {
	      return messages.size();
	   }

	   public void add(AbstractMessage message)
	   {
	      messages.add(message);
	   }

	   public String toString()
	   {
	      String all = "{";
	      for (int i = 0; i < messages.size(); i++)
	      {
	         all += messages.get(i);
	         if (i < messages.size()-1)
	            all += ", ";
	      }
	      all += "}";
	      return all;
	   }

	  
}
