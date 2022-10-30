public class Test {
    public static void main(String[] args) {
        // creating 4 item varibles of type Item as Item objects with assigning valus to
        // their attributes
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 1.5;
        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 2.5;
        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 3.5;
        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 4.5;
        // --------------------------------------------

        // Create 4 order variables of type Order as Order objects
        Order order1 = new Order();
        order1.name = "Baraa";

        Order order2 = new Order();
        order2.name = "Mostafa";
        order2.items.add(item1);
        order2.total += item1.price;
        order2.ready = true;

        Order order3 = new Order();
        order3.name = "Abed";
        order3.items.add(item4);
        order3.total += item4.price;
        order3.items.add(item2);
        order3.items.add(item2);
        order3.total += (item2.price) * 2;

        Order order4 = new Order();
        order4.name = "Maram";
        order4.items.add(item2);
        order4.total += item2.price;
        order4.ready = true;

        // --------------------------------------------
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

    }
}
