import java.sql.SQLException;
import java.util.ArrayList;

import students.domain.model.Student;
import students.domain.model.StudentCollection;
import utility.persistence.MyDatabase;


public class Testing {

	public static void main(String[] args) 
	{
		StudentCollection col = new StudentCollection();
		
		 try {
			  MyDatabase db = new MyDatabase("sxclass");
			
			  
			  String sql = "SELECT CountryCode, Country FROM Nationality ORDER BY CountryCode;";

		      ArrayList<Object[]> results = db.query(sql);
		      for (int i = 0; i < results.size(); i++)
		      {
		        Object[] row = results.get(i);
		        String countryCode = row[0].toString();
		        String country = row[1].toString();
		       
		      }

		      sql = "SELECT StudyNumber, FirstName, LastName,  "
		          + "Country FROM Student, Nationality "
		          + "WHERE Student.CountryCode = Nationality.CountryCode "
		          + "AND FirstName LIKE ? " + "ORDER BY FirstName, LastName;";

		      results = db.query(sql, "%");
		    
		      for (int i = 0; i < results.size(); i++)
		      {
		        Object[] row = results.get(i);
		        int studyNumber = (int) row[0];
		        String firstName = row[1].toString();
		        String lastName = row[2].toString();
		        String country = row[3].toString();
		        String countryCode = countrycal(country);
		       
		        Student st = new Student(studyNumber, firstName, lastName, countryCode, country);
		        col.add(st);
		        
		      }
	      
		 	 }
				 catch (SQLException | ClassNotFoundException e)
				    {
				      System.out.println("Database issue");
				      e.printStackTrace();
			}
		 
		 System.out.println(col.toString());
	}

	private static String countrycal(String text) 
	{

	      if(text.equals("Bulgaria")) return "BG";
	      if(text.equals("Denmark")) return "DK";
	      if(text.equals("Spain")) return "ES";
	      if(text.equals("Ethiopia")) return "ET";
	      if(text.equals("United Kingdom")) return "GB";
	      if(text.equals("Croatia")) return "HR";
	      if(text.equals("France")) return "FR";
	      if(text.equals("Lithuania")) return "LT";
	      if(text.equals("Latvia")) return "LV";
	      if(text.equals("Moldova")) return "MD";
	      if(text.equals("Poland")) return "PL";
	      if(text.equals("Romania")) return "RO";
	      if(text.equals("Slovakia")) return "SK";
	      if(text.equals("Serbia")) return "SR";
	      if(text.equals("United States")) return "US";
	    
	      return "Not listed";
		
	}

}
