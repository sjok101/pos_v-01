import java.util.ArrayList;

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
    public boolean createDish(Dish dish){        
        if(checkDish(dish.name)){
            return false;
        }

        // Makes a new dish with the information given
        dish.setId(numDishes);
        dishList.add(dish);
        numDishes++;
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
     * Deletes a dish. If dish does not exist, return false
     * @return
     */
    public boolean deleteDish(Dish dish){

        if(!checkDish(dish.name)){
            return false;
        }

        dishList.remove(dish);
        return true;
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
            if(dish == dishList.get(i).name){
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
