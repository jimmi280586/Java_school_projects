import java.util.Scanner;


public class Ex4 {
public static void main(String[] args) {
	Scanner keyboard= new Scanner(System.in);
	System.out.println("how many numbers?");
	int no=keyboard.nextInt();
	
	double[] array=new double[no];
	
	for (int i = 0; i < array.length; i++) {
		array[i]=1/Math.pow(2,(i+1));
	}
	
	for (int i = 0; i < array.length; i++) {
		System.out.println(array[i]);
	}
	
	System.out.println("The sum is: ");
	double sum=0;
	for (int i = 0; i < array.length; i++) {
		sum=sum+array[i];
	}
	System.out.println(sum);
	keyboard.close();
}
}
