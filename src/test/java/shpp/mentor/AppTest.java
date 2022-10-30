package shpp.mentor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends App {

    @Test
    void testMain() {
        String actual=multNumber("25;255;2",Integer.MAX_VALUE);
        String expected="Procedure successful";
        Assertions.assertEquals(expected, actual);
        String actual1=multNumber("25.45;255.87;2.4",Float.MAX_VALUE);
        String expected1="Procedure successful";
        Assertions.assertEquals(expected1, actual1);
    }
}
