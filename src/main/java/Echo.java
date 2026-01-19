public class Echo {
    private String msg;
    public Echo(String msg) {
        this.msg = msg;
        String line = "___________________________________________________________ \n";
        System.out.println(line + this.msg + "\n" + line);
    }
}
