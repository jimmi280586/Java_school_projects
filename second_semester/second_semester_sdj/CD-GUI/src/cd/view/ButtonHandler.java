package cd.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import cd.controller.Controller;
import cd.domain.model.Cd;
import cd.domain.model.CdList;

	public class ButtonHandler implements ActionListener
	{
		private Controller controller;
		private CdGUI gui;

		public ButtonHandler(Controller controller, CdGUI gui)
		{
			this.controller = controller;
			this.gui = gui;
		}

		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (!(e.getSource() instanceof JButton))
				return;
			if (((JButton) e.getSource()).getText().startsWith("List"))
			{
				this.controller.execute("List");
			}
			else if (((JButton) e.getSource()).getText().startsWith("Add"))
			{
				this.controller.execute("Add");
				String message = "Add method - not implemented";
				gui.show(message);
			}
			else if (((JButton) e.getSource()).getText().startsWith("Remove"))
			{
				this.controller.execute("Remove");
			}
			else if (((JButton) e.getSource()).getText().startsWith("Search"))
			{
				this.controller.execute("Search");
			}
			else if (((JButton) e.getSource()).getText().startsWith("Quit"))
			{
				this.controller.execute("Quit");
				System.exit(0);
			}
		}
}