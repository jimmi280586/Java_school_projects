package main;

import java.io.IOException;

import students.domain.mediator.StudentDatabaseAdaptor;
import students.domain.mediator.StudentPersistence;
import students.domain.model.Student;
import students.domain.model.StudentCollection;

public class StudentAdaptorMain
{

	public static void main(String[] args) throws IOException
	{
		StudentCollection students = new StudentCollection();
		
		StudentPersistence database = new StudentDatabaseAdaptor();
		
		Student billy = new Student(111111, "Billy", "Everteen", "DE", "Germany");
		
		database.save(billy);

		database.remove(billy);
		
		database.clearStudents();
		
		database.clearAll();
	}

}
