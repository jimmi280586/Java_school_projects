package domain.controller;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import domain.mediator.ServerModelManager;
import domain.model.Item;
import domain.view.ServerView;
import utility.HardCodeMethods;



public class ServerController
{
	private ServerModelManager modelManager;
	private ServerView view;
	private String message;
	private int what1;
	private String title1;
	private int type1;

	public ServerController(){}
	public ServerController(ServerModelManager model, ServerView view)
	{
		this.modelManager = model;
		this.view = view;		
	}
	
	public void execute(int what)
	{
		switch(what)
		{
		
		case 1: 
			System.out.println("lending not coded");
				break;
		case 2: 
			System.out.println("returning not coded");
				break;
		case 3:				
			System.out.println("adding not coded");
				break; 
		case 4: 		
				Item s = searchList(this.title1);
				modelManager.setMessage(s.toString());
			
				break;
		case 5: 
			System.out.println("reserving not coded");
				break;
		case 6: 
			System.exit(0);
				break;
		}
	}
		
		
	private Item searchList(String title2)
	{
		  HardCodeMethods hard = null;
	     ArrayList<Item> list = hard.hardCodedList();
	    		
		for (int i = 0; i < list.size(); i++) 
		{		
			if(list.get(i).getTitle().equals(title2))
				return list.get(i);
		}
		return null;
		
	}


	
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public void getItem()
	{
		String what = null, title, type;
		char[] array;
		array = this.message.toCharArray();
		int nr = 1;
		for (int i = 0; i < array.length; i++) 
		{
			char in = array[i];
			if(in == 46)
			{
				translate(what, nr);
				nr++;
			}
			what += in;
		}
		execute(this.what1);
	}
	private void translate(String what, int i) 
	{
		if(i == 1)
		{
			this.what1 = Integer.parseInt(what);
		}
		else if(i == 2)
		{
			this.title1 = what;
		}
		else if(i == 3)
		{
			this.type1 = Integer.parseInt(what);
		}
		
	}
	
}
