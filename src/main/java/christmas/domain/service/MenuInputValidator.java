package christmas.domain.service;

import christmas.domain.entity.Menu;
import christmas.view.Error;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuInputValidator {

    public static Map<Menu, Integer> validate(String menusInput) {
        Map<Menu, Integer> orderMenus = new HashMap<>();
        for (String menuInput : splitMenusInput(menusInput)) {
            List<String> menuAndCount = splitMenuAndCount(menuInput);
            checkInputTypeValidation(menuAndCount);
            Menu menu = findMenu(menuAndCount.get(0));
            Integer count = findCount(menuAndCount.get(1));
            orderMenus.put(menu, count);
        }
        return orderMenus;
    }

    private static List<String> splitMenusInput(String menusInput) {
        return Arrays.asList(menusInput.split(",", -1));
    }

    private static List<String> splitMenuAndCount(String menuInput) {
        return Arrays.asList(menuInput.split("-", -1));
    }

    private static void checkInputTypeValidation(List<String> menuAndCount) {
        if (menuAndCount.size() != 2) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static Menu findMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.isSame(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
    }

    private static Integer findCount(String menuCount) {
        Integer parsedMenuCount = toInt(menuCount);
        if (isValidCount(parsedMenuCount)) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
        return parsedMenuCount;
    }

    private static Integer toInt(String menuCount) {
        try {
            return Integer.parseInt(menuCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static boolean isValidCount(Integer parsedMenuCount) {
        return parsedMenuCount < 1;
    }
}
