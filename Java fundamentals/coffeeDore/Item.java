package coffeeDore;

public class Item {
  private String name;
  private double price;

  // two parameter constructor
  public Item() {
    this("item", 0.0);
  }

  public Item(String name, double price) {
    this.name = name;
    this.price = price;
  }

  // getter for name field
  public String getName() {
    return name;
  }

  // setter for name field
  public void setName(String name) {
    this.name = name;
  }

  // getter for price field
  public double getPrice() {
    return price;
  }

  // setter for price field
  public void setPrice(double price) {
    this.price = price;
  }
}
