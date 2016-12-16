
public class Clock
{
   private Time time;
   
   // Constructor (standard)
   public Clock(Time time)
   {
      this.time = time;
   }
   
   // Constructor (from the exercise - very common)
   public Clock(int hours, int minutes, int seconds)
   {
      this.time = new Time(hours, minutes, seconds);
   }
   
   // Getter
   public Time getTime()
   {
      return time;
   }
   
   
   public String toString()
   {
      // Add a string to (some of) the fields.
      return "Time is " + this.time.toString();
   }
   
   // Standard copy method.
   public Clock copy()
   {
      return new Clock(this.time);
   }
   
   // Pure delegation
   public void advanceSeconds()
   {
      this.time.advanceSeconds();
   }
}
