package shpp.mentor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultyTest  {

    @Test
    void multyLong() {
        long actual = Multy.MultyLong(25,25);
        long expected = 625;
        assertEquals(actual,expected);
    }

    @Test
    void multyDouble() {
        double actual = Multy.MultyDouble(2.5,2.5);
        double expected = 6.25;
        assertEquals(actual,expected);
    }
}