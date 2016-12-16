package lib2.domain.view;
import java.util.Scanner;

import lib2.domain.controller.ServerController;
import lib2.utility.HardCodeMethods;


public class ServerView 
{
	ServerController controller;
	Scanner in = new Scanner(System.in);
	public void ServerMenu() throws Exception
	{		
			System.out.println("Welcome to the Fairytale library Server system!"
					+ "\n What do Client want to do next?"
					+ "\n 1) start server"
					+ "\n 2) for exit");
			int choice = in.nextInt();
			controller.execute(choice);			
	}
	
	 public void start() throws Exception
	   {
	      this.controller = new ServerController(this);	    
	      ServerMenu();
	   }
}
