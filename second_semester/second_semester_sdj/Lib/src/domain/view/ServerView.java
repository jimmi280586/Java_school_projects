package domain.view;
import java.util.Scanner;

import domain.controller.ServerController;
import utility.HardCodeMethods;


public class ServerView 
{
	ServerController controller;
	Scanner in = new Scanner(System.in);
	public void ServerMenu()
	{		
			System.out.println("Welcome to the Fairytale library Server system!"
					+ "\n What do Client want to do next?");
					
			
	}
	
	 public void start(ServerController controller)
	   {
	      this.controller = controller;
	    
	      ServerMenu();
	   }
}
