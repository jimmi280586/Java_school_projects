package linkedListRecursive;

//*****************************************************************************
//File name  : Main2LinkedList.java.
//Start date : 
//Programmer : Hans So.
//Java       : 
//Description: 
//
//Revision history:
//date     init  comment
//
//*****************************************************************************



public class Main2LinkedList
{
  public static void main (String[] args)
  {
    int choice;
    Element elem;
    LinkedList<Element> list = new LinkedList<Element>();
    
    String name;
    int number;
    
    do
    {
      menu();
      choice = Cin.readInt();
      switch (choice)
      {
        case 1 :  // addFirst
          System.out.print("Type name and number: ");
          name = Cin.readString();
          number = Cin.readInt();
          list.addFirst(new Element(name,number));
          break;
        case 2 :  // addLast
          System.out.println("addLast: to be implemented ");
          break;
        case 3 :  // removeFirst
          System.out.println("removeFirst: to be implemented ");
          break;
        case 4 :  // removeLast
          System.out.println("removeLast: to be implemented ");
          break;
        case 5 :  // print
          System.out.println("Print list:");
          list.print();          
          break;
        case 6 :  // printReverse
          System.out.println("Print reverse list:");
          list.printReverse();          
          break;
        case 7 :  // size
          System.out.println("size: to be implemented ");
          break;
        default :
          break;
      }
    }
    while (choice > 0);
    System.out.println("** End of test **");
  }
 
  private static void menu()
  {
    System.out.println("\n TEST-MENU");
    System.out.println(" 1) addFirst");
    System.out.println(" 2) addLast");
    System.out.println(" 3) removeFirst");
    System.out.println(" 4) removeLast");
    System.out.println(" 5) print");
    System.out.println(" 6) printReverse");
    System.out.println(" 7) size");
    System.out.println(" 0) Quit");
    System.out.print(" Type your choice: ");
  }
}
