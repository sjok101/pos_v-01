import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    int numDishes;
    ArrayList<Dish> dishList;


    public Menu(){
        int numDishes = 0;
    }

    /**
     * Creates a dish for the menu
     * @return
     */
    public boolean createDish(){
        Scanner sc = new Scanner(System.in);
        boolean isNewDish = false;
        String dish;
        while(isNewDish){
            System.out.println("Enter dish name: ");
            dish = sc.nextLine();
            // Checks if the dish is already in the database
            if(checkDish(dish)){
                // If the dish existed, ask the user if they would like to create another dish
                System.out.println("This dish exists in the data base. Would you like to add a new dish? Y/N");
                String yn = sc.nextLine();
                if(yn.equals("N") || yn.equals("No")){
                    System.out.println("Dish was not created");
                    return false;
                }
            }else{
                break;
            }
        }

        // This will change in the UI, it will be buttons that the user can press
        System.out.println("Enter ingredients: ");

        numDishes++;
        sc.close();
        return true;
    }

    private boolean checkDish(String dish) {


        return false;
    }





}