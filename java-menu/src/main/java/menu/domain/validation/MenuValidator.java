package menu.domain.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.entity.Menu;
import menu.view.message.Error;

public class MenuValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String DELIMITER = ",";

    public static List<Menu> validate(String menuInput) {
        List<String> parsedMenuInput = splitMenu(menuInput);
        checkNumberOfMenus(parsedMenuInput);
        checkDuplicateMenu(parsedMenuInput);
        return parsedMenuInput.stream().map(Menu::findByName)
                .collect(Collectors.toList());
    }

    private static void checkDuplicateMenu(List<String> parsedMenuInput) {
        Set<String> uniqueMenuNames = new HashSet<>(parsedMenuInput);
        if (uniqueMenuNames.size() != parsedMenuInput.size()) {
            throw new IllegalArgumentException(Error.DUPLICATE_DISLIKE_MENU.getMessage());
        }
    }

    private static void checkNumberOfMenus(List<String> parsedMenuInput) {
        if (parsedMenuInput.size() > 2) {
            throw new IllegalArgumentException(Error.NUMBER_OF_DISLIKE_MENU.getMessage());
        }
    }

    private static List<String> splitMenu(String menuInput) {
        return Arrays.asList(menuInput.split(DELIMITER, SPLIT_LIMIT));
    }
}
