




public class Lecturer extends Customer// Lecturer extends Customer
{


	



// Variables
   private int monthsInYear;
   private boolean Fine;
   

   
   public Lecturer(String name, String address, String email, int phoneNumber, int monthsInYear, boolean fine)
   {
      super(name, address, email, phoneNumber);
      this.monthsInYear = monthsInYear;
      this.Fine = fine;
   }

   // Method for the Customer's fine
   @Override
   public String CustomerFine()
   {
      String b = "";
      String a = " $5$";
      if (this.Fine == true)
      {
         return a;
      }
      else 
      {
         return b;
      }
   }

   
   // ToString methods
   @Override
   public String toString()
   {
      return super.toString() + "Lecturer: " + monthsInYear + ", Fine:" + CustomerFine()
            + " ";
   }
   
   @Override
   public void setFine(boolean a) 
   {
   	this.Fine = a;
   }
   
   

}
