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
        this.isChecked = true;
        Echo echo = new Echo(this.description);
        echo.printMark(true);
    }

    public void unmarkChecked() {
        this.isChecked = false;
        Echo echo = new Echo(this.description);
        echo.printMark(false);
    }
}
