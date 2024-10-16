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
                if (frameIndex == 11) {
                    //frameIndex = 0;
                    return;
                }
                frameIndex++;
            }
        } else {
            frames.get(frameIndex).setSecondRoll(pin);
            isFirstRoll = true;
            if (frameIndex == 9 && !frames.get(frameIndex).isStrike() && !frames.get(frameIndex).isSpare()
                    || frameIndex == 10 && frames.get(frameIndex - 1).isSpare()
                    || frameIndex == 10 && frames.get(frameIndex - 1).isStrike()) {
                frameIndex = 0;
                return;
            }
            frameIndex++;
        }
    }

    public int score() {

        for (int i = 0; i < frames.size(); i++) {

            var frame = frames.get(i);

            score += frame.scoreOfFrame(frame.getFirstRoll(), frame.getSecondRoll());

            if (i == frames.size() - 1) {  return score; }

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