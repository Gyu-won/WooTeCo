package christmas.domain.service;

import christmas.domain.entity.Menu;
import christmas.view.Error;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Order {

    public static void validate(String menusInput) {
        List<String> menuInputs = splitMenusInput(menusInput);
        for (String menuInput : menuInputs) {
            List<String> menuAndCount = splitMenuAndCount(menuInput);
            checkInputTypeValidation(menuAndCount);
            Menu menu = findMenu(menuAndCount.get(0));
            Integer count = findCount(menuAndCount.get(1));
        }
    }

    public static Integer calculateTotalPrice(Map<Menu, Integer> orderMenus) {
        return orderMenus.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
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
        return 0;
    }
}
