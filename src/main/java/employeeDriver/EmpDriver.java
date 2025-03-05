package employeeDriver;

import java.util.Scanner;
//importing the EmpService class from it's package to access there classes
import employeeService.EmpService;

//implementation class
public class EmpDriver {
	public static void main(String[] args) {
		System.out.print("=========== WELCOME TO EMPLOYEE MANAGEMENT APPLICATION ============");
		
		boolean flag = true;
		//until the user press 5to close the application the driver menu will be shown to the user
		while(flag) {
			System.out.println("\nMENU DETAILS :");
			System.out.println("~~~~~~~~~~~~~~");
			System.out.println("Press 1 to Register Employee. \nPress 2 to Update Employee. \nPress 3 to Delete Employee. \nPress 4 to Fetch Employee Data(All). \nPress 5 to Close the Application.");
			Scanner sc = new Scanner(System.in);
			System.out.print("\nEnter Your Choice: ");
			int choice = sc.nextInt();//storing the user input choice
		
		    EmpService e1 = new EmpService();
		    
		    switch (choice) {
			case 1:
				int res = e1.save();
				if(res!=0) {
					System.out.println("Employee Registration Successful.✅");
				}else {
					System.out.println("Employee Registration Unsuccessful.❎");
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
				flag = false;
				System.out.println("Exiting the application. Thank You..💌:)");
				sc.close();
				break;
			default:
				System.out.println("Enter a valid choice between: 1 to 5");
				break;
			}
		    
		}
	}
}
