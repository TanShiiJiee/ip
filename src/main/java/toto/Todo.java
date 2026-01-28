package toto;

/**
 * Represents a todo task
 *
 * @version 1.0
 * @author Shi Jie Tan
 */
public class Todo extends Task{
    /**
     * Initializes a todo task with a description.
     *
     * @param desc the description of the task.
     */
    public Todo(String desc) {
        super(desc);
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
