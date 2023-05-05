<<<<<<< HEAD

=======
>>>>>>> 9ea4349e93191276310269ea97fbfe3caa4f429c
public class Ingredient {
    int id;
    String name;
    int quantity;

    public Ingredient(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
