
public class Duration
{
   // Declare class variables
   private int minutes;
   private int seconds;
   
   // Two argument constructor
   public Duration(int minutes, int seconds)
   {
      // If given an invalid minutes value
      if (minutes <= 0)
      {
         // Set minutes to 0
        this.minutes = 0;
      }
      else
      {
         // Otherwise, set minutes to given value
         this.minutes = minutes;
      }

      // If given 60 seconds or more
      if (seconds >= 60)
      {
         // Add however many minutes in that many seconds
         // Using integer division to round down
         this.minutes += seconds / 60;
         // Keep the number of seconds that are rounded off
         // Using modulus
         this.seconds = seconds % 60;
      }
      else
      {
         // If less than 60 seconds, just set seconds to given value
         this.seconds = seconds;
      }
   }
   
   // Single argument constructor
   public Duration(int seconds)
   {
      // If more than 60 seconds
      if (seconds >= 60)
      {
         // Add however many minutes in that many seconds
         this.minutes = seconds / 60;
         // Keep the number of seconds that are rounded off
         this.seconds = seconds % 60;
      }
      else
      {
         // Otherwise, minutes set to 0
         this.minutes = 0;
         // Seconds set to given value
         this.seconds = seconds;
      }
   }
   
   // Return total number of seconds
   public int toSeconds()
   {
      // If minutes is greater than 0
      if (this.minutes > 0)
      {
         // Return the number of seconds in that many minutes
         // plus the original number of seconds
         return (this.minutes * 60) + this.seconds;
      }
      // Otherwise, just return the number of seconds
      return this.seconds;
   }

   // Return a String representation
   public String toString()
   {
      // Pad with a 0 if less than 10 seconds
      if (this.seconds < 10)
      {
         return this.minutes + ":0" + this.seconds;
      }
      // Otherwise, just return the values
      return this.minutes + ":" + this.seconds;
   }
   
   // Check for equality against another duration
   public boolean equals(Duration other)
   {
      // Check both variables for equality
      return this.minutes == other.minutes && this.seconds == other.seconds;
   }
}
