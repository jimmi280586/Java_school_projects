
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
		this.age = 0;
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
		return "person, name = " + name + ", age = " + age;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return this.name.equals(other.name)
				&& this.age == other.age;
	}

	

	

	
	
}
