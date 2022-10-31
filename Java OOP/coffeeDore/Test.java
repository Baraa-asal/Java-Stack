package coffeeDore;

public class Test {
    public static void main(String[] args) {

        CoffeeKiosk coffeeKiosk = new CoffeeKiosk();

        coffeeKiosk.addMenuItem("latte", 1);
        coffeeKiosk.addMenuItem("drip coffee", 1.5);
        coffeeKiosk.addMenuItem("capuccino", 2);
        coffeeKiosk.addMenuItem("muffin", 2.5);
        coffeeKiosk.addMenuItem("chocolate cake", 3);
        coffeeKiosk.newOrder();
    }
}
