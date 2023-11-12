package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.Error;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class OrderValidator {
    private static final Integer MAX_ORDER_COUNT = 20;

    public static Map<Menu, Integer> validate(String menusInput) {
        Map<Menu, Integer> orderMenus = MenuInputValidator.validate(menusInput);
        validateAllDrinks(orderMenus.keySet());
        validateMenuCount(orderMenus.values());
        return orderMenus;
    }

    private static void validateMenuCount(Collection<Integer> values) {
        if (calculateMenuCount(values) > MAX_ORDER_COUNT) {
            throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
        }
    }

    private static Integer calculateMenuCount(Collection<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).sum();
    }

    private static void validateAllDrinks(Set<Menu> orderMenus) {
        for (Menu menu : orderMenus) {
            if (!menu.isDrinkCategory()) {
                return;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
    }
}
