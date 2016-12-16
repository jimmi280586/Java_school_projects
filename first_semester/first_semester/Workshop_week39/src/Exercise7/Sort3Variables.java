package Exercise7;

public class Sort3Variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	
	int a,b,c,temp;
		
		a = 15;
		b = 5;
		c = 10;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		if(a>b)
		{
		
		temp= a;
		a = b;
		b = temp;
		}
		if(a > c)
		{
		temp = a;
		a = c;
		c = temp;
		}
		if (b > c)
		{
			temp = b;
			b= c;
			c= temp;
		}
		
		
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		
		
	
	}

}
