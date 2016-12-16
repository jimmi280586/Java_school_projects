
public class Hotel
{
   // Declare class variables
   private String name;
   // Since the "has a" relationship between Hotel and Room
   // is "one to many", I need an array
   // I don't need an ArrayList,
   // because hotels tend not to add or remove rooms
   private Room[] rooms;

   // Constructor
   public Hotel(String name, Room[] rooms)
   {
      // We can just copy the arguments
      // since nothing here is compositional
      this.name = name;
      // Thankfully we don't have to care about 
      // the business of adding rooms
      // That would stink with just one plain array
      this.rooms = rooms;
   }

   // Getter for name
   public String getName()
   {
      return this.name;
   }

   // Get number of rooms in hotel
   public int getNumberOfRooms()
   {
      // This is just the length of the rooms array
      return this.rooms.length;
   }

   // Get the number of available rooms
   public int getNumberOfAvailableRooms()
   {
      // This is more complicated than just the number of rooms

      // We'll start with a counter, initialized to zero
      int numberOfAvailableRooms = 0;
      // We need to loop through the rooms array
      for (int i = 0; i < this.rooms.length; i++)
      {
         // If the room isn't occupied
         if (!this.rooms[i].isOccupied()) 
         {
            // Increment the counter
            numberOfAvailableRooms += 1;
         }
      }
      // Return the final count
      return numberOfAvailableRooms;
   }
   
   // Get the first room that is available
   // At or under a max price
   public Room getFirstAvailableRoom(double maxPrice)
   {
      // Loop through the array
      for (int i = 0; i < this.rooms.length; i++)
      {
         // If the Room at the current index
         // is not occupied and is lte the max price
         if (!this.rooms[i].isOccupied() && this.rooms[i].getPrice() <= maxPrice)
         {
            // return the Room at the current index
            return this.rooms[i];
         }
      }
      // If there aren't any available rooms
      // under the max price
      // Return null
      return null;
   }
   
   // Return an array with all the available rooms
   // for a given bed type
   public Room[] getAllAvailableRooms(String bedType)
   {
      // I need to figure out how large the array needs to be
      // So I'll just do a wee loop to find the number of beds
      // in the requested type
      int numberOfAvailableRoomsInType = 0;
      for (int i = 0; i < this.rooms.length; i++)
      {
         // If the bed type of the room at the current index
         // matches the requested type
         // and is available
         if (this.rooms[i].getBedType().equals(bedType) && !this.rooms[i].isOccupied())
         {
            // Increment the counter by one
            numberOfAvailableRoomsInType += 1;
         }
      }
      
      // When loop is finished, make a new Room array
      // With the number of rooms needed
      Room[] availableRoomsInType = new Room[numberOfAvailableRoomsInType];
      
      // Loop again
      for (int i = 0; i < availableRoomsInType.length; i++)
      {
         // Once again, check for the bed time and availability
         // I don't like that I'm repeating myself here
         if (this.rooms[i].getBedType().equals(bedType) && !this.rooms[i].isOccupied())
         {
            // Set the current index to the room at that index
            availableRoomsInType[i] = this.rooms[i];
         }
      }
      // Finally, return the collected array
      return availableRoomsInType;
   }
   
   // Check to see if hotel has a particular guest
   public boolean hasGuest(Guest guest)
   {
      // Loop through the rooms array
      for (int i = 0; i < this.rooms.length; i++)
      {
         // If the guest in the room at the current index
         // equals the requested guest
         if(this.rooms[i].getGuest().equals(guest))
         {
            // return true
            return true;
         }
      }
      // If loop ended without escaping, return false
      return false;
   }
   
   // Get the room with the requested guest
   public Room getRoom(Guest guest)
   {
      // Very similar to the hasGuest() method
      // We could use the hasGuest() method
      // to see if the guest exists in the first place
      // but I'm lazy, so I won't do that here.

      // Loop through the rooms array
      for (int i = 0; i < this.rooms.length; i++)
      {
         // If the guest at the room at the current index
         // matches the requested guest
         if (this.rooms[i].getGuest().equals(guest))
         {
            // Return the room at the current index
            return this.rooms[i];
         }
      }
      // If loop ended without exiting
      // return null
      return null;
   }

}
