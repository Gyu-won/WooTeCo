package christmas.view;

import christmas.domain.entity.OrderDetails;
import christmas.view.message.EventMessage;

public class OutputView {
    public static void printOrderDetails(OrderDetails orderDetails) {
        System.out.println(EventMessage.PREVIEW.getMessage(orderDetails.getReserveDate()));
    }
}
