package teacher;

public class Employee extends Person
{
   private double salary;
   
   public Employee(String name, int age, double salary)
   {
      super(name, age);
      this.salary = salary;
   }
   
   public Employee(String name, double salary)
   {
      super(name);
      this.salary = salary;
   }
   
   public double getSalary()
   {
      return this.salary;
   }
   
   public void setSalary(double salary)
   {
      this.salary = salary;
   }
   
   @Override
   public String toString()
   {
      return "Employee, name = " + this.getName() + ", age = " + this.getAge() + ", salary = " + this.salary;
   }
   
   @Override
   public boolean equals(Object obj)
   {
      if (!(obj instanceof Employee))
         return false;
      Employee other = (Employee) obj;
      return super.equals(other) && this.salary == other.salary;
   }
}
