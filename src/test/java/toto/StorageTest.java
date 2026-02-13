package toto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Use of CoPilot to generate unit tests for Storage class
public class StorageTest {
    private static final String TEST_FILE = "./test/data/tasksTest.txt";

    @BeforeEach
    public void setUp() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
        File dir = file.getParentFile();
        if (dir.exists()) {
            dir.delete();
        }
    }

    @Test
    public void loadTasks_fileNotFound_createsFileAndEmptyList() {
        Storage storage = new Storage(TEST_FILE);
        assertTrue(new File(TEST_FILE).exists());
        assertTrue(storage.getTaskArrayList().isEmpty());
    }

    @AfterEach
    public void tearDown() {
        File file = new File(TEST_FILE);
        if (file.exists()) {
            file.delete();
        }
        File dir = file.getParentFile();
        if (dir.exists()) {
            dir.delete();
        }
    }
}
