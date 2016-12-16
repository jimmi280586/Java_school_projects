package teacher;
/*
 * PhoneCall inherits Serializable from BillableItem.
 */
public class PhoneCall extends BillableItem
{
   /*
    * Version number is needed for every class - it's not inherited.
    */
   private static final long serialVersionUID = 1;
   private int minutes;
   private double pricePerMinute;
   
   public PhoneCall(String date, String recepientNo, int minutes, double pricePerMinute)
   {
      super(date, recepientNo);
      this.minutes = minutes;
      this.pricePerMinute = pricePerMinute;
   }

   public int getMinutes()
   {
      return minutes;
   }

   public double getPricePerMinute()
   {
      return pricePerMinute;
   }
   
   public double getPrice()
   {
      return this.minutes * this.pricePerMinute;
   }
   
   @Override
   public String toString()
   {
      return String.format("PhoneCall(%s, %s, %d, 4.2%f)", getDate(), getRecepient(), minutes, pricePerMinute);
   }
}
