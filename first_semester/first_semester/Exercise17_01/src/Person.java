
public class Person 
{

	private String name;
	private House home;
	
	public Person(String name) {
		super();
		this.name = name;
		this.home = null;
	}

	public void moveTo(House house)
	{
		this.home = house;
		
	}
	
	public String getName() {
		return name;
	}

	public Address getAddress() 
	{
		return this.home.getAddress();
	}
	
	
	
}
