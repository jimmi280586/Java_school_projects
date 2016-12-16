package cd.controller;



import java.util.Scanner;

import cd.MyCdPile;
import cd.domain.model.Cd;
import cd.domain.model.CdTrack;
import cd.domain.model.Time;
import cd.view.CdView;


public class Controller 
{
	Scanner input = new Scanner(System.in);
	private MyCdPile model;
	private CdView view;
	
	public Controller( CdView view)
	{
		
		this.view = view;
	}

	public void execute(String what)
	{
		
			
		switch (what)
		{
			case "Add":
				
				this.model.push(createElement());
				this.view.show("element created");
				break;
			case "Title":
				this.view.show("" + this.model.peek().getTitle());
				break;
			case "Remove":
				this.model.pop();
				System.out.println("element is removed");
				break;
			case "Empty":
				if(this.model.isEmpty() == true)
				{
					System.out.println("stack empty");
				}
				else
				{
					System.out.println("stack is not empty");
				}
				break;			
			case "Size":
				this.view.show("" + this.model.size());
				break;
			case "PopNr":
				System.out.println("input title");
				int result = -1;
				String title = input.nextLine();
				for (int i = 0; i < this.model.size(); i++) 
				{
					if(this.model.peek().getTitle().equals(title))
					{
						result = i;
					}
				}
				this.view.show("" + result);
			case "Quit":
				System.out.println("Quit");
				break;
			default:
				this.view.show("Wrong input");
				break;
		}
	}

	private Cd createElement()
	{
		int number;
		int count = 0;
		String title = null;
		String artist = null;
		
		
		System.out.println("please input cd title");
		title = input.nextLine().toUpperCase();
		System.out.println("please input cd artist");
		artist = input.nextLine().toUpperCase();
		System.out.println("please input number of tracks");
		number = input.nextInt();
		title = input.nextLine(); 
		CdTrack[] track = new CdTrack[number];
		while(count < number)
		{
			System.out.println("please input track title");
			title = input.nextLine().toUpperCase();
			System.out.println("please input track artist");
			artist = input.nextLine().toUpperCase();
			System.out.println("please input hour");
			int hour = input.nextInt();
			System.out.println("please input minuts");
			int min = input.nextInt();
			System.out.println("please input seconds");
			int sec = input.nextInt();
			Time time = new Time(hour, min, sec);
			
			track[count] = new CdTrack(title, artist, time);
			
		}
		
		Cd cd = new Cd(title, artist, track);

		return cd;
	}

	
}
