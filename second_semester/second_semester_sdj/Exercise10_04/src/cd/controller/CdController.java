package cd.controller;

import cd.domain.mediator.CdModel;
import cd.domain.mediator.CdModelManager;
import cd.domain.model.Cd;
import cd.domain.model.CdList;
import cd.view.CdView;

public class CdController 
{
	private CdModel model;
	private CdView view;

	public CdController(CdModelManager model, CdView view) // Violates polymorphism, but it's in the chart...
	{
		this.model = model;
		this.view = view;
		model.addObserver(view);
	}

	public void execute(String what)
	{
		switch (what)
		{
		case "List":
			this.view.show("" + this.model.getAll());
			break;
		case "Add":
			this.view.show("Add method - not implemented");
			break;
		case "Remove":
			String input = this.view.get("title");
			if (input == null)
				return;
			String msg = "";
			Cd cd = this.model.removeCD(input);
			if (cd != null)
			{
				msg = "REMOVED: \n" + cd.toString();
			}
			else
			{
				msg = "No CD with title: \"" + input + "\" found";
			}
			//this.view.show(msg);
			break;
		case "Search":
			String searchInput = this.view.get("title");
			if (searchInput == null)
				return;
			String searchMsg = "";
			
			CdList list = this.model.getCD(searchInput);
			for (int i = 0; i < list.getNumberOfCds(); i++)
			{
				searchMsg += list.getCD(i) + "\n";
			}
			if (list.getNumberOfCds() == 0)
			{
				searchMsg = "No CD with title: \"" + searchInput + "\" found";
			}
			//this.view.show(searchMsg);
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
