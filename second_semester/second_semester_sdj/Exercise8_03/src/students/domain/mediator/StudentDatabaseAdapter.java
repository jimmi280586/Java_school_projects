package students.domain.mediator;

import java.io.IOException;

import students.domain.model.Student;
import students.domain.model.StudentCollection;

public class StudentDatabaseAdapter implements StudentPersistence
{

	public StudentDatabaseAdapter() 
	{
		
	}

	@Override
	public StudentCollection load() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(StudentCollection list) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Student student) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(Student student) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clearStudents() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearAll() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
