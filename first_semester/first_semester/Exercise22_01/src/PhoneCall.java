
public class PhoneCall extends BillableItem
{
	private int minutes;
	private double pricePerMinute;

	public PhoneCall(String date, String recepientNo, int minutes, double pricePerMinute) 
	{
		super(date, recepientNo);
		this.minutes = minutes;
		this.pricePerMinute = pricePerMinute;
	}

	public int getMinutes() {
		return minutes;
	}

	public double getPricePerMinute() {
		return pricePerMinute;
	}
	
	@Override
	public double getPrice()
	{
		return (this.pricePerMinute * this.minutes);
	}
}
