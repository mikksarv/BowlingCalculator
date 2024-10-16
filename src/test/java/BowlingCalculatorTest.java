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
        calc.setFrames(1);
        calc.setFrames(3);
        List<Frame> expected = List.of(new Frame(1, 3));
        assertEquals(expected, calc.frames);
    }

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
        int [] examplePins = {8,2,5,5,2};

        for (int example : examplePins){
            calc.setFrames(example);
        }
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
        int [] examplePins = {10,10,10,3,4};

        for (int example : examplePins){
            calc.setFrames(example);
        }
        assertEquals(77, calc.score());
    }

    @Test
    void regularEnd() {

        int [] examplePins = {8,2,0,10,9,0,10,10,5,5,5,3,6,3,9,1,9,0};

        for (int example : examplePins){
            calc.setFrames(example);
        }
        assertEquals(143 , calc.score());
    }

    @Test
    void spareEnd() {

        int [] examplePins = {8,2,5,4,9,0,10,10,5,5,5,3,6,3,8,1,8,2,2};

        for (int example : examplePins){
            calc.setFrames(example);
        }
        assertEquals(131 , calc.score());
    }

    @Test
    void oneStrikeEnd() {

        int [] examplePins = {8,2,5,4,9,0,10,10,5,5,5,3,6,3,8,1,10,2,3};

        for (int example : examplePins){
            calc.setFrames(example);
        }
        assertEquals(134 , calc.score());
    }

    @Test
    void doubleStrikeEnd() {

        int [] examplePins = {8,2,5,4,9,0,10,10,5,5,5,3,6,3,8,1,10,10,10};

        for (int example : examplePins){
            calc.setFrames(example);
        }
        assertEquals(149 , calc.score());
    }
}