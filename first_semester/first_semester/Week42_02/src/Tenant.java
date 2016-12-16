
public class Tenant
{
   // Declare class variables
   private String name;
   // The diagram shows Tenant "has a" MyDate object as a variable
   // and that the "has a" relationship is compositional
   // We can say that Tenant is "composed of" rentedFrom, a MyDate object
   private MyDate rentedFrom;
   
   // Constructor
   public Tenant(String name)
   {
      this.name = name;
      // Since we have no clue as to what
      // the default value of rentedFrom should be
      // I'm going to keep it simple and set it to null.
      // Note this is the default behavior in Java, so this technically isn't necessary
      // It's just nice to be explicit about what we want
      // instead of relying on behind-the-scenes "magic"
      this.rentedFrom = null;
   }
   
   // Simple getter for name
   public String getName()
   {
      // I like to be explicit every single time
      // and use this. when I refer to a class variable
      // Even when it doesn't make a difference
      return this.name;
   }
   
   // Return the value of the rentedFrom object
   // Since the "has a" relationship is compositional
   // return a copy of the object, instead of the object itself
   public MyDate getRentedFrom()
   {
      // Use the copy() method we defined in MyDate
      return this.rentedFrom.copy();
   }
   
   // Set the value of the rentedFrom object
   // Using another MyDate object
   // Since the "has a" relationship is compositional
   // We want to use the value of the other MyDate object
   // Instead of using the object itself
   // So that the two objects aren't pointing to the same place in memory
   // Which would mean some other object could control our internal rentedFrom object
   public void setRentedFrom(MyDate date)
   {
      // Get a copy of the MyDate object being passed in
      this.rentedFrom = date.copy();
   }

   // Check for equality against another Tenant object
   // The diagram wants us to check against a plain Object
   // But this is messy and we haven't covered it in class
   public boolean equals(Tenant otherTenant)
   {
      // Since name and rentedFrom are objects (remember Strings are objects)
      // we have to use .equals() to check for equality
      return this.name.equals(otherTenant.getName()) 
            && this.rentedFrom.equals(otherTenant.getRentedFrom());
   }
   
   // Return a String representation
   public String toString()
   {
      // Use the toString() method we made in the MyDate class
      return this.name + this.rentedFrom.toString();
   }
}
