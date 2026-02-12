package toto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Deadline extends Task {
    private final String by;

    /**
     * Initializes a deadline task with a description and a due date.
     *
     * @param desc the description of the task.
     * @param by the due date of the task.
     */
    public Deadline(String desc, String by) {
        super(desc);
        this.by = by;
    }

    @Override
    public String getTaskType() {
        return "D";
    }

    @Override
    public boolean isOnDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        LocalDateTime localDateTime = LocalDate.parse(by, dateTimeFormatter).atStartOfDay();

        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        return !localDateTime.isAfter(endOfDay) && !this.isChecked();
    }

    /**
     * Returns a string representation of the deadline task
     *
     * @return a string to be written in the storage text file
     */
    @Override
    public String writeTask() {
        return "D|" + super.writeTask() + "|" + this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
