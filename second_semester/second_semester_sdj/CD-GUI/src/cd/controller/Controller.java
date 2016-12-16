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
		
		public void execute(String input1)
		{
			switch (input1)
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
				String message = "";
				Cd cd = this.model.removeCD(input);
				if (cd != null)
				{
					message = "REMOVED: \n" + cd.toString();
				}
				else
				{
					message = "No CD with title: \"" + input + "\" found";
				}
				this.view.show(message);
				break;
			case "Search":
				String searchInput = this.view.get("title");
				if (searchInput == null)
					return;
				String searchMessage = "";
				CdList list = this.model.getCD(searchInput);
				for (int i = 0; i < list.getNumberOfCds(); i++)
				{
					searchMessage += list.getCD(i) + "\n";
				}
				if (list.getNumberOfCds() == 0)
				{
					searchMessage = "No CD with title: \"" + searchInput + "\" found";
				}
				this.view.show(searchMessage);
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