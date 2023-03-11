import java.util.Scanner;

public class screens {
    private static boolean exit;
    private static Scanner scan = new Scanner(System.in);
    private static int choice;

    public static void editEmployee(){
        exit = false;
        while (exit == false)
        System.out.println("Edit Employee Screen");
        System.out.println("1. Add employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Return to main");

        choice = scan.nextInt();
        switch (choice){
            case 1:
                addEmployee();
                break;
            case 2:
                removeEmployee();
                break;
            case 3:
                exit = true;
                break;
            default:
                System.out.println("Please enter a number from 1-3.");
        }
    }

    private static void addEmployee(){
        System.out.println("Adding new employee");
        System.out.println("Please enter employee name.");
        String name = scan.nextLine();
        System.out.println("Please enter employee position");
        String position = scan.nextLine();
        System.out.println("Please enter employee ID");
        int id = scan.nextInt();
        System.out.println("Please enter employee wage");
        double wage = scan.nextDouble();
        Employee newEmployee = new Employee(name, position, id, wage, 0);
        ui.addEmpSample(newEmployee);
    }

    private static void removeEmployee(){
        System.out.println("Removing employee");
        System.out.println("Please enter employee id");
        int id = scan.nextInt();
        ui.removeEmpSample(id);
    }

    public static void ClockIn(){
        while (true){
            System.out.println("Clock-in Screen");
            System.out.println("1. Clock-In");
            System.out.println("2. Clock-Out");
        }
    }
    public static void Tickets(){
        while (true){
            System.out.println("Tickets Screen. TICKETS PLEASE");
        }
    }
    public static void Tables(){
        while (true){
            System.out.println("Tables Screen");
            
        }
    }
    public static void Kitchen(){
        while (true){
            System.out.println("Kitchen Screen");
        }
    }

}
