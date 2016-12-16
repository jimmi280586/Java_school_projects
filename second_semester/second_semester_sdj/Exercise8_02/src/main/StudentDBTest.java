package main;

import java.io.IOException;
import java.util.ArrayList;

import students.domain.model.Student;
import students.domain.model.StudentCollection;
import utility.persistence.MyDatabase;

public class StudentDBTest
{

	public static void main(String[] args) throws Exception
	{
		StudentCollection students = new StudentCollection();

		MyDatabase database = new MyDatabase("SXclass");
		

		String sql = "SELECT StudyNumber, FirstName, LastName, Nationality.CountryCode, Country "
				+ "FROM Student, Nationality "
				+ "WHERE Student.CountryCode = Nationality.CountryCode "
				+ "ORDER BY FirstName, LastName;";
		
		try {
			
		ArrayList<Object[]> results = database.query(sql);
		for (int i = 0; i < results.size(); i++)
		{
			Object[] row = results.get(i);
			int StudyNumber = Integer.parseInt(row[0].toString());
			String FirstName = row[1].toString();
			String LastName = row[2].toString();
			String CountryCode = row[3].toString();
			String Country = row[4].toString();
			Student student = new Student(StudyNumber, FirstName, LastName, CountryCode, Country);
			students.add(student);
		}
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		
		System.out.println(students.toString());
					

	}

}
