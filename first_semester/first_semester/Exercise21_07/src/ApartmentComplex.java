import java.util.ArrayList;


public class ApartmentComplex 
{
	
	private String address;
	ArrayList<Residence> residences = new ArrayList<Residence>();
	
	public ApartmentComplex(String address) 
	{
		this.address = address;
	}
	
	public int getNumberOfResidence()
	{
		return residences.size();
	}
	
	public void add(Residence residence)
	{
		this.residences.add(residence);
	}
	
	public Residence getResidence(int index)
	{
		return this.residences.get(index-1);
	}
	 
	public Residence getResidenceByNumber(int number)
	{
		for(Residence residence : this.residences)
		{
			if (residence.getNumber() == number)
			{
				return residence;
			}
		}
		return null;
	}
	
	 public Room getAvailableRoom()
	 {
		 // Loop through the ArrayList
		 for (int i = 0; i < this.residences.size(); i++)
		 {
			 // If the element at the current index
			 // Is a room and is available
			 if (this.residences.get(i) instanceof Room && this.residences.get(i).isAvailable())
			 {
				 // Return the element at the current index
				 return (Room) this.residences.get(i);
			 }
		 }
	 
		 // If no available Rooms were found, return null
		 return null;
	 }
	 
	 public Apartment getAvailableApartment(int minNoOfRooms)
	 {
	
		 // Use a foreach loop for convenience
		 for (Residence residence : this.residences)
		 {
	
			 // If the current residence
			 // is an Apartment and is available
			 // and has at least the minimum number of rooms
			 if (residence instanceof Apartment
					 && residence.isAvailable()
					 && residence.getNumberOfRooms() >= minNoOfRooms)
			 {
	
				 // Return the current residence
				 return (Apartment) residence;
			 }
		 }
	 
		 	// If no suitable Apartments were found, return null
		 	return null;
	 }
}
