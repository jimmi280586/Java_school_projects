import java.util.ArrayList;


public class CodeListing_7_29
{

   public static void main(String[] args)
   {
     ArrayList<String> nameList = new ArrayList<String>();
     
     nameList.add("james");
     nameList.add("Catherine");
    nameList.add("Bill");
     
     System.out.println("the arraylist has " + nameList.size() + " objects stored in it.");

     for (int index = 0; index < nameList.size(); index++)
     System.out.println(nameList.get(index));// this will not print
     // the mening with this is to print the names in the array
     
     // the difference between code 29 and 30 is the for loop and the print of the names
     
     
 String [] nameList1= new String[3];
     
     nameList1[0] = ("james");
     nameList1[1] = ("Catherine");
     nameList1[2] = ("Bill");
     
     System.out.println("the arraylist has " + nameList1.length + " objects stored in it.");

     for (int index = 0; index < nameList1.length; index++)
     System.out.println(nameList1[index]);
   }

}
