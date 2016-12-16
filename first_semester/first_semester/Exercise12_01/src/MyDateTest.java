
public class MyDateTest {

	public static void main(String[] args) 
	{
		 // Test the MyDate class
		// Make a new MyDate object
		MyDate date = new MyDate(1,1,1970);
		System.out.println("Leap year in: " + date.getYear() + "?: " + date.leapYear());
		System.out.println("Days in month: " + date.getLengthOfMonth());
		System.out.println("Date:");
		date.displayDate();
		date.goToNextDay();
		System.out.println("Date:");
		date.displayDate();
		date.advanceDays(10);
		System.out.println("Date:");
		date.displayDate();

	}

}
