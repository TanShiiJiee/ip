public class Deadlines extends Task{
    private final String by;
    public Deadlines(String desc, String by) {
        super(desc);
        this.by = by;
    }

    @Override
    public String toString() {
        String line = "___________________________________________________________ \n";
        return "[D]" + super.toString() + "(by:" + by + ") ";
    }
}
