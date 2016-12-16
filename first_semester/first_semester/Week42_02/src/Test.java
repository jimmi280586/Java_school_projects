
public class Test
{
   // Here, we're testing to see if using == with null works
   public static void main(String[] args)
   {
      MyDate date = new MyDate(1, 1, 2014);
      Tenant alice = new Tenant("Alice");
      Apartment apt = new Apartment(300);
      
      System.out.println(apt.isAvailabe());
      apt.rentTo(alice, date);
      System.out.println(apt.isAvailabe());

   }
}
