
public class DurationTest
{
   public static void main(String[] args)
   {
      Duration dur = new Duration(351);
      Duration dur2 = new Duration(5, 51);
      System.out.println("Dur1: " + dur.toString());
      System.out.println("Dur2: " + dur2.toString());
      System.out.println(dur.equals(dur2));
   }
}
