import java.util.Scanner;
public class Employee {
	public String employeeName,employeeStreet;
	 public Scanner scanner=new Scanner(System.in);
	 public void GetEmployee()
	 {
		 System.out.println("***********	Enter the Employee Name	**************:	");
		 employeeName=scanner.nextLine();
		System.out.println("\n***********	Enter the Employee Street:	*************");
		 employeeStreet=scanner.nextLine();
		 
		 
	 }
		public void DisplayEmployee()
		{
			 System.out.println("\n Employee Name:"+employeeName);
			 System.out.println("\n	Employee Street:"+employeeStreet);
			
		}
		public String ConcatEmployeeStreet(String name,String street)
		{
			return name.concat(street);
			
		}
		public int GetEmployeeNameLength(String name)
		{
			return name.length();
		}

}
