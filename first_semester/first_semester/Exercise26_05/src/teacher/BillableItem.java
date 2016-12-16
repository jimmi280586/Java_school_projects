package teacher;
import java.io.Serializable;


/*
 * We add 'implements Serializable' to BillableItem 
 * in order to write it to a file. 
 */
public abstract class BillableItem implements Serializable
{
   /*
    * Putting a version number is good practice
    * and saves us a warning from Eclipse.
    */
   private static final long serialVersionUID = 1;
   private String date;
   private String recepient;
   
   public BillableItem(String date, String recepient)
   {
      this.date = date;
      this.recepient = recepient;
   }
   
   public String getDate()
   {
      return this.date;
   }
   
   public String getRecepient()
   {
      return this.recepient;
   }
   
   public abstract double getPrice();
}
