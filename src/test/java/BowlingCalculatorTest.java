import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingCalculatorTest {
    BowlingCalculator calc = new BowlingCalculator();

    @Test
    void multipleSetFrames() {
        calc.setFrames(10);
        calc.setFrames(1);
        calc.setFrames(3);
        List<Frame> expected = List.of(new Frame(10, 0), new Frame(1, 3));
        assertEquals(expected, calc.frames);
    }

    @Test
    void oneRoll() {
        calc.setFrames(9);
        assertEquals(9, calc.score());
    }

    @Test
    void multipleRolls() {
        calc.setFrames(5);
        calc.setFrames(4);
        calc.setFrames(3);
        assertEquals(12, calc.score());
    }

    @Test
    void oneSpare() {
        calc.setFrames(8);
        calc.setFrames(2);
        calc.setFrames(5);
        assertEquals(20, calc.score());
    }

    @Test
    void multipleSpare() {
        calc.setFrames(8);
        calc.setFrames(2);
        calc.setFrames(5);
        calc.setFrames(5);
        calc.setFrames(2);
        assertEquals(29, calc.score());
    }

    @Test
    void oneStrike() {
        calc.setFrames(10);
        calc.setFrames(4);
        calc.setFrames(3);
        assertEquals(24, calc.score());
    }

    @Test
    void multipleStrike() {
        calc.setFrames(10);
        calc.setFrames(10);
        calc.setFrames(3);
        calc.setFrames(4);
        assertEquals(47, calc.score());
    }

    @Test
    void regularEnd() {
        calc.setFrames(8);
        calc.setFrames(2);

        calc.setFrames(5);
        calc.setFrames(4);

        calc.setFrames(9);
        calc.setFrames(0);

        calc.setFrames(10);

        calc.setFrames(10);

        calc.setFrames(5);
        calc.setFrames(5);

        calc.setFrames(5);
        calc.setFrames(3);

        calc.setFrames(6);
        calc.setFrames(3);

        calc.setFrames(9);
        calc.setFrames(1);

        calc.setFrames(9);
        calc.setFrames(0);
        assertEquals(138 , calc.score());
    }

    @Test
    void spareEnd() {
        calc.setFrames(8);
        calc.setFrames(2);

        calc.setFrames(5);
        calc.setFrames(4);

        calc.setFrames(9);
        calc.setFrames(0);

        calc.setFrames(10);

        calc.setFrames(10);

        calc.setFrames(5);
        calc.setFrames(5);

        calc.setFrames(5);
        calc.setFrames(3);

        calc.setFrames(6);
        calc.setFrames(3);

        calc.setFrames(8);
        calc.setFrames(1);

        calc.setFrames(8);
        calc.setFrames(2);

        calc.setFrames(2);
        assertEquals(131 , calc.score());
    }

    @Test
    void oneStrikeEnd() {
        calc.setFrames(8);
        calc.setFrames(2);

        calc.setFrames(5);
        calc.setFrames(4);

        calc.setFrames(9);
        calc.setFrames(0);

        calc.setFrames(10);

        calc.setFrames(10);

        calc.setFrames(5);
        calc.setFrames(5);

        calc.setFrames(5);
        calc.setFrames(3);

        calc.setFrames(6);
        calc.setFrames(3);

        calc.setFrames(8);
        calc.setFrames(1);

        calc.setFrames(10);

        calc.setFrames(2);
        calc.setFrames(3);
        assertEquals(134 , calc.score());
    }

    @Test
    void doubleStrikeEnd() {
        calc.setFrames(8);
        calc.setFrames(2);

        calc.setFrames(5);
        calc.setFrames(4);

        calc.setFrames(9);
        calc.setFrames(0);

        calc.setFrames(10);

        calc.setFrames(10);

        calc.setFrames(5);
        calc.setFrames(5);

        calc.setFrames(5);
        calc.setFrames(3);

        calc.setFrames(6);
        calc.setFrames(3);

        calc.setFrames(8);
        calc.setFrames(1);

        calc.setFrames(10);

        calc.setFrames(10);

        calc.setFrames(10);
        assertEquals(149 , calc.score());
    }
}