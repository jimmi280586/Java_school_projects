package students.domain.mediator;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import students.domain.model.Student;
import students.domain.model.StudentCollection;
import utility.persistence.MyDatabase;

public class StudentDatabaseAdaptor implements StudentPersistence
{
	private final String DB_NAME = "SXclass";
	private MyDatabase database;
	
	public StudentDatabaseAdaptor()
	{
		try
		{
			database = new MyDatabase(DB_NAME);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public StudentCollection load()
	{
		StudentCollection students = new StudentCollection();

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
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public int save(StudentCollection list)
	{
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
		{
			sum += save(list.get(i));
		}
		return sum;
	}

	@Override
	public int save(Student student)
	{
		int sum = 0;
		String country = student.getNationality().getCountry();
		String countryCode = student.getNationality().getCountryCode();
		String firstName = student.getName().getFirstName();
		String lastName = student.getName().getLastName();
		int studyNumber = student.getStudyNumber();
		
		try
		{
			String sql = "INSERT INTO Nationality(CountryCode, Country)"
						+ " SELECT * FROM (SELECT ?, ?) AS temp WHERE NOT EXISTS"
						+ " (SELECT CountryCode FROM Nationality WHERE"
						+ " CountryCode = ?) LIMIT 1;";
			sum += database.update(sql, countryCode, country, countryCode);
			
			sql = "INSERT INTO Student (StudyNumber, FirstName, LastName, CountryCode)"
				+ " SELECT * FROM (SELECT ?, ?, ?, ?) AS temp"
				+ " WHERE NOT EXISTS (SELECT StudyNumber FROM Student"
				+ " WHERE StudyNumber = ?) LIMIT 1;";
			sum += database.update(sql, studyNumber, firstName, lastName, countryCode, studyNumber);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return sum;
	}

	@Override
	public int remove(Student student)
	{
		int sum = 0;
		int studyNumber = student.getStudyNumber();

		String sql = "DELETE FROM Student WHERE StudyNumber = ?;";
		
		try
		{
			sum += database.update(sql, studyNumber);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return sum;
	}

	@Override
	public void clearStudents() throws IOException
	{
		String sql = "DELETE FROM Student;";
		try
		{
			database.update(sql);
		} catch (SQLException e)
		{
			throw new IOException(e.getMessage());
		}
		
	}

	@Override
	public void clearAll() throws IOException
	{
		String sql = "DELETE FROM Student;";
		String sql2 = "DELETE FROM Nationality;";
		try
		{
			database.update(sql);
			database.update(sql2);
		} catch (SQLException e)
		{
			throw new IOException(e.getMessage());
		}


		
	}
	
	

}
