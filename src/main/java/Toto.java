import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class Toto {
    private final Ui ui;
    private final Storage storage;
    public Toto(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);

    }
    public void run() {
        //Storage storage = new Storage();
        // Stores array of item names
        ArrayList<Task> itemList = storage.getTaskArrayList();
        ui.displayStart();
        Scanner sc = new Scanner(System.in); // Read inputs
        //itemList = new ArrayList<>(); // Stores List of items
        ListOfItems lst = new ListOfItems();
        boolean isValidCommand; // Check if valid command
        boolean isValidFormat; // Check if valid task format

        // User enters inputs
        while (true) {
            String command = sc.nextLine(); // Stores user inputs
            String[] tmp = command.split(" ", 2);
            isValidCommand = true;
            isValidFormat = true;

            try {
                String line = "___________________________________________________________ \n";
                if (tmp[0].equalsIgnoreCase("bye")) { // User enters "bye" command then chatbot exits
                    break; // Exits
                } else if (tmp[0].equalsIgnoreCase("list")) {
                    // User enters "list" command then print ArrayList
                    if (tmp.length > 1) {
                        throw new TotoException("Toto doesn't seem to recognize the instruction...\n" +
                                "Try again:");
                    }
                    lst.printItem(itemList); // Print List of Items in Array List
                } else if (tmp[0].equalsIgnoreCase("mark")) { // Mark the task
                    try{
                        if (Integer.parseInt(tmp[1]) < 1 || Integer.parseInt(tmp[1]) > itemList.size()) {
                            throw new TotoException(line + "Toto can't find the item :( \nPlease try again: ");
                        }
                        itemList.get(Integer.parseInt(tmp[1]) - 1).markChecked();
                        storage.updateTasks(itemList); // Update text file with updated changes
                        ui.displayMarkCheckedMessage(itemList.get(Integer.parseInt(tmp[1]) - 1));
                    } catch (NumberFormatException | IndexOutOfBoundsException i) {
                        System.out.println("Toto doesn't seem to recognize the instruction...\n" +
                                "Try again:");
                    }

                } else if (tmp[0].equalsIgnoreCase("unmark")) { // Unmark the task
                    try {
                        if (Integer.parseInt(tmp[1]) < 1 || Integer.parseInt(tmp[1]) > itemList.size()) {
                            throw new TotoException(line + "Toto can't find the item :( \nPlease try again: ");
                        }
                        itemList.get(Integer.parseInt(tmp[1]) - 1).unmarkChecked();
                        storage.updateTasks(itemList); // Update text file with updated changes
                        ui.displayUnmarkCheckedMessage(itemList.get(Integer.parseInt(tmp[1]) - 1));
                    } catch (NumberFormatException | IndexOutOfBoundsException i) {
                        System.out.println("Toto doesn't seem to recognize the instruction...\n" +
                                "Try again:");
                    }


                } else if (tmp[0].equalsIgnoreCase("delete")) {
                    try {
                        if (Integer.parseInt(tmp[1]) < 1 || Integer.parseInt(tmp[1]) > itemList.size()) {
                            throw new TotoException(line + "Toto can't find the item :( \n" +
                                    "Please try again: ");
                        } else {
                            ui.printDeleted(); //Task Deleted printed message
                            System.out.println(itemList.get(Integer.parseInt(tmp[1]) - 1).toString()); //prints deleted task
                            itemList.remove(Integer.parseInt(tmp[1]) - 1); //remove task from arrayList
                            storage.updateTasks(itemList);
                        }

                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        //Task number stated is not part of list
                        System.out.println(line + "Toto senses your instruction format is wrong...\n" +
                                "Please type again in this format(delete <Task Number>): ");
                    }

                } else {
                    if (tmp[0].equalsIgnoreCase("todo")) {
                        if (tmp.length > 1) {
                            itemList.add(new Todo(tmp[1])); //Add todo into ArrayList

                            // Get last added item to be added to text file
                            storage.saveTasks(itemList.get(itemList.size() - 1));
                        } else {
                            throw new TotoException(line + "Toto senses you did not include your task...\n" +
                                    "Please include your task as well: ");
                        }

                    } else if (tmp[0].equalsIgnoreCase("event")) {
                        // Handles "Event" command
                        try {
                            String desc = tmp[1].split(" /")[0].trim();
                            String frm = tmp[1].split(" /from")[1].trim();
                            frm = frm.split(" /to")[0].trim();
                            String to = tmp[1].split(" /to")[1].trim();
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/M/d HHmm");
                            LocalDateTime localDateTimeFrom = LocalDateTime.parse(frm, dateTimeFormatter);
                            LocalDateTime localDateTimeTo = LocalDateTime.parse(to, dateTimeFormatter);

                            //Add event into ArrayList with formatted Date Time
                            itemList.add(new Events(desc,
                                    localDateTimeFrom.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm")),
                                    localDateTimeTo.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm"))));

                            // Get last added item to be added to text file
                            storage.saveTasks(itemList.get(itemList.size() - 1));
                        } catch (ArrayIndexOutOfBoundsException e){
                            isValidFormat = false;
                            System.out.println(line +"Toto senses your task format is wrong...\n" +
                                    "Please type again in this format(event <Task Name> /from " +
                                    "<yyyy/M/dd HHmm> /to <yyyy/M/dd HHmm>): ");
                        } catch (DateTimeParseException e) {
                            isValidFormat = false;
                            System.out.println("Invalid date-time format :( \n" +
                                    "Please use yyyy/M/dd HHmm: ");
                        }
                    } else if (tmp[0].equalsIgnoreCase("deadline")) {
                        // Handles "deadline" command
                        try {
                            String desc = tmp[1].split(" /")[0].trim();
                            String by = tmp[1].split("/by")[1].trim();
                            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/M/d");
                            LocalDate localDate = LocalDate.parse(by, dateTimeFormatter);

                            //Add deadline into ArrayList
                            itemList.add(new Deadlines(desc,
                                    localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))));

                            // Get last added item to be added to text file
                            storage.saveTasks(itemList.get(itemList.size() - 1));
                        } catch (ArrayIndexOutOfBoundsException e) {
                            isValidFormat = false;
                            System.out.println(line + "Toto senses your task format is wrong...\n" +
                                    "Please type again in this format(deadline <Task Name> /by <Date>): ");
                        } catch (DateTimeParseException e) {
                            isValidFormat = false;
                            System.out.println("Invalid date format :( \n" +
                                    "Please use yyyy/M/dd: ");
                        }
                    } else {
                        isValidCommand = false; //command is not valid
                    }

                    if (!isValidCommand) {
                        throw new TotoException(line + "Toto doesn't understand :( \n" +
                                "Please input a command from the following: \n" +
                                ui.displayCommands() + "Toto is waiting: "); //not valid command
                    } else if (isValidFormat) { //correct format
                        ui.printAddedTask(); //Task received printed message
                        System.out.println(itemList.get(itemList.size() - 1).toString()); //prints task added to list

                        System.out.println("Now You have " + itemList.size()
                                + " task(s) in the list!" + "\n" + line);
                    }
                }
            } catch (TotoException e) {
                System.out.println(e.getMessage());
            }
        }
       ui.displayEnd();// Prints exit message
    }
    public static void main(String[] args) {
        new Toto("data/tasks.txt").run();
    }
}
