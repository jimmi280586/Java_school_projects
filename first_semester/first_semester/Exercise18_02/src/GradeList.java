
public class GradeList 
{
	private Grade[] grades;
	private int indexOfNextAvailableElement;
	
	public GradeList()
	{
		grades = new Grade[4]; // initial capacity is 4
		indexOfNextAvailableElement = 0;
	}
	
	public int getSize()
	{
		return indexOfNextAvailableElement;
	}
	
	public Grade getGrade(int index)
	{
		if (index < 0 || index >= getSize())
		return null;
		return grades[index];
	}
	
	public Grade[] getAllGrades()
	{
		return grades;
	}
	
	public void addGrade(Grade grade)
	{
		if (indexOfNextAvailableElement >= grades.length)
	{
		Grade[] temporaryArray = new Grade[2*grades.length];
		for (int i=0; i<grades.length; i++)
	{
		temporaryArray[i] = grades[i];
	}
		grades = temporaryArray;
	}
		grades[indexOfNextAvailableElement] = grade;
		indexOfNextAvailableElement++;
	}
	
	public double getAverage()
	{
	
		int sum = 0;
	for (int i = 0; i < getSize(); i++)
	{
		sum += grades[i].getGrade();
	}
	
	double avg = (double) sum / getSize();
	return avg;
	}
	
	public String toString()
	{
		 // Fixed
		// Start with a basic String with the average
		String s = "Grade list: (average = " + this.getAverage() + ")\n";
		// Loop through the grades array
		for (int i = 0; i < this.getSize(); i++)
		{
		// For each index, use the toString method in the current Grade object
		s += this.getGrade(i).toString() + "\n";
		}
		return s;
	
	}
	// Questions:
	// 1) indexOfNextAvailableElement keeps track of the highest index
	// currently filled in the grades array
	// 2) getSize() returns indexOfNextAvailableElement because the array
	// is set to a "large enough" size with blank elements, so .length
	// would return the wrong value.
	// 3) The if statement checks to make sure the index given as an argument
	// is within the bounds of the array - that it will reference a filled-in element
	// 4) temporaryArray is used to store elements in grades,
	// so that the size of grades can be doubled
	// 5) The body of the if statement in addGrade will double the size
	// of the grades array, if adding one more grade would go outside
	// of the current array boundary. The temporaryArray is used to hold
	// the copied values of the grades array, and is twice the size of the grades array.
	// The last statement makes the grades array equal to the temporaryArray.
	// 6) The last statement increments the value of the index that keeps track
	// of where the last filled-in array element is.
	// 7) The statement just before the return statement in getAverage
	// actually calculates the average, by taking the sum of all the grades
	// and dividing it by the number of grades.
	// 8) Return a copy of grades in getAllGrades(). I don't know if you want to take
	// a copy of all the times a Grade object is used...
	

}
