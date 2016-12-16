
import java.io.Serializable;
import java.util.ArrayList;

//A customerlist represents  a list of customers (lectures and students)

//Implement serializable
public class CustomerList implements Serializable
{
  

   // Declare array list
   private ArrayList<Customer> customers;

   // Constructs a new CustomerList containing customers

   public CustomerList()
   {

      this.customers = new ArrayList<Customer>();
   }

   // Adds a new customer to a list
   public void addCustomer(Customer customer)
   {
      this.customers.add(customer);
   }

   // Remove a customer to a list
   public void removeCustomer(Customer customer)
   {
      this.customers.remove(customer);
   }

   // Looks up how many customer are on the Customer list and return the number
   // of customers
   public int getNumberOfCustomer()
   {
      return customers.size();

   }
   
   public Customer getCustomer(int index)
   {
	   return this.customers.get(index);
   }

   // Displaying the customer list
   public String toString()
   {
      return "CustomerList" + this.customers;
   }

   // Compare the lists of customers
   public boolean equals(Object obj)
   {

      // Check if the customerlist is the party of object
      if (!(obj instanceof CustomerList))
      {
         return false;
      }
      // If true compare lists
      CustomerList other = (CustomerList) obj;

      return this.customers.equals(other.customers);
   }

}
