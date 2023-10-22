package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int INITIAL_COUNT = 0;
    private static final int START_INDEX = 0;
    private static final int VALID_NUMBER_LENGTH = 3;
    private static final int CONTAINED_SCORE = 1;
    private static final int NOT_CONTAINED_SCORE = 0;
    private static final int MATCHED_SCORE = 1;
    private static final int NOT_MATCHED_SCORE = 0;
    private static final int MIN_VALID_DIGIT = 1;
    private static final int MAX_VALID_DIGIT = 9;
    private static final int FIRST_CHARACTER_INDEX = 0;
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String BLANK = " ";
    private final List<Character> answerAsChars = new ArrayList<>();

    public Computer() {
        generateAnswer();
    }

    public void generateAnswer() {
        while (answerAsChars.size() < VALID_NUMBER_LENGTH) {
            generateRandomNumber();
        }
    }

    public String generateResult(String playerInput) {
        List<Character> playerInputAsChars;
        playerInputAsChars = strToCharacterList(playerInput);
        return generateResultString(computeStrikeAndBall(playerInputAsChars), computeStrike(playerInputAsChars));
    }

    private void generateRandomNumber() {
        int randomIntNumber = Randoms.pickNumberInRange(MIN_VALID_DIGIT, MAX_VALID_DIGIT);
        char randomNumber = Integer.toString(randomIntNumber).charAt(FIRST_CHARACTER_INDEX);
        checkDuplicate(randomNumber);
    }

    private void checkDuplicate(char randomNumber) {
        if (!answerAsChars.contains(randomNumber)) {
            answerAsChars.add(randomNumber);
        }
    }

    private int computeStrikeAndBall(List<Character> playerInputAsChars) {
        int totalCount = INITIAL_COUNT;
        for (int i = START_INDEX; i < VALID_NUMBER_LENGTH; i++) {
            totalCount += isNumberContainedAsScore(playerInputAsChars.get(i));
        }
        return totalCount;
    }

    private int computeStrike(List<Character> playerInputAsChars) {
        int strikeCount = INITIAL_COUNT;
        for (int i = START_INDEX; i < VALID_NUMBER_LENGTH; i++) {
            strikeCount += isNumberMatchedAsScore(answerAsChars.get(i), playerInputAsChars.get(i));
        }
        return strikeCount;
    }

    private String generateResultString(int totalCount, int strikeCount) {
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

    private int isNumberContainedAsScore(Character playerInputAsChar) {
        if (answerAsChars.contains(playerInputAsChar)) {
            return CONTAINED_SCORE;
        }
        return NOT_CONTAINED_SCORE;
    }

    private int isNumberMatchedAsScore(Character answerAsChar, Character playerInputAsChar) {
        if (playerInputAsChar.equals(answerAsChar)) {
            return MATCHED_SCORE;
        }
        return NOT_MATCHED_SCORE;
    }

    private List<Character> strToCharacterList(String string) {
        List<Character> characterList = new ArrayList<>();
        for (char character : string.toCharArray()) {
            characterList.add(character);
        }
        return characterList;
    }
}
