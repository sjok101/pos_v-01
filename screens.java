import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class screens {
    private static boolean exit;
    private static Scanner scan = new Scanner(System.in);
    private static int choice;

    //============================================================================================================================//
    //==========================================+++++ CLOCK IN SCREEN +++++=======================================================//
    //============================================================================================================================//
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
            System.out.println("2. Clock-Out");
            System.out.println("3. Return to main");

            choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    clockingIn();
                    break;
                case 2:
                    //System.out.println("Clock out disabled, fixing bugs");
                    clockingOut();
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
        
        Employee retEmp = ui.returnEmpSample(id); //fixed
        
       // System.out.println("employee is: "+ retEmp.name);
        clockIO retClock = ui.findClockSample(retEmp);
        ui.clockOutSample(retClock);
        
    }


    //============================================================================================================================//
    //==========================================+++++ TICKETS SCREEN +++++========================================================//
    //============================================================================================================================//
    public static void Tickets(){
        exit = false;
        int tableNum;
        int amountSeats;
        while (exit == false){
            System.out.println("Tickets Screen");
            System.out.println("1. To-Go Order");
            System.out.println("2. Dine-In Order");
            System.out.println("3. Edit Open Ticket");
            System.out.println("4. Return to main");

            choice = scan.nextInt();
            scan.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Creating to-go order.");
                    createTicket(99, 0);
                    break;
                case 2:
                    System.out.println("Creating dine-in order");
                    System.out.println("Please enter table number");
                    tableNum = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Please enter number seated");
                    amountSeats = scan.nextInt();
                    scan.nextLine();
                    createTicket(tableNum, amountSeats);
                    break;
                case 3:
                    System.out.println("In progress");
                    //System.out.println("Editing ticket order");
                    //System.out.println("Please enter table number");
                    //tableNum = scan.nextInt();
                    //scan.nextLine();
                    //currently table is coded to accept 1 ticket for its table
                   // editTicket(tableNum);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Please enter a number from 1-3.");
            }
        }
    }
    //needs to implement adding order to ticket
    private static void createTicket(int tableNum, int amountSeats){
        Ticket newTicket = new Ticket(tableNum);
        newTicket.setStatus(Ticketstatus.OPEN);
        table setTable = new table(tableNum, amountSeats);
        System.out.println("Enter dishes by its id");
        exit = false;
        while(exit==false){
        Order newOrder = new Order(tableNum);
        System.out.println("Enter a seat number to add dishes to.");
        System.out.println("Enter 0 if to go order.");
        System.out.println("Enter 119 to finalize ticket and add to table");
        System.out.println("Enter 911 to cancel ticket");
        int dishID = 0;
        int seatNumber = scan.nextInt();
        scan.nextLine();

            if(seatNumber==911){
                newTicket = null;
                exit = true;
            }
            while(dishID!=2 && seatNumber!= 119 && exit!=true){
            System.out.println("1. Pancakes"); //hardcoded, replace with function later
            System.out.println("2. Finished");
            dishID = scan.nextInt();
            scan.nextLine();
            if(dishID == 2){
                //add order function should be revised to create Order object into hash
                //or create a hash tree to add orders to, then add to ticket
                newTicket.addOrder(seatNumber, newOrder);                
            }
            else{
                Dish dish = ui.findDishSample(dishID);
                newOrder.addDish(dish);  // either reimplement function above or
                                        //change to hash tree <Integer, LinkedList<Order>>
            }

            
        }
            if(dishID == 119){ //adds to tables and tickets list
                exit = true;
                setTable.setTicket(newTicket);
                ui.addSampleTicket(newTicket);
                ui.addSampleTable(setTable);
            }


    }

    }
    //needs to be able to find the ticket via tableNum
    //needs to be able to find the table via ticket object
    //remove old ticket from both lists
    //edit the ticket as needed
    //add the tickets back to both lists
    public static void editTicket(int tableNum){

    }

    //============================================================================================================================//
    //===========================================+++++ TABLES SCREEN +++++========================================================//
    //============================================================================================================================//
    

    public static void Tables(){
        //Displays tables
        //can choose table from display
        //Displays ticket
        //can choose to open tickets from display
        //can edit ticket
            System.out.println("Tables Screen");
            
        
    }

    //============================================================================================================================//
    //==========================================+++++ KITCHEN SCREEN +++++========================================================//
    //============================================================================================================================//
    
    public static void Kitchen(){
        //Displays Orders
        //Can choose if Dish is out of stock
            System.out.println("Kitchen Screen");
        
    }

}
