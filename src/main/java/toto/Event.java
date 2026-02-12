package toto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event task.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Event extends Task {
    private final String from;
    private final String to;

    /**
     * Initializes a deadline task with a description and a start and end date.
     *
     * @param desc the description of the task.
     * @param from the start date and time of the task.
     * @param to the end date and time of the task.
     */
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTaskType() {
        return "E";
    }

    @Override
    public boolean isOnDate(LocalDate date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d yyyy HHmm");
        LocalDateTime localDateTimeFrom = LocalDateTime.parse(from, dateTimeFormatter);
        LocalDateTime localDateTimeTo = LocalDateTime.parse(to, dateTimeFormatter);
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        boolean overlaps = !localDateTimeTo.isBefore(startOfDay) && !localDateTimeFrom.isAfter(endOfDay);
        return overlaps && !this.isChecked();
    }

    /**
     * Returns a string representation of the event task
     *
     * @return a string to be written in the storage text file
     */
    public String writeTask() {
        return "E|" + super.writeTask() + "|" + this.from + "|" + this.to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
