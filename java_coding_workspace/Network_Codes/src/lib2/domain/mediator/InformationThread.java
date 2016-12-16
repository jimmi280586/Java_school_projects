package lib2.domain.mediator;

import java.util.Scanner;

public class InformationThread extends Thread
{
	private String message;
	private int Choice;
	private Scanner in = new Scanner(System.in);
	
	public InformationThread(int choice)
	{
		this.Choice = choice;
	}
	
	public void run()
	{
		switch(this.Choice)
		{
		case 1:
			System.out.println("lend not implemented");
			break;
		case 2:
			System.out.println("return not implemented");
			break;
		case 3:
			System.out.println("add not implemented");
			break;
		case 4:
			System.out.println("please input title");
			String msg = in.nextLine();
			this.message = this.Choice + msg;
			break;
		case 5:
			System.out.println("reserve not implemented");
			break;
		case 6:
			System.exit(0);
			break;	
		}
		
	}
	
	public String getMessage()
	{
		run();
		return this.message;
	}
}
