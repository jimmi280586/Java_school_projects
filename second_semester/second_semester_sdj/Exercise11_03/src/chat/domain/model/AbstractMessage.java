package chat.domain.model;

import java.io.Serializable;

public abstract class AbstractMessage implements Serializable
{
	 private int id;
	   private String from;
	   private String messageBody;
	   
	   public AbstractMessage(int id, String from, String message)
	   {
	      this.from = from;
	      this.id = id;
	      this.messageBody = message;
	   }

	   public AbstractMessage(String from, String message)
	   {
	      this(0, from, message);
	      setId(this.hashCode());
	   }

	   public int getId()
	   {
	      return id;
	   }

	   public void setId(int id)
	   {
	      this.id = id;
	   }

	   public String getBody()
	   {
	      return messageBody;
	   }

	   public void setBody(String messageBody)
	   {
	      this.messageBody = messageBody;
	   }
	   
	   public String getFrom()
	   {
	      return from;
	   }

	   public void setFrom(String from)
	   {
	      this.from = from;
	   }
	   
	   public String toString()
	   {
	      return "id=" + id + ", from=" + from + ", \""+ messageBody + "\"";
	   }

}
