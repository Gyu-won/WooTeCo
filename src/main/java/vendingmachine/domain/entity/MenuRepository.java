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
        Menu menu = findMenu(menuNameToBuy);
        menu.buy(money);
    }

    private static Menu findMenu(String menuNameToBuy) {
        for (Menu menu : menus) {
            if (menu.isSameName(menuNameToBuy)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(Error.ORDER.getMessage());
    }

    //TODO: menu getter 안쓰고 리펙터링
    public static boolean purchaseAvailable(Money money) {
        int minimumPrice = calculateCheapestMenuPrice();
        int totalMenuQuantity = calculateMenusQuantity();
        return money.isBiggerOrEqual(minimumPrice) && totalMenuQuantity > 0;
    }

    private static int calculateMenusQuantity() {
        return menus.stream()
                .mapToInt(Menu::getQuantity)
                .sum();
    }

    private static int calculateCheapestMenuPrice() {
        return menus.stream()
                .mapToInt(Menu::getPrice)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Menu가 없습니다."));
    }
}
