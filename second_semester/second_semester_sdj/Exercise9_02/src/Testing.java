


public class Testing {

	public Testing()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		SingletonLog l = SingletonLog.getInstance();
		System.out.println("");
		SingletonLog l1 = SingletonLog.getInstance();
		l.add("cd", true);
		l.add("dvd", false);
		System.out.println("");
		l1.add("cd", true);
		l1.add("dvd", false);
		System.out.println("");
		
		System.out.println(l.getAll().toString());
	}
}
