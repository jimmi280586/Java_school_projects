package Exercise3;

public class PrintArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		double[] array = {1,2,3,4,5};
		
		
		
		for(int i = 0; i< array.length; i++)
		System.out.println(array[i] + "" );
		
		
		
		for(int i = 0; i < array.length; i++)
		{
			System.out.print(array[i]);
			if(i  < array.length -1)
			System.out.print(",");
		}
		
		
		
		
		

	}

}
