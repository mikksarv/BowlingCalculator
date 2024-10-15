import java.util.ArrayList;
import java.util.List;

public class Frame {
    int firstRoll;
    int secondRoll;
    boolean isStrike;
    boolean isSpare;

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    public int sumOfFrame(int firstRoll, int secondRoll) {
        return firstRoll + secondRoll;
    }

    //List<Integer> rolls = new ArrayList<>();
//    int[][] frames = new int[12][2];
//    //    frameIndex
//    int row = 0;
//    //    isFirstOrSecondInPair
//    int col = 0;
//    boolean strike;
//    boolean spare;
//
//
//    public void roll(int pins) {
//
//        if (row >= 0 && col == 1) {
//            frames[row][col] = pins;
//            row++;
//            col--;
//        } else {
//            frames[row][col] = pins;
//            col++;
//        }
//        if (pins == 10) {
//            frames[row][col] = 0;
//            strike = true;
//        }
//    }
}
