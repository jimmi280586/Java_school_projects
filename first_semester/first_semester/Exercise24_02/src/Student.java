
public class Student 
{
	private String name;
	private int grade;
	
	public Student(String name, int grade)
	{
		this.name = name;
		this.setGrade(grade);
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) 
	{
		if (grade == -3 || grade == 0 || grade == 2 || grade == 4 || grade == 7
				|| grade == 10 || grade == 12)
		{
		this.grade = grade;
		}
		else
		{
			throw new IllegalGradeException("not a legal grade: " + grade);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student name = " + name + ", grade = " + grade + "";
	}
	
	
}
