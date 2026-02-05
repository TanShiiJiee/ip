package toto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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
}
