
public abstract class BillableItem 
{
	private String date;
	private String recepientNo;
	
	public BillableItem(String date, String recepientNo)
	{
		this.date = date;
		this.recepientNo = recepientNo;
	}

	public String getDate() {
		return this.date;
	}

	public String getRecepientNo() {
		return this.recepientNo;
	}
	
	public abstract double getPrice();
	
}
