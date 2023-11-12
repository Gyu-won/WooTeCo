package christmas.view;

import christmas.domain.entity.OrderDetails;
import christmas.view.message.EventMessage;
import christmas.view.message.PromptMessage;

public class OutputView {
    private static final String ORDER_MENU = "%s %d개\n";

    public static void printOrderDetails(OrderDetails orderDetails) {
        printEventPreview(orderDetails);
        printOrderMenus(orderDetails);
    }

    private static void printEventPreview(OrderDetails orderDetails) {
        System.out.println(EventMessage.PREVIEW.getMessage(orderDetails.getReserveDate()));
    }

    private static void printOrderMenus(OrderDetails orderDetails) {
        System.out.println(PromptMessage.ORDER_SUMMARY.getMessage());
        orderDetails.getOrderMenus().forEach((key, value) ->
                System.out.printf(ORDER_MENU, key.getName(), value));
    }
}
