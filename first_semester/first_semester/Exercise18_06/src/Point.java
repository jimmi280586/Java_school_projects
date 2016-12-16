
public class Point
{
   // Declare class variables
   private double x;
   private double y;
   
   // Constructor
   public Point(double x, double y)
   {
      this.x = x;
      this.y = y;
   }
   
   // Getters
   public double getX()
   {
      return this.x;
   }

   public double getY()
   {
      return this.y;
   }
   
   // Get distance to another x,y Point
   public double getDistance(Point other)
   {
      double distance = 0;
      
      distance = Math.sqrt(Math.pow((other.y - this.y), 2)
                 + Math.pow((other.x - this.x), 2));

      return distance;
   }
   
   // Return a String representation
   public String toString()
   {
      return this.x + ", " + this.y;
   }

}
