import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil {

    public int getStreakGoal() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        return sum;
    }

    public int getOrderTotal(double[] lineItems) {
        int total = 0;
        for (int i = 0; i < lineItems.length; i++) {
            total += lineItems[i];
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menu, double[] lineItems) {
        for (int i = 0; i < 4; i++) {
            System.out.println(i + " " + menu.get(i) + " -- " + lineItems[i]);
        }
    }

    public void addCustomers(ArrayList<String> customers) {
        int counter = 0;
        while (true) {
            String userName = System.console().readLine();
            if (userName.equals("q")) {
                break;
            }
            customers.add(userName);
            System.out.println("Hello," + userName + "! There are " + counter + " people ahead of you.");
            System.out.println(Arrays.toString(customers.toArray()));
            counter++;
        }
    }

    public void printPriceChart(String product, double price, double maxQuantity) {
        double discount = 0;
        System.out.println(product + "\n");
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.println(i + " - $" + (price * i - discount));
            discount += 0.5;
        }
    }
}
