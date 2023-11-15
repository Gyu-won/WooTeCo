package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.ErrorMessage;

public class OrderValidator {
    private static final Integer MINIMUM_VALID_COUNT = 1;

    public static Menu validateMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.isSameName(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
    }

    public static Integer validateCount(String menuCount) {
        Integer parsedIntCount = toInt(menuCount);
        if (isInValidCount(parsedIntCount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        return parsedIntCount;
    }

    private static Integer toInt(String menuCount) {
        try {
            return Integer.parseInt(menuCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean isInValidCount(Integer parsedMenuCount) {
        return parsedMenuCount < MINIMUM_VALID_COUNT;
    }
}
