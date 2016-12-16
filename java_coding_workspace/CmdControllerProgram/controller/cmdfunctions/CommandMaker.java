package cmdfunctions;

public class CommandMaker implements ICommandMaker
{

	private int commandId = 0;

	@Override
	public Command cancelShutdown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command shutdownTimer(int timer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command shutdownTimerMessage(int timer, String msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command shutdownNow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command hibernate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command restart() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * this method is for starting the windows diskpart command line promt
	 * only for experiances users.
	 */
	@Override
	public Command diskpart() {
		int id = commandId ;
		Command res = new Command(id, "diskpart");
		id++;
		return res;
	}

}
