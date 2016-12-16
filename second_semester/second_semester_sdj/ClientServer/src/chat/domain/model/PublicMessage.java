package chat.domain.model;

import java.io.Serializable;

public class PublicMessage extends AbstractMessage implements Serializable
{
	public PublicMessage(int id, String from, String message)
	   {
	      super(id, from, message);
	   }
	   public PublicMessage(String from, String message)
	   {
	      super(from, message);
	   }
	   
	   public String toString()
	   {
	      return "Public: " + super.toString();
	   }
}
