//Handles Task that start at a specific date/time and ends at a specific date/time
public class Events extends Task{
    private String from;
    private String to;
    public Events(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }


    @Override
    public String toString() {
        String line = "___________________________________________________________ \n";
        return "[E]" + super.toString() + " (from:" + from + " to:" + to + ")";
    }
}
