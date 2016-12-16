package lib2.domain.mediator;

import java.util.ArrayList;

import lib2.utility.HardCodeMethods;
import lib2.domain.model.Item;

public class SearchThread extends Thread
{
	private String title;
	private ArrayList<Item> list;
	private HardCodeMethods hard;
	private String messageReturn;

	public SearchThread(String title)
	{
		this.list = hard.hardCodedList();
		this.title = title;
	}
	
	public void run()
	{
		System.out.println(this.title);
		int index = this.list.size() - 1;
		boolean a = false;
		while(a == false)
		{		
			System.out.println(this.list.get(index));
			if(this.list.get(index).getTitle().equals(this.title))
			{
				this.messageReturn = this.list.get(index).toString();
				a = true;
				
			}
			else
				a = false;
			index--;
		}
	}
	
	public String getReturnMessage()
	{				
		run();
		System.out.println(this.messageReturn);
		return this.messageReturn;
	}
}
