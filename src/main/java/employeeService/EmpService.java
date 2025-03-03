package employeeService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//this package is used to write Service Logic(database logic).

public class EmpService {
	private static Scanner sc = new Scanner(System.in);
	private static String url = "jdbc:postgresql://localhost:5432/employeemanagement?user=postgres&password=123";
	private static Connection con;
	
	//static block(as every step needs this, so we have written this inside a static block
	static {
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//save method
	public int save() {
		int res = 0;
		System.out.println("Please enter the below details to register:-");
		System.out.println("Enter employee id: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter employee name: ");
		String name = sc.next();
		System.out.println("Enter employee age: ");
		int age = sc.nextInt();
		System.out.println("Enter employee salary: ");
		int sal = sc.nextInt();
		
		String query = "INSERT into employee values(?,?,?,?)";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			pstm.setString(2, name);
			pstm.setInt(3, age);
			pstm.setInt(4, sal);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public int update() {
		int res = 0;
		System.out.print("\nEnter salary which you want to update: ");
		int sal = sc.nextInt();
		System.out.print("Enter employee id, whose data you want to update: ");
		int id = sc.nextInt();
		
		String query = "UPDATE employee set salary = ? where id = ?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, sal);
			pstm.setInt(2, id);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public int delete() {
		int res = 0;
		System.out.print("Enter employee id, whose data you want to delete: ");
		int id = sc.nextInt();
		
		String query = "DELETE from employee where id = ?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(query);
			pstm.setInt(1, id);
			
			res = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void fetchAll() {
		String query = "SELECT * FROM employee";
		
		try {
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getInt(4));
				System.out.println("============");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
