package students.domain.model;

public class Student
{
  private int studyNumber;
  private Name name;
  private Nationality nationality;

  public Student(int studyNumber, String firstName, String lastName,
      String countryCode, String country)
  {
    this.setStudyNumber(studyNumber);
    this.setName(new Name(firstName, lastName));
    this.setNationality(new Nationality(countryCode, country));
  }

  public Name getName()
  {
    return name;
  }

  public Nationality getNationality()
  {
    return nationality;
  }

  public int getStudyNumber()
  {
    return studyNumber;
  }

  public void setName(Name name)
  {
    this.name = name;
  }

  public void setNationality(Nationality nationality)
  {
    this.nationality = nationality;
  }

  public void setStudyNumber(int studyNumber)
  {
    this.studyNumber = studyNumber;
  }

  public String toString()
  {
    return studyNumber + " - " + name + " - " + nationality;
  }

  public boolean equals(Object obj)
  {
    if (!(obj instanceof Student))
    {
      return false;
    }
    Student other = (Student) obj;
    return studyNumber == other.studyNumber && name.equals(other.name)
        && nationality.equals(other.nationality);
  }
}
