public class Echo {
    private String msg;
    public Echo(String msg) {
        this.msg = msg;
    }

    public void printEcho(String msg) {
        String line = "___________________________________________________________ \n";
        System.out.println(line + "added: " + this.msg + "\n" + line);
    }
}
