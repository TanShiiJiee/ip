import java.util.ArrayList;

public class ListOfItems {
    private String item; // Stores item name

    public void addItems(ArrayList<Task> arrOfItems, String command) {
        arrOfItems.add(new Task(command)); //Add item into ArrayList
        Echo echo = new Echo(command);
        echo.printEcho(); // Print what has been added
    }

    public void printItem(ArrayList<Task> arrOfItems) {
        String line = "___________________________________________________________ \n";
        System.out.println(line);
        for (int i = 0; i < arrOfItems.size(); i++) {
            System.out.println(i+1 + ". [" + arrOfItems.get(i).getMark() + "] " +
                    arrOfItems.get(i).getDescription());
        }
        System.out.println(line);
    }
}
