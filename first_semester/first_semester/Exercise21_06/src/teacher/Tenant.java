package teacher;

import java.util.Date;

public class Tenant
{
   private String name;
   private Date rentedFrom;
   
   public Tenant(String name)
   {
      this.name = name;
      this.rentedFrom = new Date();
   }

   public Date getRentedFrom()
   {
      return rentedFrom;
   }

   public void setRentedFrom(Date rentedFrom)
   {
      this.rentedFrom = rentedFrom;
   }

   public String getName()
   {
      return name;
   }
   
   
}
