package vendingmachine.domain.entity;

import java.util.Arrays;
import java.util.List;

public class MenuRepository {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String ITEM_DELIMITER = ",";
    private static final String MENU_DELIMITER = ";";

    public static void create(String menusInput) {
        List<String> menus = splitMenu(menusInput);

    }

    private static List<String> splitMenu(String menusInput) {
        return Arrays.asList(menusInput.split(MENU_DELIMITER, SPLIT_LIMIT));
    }
}
