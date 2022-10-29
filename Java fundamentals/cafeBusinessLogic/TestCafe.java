import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCafe {
  public static void main(String[] args) {

    CafeUtil cafe = new CafeUtil();
    /* ============ App Test Cases ============= */

    System.out.println("\n----- Streak Goal Test -----");
    System.out.printf("Purchases needed by week 10: %s \n\n", cafe.getStreakGoal());

    System.out.println("----- Order Total Test-----");
    double[] lineItems = { 3.5, 1.5, 4.0, 4.5 };
    System.out.printf("Order total: %s \n\n", cafe.getOrderTotal(lineItems));

    System.out.println("----- Display Menu Test-----");

    List<String> loadMenu = Arrays.asList(
        "drip coffee",
        "cappucino",
        "latte",
        "mocha");
    ArrayList<String> menu = new ArrayList<String>();
    menu.addAll(loadMenu);
    cafe.displayMenu(menu, lineItems);

    System.out.println("\n----- Add Customer Test-----");
    ArrayList<String> customers = new ArrayList<String>();
    cafe.addCustomers(customers);
    System.out.println("\n");

    double[] maxQuantity = { 3, 5, 3, 6 };
    // cafe.printPriceChart("Latte", 3, 3);
    System.out.println("Enter the type of drink:");
    String productName = System.console().readLine();
    boolean drinkIsFound = false;
    for (int i = 0; i < menu.size(); i++) {
      if (productName.equals(menu.get(i))) {
        drinkIsFound = true;
        cafe.printPriceChart(productName, lineItems[i], maxQuantity[i]);
        break;
      }
    }
    if (!drinkIsFound) {
      System.out.println("Drink is not found.");
    }
  }
}
