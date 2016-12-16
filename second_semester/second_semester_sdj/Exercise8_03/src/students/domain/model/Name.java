package students.domain.model;

public class Name
{
  private String firstName;
  private String lastName;

  public Name(String firstName, String lastName)
  {
    setFirstName(firstName);
    setLastName(lastName);
  }

  public void setFirstName(String firstName)
  {
    if (firstName == null || firstName.length() == 0)
    {
      throw new IllegalArgumentException("cannot be null or empty");
    }
    this.firstName = firstName.substring(0, 1).toUpperCase()
        + firstName.substring(1);
  }

  public void setLastName(String lastName)
  {
    if (lastName == null || lastName.length() == 0)
    {
      throw new IllegalArgumentException("cannot be null or empty");
    }
    this.lastName = lastName.substring(0, 1).toUpperCase()
        + lastName.substring(1);
  }

  public String getFirstName()
  {
    return firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String toString()
  {
    return firstName + " " + lastName;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Name))
    {
      return false;
    }
    Name other = (Name) obj;
    return lastName.equals(other.lastName)
        && firstName.equals(other.firstName);
  }

}
