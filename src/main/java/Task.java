public class Task {
    private final String description;
    private boolean isChecked;
    public Task(String desc) {
        this.description = desc;
        this.isChecked = false;
    }

    public String getMark() {
        if (this.isChecked) {
            return "X";
        } else {
            return " ";
        }
    }

    public String getDescription() {
        return this.description;
    }

    public void markChecked() {
        String line = "___________________________________________________________ \n";
        this.isChecked = true;
        Echo echo = new Echo(this.description);
        echo.printMark(true);
        System.out.println(this + "\n" + line);
    }

    public void unmarkChecked() {
        String line = "___________________________________________________________ \n";
        this.isChecked = false;
        Echo echo = new Echo(this.description);
        echo.printMark(false);
        System.out.println(this + "\n" + line);
    }

    @Override
    public String toString() {
        return "[" + getMark() + "] " + this.description;
    }
}
