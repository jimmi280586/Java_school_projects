import java.util.Calendar;


public class Log
{
	private boolean printout;
	private ListADT<String> que;
	
	public Log(boolean printout)
	{
		this.printout = printout;
		this.que = new LinkedList<String>();
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

	public static void main(String[] args) {
		
		Log l = new Log(true);
		l.add("cd", true);
		l.add("dvd", false);
		
		System.out.println(l.getAll().toString());
	}
}
