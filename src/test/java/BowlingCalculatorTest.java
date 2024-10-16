import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlingCalculatorTest {
    BowlingCalculator calc = new BowlingCalculator();

    @Test
    void isStrike() {
        assertTrue(new Frame(10, 0).isStrike());
    }

    @Test
    void isSpare() {
        assertTrue(new Frame(4, 6).isSpare());
    }

    @Test
    void scoreOfFrame() {
        assertEquals(8, new Frame(2, 6).scoreOfFrame(2, 6));
    }

    @Test
    void oneFrame() {
        calc.addRoll(1);
        calc.addRoll(3);
        List<Frame> expected = List.of(new Frame(1, 3));
        assertEquals(expected, calc.frames);
    }

    @Test
    void multipleSetFrames() {
        calc.addRoll(10);
        calc.addRoll(1);
        calc.addRoll(3);
        List<Frame> expected = List.of(new Frame(10, 0), new Frame(1, 3));
        assertEquals(expected, calc.frames);
    }

    @Test
    void oneRoll() {
        calc.addRoll(9);
        assertEquals(9, calc.score());
        assertEquals(9, calc.score()); // TODO: fix bug, liidab juurde (tulemus 18), ilmselt int score = 0; eemaldamisega saab lahendada?
    }

    @Test
    void multipleRolls() {
        calc.addRoll(5);
        calc.addRoll(4);
        calc.addRoll(3);
        assertEquals(12, calc.score());
    }

    @Test
    void oneSpare() {
        calc.addRoll(8);
        calc.addRoll(2);
        calc.addRoll(5);
        assertEquals(20, calc.score());
    }

    @Test
    void multipleSpare() {
        int[] examplePins = {8, 2, 5, 5, 2};

        addRolls(examplePins);
        assertEquals(29, calc.score());
    }

    @Test
    void oneStrike() {
        calc.addRoll(10);
        calc.addRoll(4);
        calc.addRoll(3);
        assertEquals(24, calc.score());
    }

    @Test
    void multipleStrike() {
        addRolls(10, 10, 10, 3, 4);
        assertEquals(77, calc.score());
    }

    @Test
    void regularEnd() {
        addRolls(8, 2, 0, 10, 9, 0, 10, 10, 5, 5, 5, 3, 6, 3, 9, 1, 9, 0);
        assertEquals(143, calc.score());
    }

    @Test
    void spareEnd() {
        addRolls(8, 2, 5, 4, 9, 0, 10, 10, 5, 5, 5, 3, 6, 3, 8, 1, 8, 2, 2);
        assertEquals(131, calc.score());
    }

    @Test
    void oneStrikeEnd() {
        addRolls(8, 2, 5, 4, 9, 0, 10, 10, 5, 5, 5, 3, 6, 3, 8, 1, 10, 2, 3);
        assertEquals(134, calc.score());
    }

    @Test
    void doubleStrikeEnd() {
        addRolls(8, 2, 5, 4, 9, 0, 10, 10, 5, 5, 5, 3, 6, 3, 8, 1, 10, 10, 10);
        assertEquals(149, calc.score());
    }

    @Test
    void fullGame() {
        for (int i = 0; i < 11; i++) {
            calc.addRoll(10);
        }
        assertEquals(300, calc.score());
    }

    private void addRolls(int... examplePins) {
        for (int example : examplePins) {
            calc.addRoll(example);
        }
    }

}