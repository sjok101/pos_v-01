import java.util.Scanner;
import java.util.ArrayList;
//import java.text.SimpleDateFormat;  
//import java.util.Date; 

public class Employee {
	
	int id;
	String name;
	String position;
	double wage;
	double hour;
	
	boolean clocked;
	String timeIn, timeOut;
	
	ArrayList<Employee> employeeList = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	Employee(){
		name = "";
		position = "";
		id = 0; 
		wage = 0;
		hour = 0;
		
	}
	Employee(String name,String position, int id, double wage, double hour){
		this.name = name;
		this.position = position;
		this.id = id;
		this.wage = wage;
		this.hour = hour;
		
	}
	
	void updateProfile() {
		
		String newName, newPosition, newID, newWage;
		
		System.out.println("Update empolyee's name:");
		newName = scan.nextLine();
		
		System.out.println("Update empolyee's position:");
		newPosition = scan.nextLine();
		
		System.out.println("Update empolyee's ID:");
		newID = scan.nextLine();
		
		System.out.println("Update empolyee's wage:");
		newWage = scan.nextLine();
		
		if(newName != "")
			this.name = newName;
		if(newPosition != "")
			this.position = newPosition;
		if(newID != "")
			this.id = Integer.parseInt(newID);
		if(newWage != "")
			this.wage = Double.parseDouble(newWage);

	}
	void clock_in() {
		this.clocked = true;
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
//		timeIn = formatter.format(new Date());
	}
	void clock_out() {
		this.clocked = false;
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
//		timeOut = formatter.format(new Date());
	}
	
	public static void main(String[] args) {
		Employee A = new Employee();
		A.clock_in();
		A.updateProfile();
		System.out.println("emplyee");
		A.clock_out();
		
		
	}
	
	
}