package menu.domain.validation;

import java.util.Arrays;
import java.util.List;
import menu.view.message.Error;

public class CoachNameValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static void validate(String coachNameInput) {
        List<String> parsedCoachNameInput = splitCoachName(coachNameInput);
        checkNumberOfCoach(parsedCoachNameInput);
        parsedCoachNameInput.forEach(CoachNameValidator::checkCoachNameLength);
    }

    private static void checkCoachNameLength(String coachName) {
        int coachNameLength = coachName.length();
        if (coachNameLength < 2 || coachNameLength > 4) {
            throw new IllegalArgumentException(Error.NAME_LENGTH_OF_COACH.getMessage());
        }
    }

    private static void checkNumberOfCoach(List<String> parsedCoachNameInput) {
        int numberOfCoach = parsedCoachNameInput.size();
        if (numberOfCoach < 2 || numberOfCoach > 5) {
            throw new IllegalArgumentException(Error.NUMBER_OF_COACH.getMessage());
        }
    }

    private static List<String> splitCoachName(String coachNameInput) {
        return Arrays.asList(coachNameInput.split(DELIMITER, SPLIT_LIMIT));
    }
}
