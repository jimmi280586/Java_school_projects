package lib2.domain.controller;
import lib2.domain.mediator.TCPservermanager;
import lib2.domain.view.ServerView;



public class ServerController
{
	private TCPservermanager modelManager;
	private ServerView view;
	private String message;
	private int what1;
	private String title1;
	private int type1;

	public ServerController(){}
	public ServerController(ServerView view)
	{	
		this.modelManager = new TCPservermanager();
		this.view = view;		
	}
	
	public void execute(int what) throws Exception
	{
		
		switch(what)
		{		
		case 1: 
			modelManager.StartServer();
			System.out.println("server started");
			break;
		case 2: 
			System.exit(0);
			break;
		}
	}

	
}
