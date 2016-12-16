package teacher;


public class Apartment extends Residence
{
   private int numberOfRooms;
   
   public Apartment(int number, double size, int numberOfRooms)
   {
      super(number, size, "Apartment");
      this.numberOfRooms = numberOfRooms;
   }
   
   public int getNumberOfRooms()
   {
      return this.numberOfRooms;
   }
}
