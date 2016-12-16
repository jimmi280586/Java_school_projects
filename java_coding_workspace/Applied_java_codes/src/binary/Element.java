package binary;

public class Element implements Comparable<Element>
{
  private String name; 
  private int no;

  public Element (String name, int no)
  {
    this.name = name;
    this.no   = no;
  }

public String toString()
  {
    return "(" + name + ", " + no + ")";
  }

  public int compareTo(Element elem)
  {
	  if(this.no == elem.no)
	  {
		  if(this.name.equalsIgnoreCase(elem.name))
			  return 0;
	  }
	  return -1;
  }
  
  public static void main(String[] args)
  {
	Element a = new Element("jimmi", 2);
	Element b = new Element("jimmi", 2);
	Element c = new Element("kurt", 3);
	Element d = new Element("jimmy", 2);
	
	System.out.println(a.compareTo(b)); // returns 0
	System.out.println(a.compareTo(c)); //returns -1
	System.out.println(a.compareTo(d)); //returns -1
	
}
}