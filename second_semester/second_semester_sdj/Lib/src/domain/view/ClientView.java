package domain.view;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import domain.controller.ClientController;


public class ClientView 
{
	ClientController controller;
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
			in.nextLine();
			String title, type1;
			int type2;
			switch(choice)
			{
			case 1: 
				System.out.println("enter title of item");
				title = in.nextLine();
				System.out.println("enter item`s type Book, Cd, Dvd, Article");
				type1 = in.nextLine();
				type2 = type(type1);
				try {
					controller.execute(choice, "lend", title, type2);
				} catch (TransformerException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			case 2: 
				System.out.println("enter title of item");
				title = in.nextLine();
				System.out.println("enter item`s type Book, Cd, Dvd, Article");
				type1 = in.nextLine();
				type2 = type(type1);
				try {
					controller.execute(choice, "return", title, type2);
				} catch (TransformerException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			case 3:				
				System.out.println("enter item`s type Book, Cd, Dvd, Article");
				type1 = in.nextLine();
				type2 = type(type1);
				try {
					controller.execute(choice, "add", null, type2);
				} catch (TransformerException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break; 
			case 4: 
				System.out.println("enter title of item");
				title = in.nextLine();
				System.out.println("enter item`s type Book, Cd, Dvd, Article");
				type1 = in.nextLine();
				type2 = type(type1);
				try {
					controller.execute(choice, "search", title, type2);
				} catch (TransformerException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			case 5: 
				System.out.println("enter title of item");
				title = in.nextLine();
				System.out.println("enter item`s type Book, Cd, Dvd, Article");
				type1 = in.nextLine();
				type2 = type(type1);
				try {
					controller.execute(choice, "reserve", title, type2);
				} catch (TransformerException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			case 6: 
				try {
					controller.execute(choice, "quit", null, 0);
				} catch (TransformerException | ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
			}
		}

	private int type(String type)
	{
		if(type.equalsIgnoreCase("book"))
			return 1;
		else if(type.equalsIgnoreCase("cd"))
			return 2;
		else if(type.equalsIgnoreCase("dvd"))
			return 3;
		else if(type.equalsIgnoreCase("article"))
			return 4;
		else return -1;
	}
	
	 public void start(ClientController controller)
	   {
	      this.controller = controller;
	      ClientMenu();
	   }
}
