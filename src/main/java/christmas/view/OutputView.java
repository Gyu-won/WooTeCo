package christmas.view;

import christmas.domain.entity.EventReward;
import christmas.domain.entity.OrderDetails;
import christmas.view.message.EventMessage;
import christmas.view.message.OrderMessage;
import christmas.view.message.PromptMessage;

public class OutputView {
    private static final Integer GIFT_EVENT_INDEX = 4;
    private static final Integer NO_DISCOUNT_AMOUNT = 0;
    private static final String NO_DISCOUNT = "0원";
    private static final String NO_REWARD = "없음";
    private static final String GIFT_MENU = "샴페인 1개";

    public static void printGreetingMessage() {
        System.out.println(PromptMessage.GREETING.getMessage());
    }

    public static void printOrderDetails(OrderDetails orderDetails) {
        printEventPreview(orderDetails);
        printOrderMenus(orderDetails);
        printOrderPrice(orderDetails);
    }

    public static void printEventReward(EventReward eventReward) {
        printGiftMenu(eventReward);
        printBenefitDetails(eventReward);
        printTotalDiscountAmount(eventReward);
    }

    public static void printDiscountedPrice(Integer discountedPrice) {
        System.out.println(PromptMessage.DISCOUNTED_PRICE.getMessage());
        System.out.println(OrderMessage.TOTAL_PRICE.getMessage(discountedPrice));
    }

    private static void printEventPreview(OrderDetails orderDetails) {
        System.out.println(PromptMessage.EVENT_PREVIEW.getMessage(orderDetails.getReserveDate()));
    }

    private static void printOrderMenus(OrderDetails orderDetails) {
        System.out.println(PromptMessage.ORDER_SUMMARY.getMessage());
        orderDetails.getOrderMenus().forEach((key, value) ->
                System.out.println(OrderMessage.ORDER_MENU.getMessage(key.getName(), value)));
    }

    private static void printOrderPrice(OrderDetails orderDetails) {
        System.out.println(PromptMessage.TOTAL_PRICE.getMessage());
        System.out.println(OrderMessage.TOTAL_PRICE.getMessage(orderDetails.getTotalPrice()));
    }

    private static void printGiftMenu(EventReward eventReward) {
        System.out.println(PromptMessage.GIFT_MENU.getMessage());
        System.out.println(makeGiftMessage(eventReward.getEventRewards().get(GIFT_EVENT_INDEX)));
    }

    private static String makeGiftMessage(Integer giftMenuPrice) {
        if (giftMenuPrice.equals(NO_DISCOUNT_AMOUNT)) {
            return NO_REWARD;
        }
        return GIFT_MENU;
    }

    private static void printBenefitDetails(EventReward eventReward) {
        System.out.println(PromptMessage.EVENT_REWARD.getMessage());
        System.out.println(makeBenefitMessage(eventReward));
    }

    private static String makeBenefitMessage(EventReward eventReward) {
        if (eventReward.sumEventRewards().equals(NO_DISCOUNT_AMOUNT)) {
            return NO_REWARD;
        }
        return EventMessage.calculateAllBenefits(eventReward.getEventRewards());
    }

    private static void printTotalDiscountAmount(EventReward eventReward) {
        System.out.println(PromptMessage.TOTAL_DISCOUNT.getMessage());
        System.out.println(makeDiscountAmountMessage(eventReward.sumEventRewards()));
    }

    private static String makeDiscountAmountMessage(Integer totalDiscountPrice) {
        if (totalDiscountPrice.equals(NO_DISCOUNT_AMOUNT)) {
            return NO_DISCOUNT;
        }
        return OrderMessage.DISCOUNT_AMOUNT.getMessage(totalDiscountPrice);
    }

    public static void printBadge(String badge) {
        System.out.println(PromptMessage.EVENT_BADGE.getMessage());
        System.out.println(badge);
    }
}
