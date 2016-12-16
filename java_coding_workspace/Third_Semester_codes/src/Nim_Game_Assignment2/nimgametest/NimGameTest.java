package nimgametest;

import exceptions.EmptyCollectionException;
import nimgame.Menu;

public class NimGameTest
{
   static Menu menu = new Menu();

   public static void main(String[] args) throws InterruptedException, EmptyCollectionException
   {
      menu.run();
   }

}
