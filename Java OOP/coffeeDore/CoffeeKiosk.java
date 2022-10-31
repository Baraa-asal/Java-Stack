package coffeeDore;

import java.util.ArrayList;

public class CoffeeKiosk {

    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {
        this.menu = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addMenuItem(String itemName, double itemPrice) {
        Item item = new Item(itemName, itemPrice);
        this.menu.add(item);
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(i + " " + this.menu.get(i) + " -- " + "$" + this.menu.get(i).getPrice());
        }
    }

    public void newOrder() {

        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();

        // My code:
        Order order = new Order(name);
        displayMenu();

        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();

        while (!itemNumber.equals("q")) {
            order.addItem(this.menu.get(Integer.parseInt(itemNumber)));
            System.out.println("Please enter a menu item index or q to quit:");
            itemNumber = System.console().readLine();
            order.display();
        }

    }

}
