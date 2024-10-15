import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {
    //List<Integer> rolls = new ArrayList<>();
    int[][] frames = new int[12][2];
//    frameIndex
    int i = 0;
//    isFirstOrSecondInPair
    int j = 0;

    public int score() {
        int score = 0;



//        for (int i = 0; i < rolls.size(); i++) {
//
//            var currentRoll = rolls.get(i);
//            var lastRoll = 0;
//            if (i > 0) lastRoll = rolls.get(i - 1);
//            var beforeLastRoll = 0;
//            if (i > 1) beforeLastRoll = rolls.get(i - 2);
//            var beforeBeforeLastRoll = 0;
//            if (i > 2) beforeBeforeLastRoll = rolls.get(i - 3);
//
//
//            if (i % 2 == 0 && (lastRoll + beforeLastRoll == 10) || beforeBeforeLastRoll == 10) {
//                currentRoll *= 2;
//            }
//            score += currentRoll;
//        }

        return score;
    }

//    public void roll(int pins) {
//        rolls.add(pins);
//      if (pins == 10) {
//           rolls.add(0);
//        }
//    }

    public void roll(int pins) {

        if (i >= 0 && j == 1) {
            frames[i][j] = pins;
            i++;
            j--;
        } else {
            frames[i][j] = pins;
            j++;
        }
        if (pins == 10) {
            frames[i][j] = 0;
        }
    }
}