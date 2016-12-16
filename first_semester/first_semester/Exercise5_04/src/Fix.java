import java.util.Scanner;


public class Fix {

	public static void main(String[] args) {
		
		
		Scanner keyboard = new Scanner(System.in);
		double debt = keyboard.nextDouble();
		double monthlyInterestRate = keyboard.nextDouble();
		double monthlyPayment = keyboard.nextDouble();
		int month = 0;
		while (debt > 0)
		{
		debt += debt * monthlyInterestRate;
		debt -= monthlyPayment;
		System.out.println("Debt is " + debt);
		month += 1;
		}
		System.out.println("Month to repay: " + month);

	}

}
