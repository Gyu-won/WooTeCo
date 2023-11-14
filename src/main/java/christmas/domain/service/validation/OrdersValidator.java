package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.ErrorMessage;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class OrdersValidator {
    private static final Integer MAX_ORDER_COUNT = 20;

    public static Map<Menu, Integer> validate(String ordersInput) {
        Map<Menu, Integer> orders = OrderValidator.validate(ordersInput);
        checkIfAllMenuItemsAreDrinks(orders.keySet());
        checkTotalMenuCount(orders.values());
        return orders;
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
