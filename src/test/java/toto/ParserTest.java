package toto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

// Use of CoPilot to generate unit tests for Parser class

public class ParserTest {
    @Test
    public void parseList_valid_noException() {
        String[] command = {"list"};
        assertDoesNotThrow(() -> new Parser().parseList(command));
    }

    @Test
    public void parseList_invalidExtraArg_throws() {
        String[] command = {"list", "extra"};
        assertThrows(TotoException.class, () -> new Parser().parseList(command));
    }

    @Test
    public void parseMark_validIndex_noException() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Todo("task"));
        String[] command = {"mark", "1"};
        assertDoesNotThrow(() -> new Parser().parseMark(command, tasks));
    }

    @Test
    public void parseMark_invalidIndex_throws() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"mark", "2"};
        assertThrows(TotoException.class, () -> new Parser().parseMark(command, tasks));
    }

    @Test
    public void parseDelete_validIndex_noException() {
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Todo("task"));
        String[] command = {"delete", "1"};
        assertDoesNotThrow(() -> new Parser().parseDelete(command, tasks));
    }

    @Test
    public void parseDelete_invalidIndex_throws() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"delete", "0"};
        assertThrows(TotoException.class, () -> new Parser().parseDelete(command, tasks));
    }

    @Test
    public void parseTodo_valid_noException() {
        String[] command = {"todo", "read book"};
        assertDoesNotThrow(() -> new Parser().parseTodo(command));
    }

    @Test
    public void parseTodo_missingDesc_throws() {
        String[] command = {"todo"};
        assertThrows(TotoException.class, () -> new Parser().parseTodo(command));
    }

    @Test
    public void parseEvent_valid_noException() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"event", "meeting /from 2024/6/1 1200 /to 2024/6/1 1300"};
        assertDoesNotThrow(() -> new Parser().parseEvent(command, tasks));
    }

    @Test
    public void parseEvent_invalidFormat_throws() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"event", "meeting /from 2024/6/1 /to 2024/6/1"};
        assertThrows(TotoException.class, () -> new Parser().parseEvent(command, tasks));
    }

    @Test
    public void parseDeadline_valid_noException() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"deadline", "submit report /by 2024/6/1"};
        assertDoesNotThrow(() -> new Parser().parseDeadline(command, tasks));
    }

    @Test
    public void parseDeadline_invalidFormat_throws() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"deadline", "submit report /by 2024-06-01"};
        assertThrows(TotoException.class, () -> new Parser().parseDeadline(command, tasks));
    }

    @Test
    public void parseFind_valid_noException() {
        String[] command = {"find", "book"};
        assertDoesNotThrow(() -> new Parser().parseFind(command));
    }

    @Test
    public void parseFind_missingKeyword_throws() {
        String[] command = {"find"};
        assertThrows(TotoException.class, () -> new Parser().parseFind(command));
    }

    @Test
    public void parseViewSchedule_valid_noException() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"view", "2024/6/1"};
        assertDoesNotThrow(() -> new Parser().parseViewSchedule(command, tasks));
    }

    @Test
    public void parseViewSchedule_invalidFormat_throws() {
        ArrayList<Task> tasks = new ArrayList<>();
        String[] command = {"view", "01-06-2024"};
        assertThrows(TotoException.class, () -> new Parser().parseViewSchedule(command, tasks));
    }
}
