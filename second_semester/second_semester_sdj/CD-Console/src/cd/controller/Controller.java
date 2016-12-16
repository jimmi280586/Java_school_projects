package cd.controller;

import cd.domain.mediator.CdModel;
import cd.domain.model.Cd;
import cd.domain.model.CdList;
import cd.view.CdView;


public class Controller 
{
	private CdModel model;
	private CdView view;
		
	public Controller(CdModel model, CdView view)
	{
		this.model = model;
		this.view = view;
	}

	public void execute(String input)
	{
		
		switch (input)
		{
			
			case "List":
				this.view.show("" + this.model.getAll());
				break;
			case "Add":
				this.view.show("Add method - not implemented");
				break;
			case "Remove":
				String message;
				String input1 = this.view.get("Title");
				if (input1.length() == 0)
				{
					
					message = "";
					return;
					
				}
				Cd cd = this.model.removeCD(input1);
				if (cd != null)
				{
					message = "REMOVED: \n" + cd.toString();
				}
				else
				{
					message = "No CD with title: \"" + input1 + "\" found";
				}
				this.view.show(message);
				break;
			case "Search":
				String message1 = "";
				input1 = this.view.get("Title");
				if (input1 == null)
				{
					message1 = "";
					return;
					
				}
				CdList list = this.model.getCD(input1);
				
				for (int i = 0; i < list.getNumberOfCds(); i++)
				{
					message1 += list.getCD(i) + "\n";
				}
				if (list.getNumberOfCds() == 0)
				{
					message = "No CD with title: \"" + input1 + "\" found";
				}
				this.view.show(message1);
				break;
			case "Quit":
				System.out.println("Quit");
				break;
			default:
				this.view.show("Wrong input");
				break;
		}
		
	}

	
}
