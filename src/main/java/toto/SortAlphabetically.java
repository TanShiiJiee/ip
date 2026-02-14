package toto;

import java.util.ArrayList;

// Use of CoPilot to generate Javadoc for SortAlphabetically class

/**
 * Sorts the tasks in the list alphabetically by their descriptions.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class SortAlphabetically {
    private ArrayList<Task> taskArrayList;
    /**
     * Initializes the SortAlphabetically object with the list of tasks.
     *
     * @param taskList the list of tasks.
     */
    public SortAlphabetically(ArrayList<Task> taskList) {
        this.taskArrayList = taskList;
    }

    /**
    * Sorts the tasks in the list alphabetically by their descriptions.
    */
    public ArrayList<Task> sortTask() {
        this.taskArrayList.sort((t1, t2) -> t1.getDescription().compareToIgnoreCase(t2.getDescription()));
        return this.taskArrayList;
    }
}
