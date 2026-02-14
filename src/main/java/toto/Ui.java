package toto;

import java.util.ArrayList;

/**
 * Handle printing of outputs.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Ui {
    /**
     * Displays list of commands available.
     *
     * @return a string of commands available in the chatbot.
     */
    public String displayCommands() {
        // Commands user can input
        String commandsAvail = "- list\n"
                + "- mark <Task Number>\n"
                + "- unmark <Task Number>\n"
                + "- delete <Task Number>\n"
                + "- todo <Task>\n"
                + "- deadline <Task Name> /by <yyyy/M/d>\n"
                + "- event <Task Name> /from <yyyy/M/d hhmm> /to <yyyy/M/d hhmm>\n"
                + "- find <Keyword>\n"
                + "- view <yyyy/M/d>\n"
                + "- sort\n"
                + "- bye \n";

        return commandsAvail;
    }

    /**
     * Displays start greeting to users.
     * @return the string to be displayed at the start.
     */
    public String displayStart() {
        //Greeting message
        String start = "Hello! I'm Toto! Here is what I can do: \n" + displayCommands()
                + "So, what can I do for you? \n";
        return start;
    }
    /**
     * Displays end message to users.
     * @return the string to be displayed at the end.
     */
    public String displayEnd() {
        // Goodbye message
        String end = "Bye bye! Hope to see you again soon!\n";
        return end;
    }

    /**
     * Displays message that task has been marked.
     *
     * @param task the task that has been marked.
     * @return the task that has been checked with a message.
     */
    public String displayMarkCheckedMessage(Task task) {
        return printMark(true) + task.toString() + "\n";
    }

    /**
     * Displays message that task has been unmarked.
     *
     * @param task the task that has been unmarked.
     * @return the task that has been unchecked with a message.
     */
    public String displayUnmarkCheckedMessage(Task task) {
        return printMark(false) + task.toString() + "\n";
    }

    /**
     * Displays message that task has been deleted.
     *
     * @return the message to displayed when deleted.
     */
    public String printDeleted() {
        return "Task Deleted! Toto had removed this task:\n";
    }

    /**
     * Displays message when task is marked or unmarked.
     *
     * @param isMark true if task is marked, false otherwise.
     * @return the string to be displayed when task is marked or unmarked.
     */
    public String printMark(boolean isMark) {
        String markMsg;
        if (isMark) {
            markMsg = "Done! Toto is very happy :)\n";
        } else {
            markMsg = "Oh no! Back to work!\n";
        }
        return markMsg;
    }

    /**
     * Displays the task that has been added to the list.
     *
     * @param task the task that has been added to the list.
     * @param size the size of the task list.
     * @return the task that has been added.
     */
    public String printAddedTask(Task task, int size) {
        String tmp = "Task received! Toto had added this task:\n"
                + task.toString()
                + "\nNow You have " + size
                + " task(s) in the list!"
                + "\n";
        return tmp;
    }

    /**
     * Displays the list of task that has been added before.
     *
     * @param arrOfItems the full list of tasks.
     * @return the string of tasks.
     */
    public String printItem(ArrayList<Task> arrOfItems) {
        StringBuilder itemStatement = new StringBuilder("Task delivery! Toto's got your back:\n");
        for (int i = 0; i < arrOfItems.size(); i++) {
            itemStatement.append(i + 1).append(". ").append(arrOfItems.get(i).toString()).append("\n");
        }
        return itemStatement.toString();
    }

    /**
     * Displays the error message.
     *
     * @param msg the error message to be printed.
     * @return the error message string.
     */
    public String printError(String msg) {
        return msg;
    }

    /**
     * Displays all matching tasks with keywords.
     *
     * @param arrOfItems the full list of tasks.
     * @return the string of tasks with matching keywords.
     */
    public String printMatchingTasks(ArrayList<Task> arrOfItems) {
        StringBuilder matchTasks = new StringBuilder("Toto has compiled all the matching tasks: \n");
        for (int i = 0; i < arrOfItems.size(); i++) {
            matchTasks.append(i + 1).append(". ").append(arrOfItems.get(i).toString()).append("\n");
        }
        return matchTasks.toString();
    }
}
