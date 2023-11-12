package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.ErrorMessage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuInputValidator {

    private static final int VALIDATE_INPUT_SIZE = 2;
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;

    public static Map<Menu, Integer> validate(String menusInput) {
        Map<Menu, Integer> orderMenus = new HashMap<>();
        for (String menuInput : splitMenusInput(menusInput)) {
            List<String> menuAndCount = splitMenuAndCount(menuInput);
            validateInputType(menuAndCount);
            Menu menu = checkDuplicate(findMenu(menuAndCount.get(MENU_INDEX)), orderMenus);
            Integer count = findCount(menuAndCount.get(COUNT_INDEX));
            orderMenus.put(menu, count);
        }
        return orderMenus;
    }

    private static Menu checkDuplicate(Menu menu, Map<Menu, Integer> orderMenus) {
        if (orderMenus.containsKey(menu)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        return menu;
    }

    private static List<String> splitMenusInput(String menusInput) {
        return Arrays.asList(menusInput.split(",", -1));
    }

    private static List<String> splitMenuAndCount(String menuInput) {
        return Arrays.asList(menuInput.split("-", -1));
    }

    private static Menu findMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.isSame(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
    }

    private static Integer findCount(String menuCount) {
        Integer parsedMenuCount = toInt(menuCount);
        if (isValidCount(parsedMenuCount)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        return parsedMenuCount;
    }

    private static Integer toInt(String menuCount) {
        try {
            return Integer.parseInt(menuCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static boolean isValidCount(Integer parsedMenuCount) {
        return parsedMenuCount < 1;
    }

    private static void validateInputType(List<String> menuAndCount) {
        if (menuAndCount.size() != VALIDATE_INPUT_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }
}
