package employeeDriver;

import java.util.Scanner;
import employeeService.EmpService;//importing the EmpService class from it's package

//implementation class
public class EmpDriver {
	public static void main(String[] args) {
		System.out.println("=========== WELCOME TO EMPLOYEE MANAGEMENT APPLICATION ============");
		System.out.println("\nMENU DETAILS :---");
		System.out.println("1. Press 1 to Register Employee. \n2. Press 2 to Update Employee. \n3. Press 3 to Delete Employee. \n4. Press 4 to Fetch Employee Data(All). \n5. Press 5 to Close the Application.");
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Choice: ");
		int choice = sc.nextInt();
		
		EmpService e1 = new EmpService();
		
		switch (choice) {
		case 1:
			int res = e1.save();
			if(res!=0) {
				System.out.print("Employee Registration Successful..✅");
			}else {
				System.out.print("Employee Registration Unsuccessful..❎");
			}
			break;
		case 2:
			int uRes = e1.update();
			if(uRes != 0) {
				System.out.println("Employee Data Updated..!🆗");
			}else {
				System.out.println("Employee Data not Updated...🔀");
			}
			break;
		case 3:
			int dRes = e1.delete();
			if(dRes != 0) {
				System.out.println("Employee Data Deleted Successfully..!✔");
			}else {
				System.out.println("Employee Data Does not Deleted...✖");
			}
			break;
		case 4:
			e1.fetchAll();
			System.out.println("All Employees Data Fetched Successfully..!");
			break;
		case 5:
			e1.exit();
			System.out.println("Exiting the application. Thank You..💌:)");
			break;
		default:
			System.out.println("Enter a valid choice between: 1 to 5");
			break;
		}
		sc.close();
	}
}
