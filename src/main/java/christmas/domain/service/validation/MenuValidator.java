package christmas.domain.service.validation;

import christmas.domain.entity.Menu;
import christmas.view.message.ErrorMessage;

public class MenuValidator {
    public static Menu validate(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.isSameName(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_ORDER.getMessage());
    }
}
