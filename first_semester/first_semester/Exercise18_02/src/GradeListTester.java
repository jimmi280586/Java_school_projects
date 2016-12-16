
public class GradeListTester {

	public static void main(String[] args)
	{
		System.out.println("// Test class GradeList");
		System.out.println("Create a Grade list and add 5 Grade ob-jects");
		GradeList list = new GradeList();
		list.addGrade(new Grade("SDJ", 12));
		list.addGrade(new Grade("WDD", 10));
		list.addGrade(new Grade("EIC", 7));
		list.addGrade(new Grade("SEP", 10));
		list.addGrade(new Grade("LRL", 4));
		System.out.println("Method toString():\n" + list);

	}

}
