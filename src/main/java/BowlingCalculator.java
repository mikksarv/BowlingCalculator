import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {

    List<Frame> frames = new ArrayList<>();
    boolean isFirstRoll = true;
    int score = 0;
    int frameIndex = 0;

    public void setFrames(int pin) {
        if (isFirstRoll) {
            Frame frame = new Frame();
            isFirstRoll = false;
            frame.setFirstRoll(pin);
            frames.add(frame);

            if (frame.isStrike()) {
                isFirstRoll = true;
                frameIndex++;
            }
        } else {
            frames.get(frameIndex).setSecondRoll(pin);
            isFirstRoll = true;
            frameIndex++;
        }
    }

    public int score() {

        for (int i = 0; i <= 9; i++) {

            var frame = frames.get(i);

            score += frame.scoreOfFrame(frame.getFirstRoll(), frame.getSecondRoll());

            if (i == frames.size() - 1) {return score;}
            var nextFrame = frames.get(i + 1);

            if (frame.isSpare()) {
                score += nextFrame.getFirstRoll();
            }
            if (frame.isStrike()) {
                score += nextFrame.scoreOfFrame(nextFrame.getFirstRoll(), nextFrame.getSecondRoll());
                if (nextFrame.isStrike()) {
                    score += frames.get(i + 2).getFirstRoll();
                }
            }
        }
        return score;
    }
}