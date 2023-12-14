package christmas.domain.validation;

import java.util.Arrays;
import java.util.List;

public class OrderValidator {
    private static final Integer SPLIT_LIMIT = -1;
    private static final String ORDER_DELIMITER = ",";
    private static final String MENU_AND_COUNT_DELIMITER = "-";

    public static void validateAndReturn(String orderInput) {
        List<String> parsedOrders = splitOrderInput(orderInput);
        for (String order : parsedOrders) {
            List<String> menuAndCount = splitOrder(order);
            
        }
    }

    private static List<String> splitOrder(String order) {
        return Arrays.asList(order.split(MENU_AND_COUNT_DELIMITER, SPLIT_LIMIT));
    }

    private static List<String> splitOrderInput(String orderInput) {
        return Arrays.asList(orderInput.split(ORDER_DELIMITER, SPLIT_LIMIT));
    }
}
