package christmas.domain.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.Error;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_AND_COUNT_DELIMITER = "-";

    public static void validateAndReturn(String orderInput) {
        List<String> menus = new ArrayList<>();
        List<String> counts = new ArrayList<>();
        List<String> parsedOrders = splitOrderInput(orderInput);
        for (String order : parsedOrders) {
            List<String> menuAndCount = splitOrder(order);
            checkFormat(menuAndCount);
            menus.add(menuAndCount.get(0));
            counts.add(menuAndCount.get(1));
        }
        validateMenu(menus);
        List<Integer> parsedCounts = validateAndReturnCount(counts);
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
        if (totalCount > 20) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static void checkInvalidCount(List<Integer> parsedCounts) {
        parsedCounts.forEach(OrderValidator::checkSmallerThanMinimumCount);
    }

    private static void checkSmallerThanMinimumCount(Integer count) {
        if (count < 1) {
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
        if (menuAndCount.size() != 2) {
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
