import java.util.ArrayList;


public class FerrySchedule 
{
 
	private ArrayList<Departure> departure;
 
	public FerrySchedule()
	{
		this.departure = new ArrayList<Departure>();
	}
	
	public void addDeparture(String dayAndTime, Trip trip)
	{
		this.departure.add(new Departure(dayAndTime, trip));
	}
	
	public int getDepartureCount()
	{
		return this.departure.size();
	}
	
	public Departure getDeparture(int index)
	{
		return this.departure.get(index);
	}
	
	public ArrayList<Departure> getDeparturesFrom(Harbor harbor)
	{
		ArrayList<Departure> departuresfrom = new ArrayList<Departure>();
		
		for (int i = 0; i < this.departure.size(); i++)
		{
			Departure departure = this.departure.get(i);
			if (departure.getFrom().equals(harbor))
			{
				departuresfrom.add(departure);
			}
		}
		return departuresfrom;
	}
}
