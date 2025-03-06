package employeeEntity;

//Entity class, contains the properties of a employee to perform operations.
public class Employee {
	public int id;
	public String name;
	public int age;
	public int salary;
	
	//parameterized constructor defined
	public Employee(int id, String name, int age, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}
