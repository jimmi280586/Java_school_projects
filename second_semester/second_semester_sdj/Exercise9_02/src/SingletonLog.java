import java.util.Calendar;


public class SingletonLog
{
	private static SingletonLog instance = null;
	private ListADT<String> que = new LinkedList<String>();;
		
	
	private SingletonLog()
	{		
		
	}
	
	public static SingletonLog getInstance()
	{
		if(instance != null)
		{
		System.out.println("can´t start constructor");
		}
		if(instance == null)
		{
			System.out.println("started constructor");
			instance = new SingletonLog();
		}
		
		return instance;
	}
	
	public void add(String log, boolean b)
	{
		if(b == true)
		{			
			log = Calendar.getInstance().getTime() + " " + log;
			
			this.que.add(log);
			System.out.println(log + " has been added");
		}
		else
		{
			log = Calendar.getInstance().getTime() + " " + log;
			
			this.que.add(log);
		}
		
	}
	
	public ListADT<String> getAll()
	{
		
		return this.que;
	}


}
