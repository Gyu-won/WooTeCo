package baseball.computer;

import baseball.player.Guess;
import java.util.List;

public class Result {
    private static final int INITIAL_COUNT = 0;
    private static final int START_INDEX = 0;
    private static final int NUMBER_LENGTH = 3;
    private static final int CONTAINED_VALUE = 1;
    private static final int NOT_CONTAINED_VALUE = 0;
    private static final int MATCHED_VALUE = 1;
    private static final int NOT_MATCHED_VALUE = 0;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";

    private final String result;

    public Result(Guess guess, Answer answer) {
        result = generateResult(computeStrikeAndBall(guess, answer), computeStrike(guess, answer));
    }

    private int computeStrikeAndBall(Guess guess, Answer answer) {
        int totalCount = INITIAL_COUNT;
        for (char guessDigit : guess.getGuessAsChars()) {
            totalCount += countIfContained(guessDigit, answer);
        }
        return totalCount;
    }

    private int computeStrike(Guess guess, Answer answer) {
        int strikeCount = INITIAL_COUNT;
        List<Character> guessAsChars = guess.getGuessAsChars();
        List<Character> answerAsChars = answer.getAnswerAsChars();
        for (int i = START_INDEX; i < NUMBER_LENGTH; i++) {
            strikeCount += countIfMatched(guessAsChars.get(i), answerAsChars.get(i));
        }
        return strikeCount;
    }

    private String generateResult(int totalCount, int strikeCount) {
        int ballCount = totalCount - strikeCount;
        if (totalCount == INITIAL_COUNT) {
            return NOTHING;
        }
        if (strikeCount == INITIAL_COUNT) {
            return ballCount + BALL;
        }
        if (ballCount == INITIAL_COUNT) {
            return strikeCount + STRIKE;
        }
        return ballCount + BALL + BLANK + strikeCount + STRIKE;
    }

    private int countIfContained(char guessDigit, Answer answer) {
        List<Character> answerAsChars = answer.getAnswerAsChars();
        if (answerAsChars.contains(guessDigit)) {
            return CONTAINED_VALUE;
        }
        return NOT_CONTAINED_VALUE;
    }

    private int countIfMatched(Character answerAsChar, Character playerInputAsChar) {
        if (playerInputAsChar.equals(answerAsChar)) {
            return MATCHED_VALUE;
        }
        return NOT_MATCHED_VALUE;
    }

    @Override
    public String toString() {
        return result;
    }
}
