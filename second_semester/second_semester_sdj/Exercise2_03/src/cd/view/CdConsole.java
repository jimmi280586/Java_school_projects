package cd.view;
import java.util.Scanner;

import cd.controller.Controller;


public class CdConsole implements CdView
{
   private Scanner in;
   private Controller controller;

   public CdConsole()
   {
      in = new Scanner(System.in);
      controller = null;
   }

   @Override
   public void show(String value)
   {
      System.out.println(value);
   }

   @Override
   public String get(String what)
   {
      System.out.print("Please enter: " + what + ": ");
      String input = in.nextLine();
      return input;
   }

   private int menu()
   {
      System.out.println("CD Application");
      System.out.println("--------------");
      System.out.println("1) Add new CD to stack");
      System.out.println("2) Se title of top CD");
      System.out.println("3) Remove top CD from stack");
      System.out.println("4) check if stack is empty");
      System.out.println("5) get the number of Cds in stack");
      System.out.println("6) get number of cds to pop until desiret cd");
      System.out.println("7) Quit");
      System.out.println();
      System.out.print("Select an item 1-5: ");
      int selection = in.nextInt();
      in.nextLine();
      return selection;
   }

   @Override
   public void start(Controller controller)
   {
	   this.controller = controller;
	   int menuSelection;
	   do
	   {
	   menuSelection = menu();
	   switch (menuSelection)
	   {
	   	case 1:
	   		controller.execute("Add");
	   		break;
	   	case 2:
	   		controller.execute("Title");
	   		break;
	   	case 3:
	   		controller.execute("Remove");
	   		break;
	   	case 4:
	   		controller.execute("Empty");
	   		break;
	   	case 5:
	   		controller.execute("Size");
	   		break;
	   	case 6:
	   		controller.execute("PopNr");
	   		break;	
	   	case 7:
		   controller.execute("Quit");
		   break;
	   	default:
	   		show("Wrong input");
	   		break;
	   }
	   	System.out.println("\nPress ENTER to continue...");
	   	in.nextLine();
	   }
	   	while (menuSelection != 5);

   }





}
