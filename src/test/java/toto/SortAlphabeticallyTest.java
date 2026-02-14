package toto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

// Use of CoPilot to generate unit tests for SortAlphabetically class
public class SortAlphabeticallyTest {
    @Test
    public void sortTask_uniqueDescriptions_correctOrder() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Todo("read book"));
        tasks.add(new Todo("yoga"));
        tasks.add(new Todo("grocery shopping"));
        ArrayList<Task> sorted = new SortAlphabetically(tasks).sortTask();
        assertEquals("grocery shopping", sorted.get(0).getDescription());
        assertEquals("read book", sorted.get(1).getDescription());
        assertEquals("yoga", sorted.get(2).getDescription());
    }

    @Test
    public void sortTask_duplicateDescriptions_correctOrder() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Todo("read book"));
        tasks.add(new Todo("yoga"));
        tasks.add(new Todo("yoga"));
        ArrayList<Task> sorted = new SortAlphabetically(tasks).sortTask();
        assertEquals("read book", sorted.get(0).getDescription());
        assertEquals("yoga", sorted.get(1).getDescription());
        assertEquals("yoga", sorted.get(2).getDescription());
    }
}
