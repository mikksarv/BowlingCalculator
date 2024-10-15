import java.util.ArrayList;
import java.util.List;

public class BowlingCalculator {

    Frame frame = new Frame();
    List<Frame> frames = new ArrayList<>();
    int score = 0;

    public void setFrames(int pin) {
        if (frame.getFirstRoll() == 0) {
            frame.setFirstRoll(pin);
        } else {
            frame.setSecondRoll(pin);
        }

        if (frame.sumOfFrame(frame.getFirstRoll(), frame.getSecondRoll()) == 10 && frame.getFirstRoll() != 10) {
            frame.setSpare(true);
        }
        if (pin == 10) {
            frame.setStrike(true);
        }
//        todo: frames array lisamisega probleem ilmselt
        frames.add(frame);
    }

    public int score() {

        for (int i = 0; i < frames.size(); i++) {

            score += frame.getFirstRoll() + frame.getSecondRoll();

            if (frame.isStrike() && i<frames.size() - 2) {
                score += frames.get(i + 1).sumOfFrame(frame.getFirstRoll(), frame.getSecondRoll());

                if (frames.get(i + 1).isStrike()) {
                    score += frames.get(i + 2).sumOfFrame(frame.getFirstRoll(), frame.getSecondRoll());
                }
            }
            if (frame.isSpare() && i<frames.size() - 1) {
                score += frames.get(i + 1).getFirstRoll();
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