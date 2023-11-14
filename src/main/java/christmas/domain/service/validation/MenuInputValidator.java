package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.ErrorMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuInputValidator {
    private static final Integer MENU = 0;
    private static final Integer COUNT = 1;
    private static final Integer SPLIT_LIMIT = -1;
    private static final Integer MINIMUM_VALID_COUNT = 1;
    private static final Integer VALIDATE_INPUT_SIZE = 2;
    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_COUNT_DELIMITER = "-";

    public static Map<Menu, Integer> validate(String orders) {
        Map<Menu, Integer> orderMenus = new HashMap<>();
        for (String order : splitOrder(orders)) {
            List<String> menuAndCount = validateInputType(splitMenuAndCount(order));
            orderMenus.put(validateMenu(menuAndCount.get(MENU), orderMenus), validateCount(menuAndCount.get(COUNT)));
        }
        return orderMenus;
    }

    private static List<String> splitOrder(String menusInput) {
        return Arrays.asList(menusInput.split(ORDER_DELIMITER, SPLIT_LIMIT));
    }

    private static List<String> splitMenuAndCount(String menuInput) {
        return Arrays.asList(menuInput.split(MENU_COUNT_DELIMITER, SPLIT_LIMIT));
    }

    private static List<String> validateInputType(List<String> menuAndCount) {
        if (menuAndCount.size() != VALIDATE_INPUT_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        return menuAndCount;
    }

    private static Menu validateMenu(String menuName, Map<Menu, Integer> orderMenus) {
        return checkDuplicate(toMenu(menuName), orderMenus);
    }

    private static Menu toMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.isSame(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
    }

    private static Menu checkDuplicate(Menu menu, Map<Menu, Integer> orderMenus) {
        if (orderMenus.containsKey(menu)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        return menu;
    }

    private static Integer validateCount(String menuCount) {
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
