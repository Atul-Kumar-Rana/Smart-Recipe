public class FactoryMethodPatternTest {
    public static void main(String[] args) {
        MenuFactory pizzaFactory = new PizzaFactory();
        MenuItem pizzaItem = pizzaFactory.createMenuItem();
        pizzaItem.prepare();
        MenuFactory burgerFactory = new BurgerFactory();
        MenuItem burgerItem = burgerFactory.createMenuItem();
        burgerItem.prepare();
        MenuFactory saladFactory = new SaladFactory();
        MenuItem saladItem = saladFactory.createMenuItem();
        saladItem.prepare();
    }
}
