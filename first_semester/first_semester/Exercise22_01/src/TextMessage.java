
public class TextMessage extends BillableItem
{
	private double smsPrice;
	private double extraCharges;
	
	public TextMessage(String date, String recepientNo, double smsPrice, double extraCharges) 
	{
		super(date, recepientNo);
		this.smsPrice = smsPrice;
		this.extraCharges = extraCharges;
	}

	public double getSmsPrice() {
		return smsPrice;
	}

	public double getExtraCharges() {
		return extraCharges;
	}
	
	@Override
	public double getPrice()
	{
		return (this.extraCharges + this.smsPrice);
	}
}
