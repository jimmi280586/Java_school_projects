package teacher;



import java.util.Date;

public abstract class Residence
{
   private int number;
   private double size;
   private String type;
   private Tenant rentedTo;
   
   public Residence(int number, double size, String type)
   {
      this.number = number;
      this.size = size;
      this.type = type;
      this.rentedTo = null;
   }

   public int getNumber()
   {
      return number;
   }

   public double getSize()
   {
      return size;
   }

   public String getType()
   {
      return type;
   }
   
   public boolean isAvailable()
   {
      return this.rentedTo == null;
   }
   
   public void rentTo(Tenant tenant, Date rentedFrom)
   {
      this.rentedTo = tenant;
      this.rentedTo.setRentedFrom(rentedFrom);
   }
   
   public Tenant getTenant()
   {
      return this.rentedTo;
   }
   
   public abstract int getNumberOfRooms();
}
