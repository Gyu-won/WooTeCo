package christmas.view;

import christmas.domain.entity.EventReward;
import christmas.domain.entity.OrderDetails;
import christmas.view.message.DynamicMessage;
import christmas.view.message.PromptMessage;

public class OutputView {
    private static final Integer GIFT_EVENT_INDEX = 4;
    private static final Integer NO_GIFT_PRICE = 0;
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
    }

    private static void printBenefitDetails(EventReward eventReward) {
        System.out.println(PromptMessage.EVENT_REWARD.getMessage());
    }

    private static void printGiftMenu(EventReward eventReward) {
        System.out.println(PromptMessage.GIFT_MENU.getMessage());
        System.out.println(generateGiftMessage(eventReward.getEventRewards().get(GIFT_EVENT_INDEX)));
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
                System.out.println(DynamicMessage.ORDER_MENU.getMessage(key.getName(), value)));
    }

    private static String generateGiftMessage(Integer giftMenuPrice) {
        if (giftMenuPrice.equals(NO_GIFT_PRICE)) {
            return NO_REWARD;
        }
        return GIFT_MENU;
    }
}
