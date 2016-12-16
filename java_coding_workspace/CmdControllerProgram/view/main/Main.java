package main;

import java.io.IOException;

import cmdfunctions.CmdFunctions;
import cmdfunctions.Command;
import cmdfunctions.CommandMaker;
import cmdfunctions.ICmdFunctions;
import cmdfunctions.ICommandMaker;

public class Main 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		Command a = new CommandMaker().diskpart();
		System.out.println(a.getCommand());
		
		ICmdFunctions b = new CmdFunctions();
		b.execute(a);
	}
	

}
