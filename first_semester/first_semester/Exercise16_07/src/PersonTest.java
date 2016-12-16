
public class PersonTest 
{
	
	 public static void main(String[] args)
	 {
	 // TODO Auto-generated method stub
	 Person bob = new Person("Bob", new MyDate(1, 1, 1970));
	 Person bob2 = new Person("Bob", new MyDate(1, 1, 1970));
	 Person jim = new Person("Jim", new MyDate(1,1,1970));
	 System.out.println(bob.getAge());
	 System.out.println(bob.toString());
	 System.out.println(bob.equals(jim));
	 System.out.println(bob.equals(bob2));
	 }
}
