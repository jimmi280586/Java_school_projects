


public class EmployeeList 
{
	private int size;
	private Employee[] employees;
	
	public EmployeeList(int maxNumberOfEmployees) 
	{
		this.employees = new Employee[maxNumberOfEmployees];
		this.size = 0;
	}
	
	public void addEmployee(Employee employee)
	   {
	      this.employees[this.size] = employee;
	      this.size++;
	   }
	
	   public void removeEmployee(Employee employee)
	   {
	      for (int index = 0; index < this.size; index++)
	      {
	         if (this.employees[index].equals(employee))
	         {
	            for (int j = index; j < this.size - 1; j++)
	            {
	               this.employees[j] = this.employees[j + 1];
	            }
	            this.size--;
	         	}
	      	}
	   	}

	public int getNumberOfEmployees()
	{
		return this.size;
	}
	
	   public double getTotalEarningsPerWeek()
	   {
	      double total = 0.0;
	      for (int i = 0; i < this.size; i++)
	      {
	         total += this.employees[i].earningsPerWeek();
	      }
	      return total;
	   }

	   public String toString()
	   {
	      String total = "";
	      for (int i = 0; i < this.size; i++)
	      {
	         total += this.employees[i].toString() + " ";
	      }
	      return total;
	   }

	   public boolean equals(Object obj)
	   {
	      if (!(obj instanceof EmployeeList))
	      {
	         return false;
	      }
	      EmployeeList other = (EmployeeList) obj;
	      if (this.size == other.size)
	      {
	         boolean total = true;
	         for (int i = 0; i < this.size; i++)
	         {
	            total = total && this.employees[i].equals(other.employees[i]);
	         }
	         return total;
	      }
	      else
	      {
	         return false;
	      }
	   }
	
	
}
