package vendingmachine.domain.entity;

import java.util.Arrays;
import java.util.List;
import vendingmachine.view.message.Error;

public class Menu {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String ITEM_DELIMITER = ",";
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int MINIMUM_VALID_QUANTITY = 0;
    private static final Integer PRICE_DIVISOR = 10;
    private static final int NO_REMAINDER = 0;
    private static final int MINIMUM_VALID_PRICE = 100;
    private static final Integer CHANGE_AMOUNT = 1;

    private final String name;
    private final Integer price;
    private Integer quantity;

    public Menu(String menu) {
        List<String> parsedMenu = splitMenu(menu);
        name = parsedMenu.get(NAME_INDEX);
        price = validateAndReturnPrice(parsedMenu.get(PRICE_INDEX));
        quantity = validateAndReturnQuantity(parsedMenu.get(QUANTITY_INDEX));
    }

    private Integer validateAndReturnQuantity(String quantityInput) {
        int parsedQuantity = toInteger(quantityInput);
        checkBiggerOrEqualThanMinimumQuantity(parsedQuantity);
        return parsedQuantity;
    }

    private void checkBiggerOrEqualThanMinimumQuantity(int parsedQuantity) {
        if (parsedQuantity < MINIMUM_VALID_QUANTITY) {
            throw new IllegalArgumentException(Error.MENU_INPUT.getMessage());
        }
    }

    private Integer validateAndReturnPrice(String priceInput) {
        int parsedPrice = toInteger(priceInput);
        checkBiggerOrEqualThanMinimumPrice(parsedPrice);
        checkDivisibleByTen(parsedPrice);
        return parsedPrice;
    }

    private void checkDivisibleByTen(Integer parsedPrice) {
        if (parsedPrice % PRICE_DIVISOR != NO_REMAINDER) {
            throw new IllegalArgumentException(Error.MENU_INPUT.getMessage());
        }
    }

    private void checkBiggerOrEqualThanMinimumPrice(int parsedPrice) {
        if (parsedPrice < MINIMUM_VALID_PRICE) {
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

    public boolean isSameName(String menuNameToBuy) {
        return name.equals(menuNameToBuy);
    }

    public void buy(Money money) {
        if (money.getAmount() < price || quantity == MINIMUM_VALID_QUANTITY) {
            throw new IllegalArgumentException(Error.PURCHASE.getMessage());
        }
        quantity -= CHANGE_AMOUNT;
        money.minus(price);
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public boolean isPurchaseAble() {
        return quantity > MINIMUM_VALID_QUANTITY;
    }
}
