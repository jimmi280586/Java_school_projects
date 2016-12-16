package teacher;

public class Room extends Residence
{
   public Room(int number, double size)
   {
      super(number, size, "Room");
   }
   
   public int getNumberOfRooms()
   {
      return 1;
   }
}
