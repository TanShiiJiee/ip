import java.util.ArrayList;
import java.util.Scanner;
public class Toto {
    private static ArrayList<Task> itemList; // Stores array of item names
    public static void main(String[] args) {
        //Start Greeting
        String line = "___________________________________________________________ \n";
        String start = "Hello! I'm Toto \n"
                + "What can I do for you? \n";
        //End Message
        String end = "Bye bye! Hope to see you again soon!";
        System.out.println(line + start + line); //Print start greeting
        Scanner sc = new Scanner(System.in); //Read inputs
        itemList = new ArrayList<>(); //Stores List of items
        ListOfItems lst = new ListOfItems();
        while (true) {
            String command = sc.nextLine(); //Stores user inputs
            String[] tmp = command.split(" ", 2);
            if (tmp[0].equalsIgnoreCase("bye")) {
                break; // Exits
            } else if (tmp[0].equalsIgnoreCase("list")) {
                lst.printItem(itemList); //Print List of Items in Array List
            } else if (tmp[0].equalsIgnoreCase("mark")) { //Mark the task
                itemList.get(Integer.parseInt(tmp[1]) - 1).markChecked();
            } else if (tmp[0].equalsIgnoreCase("unmark")) { //Unmark the task
                    itemList.get(Integer.parseInt(tmp[1]) - 1).unmarkChecked();
            } else {
                if (tmp[0].equalsIgnoreCase("todo")) {
                    itemList.add(new Todo(tmp[1])); //Add todo into ArrayList
                } else if (tmp[0].equalsIgnoreCase("event")) {
                    String desc = tmp[1].split(" /")[0];
                    String frm = tmp[1].split(" /from")[1];
                    frm = frm.split(" /to")[0];
                    String to = tmp[1].split(" /to")[1];
                    itemList.add(new Events(desc, frm, to)); //Add event into ArrayList
                } else {
                    String desc = tmp[1].split(" /")[0];
                    String by = tmp[1].split("/by")[1];
                    itemList.add(new Deadlines(desc, by)); //Add deadline into ArrayList
                }
                //lst.addItems(itemList, command);
                Echo.printEcho(); //Task received printed message
                System.out.println(itemList.get(itemList.size() - 1).toString());
                System.out.println("Now You have " + itemList.size()
                        + " task(s) in the list!"  + "\n" + line);
            }
        }

        System.out.println(line + end + "\n" + line);// Prints exit message

    }
}
