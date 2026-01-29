package toto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Handles making sense of the user command.
 *
 * @version 1.0
 * @author Shi Jie Tan
 */
public class Parser {
    private final String line = "___________________________________________________________ \n";
    public void parseList(String[] command) throws TotoException{
        if (command.length > 1) {
            throw new TotoException("Toto doesn't seem to recognize the instruction...\n" +
                    "Try again:");
        }
    }

    /**
     * Parses the "mark" command and validates the task index.
     *
     * @param command represents the split array of commands.
     * @param taskArrayList the list of tasks.
     * @throws TotoException if the task number input is invalid.
     */
    public void parseMark(String[] command, ArrayList<Task> taskArrayList) throws TotoException{
        try{
            if (Integer.parseInt(command[1]) < 1 || Integer.parseInt(command[1]) > taskArrayList.size()) {
                throw new TotoException(line + "Toto can't find the item :( \nPlease try again: ");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException i) {
            throw new TotoException("Toto doesn't seem to recognize the instruction...\n" +
                    "Try again:");
        }
    }

    /**
     * Parses the "delete" command and validates input.
     *
     * @param command represents the split array of commands.
     * @param taskArrayList the list of tasks.
     * @throws TotoException if the task input command is invalid.
     */
    public void parseDelete(String[] command, ArrayList<Task> taskArrayList) throws TotoException{
        try {
            if (Integer.parseInt(command[1]) < 1 || Integer.parseInt(command[1]) > taskArrayList.size()) {
                throw new TotoException(line + "Toto can't find the item :( \n" +
                        "Please try again: ");
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            //Task number stated is not part of list
            throw new TotoException(line + "Toto senses your instruction format is wrong...\n" +
                    "Please type again in this format(delete <Task Number>): ");
        }
    }

    /**
     * Parses the "todo" command and validates input.
     *
     * @param command represents the split array of commands.
     * @throws TotoException if the task input command is invalid.
     */
    public void parseTodo(String[] command) throws TotoException {
        if (command.length <= 1) {
            throw new TotoException(line + "Toto senses you did not include your task...\n" +
                    "Please include your task as well: ");
        }
    }

    /**
     * Parses the "event" command and validates input.
     * Changes date format from string to LocalDateTime.
     *
     * @param command represents the split array of commands.
     * @param taskArrayList the list of tasks.
     * @throws TotoException if the task input command is invalid.
     */
    public void parseEvent(String[] command, ArrayList<Task> taskArrayList ) throws TotoException {
        try {
            String desc = command[1].split(" /")[0].trim();
            String frm = command[1].split(" /from")[1].trim();
            frm = frm.split(" /to")[0].trim();
            String to = command[1].split(" /to")[1].trim();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/M/d HHmm");
            LocalDateTime localDateTimeFrom = LocalDateTime.parse(frm, dateTimeFormatter);
            LocalDateTime localDateTimeTo = LocalDateTime.parse(to, dateTimeFormatter);

            //Add event into ArrayList with formatted Date Time
            taskArrayList.add(new Events(desc,
                    localDateTimeFrom.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm")),
                    localDateTimeTo.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm"))));


        } catch (ArrayIndexOutOfBoundsException e){
            throw new TotoException(line +"Toto senses your task format is wrong...\n" +
                    "Please type again in this format(event <Task Name> /from " +
                    "<yyyy/M/dd HHmm> /to <yyyy/M/dd HHmm>): ");
        } catch (DateTimeParseException e) {
            throw new TotoException("Invalid date-time format :( \n" +
                    "Please use yyyy/M/dd HHmm: ");
        }
    }
    /**
     * Parses the "deadline" command and validates input.
     * Changes date format from string to LocalDate.
     *
     * @param command represents the split array of commands.
     * @param taskArrayList the list of tasks.
     * @throws TotoException if the task input command is invalid.
     */
    public void parseDeadline(String[] command, ArrayList<Task> taskArrayList) throws TotoException {
        try {
            String desc = command[1].split(" /")[0].trim();
            System.out.println(desc);
            String by = command[1].split("/by")[1].trim();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/M/d");
            LocalDate localDate = LocalDate.parse(by, dateTimeFormatter);

            //Add deadline into ArrayList
            taskArrayList.add(new Deadlines(desc,
                    localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))));

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TotoException(line + "Toto senses your task format is wrong...\n" +
                    "Please type again in this format(deadline <Task Name> /by <yyyy/M/dd>): ");
        } catch (DateTimeParseException e) {
            throw new TotoException("Invalid date format :( \n" +
                    "Please use yyyy/M/dd: ");
        }
    }

    /**
     * Handles "find" command and checks for valid parsing input.
     *
     * @param keyword the keyword to search from list.
     * @param taskArrayList the list of tasks.
     * @throws TotoException
     */
    public void parseFind(String[] keyword, ArrayList<Task> taskArrayList) throws TotoException{
        try {
            if (keyword.length <= 1) {
                throw new TotoException("Toto senses you did not input your keyword to find...\n" +
                        "Please include your keyword:");
            }
        } catch (TotoException e){
            throw new TotoException(e.getMessage());
        }
    }
}
