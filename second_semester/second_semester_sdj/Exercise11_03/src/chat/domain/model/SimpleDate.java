package chat.domain.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SimpleDate
{
	private Calendar time;

	   public SimpleDate()
	   {
	      time = new GregorianCalendar();
	   }

	   public SimpleDate(Calendar time)
	   {
	      this.time = time;
	   }

	   public String getTime()
	   {
	      String tmp = "" + time.get(Calendar.DAY_OF_MONTH);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      String t = tmp + "/";
	      tmp = "" + (time.get(Calendar.MONTH) + 1);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      t += tmp + "/";
	      tmp = "" + time.get(Calendar.YEAR);
	      while (tmp.length() < 4)
	         tmp = "0" + tmp;
	      t += tmp + " ";
	      tmp = "" + time.get(Calendar.HOUR_OF_DAY);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      t += tmp + ":";
	      tmp = "" + time.get(Calendar.MINUTE);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      t += tmp + ":";
	      tmp = "" + time.get(Calendar.SECOND);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      t += tmp;
	      return t;
	   }

	   public String getShortTime()
	   {
	      String t = "";
	      String tmp = "" + time.get(Calendar.HOUR_OF_DAY);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      t += tmp + ":";
	      tmp = "" + time.get(Calendar.MINUTE);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      t += tmp + ":";
	      tmp = "" + time.get(Calendar.SECOND);
	      if (tmp.length() < 2)
	         tmp = "0" + tmp;
	      t += tmp;
	      return t;
	   }

	    public String toString()
	   {
	      return getTime();
	   }

	   public static Calendar getTime(String timeText)
	   {
	      Calendar c = GregorianCalendar.getInstance();
	      c.set(Calendar.MILLISECOND, 0);
	      try
	      {
	         c.set(Calendar.DAY_OF_MONTH, Integer
	               .parseInt(timeText.substring(0, 2)));
	         c.set(Calendar.MONTH, (Integer
	               .parseInt(timeText.substring(3, 5)) + 1));
	         c.set(Calendar.YEAR, Integer
	               .parseInt(timeText.substring(6, 10)));
	         c.set(Calendar.HOUR_OF_DAY, Integer
	               .parseInt(timeText.substring(11, 13)));
	         c.set(Calendar.MINUTE, Integer
	               .parseInt(timeText.substring(14, 16)));
	         c.set(Calendar.SECOND, Integer
	               .parseInt(timeText.substring(17)));
	      }
	      catch (Exception e)
	      {
	         c.set(Calendar.DAY_OF_MONTH, 1);
	         c.set(Calendar.MONTH, 1);
	         c.set(Calendar.YEAR, 0);
	         c.set(Calendar.HOUR_OF_DAY, 0);
	         c.set(Calendar.MINUTE, 0);
	         c.set(Calendar.SECOND, 0);
	      }
	      return c;
	   }

}
