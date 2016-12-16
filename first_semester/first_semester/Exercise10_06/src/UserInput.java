import java.util.Scanner;


public class UserInput 
{
	public static void main(String[] args) {
		
	
		int size;
		
		
	  
	    Scanner keyboard = new Scanner(System.in);
	    System.out.println("how many student to input");
	    size = keyboard.nextInt();
	    Student[] person = new Student[size];
	    for (int i = 0; i < person.length; i++)
	    {
		   
	    System.out.println("input name");
	    String a = keyboard.nextLine();
	    System.out.println("input gender type M for male ore F for female");
	    char b = keyboard.next().charAt(0);
	    System.out.println("input study number");
	    int c = keyboard.nextInt();
	    person[i] = new Student(a, b, c); 
	    
	    }
	     
	    System.out.println(person.toString());
}
}
