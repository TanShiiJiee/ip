package toto;

import java.time.LocalDate;

/**
 * Represents a task.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Task {
    private final String description;
    private boolean isChecked;
    /**
     * Initializes a task with a description.
     * Task is not mark as checked by default.
     *
     * @param desc the description of the task.
     */
    public Task(String desc) {
        this.description = desc;
        this.isChecked = false;
    }

    /**
     * Returns whether this task has been checked.
     *
     * @return true if tasks is checked, false otherwise.
     */
    public boolean isChecked() {
        return isChecked;
    }

    public String getMark() {
        if (this.isChecked) {
            return "X";
        } else {
            return " ";
        }
    }

    public String getTaskType() {
        return "Z";
    }

    public String getDescription() {
        return this.description;
    }

    /**
     * Mark the task as checked.
     */
    public void markChecked() {
        this.isChecked = true;
    }

    /**
     * Mark the task as unchecked.
     */
    public void unmarkChecked() {
        this.isChecked = false;
    }

    /**
     * Returns a string representation of the task.
     *
     * @return a partial string to be written in the storage text file.
     */
    public String writeTask() {
        if (isChecked) {
            return "1|" + getDescription();
        } else {
            return "0|" + getDescription();
        }
    }

    public boolean checkKeyword(String keyword) {
        return getDescription().contains(keyword);
    }


    public boolean isOnDate(LocalDate date) {
        return true;
    }

    @Override
    public String toString() {
        return "[" + getMark() + "] " + this.description;
    }
}
