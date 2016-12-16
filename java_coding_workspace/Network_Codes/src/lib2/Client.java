package lib2;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import lib2.domain.controller.ClientController;
import lib2.domain.view.ClientView;


public class Client
{
	public static void main(String[] args) throws Exception 
	{		
		ClientView view = new ClientView();		
		view.start();
	}
}
