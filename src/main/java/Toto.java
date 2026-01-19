import java.util.ArrayList;
import java.util.Scanner;
public class Toto {
    private static ArrayList<String> itemList; // Stores array of item names
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
            if (command.equalsIgnoreCase("bye")) {
                break; // Exits
            } else if (command.equalsIgnoreCase("list")) {
                lst.printItem(itemList); //Print List of Items in Array List
            } else {
                lst.addItems(itemList, command); //Add item into ArrayList
            }
        }

        System.out.println(end);// Prints exit message

    }
}
