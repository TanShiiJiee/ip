import java.util.ArrayList;
import java.util.Scanner;
public class Toto {
    private static ArrayList<Task> itemList; // Stores array of item names
    public static void main(String[] args) {
        //Start Greeting
        String line = "___________________________________________________________ \n";

        //End Message
        String end = "Bye bye! Hope to see you again soon!";
        String commandsAvail = "- list\n" +
                "- mark <Task Number>\n" +
                "- unmark <Task Number>\n" +
                "- todo <Task>\n" +
                "- deadline <Task Name> /by <Date/Time>\n" +
                "- event <Task Name> /from <Date/Time> /to <Date/time>\n" +
                "- bye \n";
        String start = "Hello! I'm Toto! Here is what I can do: \n" + commandsAvail
                + "So, what can I do for you? \n";
        System.out.println(line + start + line); //Print start greeting
        Scanner sc = new Scanner(System.in); //Read inputs
        itemList = new ArrayList<>(); //Stores List of items
        ListOfItems lst = new ListOfItems();
        boolean isValidCommand; //check if valid command
        boolean isValidFormat; //check if valid task format
        while (true) {
            String command = sc.nextLine(); //Stores user inputs
            String[] tmp = command.split(" ", 2);
            isValidCommand = true;
            isValidFormat = true;
            try {
                if (tmp[0].equalsIgnoreCase("bye")) {
                    break; // Exits
                } else if (tmp[0].equalsIgnoreCase("list")) {
                    lst.printItem(itemList); //Print List of Items in Array List
                } else if (tmp[0].equalsIgnoreCase("mark")) { //Mark the task
                    if (Integer.parseInt(tmp[1]) < 1 || Integer.parseInt(tmp[1]) > itemList.size()) {
                        throw new TotoException("Toto can't find the item :( \nPlease try again: ");
                    }
                    itemList.get(Integer.parseInt(tmp[1]) - 1).markChecked();
                } else if (tmp[0].equalsIgnoreCase("unmark")) { //Unmark the task
                    if (Integer.parseInt(tmp[1]) < 1 || Integer.parseInt(tmp[1]) > itemList.size()) {
                        throw new TotoException("Toto can't find the item :( \nPlease try again: ");
                    }

                    itemList.get(Integer.parseInt(tmp[1]) - 1).unmarkChecked();

                } else {
                    if (tmp[0].equalsIgnoreCase("todo")) {
                        if (tmp.length > 1) {
                            itemList.add(new Todo(tmp[1])); //Add todo into ArrayList
                        } else {
                            throw new TotoException(line + "Toto senses you did not include your task...\nPlease include your task as well: ");
                        }

                    } else if (tmp[0].equalsIgnoreCase("event")) {
                        try {
                            String desc = tmp[1].split(" /")[0];
                            String frm = tmp[1].split(" /from")[1];
                            frm = frm.split(" /to")[0];
                            String to = tmp[1].split(" /to")[1];
                            itemList.add(new Events(desc, frm, to)); //Add event into ArrayList
                        } catch (ArrayIndexOutOfBoundsException e){
                            isValidFormat = false;
                            System.out.println(line +"Toto senses your task format is wrong...\n" +
                                    "Please type again in this format(event <Task Name> /from <Date/Time> /to <Date/time>): ");
                        }
                    } else if (tmp[0].equalsIgnoreCase("deadline")) {
                        try {
                            String desc = tmp[1].split(" /")[0];
                            String by = tmp[1].split("/by")[1];
                            itemList.add(new Deadlines(desc, by)); //Add deadline into ArrayList
                        } catch (ArrayIndexOutOfBoundsException e) {
                            isValidFormat = false;
                            System.out.println(line + "Toto senses your task format is wrong...\n" +
                                    "Please type again in this format(deadline <Task Name> /by <Date/Time>): ");
                        }

                    } else {
                        isValidCommand = false;
                    }
                    //lst.addItems(itemList, command);

                    if (!isValidCommand) {
                        throw new TotoException(line + "Toto doesn't understand :( \nPlease input a command from the following: \n" +
                                commandsAvail + "Toto is waiting: ");
                    } else if (isValidFormat) {
                        Echo.printEcho(); //Task received printed message
                        System.out.println(itemList.get(itemList.size() - 1).toString());
                        System.out.println("Now You have " + itemList.size()
                                + " task(s) in the list!"  + "\n" + line);
                    }


                }

            } catch (TotoException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(line + end + "\n" + line);// Prints exit message

    }
}
