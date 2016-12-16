import java.util.Date;


public class Tenant
{
	private String name;
	private Date rentedFrom;
	
	public Tenant(String name)
	{
		this.name = name;
		this.rentedFrom = new Date();
	}

	public Date getRentedFrom() {
		return this.rentedFrom;
	}

	public void setRentedFrom(Date date) {
		this.rentedFrom = date;
	}

	public String getName() {
		return this.name;
	}
	
}
