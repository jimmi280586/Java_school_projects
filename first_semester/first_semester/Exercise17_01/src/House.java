
public class House 
{

	private double size;
	private Address address;
	
	public House(double size, Address address) {
		super();
		this.size = size;
		this.address = address.copy();
	}

	public double getSize() {
		return size;
	}

	public Address getAddress() {
		return address.copy();
	}
	
	
}
