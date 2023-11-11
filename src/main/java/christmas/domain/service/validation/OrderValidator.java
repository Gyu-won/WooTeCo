package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import java.util.Map;

public class OrderValidator {
    public static void validate(String menusInput) {
        Map<Menu, Integer> orderMenus = MenuInputValidator.validate(menusInput);
    }

}
