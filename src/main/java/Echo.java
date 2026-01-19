public class Echo {
    private String msg;
    public Echo(String msg) {
        this.msg = msg;
    }

    public void printEcho() {
        String line = "___________________________________________________________ \n";
        System.out.println(line + "added: " + this.msg + "\n" + line);
    }

    public void printMark(boolean mark) {
        if (mark) {
            String line = "___________________________________________________________ \n";
            System.out.println(line + "Done! Toto is very happy :)");
            System.out.println("[X] " + msg);
            System.out.println(line);
        } else {
            String line = "___________________________________________________________ \n";
            System.out.println(line + "Oh no! Back to work!");
            System.out.println("[ ] " + msg);
            System.out.println(line);
        }
    }

}
