package coffeeDore;

public class Test {
    public static void main(String[] args) {
        CoffeeKiosk coffee_kiosk = new CoffeeKiosk();
        coffee_kiosk.addMenuItem("latte", 1);
        coffee_kiosk.addMenuItem("drip coffee", 1.5);
        coffee_kiosk.addMenuItem("capuccino", 2);
        coffee_kiosk.addMenuItem("muffin", 2.5);
        coffee_kiosk.addMenuItem("chocolate cake", 3);
        coffee_kiosk.newOrder();
    }
}
