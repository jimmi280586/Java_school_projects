// *****************************************************************************
// File name  : Main2IntTable.java
// Start date : 
// Programmer : Hans So.
// Java       : Java 
// Description: 
// *****************************************************************************

package utillity.problemsolving;

import utillity.object.Cin;

public class Main2IntTable
{
  public static void main (String[] args)
  {
    int choice;
    
    IntTable intTable = null;
    int n;
    int value;
    
    do
    {
      menu();
      choice = Cin.readInt();
      switch (choice)
      {
        case 1 :  // create table
          System.out.print("Create table; type length: ");
          n = Cin.readInt();
          intTable = new IntTable (n);
          System.out.println("Table of length " + intTable.length() + " is created");
          break;
        case 2 :  // insert value
          System.out.print("Insert: type value: ");
          value = Cin.readInt();
          intTable.insert (value);
          System.out.println("Table has " + intTable.size() + " values");
          break;
        case 3 :  // remove value
          System.out.print("Remove: type value: ");
          value = Cin.readInt();
          intTable.remove(value);
          System.out.println("Table has " + intTable.size() + " values");
          break;
        case 4 :  // print table
          System.out.println(intTable.toString());
          break;
        default :
          break;
        case 5 :  // removeall of same value
            System.out.print("RemoveAll: type value: ");
            value = Cin.readInt();
            intTable.removeAll(value);
            System.out.println("Table has " + intTable.size() + " values");
            break;
        case 6 :  // remove last value
            System.out.print("Remove last: value: ");
            intTable.removeLast();
            System.out.println("Table has " + intTable.size() + " values");
            break;
        case 7 :  // find index of value
            System.out.print("find index number: type value: ");
            value = Cin.readInt();
            System.out.println("index number is " + intTable.findIndex(value) + " ");
            break;
        case 8 :  // get maximum value
            System.out.print("get the maximum number ");
            System.out.println("maximum number is " + intTable.getMax() + " ");
            break;
        case 9 :  // get minimum value
            System.out.print("get minimum number ");
            System.out.println("minimum value is " + intTable.getMin() + " ");
            break;
        case 10 :  // how many of same value
            System.out.print("how many of the same number : type value: ");
            value = Cin.readInt();
            System.out.println("Table has " + intTable.howMany(value) + " of the same value");
            break;
        case 11 :  // get mean value
            System.out.print("the mean number ");
            System.out.println("the mean number is " + intTable.mean() + " ");
            break;
        case 12 :  // print table
            System.out.println(intTable.sorttoString());
            break;
         
      }
    }
    while (choice > 0);
    System.out.println("** End **");
  }
 
  private static void menu()
  {
    System.out.println(" MENU");
    System.out.println(" 1) create table");
    System.out.println(" 2) insert element");
    System.out.println(" 3) remove element");
    System.out.println(" 4) print table");
    System.out.println(" 5) remove all of same element");
    System.out.println(" 6) remove last element");
    System.out.println(" 7) print index of element");
    System.out.println(" 8) print maximum number");
    System.out.println(" 9) print minimum number");
    System.out.println(" 10) print how many of same number");
    System.out.println(" 11) print mean number");
    System.out.println(" 12) print sorted table");
    System.out.println(" 0) Quit");
    System.out.print(" Type your choice: ");
  }
}
