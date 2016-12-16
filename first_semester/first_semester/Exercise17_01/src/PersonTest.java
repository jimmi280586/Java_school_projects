
public class PersonTest 
{

	public static void main(String[] args) 
	
	{	
		
		Person person1 = new Person("kurt");
		Person person2 = new Person("jimmi");
		
		person1.moveTo(new House(60, new Address("hulla", 8721)));
		person2.moveTo(new House(80, new Address("bulla", 8722)));
		
		System.out.println("person1 " + person1.getAddress().getStreetAddress());
		System.out.println("person2 " + person2.getAddress().getStreetAddress());
		
		System.out.println(person1.getName() + " and " + person2.getName() + " live at same palce " + person1.getAddress().equals(person2.getAddress()) + " ");
	}

}
