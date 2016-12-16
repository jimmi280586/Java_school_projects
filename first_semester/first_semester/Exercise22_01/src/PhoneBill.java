import java.util.ArrayList;


public class PhoneBill 
{
	private String phoneNo;
	private ArrayList<BillableItem> billableitem;
	
	public PhoneBill(String phoneNo)
	{
		this.phoneNo = phoneNo;
		this.billableitem = new ArrayList<BillableItem>();
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	public void addItem(BillableItem item){
		this.billableitem.add(item);
	}
	
	public int getNumberOfItems(){
		
		return this.billableitem.size();
	}
	
	public BillableItem getItem(int index){
		return billableitem.get(index-1);
	}
	public double getAmountDue(){
		double total = 0;
		for (int i = 0; i < billableitem.size(); i++){
			
			total += billableitem.get(i).getPrice();
		}
		return total;
	}
	
	public double getPhoneCallMinutes(){
		int minutes = 0;
		for (int i = 0; i < billableitem.size(); i++)
		{
			if(this.billableitem.get(i) instanceof PhoneCall)
			{
				minutes += ((PhoneCall) this.billableitem.get(i)).getMinutes();
			}
			
		}
		return minutes;
	}
	
	public ArrayList<TextMessage> getTextMassages()
	{
		ArrayList<TextMessage> textmessages = new ArrayList<TextMessage>();
		
		for (int i = 0; i < billableitem.size(); i++)
		{
			if (this.billableitem.get(i) instanceof TextMessage)
			{
				TextMessage textmessage = (TextMessage) this.billableitem.get(i);
				textmessages.add(textmessage);
			}
		}
		return textmessages;
	}
	
}
