import java.util.Calendar;


public class Person
{
   
	 // Declare the fields
	private String name;
	private MyDate birthday;
	// Two-argument Constructor
	public Person(String name, MyDate birthday)
	{
	this.name = name;
	// Make sure the birthday object is a composite
	this.birthday = birthday.copy();
	}
	// One-argument Constructor
	public Person(MyDate birthday)
	{
	this.name = null;
	this.birthday = birthday.copy();
	}
	// Set the name variable
	public void setName(String name)
	{
	this.name = name;
	}
	// Return the name variable
	public String getName()
	{
	return this.name;
	}
	// Returns a birthday object
	public MyDate getBirthday()
	{
	// Return a copy instead of the internal object
	return this.birthday.copy();
	}
	// Returns the age of the person
	public int getAge()
	{
	// WARNING: complicated!
	// Without any arguments to use, the only way to check age is to get the current date/year
	// This can be done with the built-in Calendar class
	// TO-DO: check if birthday has already happened in the current year
	return Calendar.getInstance().get(Calendar.YEAR) - this.birthday.getYear();
	}
	// Return a String representation
	public String toString()
	{
	// Use the toString method in the MyDate class
	return "Name: " + this.name + ", Date of Birth: " + this.birthday.toString();
	}
	// Compare against another Person object
	// WARNING: complicated!
	// Need to check if obj is a Person
	// then cast obj to Person to do comparisons
	public boolean equals(Object obj)
	{
	if (obj instanceof Person)
	{
	return this.name.equals(((Person) obj).name) && this.birthday.equals(((Person)obj).birthday);
	}
	return false;
	}
}
