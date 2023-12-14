package christmas.view;

import christmas.domain.entity.Order;
import christmas.domain.entity.VisitDate;
import christmas.view.message.Prompt;
import christmas.view.message.Result;
import java.util.Map.Entry;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printStartMessage() {
        System.out.println(Prompt.START.getMessage());
    }

    public static void printEventMessage(VisitDate visitDate) {
        System.out.printf(Prompt.EVENT.getMessage(), visitDate.getVisitDate());
    }

    public static void printOrder(Order order) {
        System.out.println(Prompt.ORDER_MENU.getMessage());
        for (Entry<String, Integer> entry : order.getOrder().entrySet()) {
            System.out.printf(Result.ORDER.getMessage(), entry.getKey(), entry.getValue());
        }
    }

    public static void printTotalPriceBeforeDiscount(Integer totalPrice) {
        System.out.println(Prompt.BEFORE_DISCOUNT_PRICE.getMessage());
        System.out.printf(Result.PRICE.getMessage(), totalPrice);
    }
}