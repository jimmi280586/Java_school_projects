package chat.controller;

import chat.domain.view.ServerView;
import chat.domain.mediator.ServerModelManager;
import chat.domain.model.AbstractMessage;
import chat.domain.model.PrivateMessage;
import chat.domain.model.PublicMessage;

public class ServerController
{
	private ServerModelManager modelManager;
	private ServerView view;
	
	public ServerController(ServerModelManager model, ServerView view)
	{
		this.modelManager = model;
		this.view = view;
		
	}
	
	public void execute(String what)
	{
		modelManager.add(new PublicMessage("server",what));;
		
	}
	
}
