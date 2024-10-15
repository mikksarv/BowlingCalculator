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
    @Test
    void oneStrike() {
        calc.roll(10);
        calc.roll(4);
        calc.roll(3);
        assertEquals(24, calc.score());
    }

    @Test
    void multipleStrike() {
        calc.roll(10);
        calc.roll(10);
        calc.roll(3);
        calc.roll(4);
        assertEquals(44, calc.score());
    }

    @Test
    void regularEnd() {
        calc.roll(8);
        calc.roll(2);

        calc.roll(5);
        calc.roll(4);

        calc.roll(9);
        calc.roll(0);

        calc.roll(10);

        calc.roll(10);

        calc.roll(5);
        calc.roll(5);

        calc.roll(5);
        calc.roll(3);

        calc.roll(6);
        calc.roll(3);

        calc.roll(9);
        calc.roll(1);

        calc.roll(9);
        calc.roll(0);
        assertEquals(138 , calc.score());
    }
}