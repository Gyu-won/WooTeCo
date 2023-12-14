package christmas.view;

import christmas.domain.entity.Badge;
import christmas.domain.entity.Order;
import christmas.domain.entity.VisitDate;
import christmas.view.message.Prompt;
import christmas.view.message.Result;
import java.util.Map;
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

    public static void printGiftEvent(Map<String, Integer> giftEventResult) {
        System.out.println(Prompt.GiFT_MENU.getMessage());
        System.out.println(writeGiftEventResult(giftEventResult));
    }

    private static String writeGiftEventResult(Map<String, Integer> giftEventResult) {
        if (giftEventResult.isEmpty()) {
            return Result.NOTHING.getMessage();
        }
        return Result.GIFT_MENU.getMessage();
    }

    public static void printAllEventDetails(Map<String, Integer> eventResult) {
        System.out.println(Prompt.EVENT_DETAILS.getMessage());
        printEventDetailsResult(eventResult);
    }

    private static void printEventDetailsResult(Map<String, Integer> eventResult) {
        if (eventResult.isEmpty()) {
            System.out.println(Result.NOTHING.getMessage());
            return;
        }
        for (Entry<String, Integer> result : eventResult.entrySet()) {
            System.out.printf(Result.EVENT.getMessage(), result.getKey(), result.getValue());
        }
    }

    public static void printTotalDiscountPrice(Integer discountPrice) {
        System.out.println(Prompt.TOTAL_DISCOUNT_PRICE.getMessage());
        System.out.println(Result.DISCOUNT_PRICE.getMessage());
    }

    public static void printFinalPrice(Integer finalPrice) {
        System.out.println(Prompt.FINAL_PRICE.getMessage());
        System.out.printf(Result.PRICE.getMessage(), finalPrice);
    }

    public static void printBadge(Badge badge) {
        System.out.println(Prompt.BADGE.getMessage());
        System.out.println(badge.getBadge());
    }
}