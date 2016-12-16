import chat.controller.ServerController;
import chat.domain.mediator.ServerModelManager;
import chat.domain.view.ServerView;


public class Server
{

	public static void main(String[] args)
	{
		{
			ServerModelManager manager = new ServerModelManager();
			ServerView view = new ServerView();
			ServerController control = new ServerController(manager, view);
			view.start(control);
		}

	}

}
