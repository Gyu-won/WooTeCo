package christmas.view;

import christmas.domain.entity.OrderDetails;
import christmas.view.message.EventMessage;
import christmas.view.message.PromptMessage;

public class OutputView {
    public static void printOrderDetails(OrderDetails orderDetails) {
        System.out.println(EventMessage.PREVIEW.getMessage(orderDetails.getReserveDate()));
        System.out.println(PromptMessage.ORDER_SUMMARY.getMessage());
    }
}
