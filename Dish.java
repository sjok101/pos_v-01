import java.util.ArrayList;
import java.util.Properties;

public class Dish {

    ArrayList<Ingredient> ingredients;
    int id;
    String description;
    String name;

    /**
     * Stores if its an special, appetizer, main entree, dessert
     */
    int type;

    /**
     * Default constructor for dish.
     */
    public Dish(int id, String name){
        ingredients = new ArrayList<>();
        this.id = id;
        this.name = name;
    }

    public void updateDesc(String desc){
        this.description = desc;
    }

    public void printDesc(){
        System.out.println(name);
        System.err.println("Ingredients: ");
        ingredients.toString();
    }



}