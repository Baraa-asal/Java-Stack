import java.util.ArrayList;

class ListOfExceptions {
    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("22");
        myList.add("Hello");
        myList.add("My name is baraa");
        myList.add(11);

        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } catch (ClassCastException exception) {
                System.out.println(exception);
            }
        }
    }
}