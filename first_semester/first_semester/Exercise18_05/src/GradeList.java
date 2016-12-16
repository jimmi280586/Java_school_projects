import java.util.ArrayList;

public class GradeList
{
   private ArrayList<Grade> grades;
   
   public GradeList()
   {
      this.grades = new ArrayList<Grade>();
   }
   
   public int getSize()
   {
      return grades.size();
   }
   
   public Grade getGrade(int index)
   {
      return grades.get(index);
   }
   
   public Grade[] getAllGrades()
   {
      Grade[] allGrades = new Grade[grades.size()];
      // Alternative to the next three lines: 
      //   return grades.toArray(allGrades);
      for(int i = 0; i < grades.size(); i++) {
         allGrades[i] = grades.get(i);
      }
      return allGrades;
   }
   
   public void addGrade(Grade grade)
   {
      grades.add(grade);
   }
   
   public double getAverage()
   {
      double sum = 0.0;
      for(int i = 0; i < grades.size(); i++)
      {
         sum += grades.get(i).getGrade();
      }
      return sum / grades.size();
   }
   
   @Override
   public String toString()
   {
      // Note the similarities between this and getAverage()
      // This is a very common pattern.
      String result = "Grade list: (average = " + getAverage() + ")\n";
      for(int i = 0; i < grades.size(); i++)
      {
         result += grades.get(i).toString();
      }
      return result;
   }
}
