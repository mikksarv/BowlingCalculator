import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingCalculatorTest {
    BowlingCalculator calc = new BowlingCalculator();

    @Test
    void oneRoll() {
        calc.roll(8);
        assertEquals(8, calc.score());
    }

    @Test
    void multipleRolls() {
        calc.roll(8);
        calc.roll(1);
        calc.roll(3);
        assertEquals(12, calc.score());
    }

    @Test
    void oneSpare() {
        calc.roll(8);
        calc.roll(2);
        calc.roll(5);
        assertEquals(20, calc.score());
    }
    @Test
    void multipleSpare() {
        calc.roll(8);
        calc.roll(2);
        calc.roll(5);
        calc.roll(5);
        calc.roll(2);
        assertEquals(29, calc.score());
    }
}