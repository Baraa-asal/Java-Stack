package coffeeDore;
import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String itemName, double itemPrice) {
        Item item = new Item(itemName, itemPrice);
        this.menu.add(item);
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + " " + menu.get(i) + " -- " + "$" + menu.get(i).getPrice());
        }
    }

    public void newOrder() {

        System.out.println("Please enter customer name for new order:");
        String user = System.console().readLine();

        // My code:
        Order userOrder = new Order(user);
        displayMenu();

        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        while (!itemNumber.equals("q")) {

            userOrder.addItem(this.menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
            // userOrder.display();
        }
        this.orders.add(userOrder);
        userOrder.display();

    }
}
