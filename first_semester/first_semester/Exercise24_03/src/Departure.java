
public class Departure 
{
	private String DayAndTime;
	private Trip trip;

		
	public Departure(String dayAndTime, Trip trip)
	{
		this.DayAndTime = dayAndTime;
		this.trip = trip;
		
	}

	public String getDayAndTime() {
		return DayAndTime;
	}
	
	public Harbor getFrom()
	{
		return this.trip.getFrom();
	}
	
	public Harbor getTo()
	{
		return this.trip.getTo();
	}
}
