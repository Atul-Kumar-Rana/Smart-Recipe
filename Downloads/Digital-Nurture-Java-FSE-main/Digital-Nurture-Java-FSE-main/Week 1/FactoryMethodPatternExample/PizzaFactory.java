public class PizzaFactory extends MenuFactory {
    public MenuItem createMenuItem() {
        return new PizzaItem();
    }
}
