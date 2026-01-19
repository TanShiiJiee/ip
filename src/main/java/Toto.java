import java.util.Scanner;
public class Toto {
    public static void main(String[] args) {
        //Start Greeting
        String start = "___________________________________________________________ \n"
                + "Hello! I'm Toto \n"
                + "What can I do for you? \n"
                + "___________________________________________________________ \n" ;
        //End Message
        String end = "___________________________________________________________ \n"
                + "Bye. Hope to see you again soon! \n"
                + "___________________________________________________________ \n";
        System.out.println(start); //Print start greeting
        Scanner sc = new Scanner(System.in);
        String command = ""; //Stores user inputs
        while (true) {
            command = sc.nextLine();
            if (command.equals("bye")) {
                break; // Exits
            } else {
                Echo echo = new Echo(command);
            }
        }

        System.out.println(end);// Prints exit message

    }
}
