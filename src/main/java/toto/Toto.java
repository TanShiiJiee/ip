package toto;

import java.util.ArrayList;

/**
 * Represents Toto chatbot.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Toto {
    private final Ui ui;
    private final Storage storage;
    private Parser parser;
    private ArrayList<Task> itemList;
    /**
     * Initializes Toto chatbot.
     *
     * @param filePath the path to store the list of task.
     */
    public Toto(String filePath) {
        assert filePath != null : "File path cannot be null";
        ui = new Ui();
        storage = new Storage(filePath);
        itemList = storage.getTaskArrayList();
        parser = new Parser();
    }

    /**
     * Returns a list of tasks containing tasks with the keyword.
     *
     * @param keyword the keyword to find.
     * @return a list of tasks with keyword.
     */
    public ArrayList<Task> findTasks(String keyword) {
        ArrayList<Task> addKeyword = new ArrayList<>();
        for (Task task : itemList) {
            if (task.checkKeyword(keyword)) {
                addKeyword.add(task);
            }
        }
        return addKeyword;
    }

    public String getStart() {
        return ui.displayStart();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        String[] tmp = input.split(" ", 2);
        try {
            if (tmp[0].equalsIgnoreCase("bye")) { // User enters "bye" command then chatbot exits
                return ui.displayEnd();
            } else if (tmp[0].equalsIgnoreCase("list")) {
                // User enters "list" command then print ArrayList
                parser.parseList(tmp);

                return ui.printItem(itemList);

            } else if (tmp[0].equalsIgnoreCase("mark")) {
                // Mark the task
                parser.parseMark(tmp, itemList);
                itemList.get(Integer.parseInt(tmp[1]) - 1).markChecked();
                storage.updateTasks(itemList);

                // Update text file with updated changes
                return ui.displayMarkCheckedMessage(itemList.get(Integer.parseInt(tmp[1]) - 1));

            } else if (tmp[0].equalsIgnoreCase("unmark")) { // Unmark the task
                // Mark the task
                parser.parseMark(tmp, itemList);
                itemList.get(Integer.parseInt(tmp[1]) - 1).unmarkChecked();
                storage.updateTasks(itemList);

                // Update text file with updated changes
                return ui.displayUnmarkCheckedMessage(itemList.get(Integer.parseInt(tmp[1]) - 1));

            } else if (tmp[0].equalsIgnoreCase("delete")) {
                parser.parseDelete(tmp, itemList);
                String delItem = itemList.get(Integer.parseInt(tmp[1]) - 1).toString(); //prints deleted task
                itemList.remove(Integer.parseInt(tmp[1]) - 1); //remove task from arrayList

                storage.updateTasks(itemList);
                return ui.printDeleted() + delItem; //Task Deleted printed message

            } else if (tmp[0].equalsIgnoreCase("todo")) {
                parser.parseTodo(tmp);
                itemList.add(new Todo(tmp[1])); //Add todo into ArrayList

                // Get last added item to be added to text file
                storage.saveTasks(itemList.get(itemList.size() - 1));

                return ui.printAddedTask(itemList.get(itemList.size() - 1), itemList.size());

            } else if (tmp[0].equalsIgnoreCase("event")) {
                parser.parseEvent(tmp, itemList);
                storage.saveTasks(itemList.get(itemList.size() - 1));
                return ui.printAddedTask(itemList.get(itemList.size() - 1), itemList.size());

            } else if (tmp[0].equalsIgnoreCase("deadline")) {
                parser.parseDeadline(tmp, itemList);
                storage.saveTasks(itemList.get(itemList.size() - 1));
                return ui.printAddedTask(itemList.get(itemList.size() - 1), itemList.size());

            } else if (tmp[0].equalsIgnoreCase("find")) {
                parser.parseFind(tmp);
                return ui.printMatchingTasks(findTasks(tmp[1]));

            } else {
                throw new TotoException("Toto doesn't understand :( \n"
                        + "Please input a command from the following: \n"
                        + ui.displayCommands()); //not valid command
            }
        } catch (TotoException e) {
            return ui.printError(e.getMessage());
        }
    }
}
