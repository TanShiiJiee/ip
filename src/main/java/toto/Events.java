package toto;

/**
 * Represents an event task.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Events extends Task {
    private final String from;
    private final String to;

    /**
     * Initializes a deadline task with a description and a start and end date.
     *
     * @param desc the description of the task.
     * @param from the start date and time of the task.
     * @param to the end date and time of the task.
     */
    public Events(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
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
        String line = "___________________________________________________________ \n";
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
