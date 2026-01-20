//Handles Task without any date/time
public class Todo extends Task{
    public Todo(String desc) {
        super(desc);
    }

    @Override
    public String toString() {
        String line = "___________________________________________________________ \n";
        return "[T]" + super.toString();
    }
}
