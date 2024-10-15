import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BowlingCalculatorTest {

    @Test
    void bowlingScoreCalculator_isScoreCorrect() {
        List<String> example = new ArrayList<>(Arrays.asList("8"));
        assertEquals(8, BowlingCalculator.bowlingScoreCalculator(example));
    }
}