

import java.rmi.RemoteException;

import controller.ClientController;
import controller.Controller;
import servers.ApplicationServer;
import servers.Model;
import view.ClientConsole;
import view.View;

public class ClientMain {

	public static void main(String[] args) {
		try {
			Model model = new ApplicationServer();
			View view = new ClientConsole();
			Controller controller = new ClientController(model, view);
			
			System.out.println("* Starting Client View *\n");
			view.start(controller);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}