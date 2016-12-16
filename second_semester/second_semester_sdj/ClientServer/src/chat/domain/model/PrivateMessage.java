package chat.domain.model;

import java.io.Serializable;

public class PrivateMessage extends AbstractMessage implements Serializable
{
	private String to;
	   
	   public PrivateMessage(int id, String from, String to, String message)
	   {
	      super(id, from, message);
	      this.to = to;
	    }
	   
	   public PrivateMessage(String from, String to, String message)
	   {
	      super(from, message);
	      this.to = to;
	    }
	   
	   public String getTo()
	   {
	      return to;
	   }

	   public void setTo(String to)
	   {
	      this.to = to;
	   }
	   
	   public String toString()
	   {
	      return "Private: (to=" + to + "), " + super.toString();
	   }
}
