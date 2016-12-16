package lib2.domain.mediator;

public class TranslationThread extends Thread
{
	private String message;
	private String ReturnMessage;
	
	
	
	public TranslationThread(String message)
	{
		this.message = message;
	}
	
	public void run()
	{
		char[] s = this.message.toCharArray();
		String msg = "";
		for (int i = 1; i < s.length; i++)
		{
			msg += s[i];
		}
		
		System.out.println(msg);
		
		SearchThread t = new SearchThread(msg);
		this.ReturnMessage = t.getReturnMessage();
		
	}
	
	public String getReturnMessage()
	{
		run();
		return this.ReturnMessage;
	}
}
