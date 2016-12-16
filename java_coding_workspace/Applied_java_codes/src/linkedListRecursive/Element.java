package linkedListRecursive;

// *****************************************************************************
// File name  : Element.java.
// Start date : 
// Programmer : 
// Java       : 
// Description: 
//
// Revision history:
//   date     init  comment
//
// *****************************************************************************



public class Element
{
  public String name;  // declared public to make the class simple
  public int no;

  public Element (String name, int no)
  {
    this.name = name;
    this.no   = no;
  }
  
  public String toString()
  {
    return "(" + name + ", " + no + ")";
  }
  
  public boolean equals (Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!( obj instanceof Element))
      return false;
    Element e = (Element)obj;
    return (name.equals(e.name) && no == e.no);
  }
}