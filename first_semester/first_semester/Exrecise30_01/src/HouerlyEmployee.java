
public class HouerlyEmployee extends Employee
{
	private double wagePerHour;
	private double hoursWorkedPerWeek;
	
	public HouerlyEmployee(String name, Date birthday, double wagePerHour,
			double hoursWorkedPerWeek)
	{
		super(name, birthday);
		this.wagePerHour = wagePerHour;
		this.hoursWorkedPerWeek = hoursWorkedPerWeek;
	}

	public double getWagePerHour() 
	{
		return wagePerHour;
	}

	public void setWagePerHour(double wagePerHour)
	{
		this.wagePerHour = wagePerHour;
	}

	public double getHoursWorkedPerWeek() 
	{
		return hoursWorkedPerWeek;
	}

	public void setHoursWorkedPerWeek(double hoursWorkedPerWeek)
	{
		this.hoursWorkedPerWeek = hoursWorkedPerWeek;
	}
	
	public double earningsPerWeek()
	{
		return (this.hoursWorkedPerWeek * this.wagePerHour);
	}

	@Override
	public String toString()
	{
		return super.toString() + "wagePerHour = " + wagePerHour
				+ ", hoursWorkedPerWeek = " + hoursWorkedPerWeek + "";
	}

	@Override
	public boolean equals(Object obj) {
	if(!(obj instanceof HouerlyEmployee))
	{
		return false;
	}
		HouerlyEmployee other = (HouerlyEmployee) obj;
		 return super.equals(obj) 
				 && this.wagePerHour == other.wagePerHour 
				 && this.hoursWorkedPerWeek == other.hoursWorkedPerWeek;
				
	}
	
	
}
