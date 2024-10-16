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
            if (pin == 10) {
                isFirstRoll = true;
                frameIndex++;
            }
        } else {
            frames.get(frameIndex).setSecondRoll(pin);
            frameIndex++;
            isFirstRoll = true;
        }
    }

    public int score() {

        for (int i = 0; i < frames.size(); i++) {
            score += frames.get(i).scoreOfFrame(frames.get(i).getFirstRoll(), frames.get(i).getSecondRoll());
            if (frames.get(i).isSpare()) {
                score += frames.get(i + 1).getFirstRoll();
            }
            if (frames.get(i).isStrike()) {
                score += frames.get(i + 1).scoreOfFrame(frames.get(i + 1).getFirstRoll(), frames.get(i + 1).getSecondRoll());
                if (frames.get(i + 1).isStrike()) {
                    score += frames.get(i + 2).getFirstRoll();
                }
            }
        }

        return score;
    }

}