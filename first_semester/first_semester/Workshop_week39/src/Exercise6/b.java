package Exercise6;

public class b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int space = 0;
		int count = 0;
		for (int j = 7; j > 0; j--) {
			
			while(count <= space)
			{
				System.out.print(" ");
				count++;
			}
			
			
			for (int i = 0; i < j; i++) {
				System.out.print("*");
			}
			space++;
			count = 0;
			System.out.println();
		}
	}
}

