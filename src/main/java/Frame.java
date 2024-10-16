import java.util.Objects;

public class Frame {
    int firstRoll;
    int secondRoll;

    public Frame() {
    }

    public Frame(int firstRoll, int secondRoll) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
    }

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

    public int scoreOfFrame(int firstRoll, int secondRoll) {
        return firstRoll + secondRoll;
    }

    public boolean isSpare() {
        return firstRoll + secondRoll == 10 && firstRoll != 10;
    }

    public boolean isStrike() {
        return firstRoll == 10;
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

}
