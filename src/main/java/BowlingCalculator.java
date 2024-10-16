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

//        frame katte saada, summa saaks katte ja lisaks skoorile
//        Strike loogika ja spare loogika
//        frameIndex jargi boonusringi loomine

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


//        if (frame.strike) {
//            score += 10;
//        } else if (frame.spare) {
//        } else {
//        }
//        for (int i = 0; i < pframes[row].length; i++) {
//            //
//            for (int j = 0; j < frames[col].length; j++) {
//                score += frames[i][j];
//            }
//            --col;
//        }

//        for (int i = 0; i < rolls.size(); i++) {
//            var currentRoll = rolls.get(i);
//            var lastRoll = 0;
//            if (i > 0) lastRoll = rolls.get(i - 1);
//            var beforeLastRoll = 0;
//            if (i > 1) beforeLastRoll = rolls.get(i - 2);
//            var beforeBeforeLastRoll = 0;
//            if (i > 2) beforeBeforeLastRoll = rolls.get(i - 3);
//
//            if (i % 2 == 0 && (lastRoll + beforeLastRoll == 10) || beforeBeforeLastRoll == 10) {
//                currentRoll *= 2;
//            }
//            score += currentRoll;
//        }
}