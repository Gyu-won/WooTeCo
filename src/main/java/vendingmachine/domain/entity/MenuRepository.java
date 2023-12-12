package vendingmachine.domain.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vendingmachine.view.message.Error;

public class MenuRepository {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String MENU_DELIMITER = ";";

    private static final List<Menu> menus = new ArrayList<>();

    public static void create(String menusInput) {
        List<String> parsedMenus = splitMenus(menusInput);
        for (String menu : parsedMenus) {
            menus.add(new Menu(removeBrackets(menu)));
        }
    }

    private static String removeBrackets(String menu) {
        return menu.replace("[", "").replace("]", "");
    }

    private static List<String> splitMenus(String menusInput) {
        return Arrays.asList(menusInput.split(MENU_DELIMITER, SPLIT_LIMIT));
    }

    public static void buy(String menuNameToBuy, Money money) {
        checkMenuIsContain(menuNameToBuy);

    }

    private static void checkMenuIsContain(String menuNameToBuy) {
        for (Menu menu : menus) {
            if (menu.isSameName(menuNameToBuy)) {
                return;
            }
        }
        throw new IllegalArgumentException(Error.ORDER.getMessage());
    }
}
