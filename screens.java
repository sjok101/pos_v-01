import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class screens {
    private static boolean exit;
    private static Scanner scan = new Scanner(System.in);
    private static int choice;

    public static void editEmployee(){
        exit = false;
        while (exit == false){
        System.out.println("Edit Employee Screen");
        System.out.println("1. Add employee");
        System.out.println("2. Remove employee");
        System.out.println("3. Return to main");

        choice = scan.nextInt();
        scan.nextLine();
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
    }

    private static void addEmployee(){
        System.out.println("Adding new employee");
        System.out.println("Please enter employee name.");
        String name = scan.nextLine();
        System.out.println("Please enter employee position");
        String position = scan.nextLine();
        System.out.println("Please enter employee ID");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter employee wage");
        double wage = scan.nextDouble();
        scan.nextLine();
        Employee newEmployee = new Employee(name, position, id, wage, 0);
        //below will be replaced with actual data imports
        ui.addEmpSample(newEmployee);
    }

    private static void removeEmployee(){
        System.out.println("Removing employee");
        System.out.println("Please enter employee id");
        int id = scan.nextInt();
        scan.nextLine();
        //below will be replaced with actual data imports
        ui.removeEmpSample(id);
    }

    public static void ClockIn(){
        exit = false;
        while (exit == false){
            System.out.println("Clock-in Screen");
            System.out.println("1. Clock-In");
            System.out.println("2. Clock-Out // Disabled");
            System.out.println("3. Return to main");

            choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    clockingIn();
                    break;
                case 2:
                    System.out.println("Clock out disabled, fixing bugs");
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a number from 1-3.");
            }
        }
    }
    public static void clockingIn(){
        System.out.println("Please enter employee id");
        int id = scan.nextInt();
        scan.nextLine();
        LocalDateTime now = LocalDateTime.now();
        clockIO clockIn = new clockIO(now, ui.returnEmpSample(id));
        ui.clockInSample(clockIn);
    }   

    public static void clockingOut(){
        System.out.println("Please enter employee id");
        int id = scan.nextInt();
        scan.nextLine();
        
        Employee retEmp = ui.returnEmpSample(id); //returns null for some reason, needs fixing
        
        System.out.println("employee is: "+ retEmp.name);
        clockIO retClock = ui.findClockSample(retEmp);
        ui.clockOutSample(retClock);
        
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
