
public class Employee extends Person
{
	private double salary;

	public Employee(String name, int age, double salary) {
		
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
		return this.getName() + ", " + this.getAge() + ", " + this.getSalary();
	}
	
	public boolean equals(Employee employee)
	{
		return this.getName().equals(employee.getName())
				&& this.getAge() == employee.getAge()
				&& this.getSalary() == employee.getSalary();
	}


}
