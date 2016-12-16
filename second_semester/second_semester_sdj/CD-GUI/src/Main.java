import java.io.IOException;

import javax.swing.JOptionPane;
import cd.controller.Controller;
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
		   CdModel model = new CdModelManager();
		   CdView view = new CdGUI();
		   Controller controller = new Controller(model, view);
		   view.start(controller);
	   }
	   	catch (Exception e)
	   {
	   		e.printStackTrace();
	   }
   }
}
