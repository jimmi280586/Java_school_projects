package cd.domain.model;


public class Time
{
   private int hour;
   private int minute;
   private int second;

   public Time(int h, int m, int s)
   {
      this(h * 3600 + m * 60 + s);
   }

   public Time(int timeInSeconds)
   {
      if (timeInSeconds < 0)
         timeInSeconds = 0;
      hour = timeInSeconds / 3600;
      minute = (timeInSeconds % 3600) / 60;
      second = (timeInSeconds % 3600) % 60;
   }

   public int getHour()
   {
      return hour;
   }

   public int getMinute()
   {
      return minute;
   }

   public int getSecond()
   {
      return second;
   }

   public int getTimeInSeconds()
   {
      return hour * 3600 + minute * 60 + second;
   }

   public String toString()
   {
      String time = "";
      if (hour < 10)
         time += "0";
      time += hour + ":";
      if (minute < 10)
         time += "0";
      time += minute + ":";
      if (second < 10)
         time += "0";
      time += second;
      return time;
   }

}
