package toto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Handles creation of schedule by date
 */
public class ViewSchedule {
    private final LocalDate localDate;
    private final ArrayList<Task> itemList;
    private ArrayList<Task> filteredList;


    /**
     * Creates a ViewSchedule that displays tasks
     * for the specified date.
     *
     * @param date the date to view the schedule for.
     * @param taskArrayList the full list of tasks.
     */
    public ViewSchedule(String date, ArrayList<Task> taskArrayList) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d yyyy");
        this.localDate = LocalDate.parse(date, dateTimeFormatter);
        this.itemList = taskArrayList;
        filteredList = new ArrayList<>();
        filterTasksByDate();
    }

    /**
     * Filters the tasks in itemList by the specified localDate.
     * Stores the filtered tasks into filteredList.
     */
    public void filterTasksByDate() {
        for (Task task : itemList) {
            if (task.isOnDate(this.localDate)) {
                filteredList.add(task);
            }
        }
    }

    /**
     * Displays the full schedule table in a formatted layout.
     *
     * @return the full table of scheduled tasks for the date.
     */
    public StringBuilder displayFullTable() {
        String tableView = "|-------------------------------|\n"
                + "| Type   |           Task              |\n"
                + "|--------|----------------------|\n";
        StringBuilder fullTable = new StringBuilder(tableView);
        for (Task task : filteredList) {
            String desc = task.getDescription();
            String displayName;
            String taskType = task.getTaskType();

            if (desc.length() > 20) {
                displayName = desc.substring(0, 17) + "...";
            } else {
                displayName = desc;
            }

            fullTable.append(String.format("|  %-7s | %-22s |\n|-------------------------------|\n",
                    taskType, displayName));
        }
        fullTable.append("Total tasks: ").append(filteredList.size()).append("\n");
        return fullTable;
    }
}
