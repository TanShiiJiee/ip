package toto;

import java.time.LocalDate;

/**
 * Represents a todo task.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Todo extends Task {
    /**
     * Initializes a todo task with a description.
     *
     * @param desc the description of the task.
     */
    public Todo(String desc) {
        super(desc);
    }

    @Override
    public String getTaskType() {
        return "T";
    }

    @Override
    public boolean isOnDate(LocalDate date) {
        if (this.isChecked()) {
            return false;
        }
        return true;
    }
    /**
     * Returns a string representation of the todo task
     *
     * @return a string to be written in the storage text file
     */
    @Override
    public String writeTask() {
        return "T|" + super.writeTask();
    }

    @Override
    public String toString() {
        String line = "___________________________________________________________ \n";
        return "[T]" + super.toString();
    }
}
