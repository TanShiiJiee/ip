package toto;

import java.util.ArrayList;

/**
 * Handle printing of outputs.
 *
 * @version 1.0
 * @author Shi Jie Tan
 */
public class Ui {
    private final String line =  "___________________________________________________________ \n";

    /**
     * Displays list of commands available.
     *
     * @return a string of commands available in the chatbot.
     */
    public String displayCommands() {
        // Commands user can input
        String commandsAvail = "- list\n" +
                "- mark <Task Number>\n" +
                "- unmark <Task Number>\n" +
                "- delete <Task Number>\n" +
                "- todo <Task>\n" +
                "- deadline <Task Name> /by <yyyy/M/dd>\n" +
                "- event <Task Name> /from <yyyy/M/dd hhmm> /to <yyyy/M/dd hhmm>\n" +
                "- bye \n";

        return commandsAvail;
    }

    /**
     * Displays start greeting to users.
     */
    public void displayStart() {
        //Greeting message
        String start = "Hello! I'm Toto! Here is what I can do: \n" + displayCommands()
                + "So, what can I do for you? \n";
        System.out.println(line + start + line);
    }
    /**
     * Displays end message to users.
     */
    public void displayEnd() {
        // Goodbye message
        String end = "Bye bye! Hope to see you again soon!\n";
        System.out.println(line + end + line);
    }

    /**
     * Displays message that task has been marked.
     *
     * @param task the task that has been marked.
     */
    public void displayMarkCheckedMessage(Task task) {
        printMark(true);
        System.out.println(task.toString() + "\n" + line);
    }

    /**
     * Displays message that task has been unmarked.
     *
     * @param task the task that has been unmarked.
     */
    public void displayUnmarkCheckedMessage(Task task) {
        printMark(false);
        System.out.println(task.toString() + "\n" + line);
    }

    /**
     * Displays message that task has been deleted.
     */
    public void printDeleted() {
        System.out.println(line + "Task Deleted! Toto had removed this task:");
    }

    /**
     * Displays message when task is marked or unmarked.
     *
     * @param mark true if task is marked, false otherwise.
     */
    public void printMark(boolean mark) {
        String markMsg;
        //String checkedMark;
        if (mark) {
            markMsg = "Done! Toto is very happy :)";
            //checkedMark = "[X] ";
        } else {
            markMsg = "Oh no! Back to work!";
            // = "[ ] ";
        }
        System.out.println(line + markMsg);
    }

    /**
     * Displays the task that has been added to the list.
     *
     * @param task the task that has been added to the list.
     * @param size the size of the task list.
     */
    public void printAddedTask(Task task, int size) {
        System.out.println(line + "Task received! Toto had added this task:");
        System.out.println(task.toString()); //prints task added to list
        System.out.println("Now You have " + size
                + " task(s) in the list!" + "\n" + line);
    }

    /**
     * Displays the list of task that has been added before.
     *
     * @param arrOfItems the full list of tasks.
     */
    public void printItem(ArrayList<Task> arrOfItems) {
        System.out.println(line);
        System.out.println("Task delivery! Toto's got your back:");
        for (int i = 0; i < arrOfItems.size(); i++) {
            System.out.println(i + 1 + "." + arrOfItems.get(i).toString());
        }
        System.out.println(line);
    }

    /**
     * Displays the error message.
     *
     * @param msg the error message to be printed.
     */
    public void printError(String msg) {
        System.out.println(msg);
    }
}
