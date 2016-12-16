
public class Apartment
{
   // Declare class variables
   private int number;
   // The diagram shows Apartment "has a" relationship with Tenant
   // Each apartment has zero or one tenant
   private Tenant tenant;
   
   // Constructor
   public Apartment(int number)
   {
      this.number = number;
      // Since tenant can be zero or one
      // We'll just set it to zero (null) by default
      this.tenant = null;
   }
   
   // Getter for number
   public int getNumber()
   {
      return this.number;
   }
   
   // Check if the current apartment is available
   // Basically, check to see if it has a tenant
   public boolean isAvailabe()
   {
      // If the tenant is still set to null
      // Then the apartment is available
      return this.tenant == null;
   }
   
   // Set the tenant variable
   public void rentTo(Tenant tenant, MyDate rentedFrom)
   {
      // Since the relationship isn't compositional
      // You can just set the tenant variable to the tenant object being passed in
      this.tenant = tenant;
      // Let the tenant object deal with the rentedFrom object we're passing in
      // We want all that implementation stuff in the Tenant class, not here
      this.tenant.setRentedFrom(rentedFrom);
   }
   
   // Return the current tenant
   // The relationship is a loose "has a" (aggregation/association)
   // so we want to return the tenant itself, not a copy 
   // (think of this in real life terms, it wouldn't make sense to return a clone of the tenant!)
   public Tenant getTenant()
   {
      return this.tenant;
   }
   
   // Return a String represenation
   public String toString()
   {
      return this.number + this.tenant.toString();
   }

}
