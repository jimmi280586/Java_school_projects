import java.io.Serializable;




public abstract class Customer implements Serializable // Abstract class
{
   private String name;
   private String address;
   private String email;
   private int phoneNumber;
     
   
   public Customer(String name, String address, String email, int phoneNumber)
   {
      this.name = name;
      this.address = address;
      this.email = email;
      this.phoneNumber = phoneNumber;
   }

   // Getters and Setters for the fields 
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
   
   // ToString method
   @Override
   public String toString()
   {
      return "Customer Name: " + name + ", address: " + address + ", email: "
            + email + ", phoneNumber: " + phoneNumber + " ";
   }

  
   // Equals method
   @Override
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Customer))
         return false;
      Customer other = (Customer) obj;
      return this.name.equals(other.getName()) && this.address.equals(other.getAddress()) && this.email.equals(other.getEmail())
            && this.phoneNumber == other.getPhoneNumber();
   }
  public abstract void setFine(boolean a);
 
  public abstract String CustomerFine();
  
   
}
