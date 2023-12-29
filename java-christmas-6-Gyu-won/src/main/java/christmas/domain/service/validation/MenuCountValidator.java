package christmas.domain.service.validation;

import christmas.view.message.ErrorMessage;

public class MenuCountValidator {
    private static final Integer MINIMUM_VALID_COUNT = 1;

    public static Integer validate(String menuCount) {
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