package toto;

/**
 * Represents a deadline task
 *
 * @version 1.0
 * @author Shi Jie Tan
 */
public class Deadlines extends Task{
    private final String by;

    /**
     * Initializes a deadline task with a description and a due date.
     *
     * @param desc the description of the task.
     * @param by the due date of the task.
     */
    public Deadlines(String desc, String by) {
        super(desc);
        this.by = by;
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
        String line = "___________________________________________________________ \n";
        return "[D]" + super.toString() + " (by: " + this.by + ")";
    }
}
