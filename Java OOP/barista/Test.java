public class Test {
    public static void main(String[] args) {
        // creating 4 item varibles of type Item as Item objects with assigning valus to
        // their attributes
        Item item1 = new Item("mocha", 1.5);
        Item item2 = new Item("latte", 2.5);
        Item item3 = new Item("drip coffee", 3.5);
        Item item4 = new Item("capuccino", 4.5);
        // --------------------------------------------

        // Create 4 order variables of type Order as Order objects
        Order guestOrder = new Order();

        Order order1 = new Order("Baraa");
        order1.addItem(item3);

        Order order2 = new Order("Mostafa");
        order2.addItem(item1);
        order2.setReady(true);

        Order order3 = new Order("Abed");
        order3.addItem(item2);
        order3.items.add(item2);
        order3.items.add(item2);

        Order order4 = new Order("Mohammad");
        order4.addItem(item4);
        order4.setReady(true);
        // --------------------------------------------

        System.out.printf("Name: %s\n", order3.getName());
        System.out.printf("Total: %s\n", order3.getOrderTotal());
        System.out.printf("Ready: %s\n", order3.getReady());

    }
}
