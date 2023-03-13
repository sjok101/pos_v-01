import java.util.ArrayList;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class MenuTester {

    /**
     * Make 2 different dishes and print out menu.
     */
    @Test
    public void addMenuItems(){
        Menu menu = new Menu();
        ArrayList<Ingredient> chcking = new ArrayList<Ingredient>();
        Dish cheesecake = new Dish("Cheesecake", "Cake made out of cheese", 4.0, chcking);
        Dish coco = new Dish("Coco", "Hot chocolate", 2.50);
        menu.createDish(cheesecake);
        menu.createDish(coco);
        assertEquals(menu.getNumDishes(), 2);
    }

    /**
     * Make 1 different dishes, insert into menu twice, num dishes = 1
     */
    @Test
    public void preventDuplicae(){
        Menu menu = new Menu();
        ArrayList<Ingredient> chcking = new ArrayList<Ingredient>();
        Dish cheesecake = new Dish("Cheesecake", "Cake made out of cheese", 4.0, chcking);
        menu.createDish(cheesecake);
        menu.createDish(cheesecake);
        assertEquals(1, menu.getNumDishes());
    }

    /**
     * Changes the price of an item.
     */
    @Test
    public void changePrice(){
        Menu menu = new Menu();
        ArrayList<Ingredient> chcking = new ArrayList<Ingredient>();
        Dish cheesecake = new Dish("Cheesecake", "Cake made out of cheese", 4.0, chcking);
        assertEquals(4.0, menu.price(cheesecake),  0.01d);
        menu.createDish(cheesecake);
        cheesecake.setPrice(5.50);
        assertEquals(5.50, menu.price(cheesecake),  0.01d);
    }

    /**
     * Attempts to delete an unknown food item from the menu
     */
    @Test
    public void deleteUnknown(){
        Menu menu = new Menu();
        ArrayList<Ingredient> chcking = new ArrayList<Ingredient>();
        Dish pizza = new Dish("Pizza", "College students diet fr", 2.25, chcking);
        assertEquals(false, menu.deleteDish(pizza));
    }

    /**
     * Delete a menu item.
     */
    @Test
    public void deleteItem(){
        Menu menu = new Menu();
        ArrayList<Ingredient> chcking = new ArrayList<Ingredient>();
        Dish chicken = new Dish("Rotissie Chicken", "Chicken that can be a hit or miss", 5.0, chcking);
        Dish pizza = new Dish("Pizza", "College students diet fr", 2.25, chcking);

        menu.createDish(pizza);
        menu.createDish(chicken);

        menu.deleteDish(pizza);

        assertEquals(1, menu.getNumDishes());
    }

    Dish pancake = new Dish("Pancake", "Flat, fried batter usually eaten for breakfast", 3.0);

    @Test
    public void dishgetDescription(){
        assertEquals("Flat, fried batter usually eaten for breakfast", pancake.description);
    }

    @Test
    public void dishgetName(){
        assertEquals("Pancake", pancake.name);
    }

    @Test
    public void dishgetPrice(){
        assertEquals(3.0, pancake.price, 0.01d);
    }

    @Test
    public void dishsetPrice(){
        pancake.setPrice(5.50);
        assertEquals(5.50, pancake.price, 0.01d);
    }

    @Test
    public void dishsetName(){
        pancake.setName("Flapjack");
        assertEquals("Flapjack", pancake.name);
    }
}
