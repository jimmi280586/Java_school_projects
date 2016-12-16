
public class Controler
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Person a = new Employee("jimmi", 28, 5000);
		Person b = new Employee("kurt", 30, 3000);
		
		System.out.println("person " + a + " person " + b);
		System.out.println(a.equals(b));
	}

}
