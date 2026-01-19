import java.util.ArrayList;

public class ListOfItems {
    private String item; // Stores item name

    public void addItems(ArrayList<String> arrOfItems, String command) {
        arrOfItems.add(command); //Add item into ArrayList
        Echo echo = new Echo(command);
        echo.printEcho(command); // Print what has been added
    }

    public void printItem(ArrayList<String> arrOfItems) {
        String line = "___________________________________________________________ \n";
        System.out.println(line);
        for (int i = 0; i < arrOfItems.size(); i++) {
            System.out.println(i+1 + ". " + arrOfItems.get(i));
        }
        System.out.println(line);
    }
}
