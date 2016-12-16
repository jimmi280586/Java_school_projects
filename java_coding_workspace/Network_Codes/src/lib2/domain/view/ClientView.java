package lib2.domain.view;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import lib2.domain.controller.ClientController;


public class ClientView 
{
	ClientController controller = new ClientController(this);
	Scanner in = new Scanner(System.in);
	public void ClientMenu()
	{
		
			System.out.println("Welcome to the Fairytale library system!"
					+ "\n What do you want to do next?"
					+ "\n 1) Lend an item"
					+ "\n 2) Return an item"
					+ "\n 3) Add a new item"
					+ "\n 4) Search item"
					+ "\n 5) Reserve item"
					+ "\n 6) quit program");  
			
			int choice = in.nextInt(); 
		
			switch(choice)
			{
			case 1: 			
				
				try {
					controller.execute(choice);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
					break;
			case 2: 			
				try {
					controller.execute(choice);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					break;
			case 3:					
				try {
					controller.execute(choice);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					break; 
			case 4: 					
				try {
					controller.execute(choice);
				} catch (Exception e1) {
					System.out.println("error");
					e1.printStackTrace();
				}		
					break;
			case 5: 				
				try {
					controller.execute(choice);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					break;
			case 6: 
				try {
					controller.execute(choice);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					break;
			}
		}


	
	 public void start()
	   {
	      this.controller = controller;
	      ClientMenu();
	   }
}
