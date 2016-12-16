
public class Employee extends Person
{
	private double salary;

	public Employee(String name, int age, double salary)
	{
		
		super(name, age);
		this.salary = salary;
	}

	public Employee(String name, double salary) {
		super(name);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
	@Override
	 public String toString()
	{
		return "employee, name = " + this.getName() + ", age = " + this.getAge() + ", salary = " + this.salary;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		
		// instead off writing the equals method from the super class again
		// just call it like this
		return super.equals(other) && this.salary == other.salary;
		
	}
	
	


}
