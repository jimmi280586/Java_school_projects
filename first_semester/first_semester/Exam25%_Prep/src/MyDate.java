
public class MyDate
{
   // Declare class variables
   private int day;
   private int month;
   private int year;
   
   // Simple Constructor
   public MyDate(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }
   
   // Getters
   public int getDay()
   {
      return this.day;
   }
   public int getMonth()
   {
      return this.month;
   }
   public int getYear()
   {
      return this.year;
   }
   
   // Set everything at once
   public void set(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }

   // Return a copy of the object
   public MyDate copy()
   {
      // It is important to return a new object
      // with the same values as the current object
      // So just make a new object, and pass values into the constructor
      return new MyDate(this.day, this.month, this.year);
   }
   
   // Check for equality against another MyDate object
   // Note that the diagram uses a generic Object
   // but that's not easy to do, and we haven't covered it in class
   public boolean equals(MyDate otherDate)
   {
      // Since all the values are ints
      // Just do some basic equality checking
      return this.day == otherDate.day 
            && this.month == otherDate.month 
            && this.year == otherDate.year; 
   }
   
   // Return a String representation
   // No need to get complicated
   public String toString()
   {
      // Remember, when you add any primitive value to a String
      // It will "concatenate" that value to the string
      return this.day + "/" + this.month + "/" + this.year;
   }
   
}
