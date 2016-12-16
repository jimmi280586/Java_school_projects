
public class Person
{
	private String name;
	private int age;
	
	public Person(String name, int age)
	{
		
		this.name = name;
		this.age = age;
	}

	public Person(String name)
	{
		
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Person " + (name != null ? "name = " + name + ", " : "")
				+ "age = " + age + "";
	}

	public boolean equals(Person obj) {
		// TODO Auto-generated method stub
		return this.name.equals(obj.name) 
				&& this.age == obj.age;
	}

	
	
}
