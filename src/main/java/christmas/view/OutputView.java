package christmas.view;

import christmas.domain.entity.OrderDetails;
import christmas.view.message.DynamicMessage;
import christmas.view.message.PromptMessage;

public class OutputView {
    private static final String ORDER_MENU = "%s %d개\n";

    public static void printGreetingMessage() {
        System.out.println(PromptMessage.GREETING.getMessage());
    }

    public static void printOrderDetails(OrderDetails orderDetails) {
        printEventPreview(orderDetails);
        printOrderMenus(orderDetails);
        printOrderPrice(orderDetails);
    }

    private static void printOrderPrice(OrderDetails orderDetails) {
        System.out.println(PromptMessage.TOTAL_PRICE.getMessage());
        System.out.println(DynamicMessage.PRICE.getMessage(orderDetails.getTotalPrice()));
    }

    private static void printEventPreview(OrderDetails orderDetails) {
        System.out.println(DynamicMessage.PREVIEW.getMessage(orderDetails.getReserveDate()));
    }

    private static void printOrderMenus(OrderDetails orderDetails) {
        System.out.println(PromptMessage.ORDER_SUMMARY.getMessage());
        orderDetails.getOrderMenus().forEach((key, value) ->
                System.out.printf(ORDER_MENU, key.getName(), value));
    }
}
