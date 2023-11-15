package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.ErrorMessage;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrdersValidator {
    private static final Integer MAX_ORDER_COUNT = 20;
    private static final Integer MENU = 0;
    private static final Integer COUNT = 1;
    private static final Integer SPLIT_LIMIT = -1;
    private static final Integer VALIDATE_INPUT_SIZE = 2;
    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_COUNT_DELIMITER = "-";

    public static Map<Menu, Integer> validate(String ordersInput) {
        Map<Menu, Integer> orders = validateEachOrder(ordersInput);
        checkIfAllMenuItemsAreDrinks(orders.keySet());
        checkTotalMenuCount(orders.values());
        return orders;
    }

    private static Map<Menu, Integer> validateEachOrder(String ordersInput) {
        Map<Menu, Integer> orderMenus = new HashMap<>();
        for (String order : splitOrder(ordersInput)) {
            List<String> menuAndCount = validateInputType(splitMenuAndCount(order));
            Menu validMenu = checkDuplicate(OrderValidator.validateMenu(menuAndCount.get(MENU)), orderMenus);
            orderMenus.put(validMenu, OrderValidator.validateCount(menuAndCount.get(COUNT)));
        }
        return orderMenus;
    }

    private static Menu checkDuplicate(Menu menu, Map<Menu, Integer> orderMenus) {
        if (orderMenus.containsKey(menu)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
        return menu;
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

    private static void checkIfAllMenuItemsAreDrinks(Set<Menu> orderMenus) {
        if (orderMenus.stream().allMatch(Menu::isDrink)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static void checkTotalMenuCount(Collection<Integer> values) {
        if (calculateTotalMenuCount(values) > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
        }
    }

    private static Integer calculateTotalMenuCount(Collection<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).sum();
    }
}
