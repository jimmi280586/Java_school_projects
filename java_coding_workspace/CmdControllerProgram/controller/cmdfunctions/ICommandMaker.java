package cmdfunctions;

public interface ICommandMaker 
{
	public Command cancelShutdown();
	
	public Command shutdownTimer(int timer);
	
	public Command shutdownTimerMessage(int timer, String msg);
	
	public Command shutdownNow();
	
	public Command hibernate();
	
	public Command restart();
	
	public Command diskpart(); //only opens the disk part command promt
	
	
	
	
}
