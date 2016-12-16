import cd.controller.CdController;
import cd.domain.mediator.CdModel;
import cd.domain.mediator.CdModelManager;
import cd.view.CdGUI;
import cd.view.CdView;

public class Main
{
	public static void main(String args[])
	{
		try
		{
			CdModelManager model = new CdModelManager();
			CdView view = new CdGUI();
			CdController controller = new CdController(model, view);

			view.start(controller);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
