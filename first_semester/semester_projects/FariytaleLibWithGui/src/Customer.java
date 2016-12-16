
import java.io.Serializable;



/**
 * This class is a super class that is serializable this class controls 2 subclasses
 * of the name student or lecturer
 */
public abstract class Customer implements Serializable // Abstract class
{
	
   private String name;
   private String address;
   private String email;
   private int phoneNumber;
     
   /**
    * This constructor sets the fields for this class
    * it takes tree variables to be used in the fields.
    * @param name
    * @param address
    * @param email
    * @param phoneNumber
    */
   public Customer(String name, String address, String email, int phoneNumber)
   {
	  
      this.name = name;
      this.address = address;
      this.email = email;
      this.phoneNumber = phoneNumber;
   }

   
   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getAddress()
   {
      return address;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   public String getEmail()
   {
      return email;
   }

   public void setEmail(String email)
   {
      this.email = email;
   }

   public int getPhoneNumber()
   {
      return phoneNumber;
   }

   public void setPhoneNumber(int phoneNumber)
   {
      this.phoneNumber = phoneNumber;
   }
   
   /**
    * This method returns the string representation 
    *  of this customer class 
    */
   @Override
   public String toString()
   {
	  
      return "Customer Name: " + name + ", address: " + address + ", email: "
            + email + ", phoneNumber: " + phoneNumber + " ";
   }

  
   /**
    * 
	 * This method checks if a customer is the same as another customer
	 * If obj is not instance of customer
	 * return false, otherwise if other customer
	 * is instance of customer obj, we make cast of customer
	 * if name is equal to other customer obj and address is equal
	 *  to other address and email is equal to other obj and phone number 
	 *  is equal to other phone number,
	 *  then return true, otherwise return false.
    */
   @Override
   public boolean equals(Object obj)
   {
	
      if (!(obj instanceof Customer))
         return false;
      Customer other = (Customer) obj;
      return this.name.equals(other.getName()) && this.address.equals(other.getAddress()) && this.email.equals(other.getEmail())
            && this.phoneNumber == other.getPhoneNumber();
   }
 
 
   public abstract void setFine(boolean fine);
 
   public abstract String CustomerFine();
  
   
}
