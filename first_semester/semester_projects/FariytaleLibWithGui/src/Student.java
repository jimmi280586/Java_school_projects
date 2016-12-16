

	/**
	 * This class is a subclass of the abstract class Customer and as such inherits from that. 
	 * The purpose of this class is to differentiate between types of customers because they
	 * do not have the same lending terms in the library.
	 *
	 */
public class Student extends Customer
{  

   private boolean Fine;
   
   /**
    * The constructor instantiates the variables and calls from the superclass Customer.
    * @param Fine is a String that holds the amount of $5 as a fine for overdue items.
    * @param name
    * @param address
    * @param email
    * @param phoneNumber
    */
   public Student(String name, String address, String email, int phoneNumber, boolean Fine)
   {
	
      super(name, address, email, phoneNumber);
  
      this.Fine = Fine;
      
   
   }

   /**This method checks if the boolean variable
    *  "fine" is true or false and sets the fine status accordingly.
    */
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
   

   @Override
   public String toString()
   {
      return super.toString()+ " Student: " + ", Fine: " + CustomerFine();
   }
   /**
	 * Sets the status of the "fine" variable.
	 */
@Override
public void setFine(boolean fine) 
{
	
	this.Fine = fine;
}

}
