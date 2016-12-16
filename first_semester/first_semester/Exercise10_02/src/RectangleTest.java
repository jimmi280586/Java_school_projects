
public class RectangleTest
{

   public static void main(String[] args)
   {
      Rectangle box = new Rectangle();
      
      box.setHeight(12);
      box.setWidth(7);
      box.getArea();
      
      System.out.println(box.getHeight() + " " + box.getWidth() + " " + box.getArea());
   }

}
