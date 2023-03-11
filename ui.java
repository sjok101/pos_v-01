import java.util.LinkedList;
import java.util.Scanner;
public class ui {
    //sample variables
    private static Employee sampleEmployee;
    private static LinkedList<Employee> sampleEmpList;
    
    public static void main(String[] args){
        //this is an login example, users are added as samples upon scan, type "test" as user and "fail" as password to example a mismatched case
        login();

        //after this initial login or before, we need to be able to upload existing employee information
        //as well as all dishes ingredients and prior data
        //for testing purposes, these will be instantiated at run time
        createSamples();
        
        //runs the pos and menu options
        pos();
        

    }
    public static void createSamples(){
        sampleEmployee = new Employee("John", "Server", 1, 7.25, 0);
        sampleEmpList.add(sampleEmployee);
    }
    public static void addEmpSample(Employee sample){
        sampleEmpList.add(sample);
    }
    public static void removeEmpSample(int id){
        LinkedList<Employee> temp = sampleEmpList;
        for (int i =0; i<temp.size(); i++){
            Employee tempEmp = temp.removeFirst();
            if(tempEmp.id==id){
                sampleEmpList.remove(tempEmp);
            }
        }
    }

    public static void pos(){
        while(true){
            mainMenu();
        }
    }

    public static void mainMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a menu choice 1-3");
        System.out.println("1. Clock in");
        System.out.println("2. Tables");
        System.out.println("3. Tickets");
        System.out.println("4. Kitchen");
        System.out.println("5. Exit Software");
        
        int choice = scan.nextInt();
        switch (choice){
            case 1:
                screens.ClockIn();
                break;
            case 2:
                screens.Tables();
                break;
            case 3:
                screens.Tickets();
                break;
            case 4:
                screens.Kitchen();
                break;
            case 5:
                screens.editEmployee();
                break;
            case 9:
                shutDown();
            default:
                System.out.println("Please choose again.");

        }
    }

    public static void login(){
        while(!userLogin.initLogin()){
            System.out.println("Please login.");
        }
    }

    public static void shutDown(){
        System.out.println("Exiting software.");
        System.exit(0);
    }
    
}
