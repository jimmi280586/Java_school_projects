import java.util.ArrayList;

public class ApartmentComplex
{
   // Declare class variables
   private String address;
   // Since the "has a" relationship between ApartmentComplex and Apartment
   // is one-to-many (note the *)
   // we want the flexibility of an ArrayList to hold the apartments
   private ArrayList<Apartment> apartments;
   
   // Constructor
   public ApartmentComplex(String address)
   {
      this.address = address;
      // Start off with an empty ArrayList
      this.apartments = new ArrayList<Apartment>();
   }
   
   // Get the number of apartments
   // Which will just be the number of elements in the ArrayList
   public int getNumberOfApartments()
   {
      return this.apartments.size();
   }
   
   // Add an apartment to the ArrayList
   // This is an association (aggregation) relationship
   // So we're using the objects themselves, not copies
   public void add(Apartment apartment)
   {
      this.apartments.add(apartment);
   }
   
   // Get the apartment
   // that is at the given ArrayList index
   public Apartment getApartment(int index)
   {
      return this.apartments.get(index);
   }

   // Get the apartment
   // with the given apartment number
   public Apartment getApartmentByNumber(int number)
   {
      // Loop through the ArrayList
      for (int i = 0; i < this.apartments.size(); i++)
      {
         // When you find an apartment that has a matching number
         if (this.apartments.get(i).getNumber() == number)
         {
            // Return the current index in the ArrayList
            return this.apartments.get(i);
         }
      }
      // If the loop ends and you still haven't found anything
      // Just return null
      return null;
   }
   
   // Get the apartment
   // with the given tenant
   public Apartment getApartmentByTenant(Tenant tenant)
   {
      // We could do this the exact same way as the above method (getApartmentByNumber)
      // But I'll split things into steps to make it very clear what we're doing
      
      // Loop through the ArrayList
      for (int i = 0; i < this.apartments.size(); i++)
      {
         // Get the apartment at the current index
         Apartment currentApartment = this.apartments.get(i);

         // Get the tenant in that apartment
         Tenant currentTenant = currentApartment.getTenant();
         
         // Check to see if that tenant equals the tenant we're looking for
         if (currentTenant.equals(tenant))
         {
            // If so, return the apartment at the current index
            return currentApartment;
         }
      }
      // If the loop has ended and we still haven't found anything
      // Just return null
      return null;
   }

   // Get the first apartment
   // that is available
   public Apartment getFirstAvailableApartment()
   {
      // Loop through the ArrayList
      for (int i = 0; i < this.apartments.size(); i++)
      {
         // When you find an apartment that is available
         if (this.apartments.get(i).isAvailabe())
         {
            // Return the current index
            return this.apartments.get(i);
            // Since the method ends here, this means we've "found" the first available apartment
         }
      }
      // If the loop has ended
      //
      return null;
   }
   
   // Return a string representation
   // That includes all of the apartments
   public String toString()
   {
      // Start with an empty String
      String apartmentsAsString = "";
      
      // Loop through the ArrayList
      for (int i = 0; i < this.apartments.size(); i++)
      {
         // Add the toString() of each apartment to the collector String
         apartmentsAsString += this.apartments.get(i).toString();
      }
      
      // Return the address plus the collector String
      // This won't look very good, so if I wasn't lazy
      // I would spend more time making the toString() methods more useful
      return this.address + apartmentsAsString;
   }
}
