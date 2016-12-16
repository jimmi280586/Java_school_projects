
public class RoundTrip extends Trip
{
	private Harbor harbor;

	public RoundTrip(Harbor harbor) 
	{
		super();
		this.harbor = harbor;
	}
	
	public Harbor getFrom()
	{
		return this.harbor;
	}
	
	public Harbor getTo()
	{
		return this.harbor;
	}
}
