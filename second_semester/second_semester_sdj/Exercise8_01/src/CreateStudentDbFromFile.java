import java.io.FileNotFoundException;
import java.sql.SQLException;

import utility.persistence.MyDatabase;

public class CreateStudentDbFromFile
{
  public static void main(String args[])
  {
    final String FILENAME = "xclass.sql"; 
    int[] updates=null;
    try
    {
      MyDatabase db = new MyDatabase();
      updates = db.updateAll(FILENAME);
    }
    catch (FileNotFoundException | SQLException | ClassNotFoundException e)
    {
      System.out.println("Database issue");
      e.printStackTrace();
    }

    // and if you want to see the number of updates:
    int sum = 0;
    for (int i = 0; i < updates.length; i++)
    {
      sum += updates[i];
    }
    System.out.println("Number of updates: " + sum);
  }
}
