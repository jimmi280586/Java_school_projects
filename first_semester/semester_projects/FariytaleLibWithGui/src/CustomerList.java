

import java.io.Serializable;
import java.util.ArrayList;



/**This class is to create an ArrayList to hold customers (lecturers and students).
*
*/
public class CustomerList implements Serializable
{
	
	
	
   private ArrayList<Customer> customers;

  
   /**
		 * Constructor initializes the list.
		 */
   public CustomerList()
   {
	

      this.customers = new ArrayList<Customer>();
   }

   /** Add customers to the list.
	 * 
	 * @param customer object from the abstract Customer class that has the
	 * subclasses Lecturer and Student.
	 */
   public void addCustomer(Customer customer)
   {
	   
      this.customers.add(customer);
   }

   /** Remove customers from the list.
	 * 
	 * @param customer object from the abstract Customer class that has the
	 * subclasses Lecturer and Student.
	 */
   public void removeCustomer(Customer customer)
   {
	  
      this.customers.remove(customer);
   }

   
   public Customer getCustomer(int index)
   {
	   return this.customers.get(index);
   }
   /** Get number of customers in the list
	 * 
	 * @return returns the number of customers as an int.
	 */
   public int getNumberOfCustomer()
   {
	  
      return customers.size();

   }
   /**Sends everything to String.
	 * 
	 */
   public String toString()
   {
		
      return "CustomerList" + this.customers;
   }

 


}
