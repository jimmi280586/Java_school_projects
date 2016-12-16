package students.domain.model;

import utility.collection.LinkedList;
import utility.collection.ListADT;

public class StudentCollection
{
  private ListADT<Student> list;

  public StudentCollection()
  {
    list = new LinkedList<>();
  }

  public void add(Student student)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (student.getStudyNumber() == list.get(i).getStudyNumber())
        return; // no duplicates
      if (student.getName().toString()
          .compareTo(list.get(i).getName().toString()) < 0)
      {
        list.add(i, student);
        return;
      }
    }
    list.add(list.size(), student);
  }

  public Student find(int studyNumber)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).getStudyNumber() == studyNumber)
      {
        return list.get(i);
      }
    }
    return null;
  }

  public Student get(int index)
  {
    return list.get(index);
  }

  public Student remove(int index)
  {
    return list.remove(index);
  }

  public Student remove(Student student)
  {
    return list.remove(student);
  }

  public int size()
  {
    return list.size();
  }

  public String toString()
  {
    String s = "StudentList: {\n";
    for (int i = 0; i < list.size(); i++)
    {
      s += "index " + i + ": " + list.get(i) + "\n";
    }
    s += "}";
    return s;
  }
}
