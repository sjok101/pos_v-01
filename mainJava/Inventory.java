

import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    int numItems;
    ArrayList<Ingredient> ingredientInventory;

    /**
     * Default constructor.
     */
    public Inventory(){
        ingredientInventory = new ArrayList<>();
        numItems = 0;
    }

    /**
     * Adds an item to the inventory by making it an igredient then adding to the list.
     * @param item
     * @return
     */
    public void addItem(String item){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the item you wish to add: ");
        String name = sc.nextLine();
        // If the item doesn't exists
        if(!checkItem(item)){
            System.out.println("Creating a new item for the inventory...");
            System.out.println("How many of this item is in inventory?: ");
            int quantity = sc.nextInt();
            ingredientInventory.add(new Ingredient(numItems, name, quantity));
            numItems++;
            System.out.println("Item has been added");
        }else{
            System.out.println("Error: Item already exists");
        }
        sc.close();
    }

    /**
     * Checks the inventory list to see if the item is already in the database. Prevents duplicate items.
     * @param item the item we want to check
     * @return true if the item exists, false if not
     */
    private boolean checkItem(String item){
        if(ingredientInventory.size() == 0){
            return false;
        }

        for(int i = 0; i < ingredientInventory.size(); i++){
            if(ingredientInventory.get(i).name == item){
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes an item from the iventory.
     * @return
     */
    public boolean deleteItem(){
        return false;
    }

    /**
     * Updates the quantity of an item.
     * @return
     */
    public void updateQuantity(Ingredient item, int quantity){
        item.setQuantity(quantity);
    }

    public int getNumItems(){
        return numItems;
    }

}
