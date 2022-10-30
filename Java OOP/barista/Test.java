public class Test {
    public static void main(String[] args) {
        // creating 4 item varibles of type Item as Item objects with assigning valus to
        // their attributes
        Item item1 = new Item();
        item1.setName("mocha");
        item1.setPrice(1.5);
        Item item2 = new Item();
        item2.setName("latte");
        item2.setPrice(2.5);
        Item item3 = new Item();
        item3.setName("drip cofee");
        item3.setPrice(3.5);
        Item item4 = new Item();
        item4.setName("capuccino");
        item4.setPrice(4.5);
        // --------------------------------------------

        // Create 4 order variables of type Order as Order objects
        Order order1 = new Order();
        order1.setName("Baraa");

        Order order2 = new Order();
        order2.setName("Mostafa");
        order2.items.add(item1);
        // order2.total += item1.getPrice();
        order2.setReady(true);

        Order order3 = new Order();
        order3.setName("Abed");
        order3.items.add(item4);
        // order3.total += item4.getPrice();
        order3.items.add(item2);
        order3.items.add(item2);
        // order3.total += (item2.getPrice()) * 2;

        Order order4 = new Order();
        order4.setName("Mohammad");
        order4.items.add(item2);
        // order4.total += item2.getPrice();
        order4.setReady(true);
        // --------------------------------------------

        System.out.printf("Name: %s\n", order3.getName());
        System.out.printf("Total: %s\n", order3.getOrderTotal());
        System.out.printf("Ready: %s\n", order3.getReady());

    }
}
