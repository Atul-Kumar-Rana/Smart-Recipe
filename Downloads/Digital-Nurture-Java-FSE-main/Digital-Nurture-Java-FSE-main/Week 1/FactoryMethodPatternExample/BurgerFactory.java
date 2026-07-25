public class BurgerFactory extends MenuFactory {
    public MenuItem createMenuItem() {
        return new BurgerItem();
    }
}
