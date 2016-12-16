package cmdfunctions;

import java.io.IOException;
import java.io.PrintWriter;

import cmdthreads.CmdThreadPipe;

public class CmdFunctions implements ICmdFunctions
{

	@Override
	public void execute(Command command) throws IOException, InterruptedException
	{
		String[] command1 =
		    {
		        "cmd",
		    };
		String com = "Msg * The command could not execute proberly";
		if(command.getId() >= 0)
		{
			com = command.getCommand();
		}		
		    Process process = Runtime.getRuntime().exec(command1);
		    
		    new Thread(new CmdThreadPipe(process.getErrorStream(), System.err)).start();
		    
		    new Thread(new CmdThreadPipe(process.getInputStream(), System.out)).start();
		    
		    PrintWriter print = new PrintWriter(process.getOutputStream());
		    
		    print.println(com);
		    
		    print.close();
		    
		    int returnCode = process.waitFor();
		    
		    System.out.println("Return code = " + returnCode);
		
	}

}
