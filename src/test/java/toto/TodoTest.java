package toto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

// Use of CoPilot to generate unit tests for Todo class

public class TodoTest {
    @Test
    public void markChecked_setsCheckedTrue_isTrue() {
        Todo t = new Todo("read book");
        t.markChecked();
        assertTrue(t.isChecked());
    }

    @Test
    public void toString_taskNotDone_correctFormat() {
        Todo t = new Todo("meet friend");
        assertEquals("[T][ ] meet friend", t.toString());
    }

    @Test
    public void isOnDate_notChecked_returnsTrue() {
        Todo t = new Todo("task");
        assertTrue(t.isOnDate(LocalDate.now()));
    }

    @Test
    public void isOnDate_checked_returnsFalse() {
        Todo t = new Todo("task");
        t.markChecked();
        assertFalse(t.isOnDate(LocalDate.now()));
    }
}
