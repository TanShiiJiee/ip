package toto;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents Toto chatbot.
 *
 * @version 1.0
 * @author Shi Jie Tan
 */
public class Toto {
    private final Ui ui;
    private final Storage storage;
    private Parser parser;

    /**
     * Initializes Toto chatbot.
     *
     * @param filePath the path to store the list of task.
     */
    public Toto(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
    }

    /**
     * Run Toto chatbot with user inputs.
     */
    public void run() {
        // Stores array of item names
        ArrayList<Task> itemList = storage.getTaskArrayList();
        ui.displayStart();
        Scanner sc = new Scanner(System.in); // Read inputs

        // User enters inputs
        while (true) {
            String command = sc.nextLine(); // Stores user inputs
            String[] tmp = command.split(" ", 2);
            parser = new Parser();

            try {
                String line = "___________________________________________________________ \n";
                if (tmp[0].equalsIgnoreCase("bye")) { // User enters "bye" command then chatbot exits
                    break; // Exits
                } else if (tmp[0].equalsIgnoreCase("list")) {
                    // User enters "list" command then print ArrayList
                    parser.parseList(tmp);
                    ui.printItem(itemList); // Print List of Items in Array List


                } else if (tmp[0].equalsIgnoreCase("mark")) {
                    // Mark the task
                    parser.parseMark(tmp, itemList);
                    itemList.get(Integer.parseInt(tmp[1]) - 1).markChecked();
                    storage.updateTasks(itemList);

                    // Update text file with updated changes
                    ui.displayMarkCheckedMessage(itemList.get(Integer.parseInt(tmp[1]) - 1));

                } else if (tmp[0].equalsIgnoreCase("unmark")) { // Unmark the task
                    // Mark the task
                    parser.parseMark(tmp, itemList);
                    itemList.get(Integer.parseInt(tmp[1]) - 1).unmarkChecked();
                    storage.updateTasks(itemList);

                    // Update text file with updated changes
                    ui.displayUnmarkCheckedMessage(itemList.get(Integer.parseInt(tmp[1]) - 1));

                } else if (tmp[0].equalsIgnoreCase("delete")) {
                    parser.parseDelete(tmp, itemList);
                    ui.printDeleted(); //Task Deleted printed message
                    System.out.println(itemList.get(Integer.parseInt(tmp[1]) - 1).toString()); //prints deleted task
                    itemList.remove(Integer.parseInt(tmp[1]) - 1); //remove task from arrayList
                    storage.updateTasks(itemList);

                } else if (tmp[0].equalsIgnoreCase("todo")){
                    parser.parseTodo(tmp);
                    itemList.add(new Todo(tmp[1])); //Add todo into ArrayList

                    // Get last added item to be added to text file
                    storage.saveTasks(itemList.get(itemList.size() - 1));

                    ui.printAddedTask(itemList.get(itemList.size() - 1), itemList.size());

                } else if (tmp[0].equalsIgnoreCase("event")) {
                    // Handles "Event" command
                    // Get last added item to be added to text file
                    parser.parseEvent(tmp, itemList);
                    storage.saveTasks(itemList.get(itemList.size() - 1));
                    ui.printAddedTask(itemList.get(itemList.size() - 1), itemList.size());

                } else if (tmp[0].equalsIgnoreCase("deadline")) {
                    // Handles "deadline" command
                    // Get last added item to be added to text file
                    parser.parseDeadline(tmp, itemList);
                    storage.saveTasks(itemList.get(itemList.size() - 1));
                    ui.printAddedTask(itemList.get(itemList.size() - 1), itemList.size());

                } else {
                    throw new TotoException(line + "Toto doesn't understand :( \n" +
                        "Please input a command from the following: \n" +
                            ui.displayCommands() + "Toto is waiting: "); //not valid command
                }

            } catch (TotoException e) {
                ui.printError(e.getMessage());
            }
        }
       ui.displayEnd();// Prints exit message
    }
    public static void main(String[] args) {
        new Toto("data/tasks.txt").run();
    }
}
