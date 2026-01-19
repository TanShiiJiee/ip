import java.util.ArrayList;
import java.util.Scanner;
public class Toto {
    private static ArrayList<Task> itemList; // Stores array of item names
    public static void main(String[] args) {
        //Start Greeting
        String start = "___________________________________________________________ \n"
                + "Hello! I'm Toto \n"
                + "What can I do for you? \n"
                + "___________________________________________________________ \n" ;
        //End Message
        String end = "___________________________________________________________ \n"
                + "Bye bye! Hope to see you again soon! \n"
                + "___________________________________________________________ \n";
        System.out.println(start); //Print start greeting
        Scanner sc = new Scanner(System.in); //Read inputs
        itemList = new ArrayList<>(); //Stores List of items
        ListOfItems lst = new ListOfItems();
        while (true) {
            String command = sc.nextLine(); //Stores user inputs
            String[] tmp = command.split(" ");
            if (tmp[0].equalsIgnoreCase("bye")) {
                break; // Exits
            } else if (tmp[0].equalsIgnoreCase("list")) {
                lst.printItem(itemList); //Print List of Items in Array List
            } else if (tmp[0].equalsIgnoreCase("mark")) { //Mark the task
                itemList.get(Integer.parseInt(tmp[1]) - 1).markChecked();
            } else if (tmp[0].equalsIgnoreCase("unmark")) { //Unmark the task
                    itemList.get(Integer.parseInt(tmp[1]) - 1).unmarkChecked();
            } else {
                lst.addItems(itemList, command); //Add item into ArrayList
            }
        }

        System.out.println(end);// Prints exit message

    }
}
