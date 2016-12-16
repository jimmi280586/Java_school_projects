
public class PersonTest
{

   public static void main(String[] args)
   {
	   // Demonstrate the person class
	// Get a new person object
	Person dude = new Person();
	// Use setter methods to set fields
	dude.setName("Bob");
	dude.setBirthday("1/1/1970");
	// Use getter methods to get field values
	System.out.println("Name is: " + dude.getName());
	System.out.println("Birthday is: " + dude.getBirthday());

   }

}
