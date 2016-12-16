package teacher;
/*
 * TextMessage inherits Serializable from BillableItem 
 */
public class TextMessage extends BillableItem
{
   /*
    * Version number is needed for every class - it's not inherited.
    */
   private static final long serialVersionUID = 1;
   private double smsPrice;
   private double extraCharges;
   
   public TextMessage(String date, String recepientNo, double smsPrice, double extraCharges)
   {
      super(date, recepientNo);
      this.smsPrice = smsPrice;
      this.extraCharges = extraCharges;
   }

   public double getSmsPrice()
   {
      return this.smsPrice;
   }

   public double getExtraCharges()
   {
      return this.extraCharges;
   }
   
   public double getPrice()
   {
      return this.smsPrice + this.extraCharges;
   }
   
   @Override
   public String toString()
   {
      return String.format("TextMessage(%s,  %s, %4.2f, %4.2f)", getDate(), getRecepient(), smsPrice, extraCharges);
   }
}
