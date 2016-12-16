package teacher;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * We implement Serializable in order to write 
 * phone bills to a disk.
 */
public class PhoneBill implements Serializable
{
   /*
    * Version number.
    */
   private static final long serialVersionUID = 1;
   private String phoneNo;
   /*
    * It's important that BillableItem is also Serializable.
    * Otherwise, we cannot serialize PhoneBill
    */
   private ArrayList<BillableItem> items;
   
   public PhoneBill(String phoneNo)
   {
      this.phoneNo = phoneNo;
      this.items = new ArrayList<BillableItem>();
   }

   public String getPhoneNo()
   {
      return phoneNo;
   }

   public void setPhoneNo(String phoneNo)
   {
      this.phoneNo = phoneNo;
   }
   
   public void addItem(BillableItem item)
   {
      this.items.add(item);
   }
   
   public int getNumberOfItems()
   {
      return this.items.size();
   }
   
   public BillableItem getItem(int index)
   {
      return this.items.get(index);
   }
   
   public double getAmountDue()
   {
      double amountDue = 0.0;
      for(int i = 0; i < this.items.size(); i++)
      {
         amountDue += this.items.get(i).getPrice();
      }
      return amountDue;
   }
   
   public double getPhoneCallMinutes()
   {
      double phoneCallMinutes = 0.0;
      for(int i = 0; i < this.items.size(); i++)
      {
         if (this.items.get(i) instanceof PhoneCall)
         {
            PhoneCall phoneCall = (PhoneCall) this.items.get(i);
            phoneCallMinutes += phoneCall.getMinutes();
         }
      }
      return phoneCallMinutes;
   }
   
   public ArrayList<TextMessage> getTextMessages()
   {
      ArrayList<TextMessage> textMessages = new ArrayList<TextMessage>();
      for(int i = 0; i < this.items.size(); i++)
      {
         if (this.items.get(i) instanceof TextMessage)
         {
            TextMessage textMessage = (TextMessage) this.items.get(i);
            textMessages.add(textMessage);
         }
      }
      return textMessages;
   }
}
