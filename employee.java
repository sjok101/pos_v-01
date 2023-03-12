import java.util.*;
import java.time.LocalTime;
 

public class employee {
	
	int id;
	String name;
	String position;
	double wage;
	double hour;
	
	boolean clocked;
	String timeIn, timeOut;
	
	ArrayList<employee> EmployeeCalvinList = new ArrayList<>();
	
	Scanner scan = new Scanner(System.in);
	
	employee(){
		name = "";
		position = "";
		id = 0; 
		wage = 0;
		hour = 0;
		
	}
	employee(String name,String position, int id, double wage, double hour){
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

	//SET METHODS----------------------------------------------------------------
	}
	void setName(String name){
		this.name = name;
	}
	void setID(int id) {
		this.id = id;
	}
	void setPosition(String position) {
		this.position = position;
	}
	void setWage(double wage) {
		this.wage = wage;
	}
	void setHour(double hour)
	{
		this.hour = hour;
	}
	//GET METHODS -----------------------------------------------------------------
	String getName() {
		return this.name;
	}
	int getID() {
		return this.id;
	}
	String getPosition() {
		return this.position;
	}
	Double getWage() {
		return this.wage;
	}
	Double getHour() {
		return this.hour;
	}
	
	void addEmp(employee newEmp) {
		EmployeeCalvinList.add(newEmp);
	}
	
	void removeEmp(employee emp) {
		EmployeeCalvinList.remove(emp);
	}
	
	ArrayList<employee> empList()
	{
		return EmployeeCalvinList;
	}
	
	void clock_in() {
		this.clocked = true;
		LocalTime currentTime = LocalTime.now();
		this.timeIn = currentTime.toString();

	}
	void clock_out() {
		this.clocked = false;
		LocalTime currentTime = LocalTime.now();
		this.timeOut = currentTime.toString();

	}
	
//	public static void main(String[] args) {
//		EmployeeCalvin A = new EmployeeCalvin();
//		A.clock_in();
//
//		System.out.println("emplyee");
//		A.clock_out();
//		System.out.println(A.timeIn);
//		System.out.println(A.timeOut);
//		
//		
//	}
	
	
}
