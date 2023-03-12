import java.util.ArrayList;
import java.util.Properties;

public class Dish {

    /**
     * Automatically assigned by the PC. User will not be able to update this value.
     */
    int id;

    /**
     * The name of the dish.
     */
    String name;

    /**
     * The description of the dish.
     */
    String description;

    /**
     * List of ingredients.
     */
    ArrayList<Ingredient> ingredients;

    /**
     * The price of the dish.
     */
    double price;

    /**
     * Stores if its an special, appetizer, main entree, dessert
     */
    int type;

    /**
     * Default constructor.
     */
    public Dish(int id){
        this.id = id;
        this.name = "No name given";
        this.description = "Empty description";
        this.ingredients = null;
        this.price = 0.0;
    }

    public Dish(int id, String name){
        this.name = name;
        this.id = id;
        description = "Empty description";
    }

    public Dish(int id, String name, String desc, double price){
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
    }

    public Dish(int id, String name, String desc, double price, ArrayList<Ingredient> ingredients){
        this.id = id;
        this.name = name;
        this.description = desc;
        this.price = price;
        this.ingredients = ingredients;
    }

    public void updateDesc(String desc){
        this.description = desc;
    }

    public void printDesc(){
        System.out.println(name);
        System.err.println("Ingredients: ");
        ingredients.toString();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Gets the id of the dish.
     * @return
     */
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }



}
