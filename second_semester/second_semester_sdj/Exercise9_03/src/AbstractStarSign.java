
public abstract class AbstractStarSign 
{
	private String name;
	private DateInterval interval;
	
	
	public AbstractStarSign(String name) 
	{		
		this.name = name;
	}
	
	public abstract String getName();
	public abstract DateInterval getInterval();
	public abstract String toString();
	
	
	
}
