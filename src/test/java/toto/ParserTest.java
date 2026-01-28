package toto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    @Test
    public void parseList_validArguments_doesNotThrow() {
        String[] command = {"list"};
        try {
            new Parser().parseList(command);
        } catch (TotoException e) {
            throw new AssertionError("Test failed");
        }
    }

    @Test
    public void parseList_invalidCommand_doesNotThrow() {
        String[] command = {"list", "abc"};
        assertThrows(TotoException.class, () -> new Parser().parseList(command));
    }
}
