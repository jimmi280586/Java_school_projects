
public class Route extends Trip
{
	private Harbor from;
	private Harbor to;
	
	public Route(Harbor from, Harbor to) 
	{
		super();
		this.from = from;
		this.to = to;
	}

	public Harbor getFrom() {
		return this.from;
	}

	public Harbor getTo() {
		return this.to;
	}
	
	
}
