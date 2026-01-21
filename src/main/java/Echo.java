public class Echo {
    private final String msg;
    public Echo(String msg) {
        this.msg = msg;
    }

    public static void printEcho() {
        String line = "___________________________________________________________ \n";
        System.out.println(line + "Task received! Toto had added this task:");
    }

    public void printMark(boolean mark) {
        String line = "___________________________________________________________ \n";
        String markMsg;
        //String checkedMark;
        if (mark) {
            markMsg = "Done! Toto is very happy :)";
            //checkedMark = "[X] ";
        } else {
            markMsg = "Oh no! Back to work!";
            // = "[ ] ";
        }

        System.out.println(line + markMsg);
//        System.out.println(checkedMark + msg);
//        System.out.println(line);

    }

    public static void printDeleted() {
        String line = "___________________________________________________________ \n";
        System.out.println(line + "Task Deleted! Toto had removed this task:");
    }

}
