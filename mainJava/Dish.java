import java.util.ArrayList;

import java.util.ArrayList;
public class Dish {

    ArrayList<Ingredient> ingredients;
    int id;
    String description;
    String name;
    double price;
    int type;

    public Dish(String name, int id){
        this.name = name;
        this.id = id;
    }

    public Dish(String name, double price, int id){
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public Dish(String name, int id, ArrayList<Ingredient> ingredients){
        this.name = name;
        this.id = id;
        this.ingredients = new ArrayList<>();
    }

    public Dish(String name, int id, ArrayList<Ingredient> ingredients, int price){
        this.name = name;
        this.id = id;
        this.ingredients = new ArrayList<>();
        this.price = price;
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
