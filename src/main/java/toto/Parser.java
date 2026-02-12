package toto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Handles making sense of the user command.
 *
 * @author Shi Jie Tan
 * @version 1.0
 */
public class Parser {
    private final String invalidCommandMessage = "Toto doesn't seem to recognize the instruction...\n"
            + "Try again!";
    private final String invalidItemNumber = "Toto can't find the item :( \nPlease try again";
    private final String invalidFormat = "Toto senses your instruction format is wrong...\n";

    /**
     * Parses the list command.
     *
     * @param command represents the split array of commands.
     * @throws TotoException if command does not exist.
     */
    public void parseList(String[] command) throws TotoException {
        if (command.length > 1) {
            throw new TotoException(invalidCommandMessage);
        }
    }

    /**
     * Parses the "mark" command and validates the task index.
     *
     * @param command represents the split array of commands.
     * @param taskArrayList the list of tasks.
     * @throws TotoException if the task number input is invalid.
     */
    public void parseMark(String[] command, ArrayList<Task> taskArrayList) throws TotoException {
        try {
            if (Integer.parseInt(command[1]) < 1 || Integer.parseInt(command[1]) > taskArrayList.size()) {
                throw new TotoException(invalidItemNumber);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException i) {
            throw new TotoException(invalidCommandMessage);
        }
    }

    /**
     * Parses the "delete" command and validates input.
     *
     * @param command represents the split array of commands.
     * @param taskArrayList the list of tasks.
     * @throws TotoException if the task input command is invalid.
     */
    public void parseDelete(String[] command, ArrayList<Task> taskArrayList) throws TotoException {
        try {
            if (Integer.parseInt(command[1]) < 1 || Integer.parseInt(command[1]) > taskArrayList.size()) {
                throw new TotoException(invalidItemNumber);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            //Task number stated is not part of list
            throw new TotoException(invalidFormat + "Please type again in this format(delete <Task Number>)");
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
            throw new TotoException(invalidFormat + "Please include your task as well...");
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
    public void parseEvent(String[] command, ArrayList<Task> taskArrayList) throws TotoException {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/M/d HHmm");

            String desc = command[1].split(" /")[0].trim();

            String frm = command[1].split(" /from")[1].trim();
            frm = frm.split(" /to")[0].trim();
            LocalDateTime localDateTimeFrom = LocalDateTime.parse(frm, dateTimeFormatter);

            String to = command[1].split(" /to")[1].trim();
            LocalDateTime localDateTimeTo = LocalDateTime.parse(to, dateTimeFormatter);
            assert localDateTimeFrom.isBefore(localDateTimeTo) : "From must be before to";

            //Add event into ArrayList with formatted Date Time
            taskArrayList.add(new Event(desc,
                    localDateTimeFrom.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm")),
                    localDateTimeTo.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm"))));


        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TotoException(invalidFormat
                    + "Please type again in this format(event <Task Name> /from "
                    + "<yyyy/M/dd HHmm> /to <yyyy/M/dd HHmm>) ");
        } catch (DateTimeParseException e) {
            throw new TotoException("Invalid date-time format :( \nPlease use yyyy/M/dd HHmm");
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
            //System.out.println(desc);
            String by = command[1].split("/by")[1].trim();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/M/d");
            LocalDate localDate = LocalDate.parse(by, dateTimeFormatter);

            //Add deadline into ArrayList
            taskArrayList.add(new Deadline(desc,
                    localDate.format(DateTimeFormatter.ofPattern("MMM d yyyy"))));

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new TotoException(invalidFormat
                    + "Please type again in this format(deadline <Task Name> /by <yyyy/M/dd>) ");
        } catch (DateTimeParseException e) {
            throw new TotoException("Invalid date format :( \nPlease use yyyy/M/dd");
        }
    }

    /**
     * Handles "find" command and checks for valid parsing input.
     *
     * @param keyword the keyword to search from list.
     * @throws TotoException if command does not exist.
     */
    public void parseFind(String[] keyword) throws TotoException {
        try {
            if (keyword.length <= 1) {
                throw new TotoException(invalidFormat
                        + "Please include your keyword");
            }
        } catch (TotoException e) {
            throw new TotoException(e.getMessage());
        }
    }
}
