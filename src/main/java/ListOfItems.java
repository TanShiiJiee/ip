import java.util.ArrayList;

public class ListOfItems {
    // private String item; // Stores item name

//    public void addItems(ArrayList<Task> arrOfItems, String command) {
//        arrOfItems.add(new Task(command)); //Add item into ArrayList
//        Echo echo = new Echo(command);
//        Echo.printEcho(); // Print what has been added
//    }

    //Printing of Task List
    public void printItem(ArrayList<Task> arrOfItems) {
        String line = "___________________________________________________________ \n";
        System.out.println(line);
        System.out.println("Task delivery! Toto's got your back:");
        for (int i = 0; i < arrOfItems.size(); i++) {
            System.out.println(i + 1 + "." + arrOfItems.get(i).toString());
        }
        System.out.println(line);
    }
}
