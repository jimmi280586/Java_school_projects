package cmdfunctions;

import java.io.IOException;

public interface ICmdFunctions 
{
	public void execute(Command command) throws IOException, InterruptedException;
}
