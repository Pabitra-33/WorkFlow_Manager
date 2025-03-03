package employeeEntity;

//Entity class, contains the properties of a employee
public class Employee {
	int id;
	String name;
	int age;
	int salary;
	
	//constructor
	public Employee(int id, String name, int age, int salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}
