
public class Buzz {

	public static void main(String[] args) {
		
		// FizzBuzz!!!
		// Print all numbers from 1 to 100
		// Replace numbers divisible by 3 with Fizz
		// Replace numbers divisible by 5 with Buzz
		// And numbers divisible by both 3 and 5 with FizzBuzz
		// A classic interview question with lots of fun solutions
		// Get a count variable
		int i = 1;
		// Loop from 1 to 100
		while (i <= 100)
		{
		// If divisible by both 3 and 5 (e.g. 15)
		if (i % 15 == 0)
		System.out.println("FizzBuzz");
		// If divisible by 3
		else if (i % 3 == 0)
		System.out.println("Fizz");
		// If divisible by 5
		else if (i % 5 == 0)
		System.out.println("Buzz");
		// Otherwise, just print i
		else
		System.out.println(i);
		// Increment i
		i++;
		}

	}

}
