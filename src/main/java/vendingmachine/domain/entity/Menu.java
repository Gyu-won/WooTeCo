package vendingmachine.domain.entity;

import java.util.Arrays;
import java.util.List;
import vendingmachine.view.message.Error;

public class Menu {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String ITEM_DELIMITER = ",";

    private final String name;
    private final Integer price;
    private final Integer quantity;

    public Menu(String menu) {
        List<String> parsedMenu = splitMenu(menu);
        name = parsedMenu.get(0);
        price = validateAndReturnPrice(parsedMenu.get(1));
        quantity = validateAndReturnQuantity(parsedMenu.get(2));
    }

    private Integer validateAndReturnQuantity(String quantityInput) {
        return 0;
    }

    private Integer validateAndReturnPrice(String priceInput) {
        int parsedPrice = toInteger(priceInput);
        checkBiggerOrEqualThanMinimumPrice(parsedPrice);
        checkDivisibleByTen(parsedPrice);
        return parsedPrice;
    }

    private void checkDivisibleByTen(Integer parsedPrice) {
        if (parsedPrice % 10 != 0) {
            throw new IllegalArgumentException(Error.MENU_INPUT.getMessage());
        }
    }

    private void checkBiggerOrEqualThanMinimumPrice(int parsedPrice) {
        if (parsedPrice < 100) {
            throw new IllegalArgumentException(Error.MENU_INPUT.getMessage());
        }
    }

    private static List<String> splitMenu(String menu) {
        return Arrays.asList(menu.split(ITEM_DELIMITER, SPLIT_LIMIT));
    }

    private static Integer toInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.MENU_INPUT.getMessage());
        }
    }
}
