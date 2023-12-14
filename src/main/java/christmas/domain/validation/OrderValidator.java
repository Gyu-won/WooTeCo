package christmas.domain.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.Error;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OrderValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_AND_COUNT_DELIMITER = "-";
    private static final int MENU_INDEX = 0;
    private static final int COUNT_INDEX = 1;
    private static final int INITIAL_INDEX = 0;
    private static final int MAXIMUM_TOTAL_COUNT = 20;
    private static final Integer MINIMUM_TOTAL_COUNT = 1;
    private static final int VALID_ORDER_SIZE = 2;

    public static Map<String, Integer> validateAndReturn(String orderInput) {
        List<String> menus = new ArrayList<>();
        List<String> counts = new ArrayList<>();
        List<String> parsedOrders = splitOrderInput(orderInput);
        for (String order : parsedOrders) {
            List<String> menuAndCount = splitOrder(order);
            checkFormat(menuAndCount);
            menus.add(menuAndCount.get(MENU_INDEX));
            counts.add(menuAndCount.get(COUNT_INDEX));
        }
        validateMenu(menus);
        List<Integer> parsedCounts = validateAndReturnCount(counts);
        return createOrder(menus, parsedCounts);
    }

    private static Map<String, Integer> createOrder(List<String> menus, List<Integer> counts) {
        Map<String, Integer> orders = new HashMap<>();
        for (int index = INITIAL_INDEX; index < menus.size(); index++) {
            orders.put(menus.get(index), counts.get(index));
        }
        return orders;
    }

    private static List<Integer> validateAndReturnCount(List<String> counts) {
        List<Integer> parsedCounts = toInteger(counts);
        checkInvalidCount(parsedCounts);
        checkTotalCount(parsedCounts);
        return parsedCounts;
    }

    private static void checkTotalCount(List<Integer> parsedCounts) {
        int totalCount = parsedCounts.stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (totalCount > MAXIMUM_TOTAL_COUNT) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void checkInvalidCount(List<Integer> parsedCounts) {
        parsedCounts.forEach(OrderValidator::checkSmallerThanMinimumCount);
    }

    private static void checkSmallerThanMinimumCount(Integer count) {
        if (count < MINIMUM_TOTAL_COUNT) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static List<Integer> toInteger(List<String> counts) {
        try {
            List<Integer> parsedCounts = new ArrayList<>();
            for (String count : counts) {
                parsedCounts.add(Integer.parseInt(count));
            }
            return parsedCounts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void validateMenu(List<String> menus) {
        checkDuplicateMenu(menus);
        checkExistInMenu(menus);
        checkOnlyBeverage(menus);
    }

    private static void checkOnlyBeverage(List<String> menus) {
        for (String menuName : menus) {
            if (!Menu.isBeverage(menuName)) {
                return;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
    }

    private static void checkExistInMenu(List<String> menus) {
        for (String menuName : menus) {
            if (!Menu.isContain(menuName)) {
                throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
            }
        }
    }

    private static void checkDuplicateMenu(List<String> menus) {
        Set<String> uniqueMenus = new HashSet<>(menus);
        if (uniqueMenus.size() != menus.size()) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void checkFormat(List<String> menuAndCount) {
        if (menuAndCount.size() != VALID_ORDER_SIZE) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static List<String> splitOrder(String order) {
        return Arrays.asList(order.split(MENU_AND_COUNT_DELIMITER, SPLIT_LIMIT));
    }

    private static List<String> splitOrderInput(String orderInput) {
        return Arrays.asList(orderInput.split(ORDER_DELIMITER, SPLIT_LIMIT));
    }
}
