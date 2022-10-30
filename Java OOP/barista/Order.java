import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    ArrayList<Item> items;

    public Order() {
        this.name = "guest";
        this.ready = false;
        this.items = new ArrayList<>();
    }

    public Order(String name) {
        this.name = name;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    // getter for name field
    public String getName() {
        return name;
    }

    // setter for name field
    public void setName(String name) {
        this.name = name;
    }

    // getter for ready field
    public boolean getReady() {
        return ready;
    }

    // setter for ready field
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItem() {
        return items;
    }

    public void setItem(ArrayList<Item> items) {
        this.items = items;
    }

    public String getStatusMessage() {
        if (this.ready) {
            return "Your order is ready.";
        } else {
            return "Your order will be ready soon.";
        }
    }

    public void display(Item item) {
        System.out.printf("Customer Name: %s\n", this.getName());
        for (Item i : items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
            System.out.printf("Total: %s\n", this.getOrderTotal());
        }
    }

    public double getOrderTotal() {
        int total = 0;
        for (Item i : items) {
            total += i.getPrice();
        }
        return total;
    }
}