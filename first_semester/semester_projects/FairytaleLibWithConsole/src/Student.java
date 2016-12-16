
public class Student extends Customer
{  
   
   

// Variables
   private int months;
   private boolean Fine;
   
   // Constructor
   public Student(String name, String address, String email, int phoneNumber, int months, boolean Fine)
   {
      super(name, address, email, phoneNumber);
      this.months = months;
      this.Fine = Fine;
      
   
   }


   
// Method for the Student's fine
   @Override
   public String CustomerFine()
   {  
      String a = "";
      String b = " $5$";
      if (this.Fine == true)
      {
         return b;
      }
      else 
      {
         return a;
      }
   }
   

// ToString methods
   @Override
   public String toString()
   {
      return super.toString()+ "Student: " + months + ", Fine: " + CustomerFine() + "";
   }

@Override
public void setFine(boolean a) 
{
	this.Fine = a;
}

}
