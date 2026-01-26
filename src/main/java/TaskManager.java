import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Responsible for saving task data to text file.
 * Responsible for loading, updating, and saving tasks.
 */
public class TaskManager {
    private ArrayList<Task> taskArrayList;
    private final String taskFile = "./data/totoTasks.txt";
    public TaskManager() {
        taskArrayList = new ArrayList<>();
        loadTasks();
    }

    /**
     * Loads saved tasks from text file into ArrayList
     */
    public void loadTasks() {
        File file = new File(taskFile);
        file.getParentFile().mkdirs();
        try {
            if (file.createNewFile()) {
                System.out.println("Looks like you are new here! Welcome!");
            } else {
                Scanner sc = new Scanner(new FileReader(taskFile));
                while (sc.hasNext()) {
                    String readTask = sc.nextLine();
                    String[] tmp = readTask.split("-");
                    if (tmp[0].equalsIgnoreCase("T")) {
                        taskArrayList.add(new Todo(tmp[2]));
                        if (Integer.parseInt(tmp[1]) == 1) {
                            taskArrayList.get(taskArrayList.size() - 1).markChecked();
                        }

                    } else if (tmp[0].equalsIgnoreCase("D")) {
                        taskArrayList.add(new Deadlines(tmp[2], tmp[3]));
                        if (Integer.parseInt(tmp[1]) == 1) {
                            taskArrayList.get(taskArrayList.size() - 1).markChecked();
                        }
                    } else if (tmp[0].equalsIgnoreCase("E")) {
                        taskArrayList.add(new Events(tmp[2], tmp[3], tmp[4]));
                        if (Integer.parseInt(tmp[1]) == 1) {
                            taskArrayList.get(taskArrayList.size() - 1).markChecked();
                        }
                    }
                }
                System.out.println("Loaded saved file! Ready to serve you!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves added tasks to text file.
     */
    public void saveTasks(Task task) {
        try (BufferedWriter bw = new BufferedWriter((new FileWriter(taskFile, true)))) {
            bw.write(task.writeTask() + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Updates tasks to text file.
     *
     * @param taskArrayList ArrayList storing new task changes
     */
    public void updateTasks(ArrayList<Task> taskArrayList) {
        try (BufferedWriter bw = new BufferedWriter((new FileWriter(taskFile)))) {
            for (int i = 0; i < taskArrayList.size(); i++) {
                bw.write(taskArrayList.get(i).writeTask() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }
}
