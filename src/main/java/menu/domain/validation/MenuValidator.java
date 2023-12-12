package menu.domain.validation;

import java.util.Arrays;
import java.util.List;

public class MenuValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static void validate(String menuInput) {
        List<String> parsedMenuInput = splitMenu(menuInput);
    }

    private static List<String> splitMenu(String menuInput) {
        return Arrays.asList(menuInput.split(DELIMITER, SPLIT_LIMIT));
    }
}
