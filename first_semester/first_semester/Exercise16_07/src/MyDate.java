
public class MyDate
{
	
	// Declare the fields
	private int day;
	private int month;
	private int year;
	// Create the constructor
	// Has parameters for day (d), month (m), and year (y)
	public MyDate(int d, int m, int y)
	{
	// Set fields to the arguments
	this.day = d;
	this.month = m;
	this.year = y;
	}
	// Everything else (getters and the like):
	public int getDay()
	{
	return this.day;
	}
	public int getMonth()
	{
	return this.month;
	}
	public int getYear()
	{
	return this.year;
	}
	public void setDay(int newDay)
	{
	if (newDay <= 0)
	{
	this.day = 1;
	}
	else if (newDay > this.getLengthOfMonth())
	{
	this.day = this.getLengthOfMonth();
	}
	else
	{
	this.day = newDay;
	}
	}
	// Send a formatted date to the console
	public void displayDate()
	{
	System.out.printf("%d/%d/%d%n", this.day, this.month, this.year);
	}
	// Determine if the year is a leap year
	// divisible by four == true
	// divisible by 100 != true
	// divisible by 400 == true
	public boolean leapYear()
	{
	// Use an internal variable to make code cleaner
	// It doesn't matter that we're shadowing the field this way
	int year = this.year;
	// Test basic case
	if (year % 4 == 0)
	{
	// Test for every 400th year
	if (year % 400 == 0)
	{
	return true;
	}
	// Test for every 100th year
	else if (year % 100 == 0)
	{
	return false;
	}
	// If only divisible by 4, true
	else
	{
	return true;
	}
	}
	// If not divisible by 4 at all, false
	else
	{
	return false;
	}
	}
	// Returns the amount of days in the month
	public int getLengthOfMonth()
	{
	// Use an internal variable to make code cleaner
	// It doesn't matter that we're shadowing the field this way
	int month = this.month;
	// Cover February changing in leap years
	if (month == 2)
	{
	// Use the leapYear method
	if (this.leapYear())
	{
	return 29;
	}
	else
	{
	return 28;
	}
	}
	// Use a switch statement for the rest
	switch (month)
	{
	// Case statements will fall through to the next
	// until they hit a return statement or a break
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12: return 31;
	case 4:
	case 6:
	case 9:
	case 11: return 30;
	default: return -1;
	}
	}
	// Advance the day by one
	// Correct for end of the month
	public void goToNextDay()
	{
	// If the day is the final day in the month
	// we'll need to move to the next month
	// and set day to 1
	if (this.day == this.getLengthOfMonth())
	{
	// If the month is December
	if (this.month == 12)
	{
	// Set month to one
	this.month = 1;
	}
	// If any other month
	else
	{
	// Increment month by one
	this.month += 1;
	}
	// Set day to 1
	this.day = 1;
	}
	// If not the last day of the month, just add one
	this.day += 1;
	}
	// Advance the date by as many days as specified
	public void advanceDays(int days)
	{
	// Just loop the given number of days
	for (int i = 0; i < days; i++)
	{
	// Add one day each time the loop runs
	goToNextDay();
	}
	}
	// Copy to a new MyDate object
	public MyDate copy()
	{
	return new MyDate(this.day, this.month, this.year);
	}
	// Compare to another MyDate
	public boolean equals(MyDate other)
	{
	return this.day == other.day &&
	this.month == other.month &&
	this.year == other.year;
	}
	// Return a String representation
	public String toString()
	{
	return this.day + "/" + this.month + "/" + this.year;
	}
    
    

}

