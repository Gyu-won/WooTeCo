package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.Error;
import java.util.Map;

public class OrderValidator {
    public static void validate(String menusInput) {
        Map<Menu, Integer> orderMenus = MenuInputValidator.validate(menusInput);
        validateAllDrinks(orderMenus);
    }

    public static void validateAllDrinks(Map<Menu, Integer> orderMenus) {
        for (Menu menu : orderMenus.keySet()) {
            if (!menu.isDrinkCategory()) {
                return;
            }
        }
        throw new IllegalArgumentException(Error.INVALID_ORDER.getMessage());
    }
}
