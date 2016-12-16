
public class Grade
{
	private String courseName;
	private int grade;
	
	public Grade(String courseName, int grade)
	{
		this.grade = grade;//1 reversed the line
		this.courseName = courseName;//2 you need this line
	}
	
	public String getCourseName()
	
	{
		return courseName;
	}
	
	public int getGrade()
	{
		return grade;
	}
	
	public void setGrade(int grade)
	{
		this.grade = grade;//4 it returns grade not grade = this.grade
	}
	
	public String toString()// don´t use kapital T
	{
		return courseName + ", " + grade;
	}
}
