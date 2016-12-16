package cmdfunctions;

public class User 
{
	private final int id;
	private String name;
	private int accountType;
	
	public User(int id, String name, int accountType)
	{
		this.id = id;
		this.name = name;
		this.accountType = accountType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public int getId() {
		return id;
	}
}
