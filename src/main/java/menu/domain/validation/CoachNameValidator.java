package menu.domain.validation;

import java.util.Arrays;
import java.util.List;

public class CoachNameValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static void validate(String coachNameInput) {
        List<String> parsedCoachNameInput = splitCoachName(coachNameInput);
        
    }

    private static List<String> splitCoachName(String coachNameInput) {
        return Arrays.asList(coachNameInput.split(DELIMITER, SPLIT_LIMIT));
    }
}
