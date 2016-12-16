import java.util.ArrayList;

public class CarFerry
{
   private String name;
   private double weight;
   private double maxWeight;
   // It's easy to forget the next one, but look at the arrow
   // and the '*' next to it. 
   // That means: A CarFerry has many Vehicles.
   // To implement that, we need an array of Vehicle or an
   // ArrayList of Vehicle.
   // I choose ArrayList, because I need to add and remove Vehicles,
   // and I have no good way of knowing how many Vehicles will be
   // on the CarFerry.
   private ArrayList<Vehicle> vehicles;
   
   // The constructor needs to initialize all four fields:
   // name, weight, maxWeight, and vehicles.
   // The first three are straightforward. To initialize vehicles
   // we create a new ArrayList. This is standard when we use
   // ArrayList.
   public CarFerry(String name, double weight, double maxWeight)
   {
      this.name = name;
      this.weight = weight;
      this.maxWeight = weight;
      this.vehicles = new ArrayList<Vehicle>();
   }
   
   // This method and the next just uses the
   // basic functionality of ArrayList.
   // This is the reason we used ArrayList in
   // the first place.
   public void addVehicle(Vehicle vehicle)
   {
      vehicles.add(vehicle);
   }
   
   public void removeVehicle(Vehicle vehicle)
   {
      vehicles.remove(vehicle);
   }
   
   // This is a common type of method. It looks
   // for an element of the ArrayList by some sort of
   // criterion. In this case, it is looking for the
   // vehicle with the right license plate.
   // The procedure is analogous to going through
   // the ferry deck and looking at the license plate
   // on every car: We loop through the entire ArrayList
   // using a (standard) for-loop. If the license plate is
   // the right one, we stop and return our result. If on
   // the other hand we get to the far end of the ArrayList
   // (or ferry deck), we give up and return a null.
   public Vehicle getVehicle(String licensePlate)
   {
      // A standard for loop to loop through all vehicles.
      for(int i = 0; i < vehicles.size(); i++)
      {
         // Every time we get here currentVehicle will get a new value
         // (because i has a new value), and eventually it will have
         // gone through all the vehicles (unless we find the right one, 
         // see below).
         Vehicle currentVehicle = vehicles.get(i);
         if (licensePlate.equals(currentVehicle.getLicensePlate()))
         {
            // Here we know that we have found the right vehicle. We
            // return the result immediately.
            // When we return, we leave this method. We will not
            // keep running the for-loop to the end.
            return currentVehicle;
         }
      }
      // If we go through a ferry deck looking for a car, we know
      // we only get to the end if the car isn't there.
      // Likewise, if we ever get here, it means that we never got
      // to line 72 (return currentVehicle;), so we never found the
      // car. We know that the sought-after car is not in the ArrayList,
      // and consequently we return null.
      return null;
   }
   
   // This is a standard "add everything together" method with a twist.
   // In these, we need to use an extra (local) variable to keep a
   // running total of the things we are adding. It usually starts
   // at 0, but this is where the twist comes in.
   public double getTotalWeight()
   {
      // First, we need to remember that the ferry has a weight.
      double w = this.weight;
      // Now we can add the weight of all the vehicles - one at a time.
      for(int i = 0; i < vehicles.size(); i++)
      {
         // This loop works exactly like in getVehicle()
         Vehicle currentVehicle = vehicles.get(i);
         // Add the current weight to the running total.
         // When we are finished with the loop, 
         // w will hold the sum of the weight of the ship
         // and all the vehicles.
         w += currentVehicle.getWeight();
      }
      return w;
   }
   
   // isOverWeight() is just a case of calling the methods
   // of the same class. The logic is pretty straightforward.
   public boolean isOverWeight()
   {
      return this.getTotalWeight() > this.getMaxWeight();
   }
   
   public String getName()
   {
      return this.name;
   }
   
   public void setName(String name)
   {
      this.name = name;
   }
   
   public double getWeight()
   {
      return this.weight;
   }
   
   public double getMaxWeight()
   {
      return this.maxWeight;
   }
}
