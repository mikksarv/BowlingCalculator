import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BowlingCalculator {
    public static void main(String[] args) {

//        List <String> roll = new ArrayList<>(Arrays.asList("8","/","5","4","9","-","x","-","x","-","5","/","5","3","6","3","9","/","9","/","x"));
        List <String> roll = new ArrayList<>(Arrays.asList("8"));
        int score = bowlingScoreCalculator(roll);


    }

    public static int bowlingScoreCalculator(List<String> roll) {
        int score = 0;

        for (int i = 0; i < roll.size(); i++){
            score += Integer.valueOf(roll.get(i));
        }
        return score;
    }
}