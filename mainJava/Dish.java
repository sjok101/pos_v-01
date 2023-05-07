import java.util.ArrayList;

public class Dish {

    ArrayList<Ingredient> ingredients;
    String description;
    String name;
    double price;

    public Dish(String name, double price){
        this.name = name;
        this.price = price;
    }


    public Dish(String name, ArrayList<Ingredient> ingredients){
        this.name = name;
        this.ingredients = new ArrayList<>();
    }

    public Dish(String name, ArrayList<Ingredient> ingredients, int price){
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.price = price;
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
        if(name != null) {
            this.name = name;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0) {
            this.price = price;
        }
    }
}
