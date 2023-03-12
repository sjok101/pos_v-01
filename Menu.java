import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    int numDishes;
    ArrayList<Dish> dishList;
    Inventory inventory;

    Menu(){
        dishList = new ArrayList<>();
        inventory = new Inventory();
        numDishes = 0;
    }

    public int getNumDishes(){
        return dishList.size();
    }

    /**
     * Creates a dish for the menu
     * @return
     */
    public boolean createDish(){
        Scanner sc = new Scanner(System.in);
        boolean isNewDish = false;
        String dishName = "";
        while(!isNewDish){
            System.out.println("Enter dish name: ");
            dishName = sc.nextLine();
            // Checks if the dish is already in the database
            if(checkDish(dishName)){
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
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        // This will change in the UI, it will be buttons that the user can press
        System.out.println("Would you like to enter the ingredients now? (Y/N)");
        String yn = sc.nextLine();
        if(yn.equals("Y") || yn.equals("Yes")){
            System.out.println("This will be buttons the user can press to add ingredients. Too lazy to implement this as a text thing.");
        }
        // System.out.println("Enter ingredients: (Example: tomato,pasta,cheese)");
        // String uiingredients = sc.nextLine();

        // ArrayList<Ingredient> ingredients = ingredientPopup(uiingredients);        

        // Makes a new dish with the information given
        System.out.println("Dish has been added to the database.");
        Dish dish = new Dish(numDishes, dishName);
        dishList.add(dish);
        numDishes++;
        sc.close();
        return true;
    }

    /**
     * Gets the price of a dish.
     * @return the price of the dish.
     */
    public double price(Dish dish){
        return dish.price;
    }

    /**
     * Implement later with the UI. Makes a little pop up that allows the user to press buttons of what ingredients belong in the dish
     * when the create a new one. Also allows the user to make a new Ingredient in case the ingredient doesnt exist
     * Makes an ingredient list for a dish.
     * @param ingredients string format of ingredienets
     * @return
     */
    private ArrayList<Ingredient> ingredientPopup(String ingredients){
        ArrayList<Ingredient> toList = new ArrayList<>();
        return toList;
    }

    /**
     * Checks if the dish exists in the list of dishes already to prevent duplicate dishes from being made.
     * @param dish
     * @return
     */
    private boolean checkDish(String dish) {
        if(dishList.size() == 0){
            return false;
        }

        for(int i = 0; i < dishList.size(); i++){
            if(dish.toLowerCase() == dishList.get(i).name.toLowerCase()){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        String s = "---------------------------------";
        s += "Menu:\n";
        for(int i = 0; i < dishList.size(); i++){
            s += dishList.get(i).name + "\n";
            s += dishList.get(i).description + "\n";
            s += "$" + dishList.get(i).price + "\n";
            s += "---------------------------------";
        }
        return s;
    }  

}
