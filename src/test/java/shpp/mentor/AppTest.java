package shpp.mentor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends App {

    @Test
    void testMain() {
        String actual = multNumber("25;31;3", Integer.MAX_VALUE);
        String expected = "Procedure successful";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testMain1() {
        String actual=multNumber("25.45;30.87;2.4",Float.MAX_VALUE);
        String expected="Procedure successful";
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testMaxValueSet1() {
        double actual = maxValueSet("byte");
        double expected=Byte.MAX_VALUE;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testMaxValueSet4() {
        double actual = maxValueSet("float");
        double expected=Float.MAX_VALUE;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testMaxValueSet3() {
        double actual = maxValueSet("short");
        double expected=Short.MAX_VALUE;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testMaxValueSet2() {
        double actual = maxValueSet("long");
        double expected=Long.MAX_VALUE;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void testMaxValueSet() {
        double actual = maxValueSet("double");
        double expected=Double.MAX_VALUE;
        Assertions.assertEquals(expected, actual);
    }

}
