import java.util.Scanner;


public class Student 
{
	private String name;
	private char gender;
	private int StudyNumber;
	
	public Student(String name, char gender, int StudyNumber)
	{
		this.name = name;
		this.gender = gender;
		this.StudyNumber = StudyNumber;
	}
	
	public void setname(String name)
	{
		this.name = name;
	}
	
	public void setgender(char gender)
	{
		this.gender = gender;
	}
	
	public void setStudyNumber(int StudyNumber)
	{
		this.StudyNumber = StudyNumber;
	}
	
	public String getname()
	{
		return this.name;
	}
	
	public char getgender()
	{
		return this.gender;
	}
	
	public int getStudyNumber()
	{
		return this.StudyNumber;
	}
	
	public void displaystudent()
	{
		System.out.println(this.toString());
	}
	public String toString()
	{
		return name + "," + gender + "," + StudyNumber;
	}
	
	
	
	
	
	
}
