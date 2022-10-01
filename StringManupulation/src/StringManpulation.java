
public class StringManpulation {
	
	public static void main(String[] args) {
		Employee employee=new Employee();
		employee.GetEmployee();
		employee.DisplayEmployee();
		System.out.println("Concatination"+  employee.ConcatEmployeeStreet(employee.employeeName, employee.employeeStreet));
		int length=employee.GetEmployeeNameLength(employee.employeeName);
		
		
	}

}
