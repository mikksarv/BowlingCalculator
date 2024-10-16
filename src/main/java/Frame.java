import java.util.Objects;

public class Frame {
    int firstRoll;
    int secondRoll;

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


    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

    public Frame() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return firstRoll == frame.firstRoll && secondRoll == frame.secondRoll;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstRoll, secondRoll);
    }

    public boolean isSpare() {
        return firstRoll + secondRoll == 10 && firstRoll != 10;
    }

    public boolean isStrike() {
        return firstRoll == 10;
    }

    public int scoreOfFrame(int firstRoll, int secondRoll) {
        return firstRoll + secondRoll;
    }

//    public boolean isFrameComplete() {
//        return firstRoll == 10 || firstRoll != -1 && secondRoll != -1;
//    }

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
