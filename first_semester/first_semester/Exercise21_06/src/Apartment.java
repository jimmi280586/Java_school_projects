
public class Apartment extends Residence
{
	private int numberOfRooms;

	public Apartment(int number, double size, String type, Tenant rentedTo,	int numberOfRooms)
	{
		super(number, size, "apartment");
		this.numberOfRooms = numberOfRooms;
	}
	@Override
	public int getNumberOfRooms()
	{
		return numberOfRooms;
	}
	
	

	
	
	
}
