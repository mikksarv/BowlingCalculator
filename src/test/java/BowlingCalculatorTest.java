import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BowlingCalculatorTest {
    BowlingCalculator calc = new BowlingCalculator();

    @Test
    void oneRoll() {
        calc.setFrames(8);
        calc.setFrames(1);
        calc.setFrames(3);
//        assertEquals(9, calc.score());
    }

    @Test
    void multipleRolls() {
        calc.setFrames(8);
        calc.setFrames(1);
        calc.setFrames(3);
        List<Frame> expected = List.of(new Frame(8, 1), new Frame(3, 0));
        assertEquals(expected, calc.frames);
    }

    @Test
    void oneSpare() {
        calc.setFrames(8);
        calc.setFrames(2);
        calc.setFrames(5);
//        assertEquals(20, calc.score());
    }
    @Test
    void multipleSpare() {
        calc.setFrames(8);
        calc.setFrames(2);
        calc.setFrames(5);
        calc.setFrames(5);
        calc.setFrames(2);
//        assertEquals(29, calc.score());
    }
    @Test
    void oneStrike() {
        calc.setFrames(10);
        calc.setFrames(4);
        calc.setFrames(3);
//        assertEquals(24, calc.score());
    }

    @Test
    void multipleStrike() {
        calc.setFrames(10);
        calc.setFrames(10);
        calc.setFrames(3);
        calc.setFrames(4);
//        assertEquals(47, calc.score());
    }

//    @Test
//    void regularEnd() {
//        calc.roll(8);
//        calc.roll(2);
//
//        calc.roll(5);
//        calc.roll(4);
//
//        calc.roll(9);
//        calc.roll(0);
//
//        calc.roll(10);
//
//        calc.roll(10);
//
//        calc.roll(5);
//        calc.roll(5);
//
//        calc.roll(5);
//        calc.roll(3);
//
//        calc.roll(6);
//        calc.roll(3);
//
//        calc.roll(9);
//        calc.roll(1);
//
//        calc.roll(9);
//        calc.roll(0);
//        assertEquals(138 , calc.score());
//    }
}