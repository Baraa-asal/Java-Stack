public class CafeJava {
    public static void main(String[] args) {

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        double mochaPrice = 3.5;
        double dripCoffee = 2.5;
        double latte = 7.0;
        double cappuccino = 5.5;

        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = true;

        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + pendingMessage);
        System.out.println(customer4 + (isReadyOrder4 ? (readyMessage + '.' + ' ' + displayTotalMessage + cappuccino + '.') : pendingMessage));
        System.out.println(generalGreeting + customer2 + '.' + ' ' + displayTotalMessage + latte * 2 + (isReadyOrder2 ? readyMessage : pendingMessage) + '.');
        System.out.println(generalGreeting + customer3 + '.' + ' ' + "Sorry for the mistake. " + displayTotalMessage + (latte - dripCoffee));
    }
}
