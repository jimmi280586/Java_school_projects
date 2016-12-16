
public class Testing 
{
	public static void main(String[] args)
	  {
	    String[] legalStarSignNames = StarSign.LEGAL_NAMES;
	    System.out.println("Leagal star sign names:");
	    for (int i=0; i<legalStarSignNames.length; i++)
	      System.out.println(legalStarSignNames[i]);
	    System.out.println();  
	    
	    Person[] list = new Person[10];
	    list[0] = new Person("Allan", new StarSign("Leo"));
	    list[1] = new Person("Bob", new StarSign("Scorpio"));
	    list[2] = new Person("Carl", new StarSign("Leo"));
	    list[3] = new Person("Dennis", new StarSign("Saggitarius"));
	    list[4] = new Person("Eric", new StarSign("Leo"));
	    list[5] = new Person("Franc", new StarSign("Leo"));
	    list[6] = new Person("Graham", new StarSign("Sagittarius"));
	    list[7] = new Person("Hans", new StarSign("Leo"));
	    list[8] = new Person("Igor", new StarSign("Virgo"));
	    list[9] = new Person("Jens", new StarSign(legalStarSignNames[8]));
	    
	    System.out.println("Person objects:");
	    for (int i=0; i< list.length; i++)
	    {
	      System.out.printf("%-40s %d\n", list[i],list[i].getStarSign().hashCode());
	    }
	  }
}
