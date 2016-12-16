package cmdfunctions;

public class Command 
{
	private int id;
	private String command;
	
	public Command(int id, String command)
	{
		this.id = id;
		this.command = command;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}	
	
}
